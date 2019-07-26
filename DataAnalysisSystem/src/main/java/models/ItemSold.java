package models;

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

    public double getValueSold() {
        return valueSold;
    }

    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return  "  id: " + idItemSold +
                ", quantity: " + quantityItemSold +
                ", price: R$" + currencyFormat.format(priceItemSold) +
                ", value sold: R" + currencyFormat.format(valueSold) + "\n";
    }
}
