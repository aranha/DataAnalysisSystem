package controllers;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

import models.ItemSold;
import models.Salesman;

public class ReportOutput {
    TypeData typeData = TypeData.getInstance();
    private double valueSaleOfWorstSalesman;

    private int amountCustomer(){
        return typeData.getCustomersList().size();
    }

    private int amountSalesman(){
        return typeData.getSalesmanList().size();
    }

    private int idMostExpansiveSale(){
        return typeData.getItemsSoldList().
            stream().
            sorted(Comparator.comparing(ItemSold::getValueSold, Comparator.reverseOrder())).
            collect(Collectors.toList()).get(0).getIdItemSold();
    }

    public String worstSalesman(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return typeData.getSalesmanList().stream().
                filter(salesman -> salesman.getNameSalesman().equals(calculateWorstSalesman().firstKey())).
                findFirst().get().toString() + " with a total sales of: R" + currencyFormat.format(valueSaleOfWorstSalesman);
    }

    private TreeMap<String, Double> calculateWorstSalesman(){
        TreeMap<String, Double> salesmanWithTotalSales = new TreeMap<>(Collections.reverseOrder());
        typeData.getSalesList().forEach(sales -> {
            if(salesmanWithTotalSales.get(sales.getNameSalesman()) != null){
                salesmanWithTotalSales.put(sales.getNameSalesman(), salesmanWithTotalSales.get(sales.getNameSalesman())
                        + sales.getItemsSold().stream().mapToDouble(ItemSold::getValueSold).sum());
            }else{
                salesmanWithTotalSales.put(sales.getNameSalesman(), sales.getItemsSold().stream().mapToDouble(ItemSold::getValueSold).sum());
            }

        });
        valueSaleOfWorstSalesman = salesmanWithTotalSales.firstEntry().getValue();
        return salesmanWithTotalSales;
    }

    public String getReport(){
        return  " Amount Customer: " + amountCustomer() + 
                "\n Amount Salesman: " + amountSalesman() + 
                "\n ID most expansive sale: " + idMostExpansiveSale() +
                "\n Worst Salesman: " + worstSalesman();
    }
}
