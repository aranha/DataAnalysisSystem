package Controllers;

public class ReportOutput {
    TypeData typeData = TypeData.getInstance();

    private int amountCustomer(){
        return typeData.getCustomersList().size();
    }

    private int amountSalesman(){
        return typeData.getSalesmanList().size();
    }

//    public int idMostExpansiveSale(){
//
//    }
//
//    public Salesman worstSalesman(){
//
//    }
}
