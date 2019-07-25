package Models;

import java.text.NumberFormat;

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

    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return  "  id: " + getIdItemSold() +
                ", quantity: " + getQuantityItemSold() +
                ", price: R$" + getPriceItemSold() +
                ", value sold: R" + currencyFormat.format(getValueSold()) + "\n";
    }
}
