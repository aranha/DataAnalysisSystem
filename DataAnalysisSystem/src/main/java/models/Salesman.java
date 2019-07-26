package models;

import java.text.NumberFormat;

public class Salesman {
    private String cpfSalesman;
    private String nameSalesman;
    private double salarySalesman;

    public Salesman(String cpfSalesman, String nameSalesman, double salarySalesman) {
        this.cpfSalesman = cpfSalesman;
        this.nameSalesman = nameSalesman;
        this.salarySalesman = salarySalesman;
    }

    public String getNameSalesman() {
        return nameSalesman;
    }

    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return "  CPF: " + cpfSalesman +
                ", name: " + nameSalesman +
                ", salary: R" + currencyFormat.format(salarySalesman)  + "\n";
    }
}
