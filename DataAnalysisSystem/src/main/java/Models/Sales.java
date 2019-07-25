package Models;

import java.util.List;

public class Sales {
    private int idSales;
    private String nameSalesman;
    private List<ItemSold> itensSaled;

    public Sales(int idSales, String nameSalesman, List<ItemSold> itensSaled) {
        this.idSales = idSales;
        this.nameSalesman = nameSalesman;
        this.itensSaled = itensSaled;
    }

    public int getIdSales() {
        return idSales;
    }

    public String getNameSalesman() {
        return nameSalesman;
    }

    public List<ItemSold> getItensSaled() {
        return itensSaled;
    }
}
