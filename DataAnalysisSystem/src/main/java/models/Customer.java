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

    @Override
    public String toString() {
        return "  CNPJ customer: " + cnpjCustomer +
                ", name customer='" + nameCustomer +
                ", business area customer='" + businessAreaCustomer + "\n";
    }
}
