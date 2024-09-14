import java.util.*;
public class BookStore{
    private  ArrayList<CDs> orderCDList = new ArrayList<CDs>();
    private  ArrayList<DVDs> orderDVDList = new ArrayList<DVDs>();
    private  ArrayList<Books> orderBookList = new ArrayList<Books>();
    private  ArrayList<PremiumMember> premiumMemberList = new ArrayList<PremiumMember>();
    private  ArrayList<RegulerMember> regulerMemberList = new ArrayList<RegulerMember>();
    private  ArrayList<String> reciptStore = new ArrayList<String>();
    private int CDID = 100;
    private int DVDID = 200;
    private int BookID = 300;
    private int rUserID = 1000;
    private int pUserID = 2000;
    private int oderID = 0;
   int orderchoice = 1;
   double totalMoney;
   String totalRecipt = "---------------------\n    Recipt    \n---------------------\n";
   double premiumMemberFee = 0.00;

 //increase each IDs.
   public void increaseCDID(){
        CDID ++;
    }

    public void increaseDVDID(){
        DVDID ++;
    }

    public void increaseBooksID(){
        BookID ++;
    }

    public void increaseRUserID(){
        rUserID++;
    }

    public void increasePUserID(){
        pUserID++;
    }

    public void increaseingOrderID(){
        oderID ++;
    }

// getters
    public int getCDID(){
        return CDID;
    }

    public int getDVDID(){
        return DVDID;
    }

