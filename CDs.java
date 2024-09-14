public class CDs{
    private double CDPrice;
    private int CDNumber;
    private String CDname;
    private int CDID;
    private String recieptStatementC;

    //constractor
    public CDs(String name, double price, int number, int id){
        CDPrice = price;
        CDNumber = number;
        CDname = name;
        CDID = id;
    }
    
    public void increaseCDID(){
        CDID ++;
    }

//setter of name
    public void setCDID(int id){
        this.CDID = id;
    }

    public void setCDName(String name){
        this.CDname = name;
    }
    public void setCDAmount(int amount){
        if (amount < 0){
            System.out.println("error");
        }
        else{
            this.CDNumber = amount;
        }
    }
    public void setCDPrice(double price){
        if (price < 0){
            System.out.println("error");
        }
        else{
            this.CDPrice = price;
        }
    }
//getter of name

    public int getIDC(){
        return CDID;
    }

    public String getCDName(){
        return CDname;
    }
    public int getCDAmount(){
        return CDNumber;
    }
    public double getCDPrice(){
        return CDPrice;
    }

    public double calcTotal(){
        double total = CDPrice * CDNumber;
        return total;
    }

    //makeing recipt
    public String orderRecipt(String name, double price, int amount, int id){
        String priceString= String.format("%.2f", price);
        String amountString = String.valueOf(amount);
        String idString = String.valueOf(id);
        recieptStatementC = idString + ":" + name + " x " + amountString + ": $" + priceString + "\n" + "-------------------" + "\n";
        return recieptStatementC;
    }
}