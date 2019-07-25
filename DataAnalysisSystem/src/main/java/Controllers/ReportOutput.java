package Controllers;

import java.util.Comparator;
import java.util.stream.Collectors;

import Models.ItemSold;

public class ReportOutput {
    TypeData typeData = TypeData.getInstance();

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
//
//    public Salesman worstSalesman(){
//
//    }

    public String getReport(){
        return  " Amount Customer: " + amountCustomer() + 
                "\n Amount Salesman: " + amountSalesman() + 
                "\n ID most expansive sale: " + idMostExpansiveSale() +
                "\n Worst Salesman: " + "function not implemented yet";
    }
}
