package Models;

import java.util.List;

public class Sales {
    private int idSales;
    private String nameSalesman;
    private List<ItemSold> itemsSold;

    public Sales(int idSales, String nameSalesman, List<ItemSold> itemsSold) {
        this.idSales = idSales;
        this.nameSalesman = nameSalesman;
        this.itemsSold = itemsSold;
    }

    public int getIdSales() {
        return idSales;
    }

    public String getNameSalesman() {
        return nameSalesman;
    }

    public List<ItemSold> getItemsSold() {
        return itemsSold;
    }

    @Override
    public String toString() {
        return  "  id sale: " + getIdSales() +
                ", name saleman: " + getNameSalesman() +
                ", list sales: " + getItemsSold() + "\n";
    }
}
