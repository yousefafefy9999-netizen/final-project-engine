import java.util.Scanner;
public class final_Quick_pay {

    // please define the variables and the arrays here
    static Scanner input = new Scanner(System.in);
    //-------------------ADMIN DATA-----------------------------
    static boolean user_found_details = false;
    static boolean found_blocked_id = false;
    static boolean found_unblocked_id = false;
    static int admin_choice;
    static String admin_name = "admin";
    static String admin_password = "admin1234";
    static int activeusers = 0;
    static int blockedusers = 0;
    static double totalbalance = 0;
    //------------------USER DATA-------------------------------
    static String[] user_id = new String[50];

    static {
        user_id[0] = "u_1";
    }

    static {
        user_id[1] = "u_2";
    }

    //-------------------------------------------
    static String[] user_name = new String[50];

    static {
        user_name[0] = "ahmed";
    }

    static {
        user_name[1] = "abdo";
    }

    //--------------------------------------
    static String[] user_email = new String[50];

    static {
        user_email[0] = "ahmed@gmail;.com";
    }

    static {
        user_email[1] = "abdo@gmail.com";
    }

    //----------------------------------
    static String[] user_phone = new String[50];

    static {
        user_phone[0] = "01011111111";
    }

    static {
        user_phone[1] = "01022222222";
    }

    //----------------------------------
    static String[] user_password = new String[50];

    static {
        user_password[0] = "a111";
    }

    static {
        user_password[1] = "a222";
    }

    //------------------------------------------
    static double[] user_balances = new double[50];

    static {
        user_balances[0] = 20000;
    }

    static {
        user_balances[1] = 20000;
    }

    //---------------------------------------
    static boolean[] user_blocked = new boolean[50];

    static {
        user_blocked[0] = false;
    }

    static {
        user_blocked[1] = false;
    }

    //----------------------------------------
    static String[] user_favorites = new String[50];

    static {
        user_favorites[0] = "";
    }

    static {
        user_favorites[1] = "";
    }

    //-----------------------------------------
    static String TransactionsSender[] = new String[50];
    static String TransactionsReceiver[] = new String[50];
    static double TransactionsAmount[] = new double[50];
    static String transferee = "";
    static int UserIndex = -1;
    static int currentUserIndex = -1;
    static String UserNameInput;
    static int transfereeIndex = -1;
    static double Amount = 0;
    static int TransactionCount = 0;
    static int choice; // the user choice
    static int UserChoice;
    static int PanelChoice;
    static int log_choice;
    //-------------------------TRANSFER INFORMATION----------------------------------
    static String[] tx_id = {"", "", "", ""};
    static String[] tx_sender = {"", "", "", ""};
    static String[] tx_receiver = {"", "", "", ""};
    static double[] tx_amount = {0, 0, 0, 0};
    static boolean[] tx_confirm = {true, false, false, false};
    static int tx_count = 1;
    // i have enterd this data randomly, and we might be able to chage it

