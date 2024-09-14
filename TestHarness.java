import java.util.*;
public class TestHarness {
    public static void main(String[] args){
        BookStore bs = new BookStore();
        Scanner input = new Scanner(System.in);
        Scanner rInput = new Scanner(System.in);
        int choice = 1;
        String pUserName = "";
        String pUnLower = "";
        int pUserID = 0;

        //it will run until user put 0
        while(0 < choice){
            System.out.println("\t1. ***Staff only*** Place Items to Store");
            System.out.println("\t2. Place Order");
            System.out.println("\t3. Join Premium Member");
            System.out.println("\t4. Check Items");
            System.out.println("\t0. Check out and exit");
            choice = input.nextInt();
            switch(choice)
            {
                //finalizing cost
                //finalizing recipt
                //check premium member fee.
                case 0:
                int id = bs.returnPID(pUnLower);
                bs.premiumMemberFeePayment(pUnLower,id);
                bs.finalCost(pUnLower,id);
                bs.printRecipt();
                bs.resetingValues();
                System.out.println("Thank you for using this book store!");
                break;

                //placing item tp stotr.
                case 1:
                System.out.println();
                System.out.println("-----Place Items to Store-----");
                System.out.println();
                int choice2 = 1;
                while(choice2 != 0){
                    System.out.println();
                    System.out.println("----------MENU----------");
                    System.out.println();
                    System.out.println("\t1. CD");
                    System.out.println("\t2. DVD");
                    System.out.println("\t3. Book");
                    System.out.println("\t0. Exit");
                    choice2 = input.nextInt();
                    Scanner nameInput = new Scanner(System.in);
                    Scanner priceInput = new Scanner(System.in);
                    Scanner amountInput = new Scanner(System.in);
                    switch(choice2){
                        case 0:
                        System.out.println();
                        System.out.println("----------Placing is done.----------");
                        System.out.println();
                        break;

                        //placing CD
                        case 1:
                        System.out.println("Name of CD (with no space): ");
                        String nameC = nameInput.nextLine();
                        String nameCL = nameC.toLowerCase();
                        System.out.println("Price of CD: ");
                        double priceC = priceInput.nextDouble();
                        System.out.println("Amount of CD: ");
                        int amountC = amountInput.nextInt();
                        bs.increaseCDID();
                        int cid = bs.getCDID();
                        bs.addCD(nameCL, priceC, amountC, cid);
                        System.out.println();
                        System.out.println("---CD had been placed.---");
                        System.out.println();
                        break;

                        //placing DVD
                        case 2:
                        System.out.println("Name of DVD (with no spacee): ");
                        String nameD = nameInput.nextLine();
                        String nameDL = nameD.toLowerCase();
                        System.out.println("Price of DVD: ");
                        double priceD = priceInput.nextDouble();
                        System.out.println("Amount of DVD: ");
                        int amountD = amountInput.nextInt();
                        bs.increaseDVDID();
                        int did = bs.getDVDID();
                        bs.addDVD(nameDL, priceD, amountD, did);
                        System.out.println();
                        System.out.println("---DVD had been placed.---");
                        System.out.println();
                        break;

                        //placing Book
                        case 3:
                        System.out.println("Name of Books (with no space): ");
                        String nameB = nameInput.nextLine();
                        String nameBL = nameB.toLowerCase();
                        System.out.println("Price of Books: ");
                        double priceB = priceInput.nextDouble();
                        System.out.println("Amount of Books: ");
                        int amountB = amountInput.nextInt();
                        bs.increaseBooksID();
                        int bid = bs.getBookID();
                        bs.addBook(nameBL, priceB, amountB, bid);
                        System.out.println();
                        System.out.println("---Book had been placed.---");
                        System.out.println();
                        break;
                    }

                }
                break;

                //check memberships
                case 2:
                System.out.println();
                System.out.println("-----Order Items-----");
                System.out.println();
                bs.placingOrder();
                System.out.println();
                System.out.print("Are you regular member of this book store already? (Y/N): ");
                String yn = rInput.nextLine();
                yn = yn.toUpperCase();
                if (yn.equals("Y")){
                    System.out.println("-----Enter your informations.-----");
                    System.out.print("Enter user name: ");
                    String userName = rInput.nextLine();
                    String unLower = userName.toLowerCase();
                    System.out.print("Enter your user ID: ");
                    int userID = rInput.nextInt();
                    int indexOfMember = bs.findRegularMember(unLower,userID);
                    if (indexOfMember != -1){
                        System.out.println("Welcome back " + userName + "!");
                    }
                    else{
                        System.out.println("You are not in regular membership.");
                        System.out.println();
                    }
                }
                else{
                    System.out.println("Do you want to join member for free?: (Y or N)");
                    String yn2 = rInput.nextLine();
                    yn2 = yn2.toUpperCase();
                    if (yn2.equals("Y")){
                        System.out.print("Enter user name: ");
                        String userName = rInput.nextLine();
                        String unLower = userName.toLowerCase();
                        //adding payment method for regular member
                        System.out.println();
                        System.out.println("Chose your payment method. Please do not chose anything not in option.");
                        System.out.println("\t1. Visa credit card");
                        System.out.println("\t2. Master card credit card");
                        System.out.println("\t3. Othre credit card");
                        System.out.println("\t4. Cash");
                        int paymentChoiceR = rInput.nextInt();
                        String paymentMethodR = "Unknown method";
                        switch(paymentChoiceR){
                            case 1:
                            paymentMethodR = "Visa credit card";
                            break;

                            case 2:
                            paymentMethodR = "Master card credit card";
                            break;

                            case 3:
                            paymentMethodR = "Othre credit card";
                            break;

                            case 4:
                            paymentMethodR = "Cash";
                            break;
                        }
                        bs.addingRegularMember(unLower, paymentMethodR);
                        System.out.println();
                    }
                    else{
                        System.out.println("If you would like to, please join our membership next time!");
                        System.out.println();
                    }
                }
                Scanner premiumMemberChoice = new Scanner(System.in);
                System.out.print("Are you premium member of this book store already? (Y/N): ");
                String pyn = premiumMemberChoice.nextLine();
                System.out.println();
                pyn = pyn.toUpperCase();
                if (pyn.equals("Y")){
                    System.out.println("-----Enter your informations.-----");
                    System.out.print("Enter user name: ");
                    pUserName = premiumMemberChoice.nextLine();
                    pUnLower = pUserName.toLowerCase();
                    System.out.print("Enter your user ID: ");
                    pUserID = premiumMemberChoice.nextInt();
                    int indexOfPMember = bs.findPremiumMember(pUnLower,pUserID);
                    if (indexOfPMember != -1){
                        System.out.println("Thank you for coming back " + pUserName + "!");
                        System.out.println();
                    }
                    else{
                        System.out.println("You are not premium member.");
                        System.out.println();
                    }
                }
                else{
                    System.out.println("We have a lot of premium membership benefit. Join premium membership next time!");
                    System.out.println();
                }
                break;

                //Add and cancel premium memberships.
                case 3:
                System.out.println();
                System.out.println("-----Premium Member Actions-----");
                System.out.println();
                int choice3 = 1;
                while(choice3 != 0){
                    System.out.println("\t1. Join premium member:");
                    System.out.println("\t2. Cancel premium membership:");
                    System.out.println("\t0. Exit");
                    choice3 = input.nextInt();
                    switch(choice3){
                        case 0:
                        break;

                        case 1:
                        Scanner pmaInput = new Scanner(System.in);
                        System.out.println();
                        System.out.println("Thank you for joining our premium member! Monthly fee is $10.");
                        System.out.print("Enter user name: ");
                        pUserName = pmaInput.nextLine();
                        pUnLower = pUserName.toLowerCase();
                        //choseing payment method
                        System.out.println();
                        System.out.println("Chose your payment method. Please do not chose anything not in option.");
                        System.out.println("\t1. Visa credit card");
                        System.out.println("\t2. Master card credit card");
                        System.out.println("\t3. Othre credit card");
                        System.out.println("\t4. Cash");
                        int paymentChoiceC = pmaInput.nextInt();
                        String paymentMethodC = "Unknown method";
                        switch(paymentChoiceC){
                            case 1:
                            paymentMethodC = "Visa credit card";
                            break;

                            case 2:
                            paymentMethodC = "Master card credit card";
                            break;

                            case 3:
                            paymentMethodC = "Othre credit card";
                            break;

                            case 4:
                            paymentMethodC = "Cash";
                            break;
                        }

                        bs.addingPremiumMember(pUnLower,paymentMethodC);
                        break;

                        case 2:
                        Scanner memberSearch = new Scanner(System.in);
                        System.out.print("Enter user name: ");
                        pUserName = memberSearch.nextLine();
                        pUnLower = pUserName.toLowerCase();
                        System.out.println();
                        System.out.print("Enter your user ID: ");
                        pUserID = memberSearch.nextInt();
                        bs.cancelPremiumMember(pUnLower, pUserID);
                        break;
                    }
                }
                break;

                //searching items.
                case 4:
                System.out.println();
                System.out.println("-----Searching Item-----");
                System.out.println();
                int choice4 = 1;
                while(0 < choice4){
                    System.out.println("\t1. CD searching:");
                    System.out.println("\t2. DVD searching:");
                    System.out.println("\t3. Book searching:");
                    System.out.println("\t0. Exit");
                    choice4 = input.nextInt();
                    Scanner searchNameInput = new Scanner(System.in);
                    switch(choice4){
                        case 0:
                        break;

                        //searching CD
                        case 1:
                        System.out.println("What CD are you looking?: ");
                        String nameC = searchNameInput.nextLine();
                        String nameCL = nameC.toLowerCase();
                        System.out.println(bs.messageofsearchingCD(nameCL));
                        break;

                        //searching DVD
                        case 2:
                        System.out.println("What DVD are you looking?: ");
                        String nameD = searchNameInput.nextLine();
                        String nameDL = nameD.toLowerCase();
                        System.out.println(bs.messageofsearchingDVD(nameDL));
                        break;

                        //searching Book
                        case 3:
                        System.out.println("What Book are you looking?: ");
                        String nameB = searchNameInput.nextLine();
                        String nameBL = nameB.toLowerCase();
                        System.out.println(bs.messageofsearchingBook(nameBL));
                        break;
                    }
                }
                break;

            }
        }
    }
}