public class RegulerMember{
    private String userName;
    private String payingMethodR;
    private int userID;

    //constractor
    public RegulerMember(String name, String pm, int id){
        userName = name;
        payingMethodR = pm;
        userID = id;
    }

    //setter
    public void setNameR(String name){
        this.userName = name;
    }

    public void setPaymentR(String pm){
        this.payingMethodR = pm;
    }

    public void setIDR (int id){
        this.userID = id;
    }

    //getter
    public String getNameR(){
        return userName;
    }

    public String getPaymentR(){
        return payingMethodR;
    }

    public int getIDR(){
        return userID;
    }
}