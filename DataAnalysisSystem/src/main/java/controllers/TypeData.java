package controllers;

import models.Customer;
import models.ItemSold;
import models.Sales;
import models.Salesman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeData {
    private List<Salesman> salesmanList = new ArrayList<>();
    private List<Customer> customersList = new ArrayList<>();
    private List<Sales> salesList = new ArrayList<>();
    private List<ItemSold> itemsSoldList = new ArrayList<>();

    private TypeData(){}

    private static TypeData INSTANCE;

    public List<Salesman> getSalesmanList() {
        return salesmanList;
    }

    public List<Customer> getCustomersList() {
        return customersList;
    }

    public List<Sales> getSalesList() {
        return salesList;
    }

    public List<ItemSold> getItemsSoldList() {
        return itemsSoldList;
    }

    public void setTypeData(List<String> listDataLine){
        int idData = Integer.parseInt(listDataLine.get(0));
        switch (idData){
            case 1:
                addSalesman(listDataLine);
                break;
            case 2:
                addCustomer(listDataLine);
                break;
            case 3:
                addSale(listDataLine);
                break;
        }
    }

    public static TypeData getInstance(){
        if(INSTANCE == null){
            synchronized (TypeData.class){
                if(INSTANCE == null){
                    INSTANCE = new TypeData();
                }
            }
        }
        return INSTANCE;
    }

    private void addSalesman(List<String> listDataLine){
        String cpf = listDataLine.get(1);
        String name = listDataLine.get(2);
        double salary = Double.parseDouble(listDataLine.get(3));
        Salesman salesman = new Salesman(cpf, name, salary);
        salesmanList.add(salesman);
    }

    private void addCustomer(List<String> listDataLine){
        String cnpj = listDataLine.get(1);
        String name = listDataLine.get(2);
        String businessArea = listDataLine.get(3);
        Customer customer = new Customer(cnpj, name, businessArea);
        customersList.add(customer);
    }

    private void addSale(List<String> listDataLine){
        int idSale = Integer.parseInt(listDataLine.get(1));
        String salesmanName = listDataLine.get(3);
        List<ItemSold> listItemsSold = new ArrayList<>();
        addItemsSold(listItemsSold, listDataLine.get(2));
        Sales sales = new Sales(idSale, salesmanName, listItemsSold);
        salesList.add(sales);
    }

    private void addItemsSold(List<ItemSold> listItemsSold, String dataLine){
        final String SEPARATOR_COMMA = ",";
        final String SEPARATOR_HYPHEN = "-";

        List<String> sales = Arrays.asList(dataLine.trim().
                replace("[", "").
                replace("]", "").
                split(SEPARATOR_COMMA));

        sales.forEach(sale -> {
            List<String> list = Arrays.asList(sale.split(SEPARATOR_HYPHEN));
            int itemID = Integer.parseInt(list.get(0));
            int itemQuantity = Integer.parseInt(list.get(1));
            double itemPrice = Double.parseDouble(list.get(2));
            ItemSold itemSold = new ItemSold(itemID, itemQuantity, itemPrice);
            listItemsSold.add(itemSold);
            itemsSoldList.add(itemSold);
        });
    }
}
