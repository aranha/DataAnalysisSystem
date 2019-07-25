package Models;

public class Customer {
    private String cnpjCustomer;
    private String nameCustomer;
    private String businessAreaCustomer;

    public Customer(String cnpjCustomer, String nameCustomer, String businessAreaCustomer) {
        this.cnpjCustomer = cnpjCustomer;
        this.nameCustomer = nameCustomer;
        this.businessAreaCustomer = businessAreaCustomer;
    }

    public String getCnpjCustomer() {
        return cnpjCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public String getBusinessAreaCustomer() {
        return businessAreaCustomer;
    }
}
