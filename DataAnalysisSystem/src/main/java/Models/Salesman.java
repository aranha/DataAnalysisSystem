package Models;

public class Salesman {
    private String cpfSalesman;
    private String nameSalesman;
    private double salarySalesman;

    public Salesman(String cpfSalesman, String nameSalesman, double salarySalesman) {
        this.cpfSalesman = cpfSalesman;
        this.nameSalesman = nameSalesman;
        this.salarySalesman = salarySalesman;
    }

    public String getCpfSalesman() {
        return cpfSalesman;
    }

    public String getNameSalesman() {
        return nameSalesman;
    }

    public double getSalarySalesman() {
        return salarySalesman;
    }
}
