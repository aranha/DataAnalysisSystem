package Models;

public class ItemSold {
    private int idItemSold;
    private int quantityItemSold;
    private double priceItemSold;
    private double valueSold;

    public ItemSold(int idItemSold, int quantityItemSold, double priceItemSold) {
        this.idItemSold = idItemSold;
        this.quantityItemSold = quantityItemSold;
        this.priceItemSold = priceItemSold;
        this.valueSold = quantityItemSold * priceItemSold;
    }

    public int getIdItemSold() {
        return idItemSold;
    }

    public int getQuantityItemSold() {
        return quantityItemSold;
    }

    public double getPriceItemSold() {
        return priceItemSold;
    }

    public double getValueSold() {
        return valueSold;
    }
}