    public static void main(String[] args) {
        do {
            System.out.println("================ WELCOME TO QUICK PAY ================\n");
            System.out.println("1. login as admin.");
            System.out.println("2. enter as user.");
            System.out.println("3. Exit.");
            System.out.println("-----------------------------------------------");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
            input.nextLine();
            switch ((int)choice) {
                // for admin-------------------------------------------------------------
                case 1:
                    System.out.println("------------------------------------------------");
                    System.out.print("Enter admin username:");
                    String admin_name_input = input.nextLine();
                    System.out.println("----------------------------------------------------");
                    System.out.print("Enter admin password:");
                    String admin_password_input = input.nextLine();
                    if (admin_name_input.equals(admin_name) && admin_password_input.equals(admin_password)) {
                        do {
                            System.out.println("============ADMIN PANEL=================");
                            System.out.println("You have successfully logged in.");
                            System.out.println("1. show statistics.");
                            System.out.println("2. search user.");
                            System.out.println("3. vew all users.");
                            System.out.println("4. update user.");
                            System.out.println("5. view all transactions.");
                            System.out.println("6. block accounts.");
                            System.out.println("7. unblock accounts.");
                            System.out.println("8. vew user details.");
                            System.out.println("9. logout.");
                            System.out.println("-----------------------------------------");
                            System.out.print("Enter your choice:");
                            admin_choice = input.nextInt();
                            switch (admin_choice) {
                                case 1:
                                    showstatistcs();
                                    break;
                                case 2:
                                    searchUser();
                                    break;
                                case 3:
                                    viewAllusers();
                                    break;
                                case 4:
                                    updateUser();
                                    break;
                                case 5:
                                    showTransactionsHistory();
                                    break;
                                case 6:
                                    blockAccounts();
                                    break;
                                case 7:
                                    unblockAccounts();
                                    break;
                                case 8:
                                    viewUserDetails();
                                    break;
                                case 9:
                                    System.out.println("you are logged out from admin.");
                                    System.out.println("============THANKS FOR USING=============");
                                    break;
                                default:
                                    System.out.println("Invalid choice. try again.");
                                    break;
                            }
                        } while (admin_choice != 9);
                    } else
                        System.out.println("Invalid admin input.");
                    break;
                //for user---------------------------------------------------------------------
                case 2:
                    do {
                        System.out.println("if you already have an account.");
                        System.out.println("1. login.");
                        System.out.println("-------------------------");
                        System.out.println("if you don't have an account.");
                        System.out.println("2. register.");
                        System.out.println("----------------------");
                        System.out.println("3. exit.");
                        System.out.print("enter your choice :");
                        log_choice = input.nextInt();
                        input.nextLine();
                        switch (log_choice) {
                            case 1:
                                USERLOGIN();
                                break;
                            case 2:
                                userRegister();
                                break;
                            case 3:
                                System.out.println("you are logged out .");
                                System.out.println("============THANKS FOR USING============");
                                break;
                            default:
                                System.out.println("Invalid choice. try again.");
                                break;
                        }
                    } while (log_choice != 3);

                    //-----------------
                    break;
                case 3:
                    System.out.println("Exiting application... Thanks for using!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 3);
    }

    // please define the methods here
    //---------------------ADMIN METHODS---------------------------
//------------------for admin panel case 1--------------------------//
    public static void showstatistcs() {
        int totalusers = 0;
        for (int i = 0; i < user_name.length; i++) {
            if (user_name[i] != null) {
                totalusers++;
                if (user_blocked[i]) {
                    blockedusers++;
                }else
                    activeusers++;
            }
        }
        System.out.println("=====system statistics=====");
        System.out.println("total users : " + totalusers);
        System.out.println(" active users : " + activeusers);
        System.out.println("blocked users : " + blockedusers);
        System.out.println("total balance : " + totalbalance);
        System.out.println("total transactions : " + TransactionCount);

    }

    //---------------for admin panel case 2--------------
    public static void searchUser() {
        System.out.print("Enter user iD: ");
        input.nextLine();
        String id = input.nextLine();
        for (int i = 0; i < user_id.length; i++) {
            if (id.equalsIgnoreCase(user_id[i])) {
                System.out.println("(user found)");
                System.out.println("id : " + user_id[i]);
                System.out.println("name : " + user_name[i]);
                System.out.println("email : " + user_email[i]);
                System.out.println("phone : " + user_phone[i]);
                return;
            }
        }
        System.out.println("user not found");
    }

    //---------------for admin panel case 3--------------
    public static void viewAllusers() {
        System.out.println(" =====all useers =====");
        for (int i = 0; i < user_id.length; i++) {
            if (user_id[i] != null) {
                System.out.println("id : " + user_id[i]);
                System.out.println("name : " + user_name[i]);
                System.out.println("email : " + user_email[i]);
                System.out.println("phone : " + user_phone[i]);
                System.out.println("==================");
            }
        }
    }

    //---------------for admin panel case 4-----------------
    public static void updateUser() {
        input.nextLine();
        System.out.print("Enter user id to update :");
        String id = input.nextLine();
        int index = -1;
        for (int i = 0; i < user_id.length; i++) {
            if (id.equalsIgnoreCase(user_id[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("user not found");
            return;
        }
        System.out.println("1: update name");
        System.out.println("2: update email");
        System.out.println("3: update password");
        System.out.println("4: update phone");
        System.out.println("--------------------");
        System.out.print("chose to update :");
        int option = input.nextInt();
        switch (option) {
            case 1:
                input.nextLine();
                System.out.print("enter new name :");
                user_name[index] = input.nextLine();
                break;
            case 2:
                input.nextLine();
                System.out.print("enter new email :");
                user_email[index] = input.nextLine();
                break;
            case 3:
                input.nextLine();
                System.out.print("enter new pasword :");
                user_password[index] = input.nextLine();
                break;
            case 4:
                input.nextLine();
                System.out.print("enter new phone :");
                user_phone[index] = input.nextLine();
                break;

            default:
                System.out.println("Invalid choice. try again.");
                break;

        }
        System.out.println("information updated succsessfully");

    }

    //---------------for admin panel case 5--------------
    public static void showTransactionsHistory() {
        System.out.println("=================ALL TRANSACTIONS HOSTORY================");
        if (TransactionCount == 0)
            System.out.println("No transactions found in the system yet.");
        else if (TransactionCount > 0) {
            for (int i = 0; i < TransactionCount; i++) {
                //System.out.println("transaction id #" + (i + 1) + " : " + tx_id[i]);
                System.out.println("transaction amount #" + (i + 1) + " : " + TransactionsAmount[i]);
                System.out.println("transaction sender #" + (i + 1) + " : " + TransactionsSender[i]);
                System.out.println("transaction receiver #" + (i + 1) + " : " + TransactionsReceiver[i]);
                //System.out.println("transaction status #" + (i + 1) + " : " + tx_confirm[i]);
                System.out.println("----------------------------------------------------------");
            }
        } else
            System.out.println("Invalid transaction count. Try again.");
    }

    //--------------------------------------------------------
    //---------------for admin panel case 6--------------
    public static void blockAccounts() {
        System.out.println("===============BLOCK ACCOUNTS===============");
        System.out.print("enter user id to block account : ");
        input.nextLine();
        String admin_id_input_to_block = input.nextLine();
        for (int i = 0; i < user_id.length; i++) {
            if (admin_id_input_to_block.equals(user_id[i])) {
                System.out.println("You have successfully blocked this account.");
                user_blocked[i] = true;
                found_blocked_id = true;
            }
        }
        if (found_blocked_id == false)
            System.out.println("user id not found.");
    }

    //-----------------------------------------------------------------
    //---------------for admin panel case 7--------------
    public static void unblockAccounts() {
        System.out.println("===============UNBLOCK ACCOUNTS===============");
        System.out.print("enter user id to unblock account : ");
        input.nextLine();
        String admin_id_input_to_unblock = input.nextLine();
        for (int i = 0; i < user_id.length; i++) {
            if (admin_id_input_to_unblock.equals(user_id[i])) {
                System.out.println("You have successfully unblocked this account.");
                user_blocked[i] = false;
                found_unblocked_id = true;
            }
        }
        if (found_unblocked_id == false)
            System.out.println("user id not found.");
    }

    //-----------------------------------------------------------
    //---------------for admin panel case 8--------------
    public static void viewUserDetails() {
        System.out.println("===============View USER DETAILS===============");
        System.out.print("enter user id to view user details : ");
        input.nextLine();
        String admin_id_input_to_view = input.nextLine();
        for (int i = 0; i < user_id.length; i++) {
            if (admin_id_input_to_view.equals(user_id[i])) {
                user_found_details = true;
                System.out.println("details about " + admin_id_input_to_view + " : ");
                System.out.println("------------------------------------");
                System.out.println(" user id : " + user_id[i]);
                System.out.println(" user name : " + user_name[i]);
                System.out.println(" user email : " + user_email[i]);
                System.out.println(" user phone : " + user_phone[i]);
                System.out.println(" user password : " + user_password[i]);
                System.out.println(" user balance : " + user_balances[i]);
                if (user_blocked[i] == false) {
                    System.out.println("user " + admin_id_input_to_view + " is active.");
                } else {
                    System.out.println("user " + admin_id_input_to_view + " is blocked.");
                }
            }
        }
        if (user_found_details == false)
            System.out.println("user id not found.");
    }

    //=========================user methods=========================
    public static void userRegister() {
        System.out.println("===============USER REGISTER===============");
        int index = -1;
        for (int i = 0; i < user_id.length; i++) {
            if (user_id[i] == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("no empty slots available.");
            return;
        }
        user_id[index] = "u_" + (index+1);
        user_favorites[index] = "";
        System.out.print("enter your name :");
        user_name[index] = input.nextLine();
        System.out.println("-------------------");
        System.out.print("enter your email :");
        user_email[index] = input.nextLine();
        System.out.println("-------------------");
        System.out.print("enter your phone :");
        user_phone[index] = input.nextLine();
        System.out.println("-------------------");
        System.out.print("enter your password :");
        user_password[index] = input.nextLine();
        System.out.println("-------------------");
        System.out.print("enter your balance :");
        user_balances[index] = input.nextDouble();
        input.nextLine();
        System.out.println("-------------------");
        System.out.println("You have successfully registered your account.");
    }

    //--------------------------------------------------------------
    public static void USERLOGIN() {
        System.out.println("---------------------------------------");
        System.out.print("Enter UserName :");
        UserNameInput = input.nextLine();
        System.out.println("---------------------------------------");
        System.out.print("Enter Password :");
        String UserPasswordInput = input.nextLine();
        UserIndex = -1;
        for (int i = 0; i < user_name.length; i++) {
            if (user_name[i] != null && UserNameInput.equalsIgnoreCase(user_name[i])) {
                UserIndex = i;
                break;
            }
        }
        if (UserIndex == -1) {
            System.out.println("User not found.");
            System.out.println("------------------");
            return;
        }
        currentUserIndex = UserIndex;
        if (UserNameInput.equalsIgnoreCase(user_name[UserIndex])
                && UserPasswordInput.equals(user_password[UserIndex])) {
            do {
                System.out.println(" ");
                System.out.println("========== USER PANEL ==========");
                System.out.println("");
                System.out.println("1. Show Balance");
                System.out.println("2. Transfer Money");
                System.out.println("3. Transaction History");
                System.out.println("4. Add Favorite");
                System.out.println("5. Remove Favorite");
                System.out.println("6. Show favorite list");
                System.out.println("7. Search Recipient");
                System.out.println("8. View Profile");
                System.out.println("9. Update Profile");
                System.out.println("10. Logout");
                System.out.println("-----------------------------");
                System.out.print("Enter Your Choice :");
                PanelChoice = input.nextInt();
                input.nextLine();
                switch (PanelChoice) {
                    case 1:
                        showBalance();
                        break;
                    case 2:
                        transferMoney();
                        break;
                    case 3:
                        showTransactionHistory();
                        break;
                    case 4:
                        addFavorite();
                        break;
                    case 5:
                        removeFavorite();
                        break;
                    case 6:
                        showFavorites();
                        break;
                    case 7:
                        searchRecipient();
                        break;
                    case 8:
                        viewProfile();
                        break;
                    case 9:
                        updateProfile();
                        break;
                    case 10:
                        System.out.println("--Logging Out--");
                        System.out.println("--Thanks for Using Our App");
                        break;
                    default:
                        System.out.println("Invalid Choice pls Try Again");
                        break;
                }
            } while (PanelChoice != 10);
        } else
            System.out.println("Invalid user input");
        System.out.println("---------------------");
    }

    //-------------user panel for case 1---------------------------
    public static void showBalance() {
        for (int i = 0; i < user_balances.length; i++) {
            if (UserNameInput.equalsIgnoreCase(user_name[i])) {
                System.out.println("Your Balance Is: " + user_balances[i]);
            }
        }
    }

    //-----------------for user panel case 2----------------------
    public static void transferMoney() {
        if (user_blocked[UserIndex]) {
            System.out.println("You are blocked");
            return;
        }
        boolean TransactionCheck = false;
        while (!TransactionCheck) {
            System.out.print("Enter the name of the person you are transferring to : (or type back to exit)");
            transferee = input.nextLine();
            if (transferee.equalsIgnoreCase("back")) {
                System.out.println("logging out");
                break;
            }
            transfereeIndex = -1;
            for (int i = 0; i < user_name.length; i++) {
                if (transferee.equalsIgnoreCase(user_name[i])) {
                    transfereeIndex = i;
                    break;
                }
            }
            if (transfereeIndex == -1) {
                System.out.println("User Not Found");
                System.out.println(" ");
                continue;
            }
            if (transferee.equalsIgnoreCase(user_name[UserIndex])) {
                System.out.println("You cant send money to yourself");
                continue;
            }
            if (user_blocked[transfereeIndex]) {
                System.out.println("The transferee Is Blocked");
                System.out.println(" ");
                continue;
            }
            System.out.print("Enter The Amount You Want to Send :");
            Amount = input.nextDouble();
            input.nextLine();
            if (Amount <= 0) {
                System.out.println("You Cant Transfer This amount");
                System.out.println(" ");
                continue;
            }
            if (user_balances[UserIndex] < Amount) {
                System.out.println("You Dont have enough Money pls recharge");
                System.out.println(" ");
                continue;
            }
            System.out.println("Transfer Completed");
            user_balances[UserIndex] = user_balances[UserIndex] - Amount;
            user_balances[transfereeIndex] = user_balances[transfereeIndex] + Amount;
            System.out.println("--the recipct--");
            System.out.println("The Sender: " + user_name[UserIndex]);
            System.out.println("The Receiver: " + user_name[transfereeIndex]);
            System.out.println("The Amount: " + Amount);
            System.out.println("Your Balance is: " + user_balances[UserIndex]);
            TransactionsSender[TransactionCount] = user_name[UserIndex];
            TransactionsReceiver[TransactionCount] = user_name[transfereeIndex];
            TransactionsAmount[TransactionCount] = Amount;
            TransactionCount = TransactionCount + 1;
            TransactionCheck = true;
        }
    }

    //-----------------for user panel case 3----------------------
    public static void showTransactionHistory() {
        boolean flag = false;
        for (int i = 0; i < TransactionCount; i++) {
            if (TransactionsSender[i].equalsIgnoreCase(user_name[UserIndex]) || TransactionsReceiver[i].equalsIgnoreCase(user_name[UserIndex])) {
                System.out.println("Transaction Num: " + (i + 1));
                System.out.println("The Sender: " + TransactionsSender[i]);
                System.out.println("The Reciever: " + TransactionsReceiver[i]);
                System.out.println("The Amount: " + TransactionsAmount[i]);
                System.out.println(" ");
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("There Is No Transactions");
        }
    }

    //-----------------for user panel case 4----------------------
    public static void addFavorite() {
        System.out.println("=============== ADD TO FAVORITES ===============");

        // Loop added to retry when an invalid ID is entered
        while (true) {
            System.out.print("Enter User ID to add to favorites (or type 'back' to return): ");
            String target_id = input.nextLine();

            // Allow the user to cancel the operation and go back
            if (target_id.equalsIgnoreCase("back")) {
                System.out.println("logging out");
                break;
            }

            // to be sure the user does not add themselves
            if (UserIndex != -1 && user_id[UserIndex] != null && target_id.equalsIgnoreCase(user_id[UserIndex])) {
                System.out.println("Error: You cannot add yourself to favorites. Please try again.\n");
                continue;
            }

            // Searching to verify the user's existence in the system.
            int target_index = -1;
            for (int i = 0; i < user_id.length; i++) {
                if (user_id[i] != null && target_id.equalsIgnoreCase(user_id[i])) {
                    target_index = i;
                    break;
                }
            }

            if (target_index == -1) {
                System.out.println("Error: User ID not found in the system. Please try again.\n");
                continue;
            }

            // Fixed NullPointerException by checking if the element is not null before using equalsIgnoreCase
            if (user_favorites[currentUserIndex] != null && user_favorites[currentUserIndex].equalsIgnoreCase(target_id)) {
                System.out.println("Notification: This user is already in your favorites.");
                return;
            }

            // Save in the designated field for the current connected user
            user_favorites[currentUserIndex] = user_id[target_index];
            System.out.println("Successfully added " + user_name[target_index] + " to your favorites!");
            break;
        }
    }

    //-----------------------------------------------------------
    //-----------------for user panel case 5----------------------
    public static void removeFavorite() {
        System.out.println("=============== REMOVE FROM FAVORITES ===============");

        // Retrieve the stored value for the current user
        String currentFav = user_favorites[currentUserIndex];

        // First, check if the favorites box is already empty for the current user.
        if (currentFav == null || currentFav.equals("")) {
            System.out.println("Error: Your favorites list is already empty.");
            return;
        }

        // Confirm the deletion of the current contact and clear their field only.
        System.out.println("Removing (User ID: " + currentFav + ") from your favorites...");
        user_favorites[currentUserIndex] = "";
        System.out.println("Removed successfully.");
    }

    //-----------------------------------------------------------
    //-----------------for user panel case 6--------------------
    public static void showFavorites() {
        System.out.println("=============== YOUR FAVORITE CONTACTS ===============");

        // Bring the stored value to the current interest
        String currentFav = user_favorites[currentUserIndex];

        // Check if the current user's favorites list is empty
        if (currentFav == null || currentFav.equals("")) {
            System.out.println("Your favorites list is currently empty.");
        } else {
            // Searching the user array to retrieve and display the data of the owner of this ID
            for (int i = 0; i < user_id.length; i++) {
                // Fixed potential NullPointerException by ensuring user_id[i] is not null
                if (user_id[i] != null && currentFav.equalsIgnoreCase(user_id[i])) {
                    System.out.println("- ID: " + user_id[i] + " \n Name: " + user_name[i] + " \n Phone: " + user_phone[i]);
                    break;
                }
            }
        }
        System.out.println("-----------------------------------------------------");
    }

    //-----------------for user panel case 7--------------------
    public static void searchRecipient() {
        System.out.println("=============== SEARCH RECIPIENT ===============");

        // Loop added to allow retrying if the input does not match any existing record
        while (true) {
            System.out.print("Enter Recipient's Email or Phone Number (or type 'back' to return): ");
            String searchInput = input.nextLine();

            if (searchInput.equalsIgnoreCase("back")) {
                break;
            }

            boolean found = false;

            //  Search through the arrays to verify user existence
            for (int i = 0; i < user_id.length; i++) {
                // Fixed NullPointerException by verifying that user_email[i] and user_phone[i] are not null before comparison
                if ((user_email[i] != null && searchInput.equalsIgnoreCase(user_email[i])) ||
                        (user_phone[i] != null && searchInput.equals(user_phone[i]))) {

                    System.out.println("\n[Recipient Found Successfully]");
                    System.out.println("---------------------------------------------");
                    System.out.println("User ID   : " + user_id[i]);
                    System.out.println("Full Name : " + user_name[i]);

                    // Display the account status using clear official text
                    if (user_blocked[i]) {
                        System.out.println("Status    : Blocked Account (Cannot receive transfers)");
                    } else {
                        System.out.println("Status    : Active Account");
                    }
                    System.out.println("---------------------------------------------");

                    found = true;
                    break;
                }
            }

            // Notification message if no match is found in the system
            if (!found) {
                System.out.println("Error: No user found with the provided email or phone number. Please try again.\n");
                continue;
            }

            break;
        }
    }


    //----------------for user panel case 8---------------------
    public static void viewProfile() {
            System.out.println("--Your Profile--");
            System.out.println(" ");
            System.out.println("Your Name: " + user_name[UserIndex]);
            System.out.println("Your ID: " + user_id[UserIndex]);
            System.out.println("Your Phone: " + user_phone[UserIndex]);
            System.out.println("Your Email: " + user_email[UserIndex]);
            System.out.println("Your Password: " + user_password[UserIndex]);
            System.out.println("Your Status: " + user_blocked[UserIndex]);
            System.out.println("Your Balance: " + user_balances[UserIndex]);
    }

    //----------------for user panel case 9---------------------
    public static void updateProfile() {
        System.out.println("=============== UPDATE PROFILE ================");
        int update_chioce = 0;
        while (update_chioce != 5) {
            System.out.println("1. change name.");
            System.out.println("2. change email.");
            System.out.println("3. change phone.");
            System.out.println("4. change password.");
            System.out.println("5. back.");
            System.out.print("Enter Your Choice :");
            update_chioce = input.nextInt();
            switch (update_chioce) {
                case 1:
                    System.out.println("----------------------");
                    System.out.print("Enter new Name :");
                    input.nextLine();
                    user_name[UserIndex] = input.nextLine();
                    System.out.println("--done--");
                    break;
                case 2:
                    System.out.println("----------------------");
                    System.out.print("Enter new Email :");
                    input.nextLine();
                    user_email[UserIndex] = input.nextLine();
                    System.out.println("--done--");
                    break;
                case 3:
                    System.out.println("----------------------");
                    System.out.print("Enter new Phone :");
                    input.nextLine();
                    user_phone[UserIndex] = input.nextLine();
                    System.out.println("--done--");
                    break;
                case 4:
                    System.out.println("----------------------");
                    System.out.print("Enter new Password :");
                    input.nextLine();
                    user_password[UserIndex] = input.nextLine();
                    System.out.println("--done--");
                    break;
                case 5:
                    System.out.println("----------------------");
                    System.out.println("you are logged out from this list.");
                    System.out.println("============THANKS FOR USING=============");
                    break;
                default:
                    System.out.println("----------------------");
                    System.out.println("Invalid choice.please try again.");
                    break;
            }
        }
    }
}
