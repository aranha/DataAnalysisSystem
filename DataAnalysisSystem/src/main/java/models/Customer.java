package models;

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

    @Override
    public String toString() {
        return "  CNPJ customer: " + getCnpjCustomer() +
                ", name customer='" + getNameCustomer() +
                ", business area customer='" + getCnpjCustomer() + "\n";
    }
}