    public int getBookID(){
        return BookID;
    }

//add CD information (CD class type) to list od CD clsses(orderCDList).
    public void addCD(String nameC, double priceC, int amountC, int cID){
        CDs newCD = new CDs(nameC, priceC, amountC, cID);
        orderCDList.add(newCD);
    }

//add DVD information (DVD class type) to list od DVD clsses(orderDVDList).
    public void addDVD(String nameD, double priceD, int amountD, int dID){
        DVDs newDVD = new DVDs(nameD, priceD, amountD, dID);
        orderDVDList.add(newDVD);
    }

//add Books information (Books class type) to list od Books clsses(orderBookList).
    public void addBook(String nameB, double priceB, int amountB, int bID){
        Books newBooks = new Books(nameB, priceB, amountB, bID);
        orderBookList.add(newBooks);
    }

//method to place order.
    public void placingOrder(){
        orderchoice = 1;
        Scanner userImput = new Scanner(System.in);
        Scanner orderInput = new Scanner(System.in);
        while (0 < orderchoice){
            System.out.println("\t1. CD");
            System.out.println("\t2. DVD");
            System.out.println("\t3. Book");
            System.out.println("\t0. Exit");
            String itemName = "";
            orderchoice = userImput.nextInt();
            userImput.nextLine();
            switch((int)orderchoice){
                case 0:
                System.out.println("Order is done.");
                break;

                case 1:
                System.out.println("\tEnter name of item:");
                itemName = orderInput.nextLine();
                String inlc = itemName.toLowerCase();
                int indexCD = checkCDByName(inlc);
                if (indexCD != -1){
                    CDs orderCD = orderCDList.get(indexCD);
                    Scanner input = new Scanner(System.in);
                    System.out.println("How many of " + itemName + ", do you want?: ");
                    int amount = input.nextInt();
                    double price = orderCD.getCDPrice();
                    int id = orderCD.getIDC();
                    int storeAmount = orderCD.getCDAmount();
                    double total = 0;
                    if (storeAmount >= amount){
                       total = price * amount;
                       int itemLeft = storeAmount - amount;
                       orderCD.setCDAmount(itemLeft);
                       totalMoney = totalMoney + total;
                       totalRecipt = totalRecipt + orderCD.orderRecipt(inlc, total, amount, id);
                    }
                    else if(storeAmount == 0){
                        System.out.println("Sorry. We don't have any " + itemName + ".");
                    }
                    else{
                        System.out.println("Sorry. We have only " + storeAmount + " of " + itemName + ".");
                        System.out.println("\tDo you want " + + storeAmount + " of " + itemName + "? (Y or N): ");
                        String uc = orderInput.nextLine();
                        String ucl = uc.toLowerCase();
                        if (ucl.equals("y")){
                            amount = storeAmount;
                            total = price * amount;
                            int itemLeft = 0;
                            orderCD.setCDAmount(itemLeft);
                            totalMoney = totalMoney + total;
                            totalRecipt = totalRecipt + orderCD.orderRecipt(inlc, total, amount, id);
                        }
                        else{
                            amount = 0;
                            total = price * amount;
                            int itemLeft = storeAmount;
                            orderCD.setCDAmount(itemLeft);
                        }

                    }
                }
                else{
                    System.out.println("Sorry. We don't have that item.");
                }

                break;

                case 2:
                System.out.println("\tEnter name of item:");
                itemName = orderInput.nextLine();
                String inld = itemName.toLowerCase();
                int indexDVD = checkDVDByName(inld);
                if (indexDVD != -1){
                    DVDs orderDVD = orderDVDList.get(indexDVD);
                    Scanner input = new Scanner(System.in);
                    System.out.println("How many of " + itemName + ", do you want?: ");
                    int amount = input.nextInt();
                    double price = orderDVD.getDVDPrice();
                    int id = orderDVD.getIDD();
                    int storeAmount = orderDVD.getDVDAmount();
                    double total = 0;
                    if (storeAmount >= amount){
                       total = price * amount;
                       int itemLeft = storeAmount - amount;
                       orderDVD.setDVDAmount(itemLeft);
                       totalMoney = totalMoney + total;
                       totalRecipt = totalRecipt + orderDVD.orderRecipt(inld, total, amount, id);
                    }
                    else if(storeAmount == 0){
                        System.out.println("Sorry. We don't have any " + itemName + ".");
                    }
                    else{
                        System.out.println("Sorry. We have only " + storeAmount + " of " + itemName + ".");
                        System.out.println("\tDo you want " + + storeAmount + " of " + itemName + "? (Y or N)");
                        String ud = orderInput.nextLine();
                        String udl = ud.toLowerCase();
                        if (udl.equals("y")){
                            amount = storeAmount;
                            total = price * amount;
                            int itemLeft = 0;
                            orderDVD.setDVDAmount(itemLeft);
                            totalMoney = totalMoney + total;
                            totalRecipt = totalRecipt + orderDVD.orderRecipt(inld, total, amount, id);
                        }
                        else{
                            amount = 0;
                            total = price * amount;
                            int itemLeft = storeAmount;
                            orderDVD.setDVDAmount(itemLeft);
                        }

                    }
                }
                else{
                    System.out.println("Sorry. We don't have that item.");
                }
                break;

                case 3:
                System.out.println("\tEnter name of item: ");
                itemName = orderInput.nextLine();
                String inlb = itemName.toLowerCase();
                int indexBook = checkBookByName(inlb);
                if (indexBook != -1){
                    Books orderBook = orderBookList.get(indexBook);
                    Scanner input = new Scanner(System.in);
                    System.out.println("How many of " + itemName + ", do you want?: ");
                    int amount = input.nextInt();
                    double price = orderBook.getBooksPrice();
                    int id = orderBook.getIDB();
                    int storeAmount = orderBook.getBooksAmount();
                    double total = 0;
                    if (storeAmount >= amount){
                       total = price * amount;
                       int itemLeft = storeAmount - amount;
                       orderBook.setBooksAmount(itemLeft);
                       totalMoney = totalMoney + total;
                       totalRecipt = totalRecipt + orderBook.orderRecipt(inlb, total, amount, id);
                    }
                    else if(storeAmount == 0){
                        System.out.println("Sorry. We don't have any " + itemName + ".");
                    }
                    else{
                        System.out.println("Sorry. We have only " + storeAmount + " of " + itemName + ".");
                        System.out.println("\tDo you want " + + storeAmount + " of " + itemName + "? (Y or N)");
                        String uc = orderInput.nextLine();
                        String ucl = uc.toLowerCase();
                        if (ucl.equals("y")){
                            amount = storeAmount;
                            total = price * amount;
                            int itemLeft = 0;
                            orderBook.setBooksAmount(itemLeft);
                            totalMoney = totalMoney + total;
                            totalRecipt = totalRecipt + orderBook.orderRecipt(inlb, total, amount, id);
                        }
                        else{
                            amount = 0;
                            total = price * amount;
                            int itemLeft = storeAmount;
                            orderBook.setBooksAmount(itemLeft);
                        }
                    }
                }
                else{
                    System.out.println("Sorry. We don't have that item.");
                }
                break;
            }
        }
    }

//Printing recpipt.
    public void printRecipt(){
        System.out.println();
        System.out.println(totalRecipt);
        System.out.println();
    }

//find regular mumber
    public int findRegularMember(String userName, int userID){
        for (int i=0; i < regulerMemberList.size(); i++){
            if (regulerMemberList.get(i).getNameR().equals(userName) && regulerMemberList.get(i).getIDR() == userID){
                return i;
            }
        }
        return -1;
    }

//add member if they are not premium member
    public void addingRegularMember(String userName, String payM){
        increaseRUserID();
        String userNameLower = userName.toLowerCase();
        RegulerMember newRMember = new RegulerMember(userNameLower, payM, rUserID);
        regulerMemberList.add(newRMember);
        String payMR = newRMember.getPaymentR();
        System.out.println("Thank you for joining regular member! Your user name and use id is: " + userNameLower + ", " + rUserID);
        System.out.println("Your payment method is: " + payMR);
    }


//check user is premium member already or not
    public int findPremiumMember(String userName, int userID){
        for (int i=0; i < premiumMemberList.size(); i++){
            if (premiumMemberList.get(i).getIDP() == userID && premiumMemberList.get(i).getNameP().equals(userName)){
                return i;
            }
        }
        return -1;
    }

