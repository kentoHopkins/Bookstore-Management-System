public class DVDs{
    private double DVDPrice;
    private int DVDNumber;
    private String DVDname;
    private int DVDID;
    private String recieptStatementD;

    //constractor
    public DVDs(String name, double price, int number, int id){
        DVDPrice = price;
        DVDNumber = number;
        DVDname = name;
        DVDID = id;
    }
    
    public void increaseDVDID(){
        DVDID ++;
    }

//setter of name
    public void setDVDID(int id){
        this.DVDID = id;
    }

    public void setDVDName(String name){
        this.DVDname = name;
    }
    public void setDVDAmount(int amount){
        if (amount < 0){
            System.out.println("error");
        }
        else{
            this.DVDNumber = amount;
        }
    }
    public void setDVDPrice(double price){
        if (price < 0){
            System.out.println("error");
        }
        else{
            this.DVDPrice = price;
        }
    }
//getter of name

    public int getIDD(){
        return DVDID;
    }

    public String getDVDName(){
        return DVDname;
    }
    public int getDVDAmount(){
        return DVDNumber;
    }
    public double getDVDPrice(){
        return DVDPrice;
    }

    public double calcTotal(){
        double total = DVDPrice * DVDNumber;
        return total;
    }

    //makeing recipt
    public String orderRecipt(String name, double price, int amount, int id){
        String priceString= String.format("%.2f", price);
        String amountString = String.valueOf(amount);
        String idString = String.valueOf(id);
        recieptStatementD = idString + ":" + name + " x " + amountString + ": $" + priceString + "\n" + "-------------------" + "\n";
        return recieptStatementD;
    }
}