package csd_ass1_library_.management;





public class Books {

    String bcode, title;
    int quantity, lended;
    double price;

    public Books() {
    }

    public Books(String bcode1, String title1, int quantity1, int lended1, double price1) {
        bcode = bcode1;
        title = title1;
        quantity = quantity1;
        lended = lended1;
        price = price1;
    }

    public String getBcode() {
        return bcode;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLended() {
        return lended;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return bcode + "  |  " + title + "  |  " + quantity + "  |  " + lended + "  |  " + price;
    }

}
