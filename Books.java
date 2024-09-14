public class Books{
    private double BooksPrice;
    private int BooksNumber;
    private String BooksName;
    private int BooksID;
    String recieptStatementB;

    //constractor
    public Books(String name, double price, int number, int id){
        BooksPrice = price;
        BooksNumber = number;
        BooksName = name;
        BooksID = id;
    }
    
//setter of name
    public void setBooksID(int id){
        this.BooksID = id;
    }

    public void setBooksName(String name){
        this.BooksName = name;
    }
    public void setBooksAmount(int amount){
        if (amount < 0){
            System.out.println("error");
        }
        else{
            this.BooksNumber = amount;
        }
    }
    public void setBooksPrice(double price){
        if (price < 0){
            System.out.println("error");
        }
        else{
            this.BooksPrice = price;
        }
    }
//getter of name

    public int getIDB(){
        return BooksID;
    }

    public String getBooksName(){
        return BooksName;
    }
    public int getBooksAmount(){
        return BooksNumber;
    }
    public double getBooksPrice(){
        return BooksPrice;
    }

    public double calcTotal(){
        double total = BooksPrice * BooksNumber;
        return total;
    }

    //makeing recipt
    public String orderRecipt(String name, double price, int amount, int id){
        String priceString= String.format("%.2f", price);
        String amountString = String.valueOf(amount);
        String idString = String.valueOf(id);
        recieptStatementB = idString + ":" + name + " x " + amountString + ": $" + priceString + "\n" + "-------------------" + "\n";
        return recieptStatementB;
    }
}