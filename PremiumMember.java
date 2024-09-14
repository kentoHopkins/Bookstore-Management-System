public class PremiumMember{
    private String userName;
    private String pymentMethod;
    private int userID;
    private boolean userStats;

    //constractor
    public PremiumMember(String name, String payM, int id, boolean states){
        userName = name;
        pymentMethod = payM;
        userID = id;
        userStats = states;
    }

    //setter
    public void setNameP(String name){
        this.userName = name;
    }

    public void setPayingMethod(String payM){
        this.pymentMethod = payM;
    }

    public void setIDP (int id){
        this.userID = id;
    }

    public void setStatsP(boolean stats){
        this.userStats = stats;
    }

    //getter
    public String getNameP(){
        return userName;
    }

    public String getPayingMethod(){
        return pymentMethod;
    }

    public int getIDP(){
        return userID;
    }

    public boolean getStats(){
        return userStats;
    }
}
    