    public int findPMbyName(String name){
        for (int i=0; i < premiumMemberList.size(); i++){
            if (premiumMemberList.get(i).getNameP().equals(name)){
                return i;
            }
        }
        return -1;
    }

//add memeber if they are not premium member
    public void addingPremiumMember(String userName, String payM){
        increasePUserID();
        String userNameLower = userName.toLowerCase();
        PremiumMember newPMember = new PremiumMember(userNameLower, payM, pUserID, false);
        premiumMemberList.add(newPMember);
        String pm = newPMember.getPayingMethod();
        System.out.println("Thank you for joining premium member! Your user name and use id is: " + userNameLower + ", " + pUserID);
        System.out.println("Your paying method is : " + pm);
        premiumMemberFeePayment(userName,pUserID);
    }

//cancel premium membership
    public void cancelPremiumMember(String userName, int userID){
        int index = findPremiumMember(userName,userID);
        if (index == -1){
            System.out.println("You are not Premium member.");
        }
        else{
            premiumMemberList.remove(index);
            System.out.println("Cancellation Success.");
        }
    }

// Check payment stats and let user pay premium fee if stats is false
    public void premiumMemberFeePayment(String userName, int userID){
        if (findPremiumMember(userName,userID) != -1){
            int index = findPremiumMember(userName,userID);
            PremiumMember member = premiumMemberList.get(index);
            boolean stats = member.getStats();
            if (!(stats)){
                String pMemberRecipt = "memberfee: $10.00" + "\n" + "-------------------" + "\n";
                totalRecipt = totalRecipt + pMemberRecipt;
                premiumMemberFee = premiumMemberFee + 10.00;
                member.setStatsP(true);
            }
        }
    }

//retuen id of premium member by getting their use name. it will return -1 if they are not member.
    public int returnPID(String userName){
        int index = findPMbyName(userName);
        if (index != -1){
            PremiumMember member = premiumMemberList.get(index);
            int rid = member.getIDP();
            return rid;
        }
        return -1;
    }

//finalizing cost. We use discount for premium member (10% discount). Add premium member fee to total cost. Make total recipt.
    public void finalCost(String userName, int userID){
        if(userID != -1){
            if (findPremiumMember(userName,userID) != -1){
                int index = findPremiumMember(userName,userID);
                boolean stats = premiumMemberList.get(index).getStats();
                if (stats){
                    double discountPrice = totalMoney * 0.1;
                    String discountString = String.format("%.2f", discountPrice);
                    String pMemberDiscount =  "memberDiscount: -$" + discountString + "\n" + "-------------------"+"\n";
                    totalRecipt = totalRecipt + pMemberDiscount;
                    totalMoney = totalMoney - discountPrice;
                }
            }
        }
        totalMoney = totalMoney + premiumMemberFee;
        //String totalString = String.valueOf(totalMoney);
        String totalString = String.format("%.2f",totalMoney);
        String totalCostRecipt = "-------------------"+"\n" + "Total Price: $" + totalString + "\n" + "-------------------";
        increaseingOrderID();
        String orderIDRecipt = "---------------------\n   ORDER ID:"+ oderID +"    \n---------------------\n";
        totalRecipt = orderIDRecipt + totalRecipt + totalCostRecipt;
        //adding recipt
        reciptStore.add(totalRecipt);
    }

//Check item by name(CD)
    public int checkCDByName(String name){
        for (int i=0; i < orderCDList.size(); i++){
            if (name.equals(orderCDList.get(i).getCDName())){
                return i;
            }
        }
        return -1;
    }

//Check item by name(DVD)
    public int checkDVDByName(String name){
        for (int i=0; i < orderDVDList.size(); i++){
            if (name.equals(orderDVDList.get(i).getDVDName())){
                return i;
            }
        }
        return -1;
    }

//Check item by name(Book)
    public int checkBookByName(String name){
        for (int i=0; i < orderBookList.size(); i++){
            if (name.equals(orderBookList.get(i).getBooksName())){
                return i;
            }
        }
        return -1;
    }

// make sentences of result of searching of CD.
    public String messageofsearchingCD(String name){
        String message;
        if (checkCDByName(name) != -1){
            int index = checkCDByName(name);
            int id = orderCDList.get(index).getIDC();
            double price = orderCDList.get(index).getCDPrice();
            int amount = orderCDList.get(index).getCDAmount();
            String idCDString = String.valueOf(id);
            String amountCDString = String.valueOf(amount);
            String priceCDString = String.valueOf(price);
            message = "We have " + amountCDString + " amount of " + name + ". Its item ID is " + idCDString + " and it's $" + priceCDString + ".";
            return message;
        }
        message = "Thank you.";
        Scanner userchoiceMS = new Scanner(System.in);
        System.out.print("Sorry we don't have that item. Do you want to add this item to this book store? Y or N: ");
        String addingChoice = userchoiceMS.nextLine();
        String lowerChoice = addingChoice.toLowerCase();
        if (lowerChoice.equals("y")){
            increaseCDID();
            CDs newCD = new CDs(name, 10.99, 20, CDID);
            orderCDList.add(newCD);
        }
        return message;
    }

// make sentences of result of searching of DVD.
    public String messageofsearchingDVD(String name){
        String message;
        if (checkDVDByName(name) != -1){
            int index = checkDVDByName(name);
            int id = orderDVDList.get(index).getIDD();
            double price = orderDVDList.get(index).getDVDPrice();
            int amount = orderDVDList.get(index).getDVDAmount();
            String idDVDString = String.valueOf(id);
            String amountDVDString = String.valueOf(amount);
            String priceDVDString = String.valueOf(price);
            message = "We have " + amountDVDString + " amount of " + name + ". Its item ID is " + idDVDString + " and it's $" + priceDVDString + ".";
            return message;
        }
        message = "Thank you.";
        Scanner userchoice = new Scanner(System.in);
        System.out.print("Sorry we don't have that item. Do you want to add this item to this book store? Y or N:");
        String addingChoice = userchoice.nextLine();
        String lowerChoice = addingChoice.toLowerCase();
        if (lowerChoice.equals("y")){
            increaseDVDID();
            DVDs newDVD = new DVDs(name, 10.99, 20, DVDID);
            orderDVDList.add(newDVD);
        }

        return message;
    }

// make sentences of result of searching of Book.
    public String messageofsearchingBook(String name){
        String message;
        if (checkBookByName(name) != -1){
            int index = checkBookByName(name);
            int id = orderBookList.get(index).getIDB();
            double price = orderBookList.get(index).getBooksPrice();
            int amount = orderBookList.get(index).getBooksAmount();
            String idBookString = String.valueOf(id);
            String amountBookString = String.valueOf(amount);
            String priceBookString = String.valueOf(price);
            message = "We have " + amountBookString + " amount of " + name + ". Its item ID is " + idBookString + " and it's $" + priceBookString + ".";
            return message;
        }
        message = "Thank you.";
        Scanner userchoice = new Scanner(System.in);
        System.out.print("Sorry we don't have that item. Do you want to add this item to this book store? Y or N:");
        String addingChoice = userchoice.nextLine();
        String lowerChoice = addingChoice.toLowerCase();
        if (lowerChoice.equals("y")){
            increaseBooksID();
            Books newBook = new Books(name, 10.99, 20, BookID);
            orderBookList.add(newBook);
        }

        return message;
    }

//reseting value of totalRecipt, totalMoney and premiumMemberFee to defalt value.
    public void resetingValues(){
        totalRecipt = "";
        totalMoney = 0.00;
        premiumMemberFee = 0.00;
    }
}