package controllers;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

import models.ItemSold;

public class ReportOutput {
    private TypeData typeData = TypeData.getInstance();
    private double valueSaleOfWorstSalesman;

    public String getReport(){
        return new StringBuilder().append(" Amount Customer: ").append(amountCustomer()).
               append("\nAmount Salesman: ").append(amountSalesman()).
               append("\nID most expensive sale: ").append(idMostExpansiveSale()).
               append("\nWorst Salesman: ").append(worstSalesman()).toString();
    }

    private int amountCustomer(){
        return typeData.getCustomersSet().size();
    }

    private int amountSalesman(){
        return typeData.getSalesmanSet().size();
    }

    private int idMostExpansiveSale(){
        return typeData.getItemsSoldList().stream().
                sorted(Comparator.comparing(ItemSold::getValueSold, Comparator.reverseOrder())).
                collect(Collectors.toList()).get(0).getIdItemSold();
    }

    private String worstSalesman(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return typeData.getSalesmanSet().stream().
                filter(salesman -> salesman.getNameSalesman().equals(calculateWorstSalesman().firstKey())).
                findFirst().get().toString() + "with a total sales of: R" + currencyFormat.format(valueSaleOfWorstSalesman);
    }

    private TreeMap<String, Double> calculateWorstSalesman(){
        TreeMap<String, Double> salesmanWithTotalSales = new TreeMap<>(Collections.reverseOrder());
        typeData.getSalesList().forEach(sales -> {
            if(salesmanWithTotalSales.get(sales.getNameSalesman()) != null){
                salesmanWithTotalSales.put(sales.getNameSalesman(), salesmanWithTotalSales.get(sales.getNameSalesman())
                        + sales.getItemsSold().stream().
                        mapToDouble(ItemSold::getValueSold).sum());
            }else{
                salesmanWithTotalSales.put(sales.getNameSalesman(), sales.getItemsSold().stream().
                		mapToDouble(ItemSold::getValueSold).sum());
            }

        });
        valueSaleOfWorstSalesman = salesmanWithTotalSales.firstEntry().getValue();
        return salesmanWithTotalSales;
    }
}
