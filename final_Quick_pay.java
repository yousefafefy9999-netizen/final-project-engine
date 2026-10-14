import java.util.Scanner;
public class mg {
    // please define the variables and the arrays here
    static Scanner input = new Scanner(System.in);
    //-------------------ADMIN DATA-----------------------------
    static boolean user_found_details = false;
    static boolean found_blocked_id = false;
    static boolean found_unblocked_id = false;
    static int admin_choice;
    static String admin_name = "admin";
    static String admin_password = "admin1234";
    //------------------USER DATA-------------------------------
    static String[] user_id = {"U_1", "U_2", "U_3", "U_4"};
    static String[] user_name = {"ahmed", "yousef", "omar", "abdelarahman"};
    static String[] user_email = {"ahmed@email.com", "yousef@email.com", "omar@eamil.com", "abdelarahman@email.com"};
    static String[] user_phone = {"01011111111", "01022222222", "01033333333", "010444444444"};
    static String[] user_password = {"a111", "y222", "o333", "a444"};
    static double[] user_balances = {20000, 20000, 20000, 20000};
    static boolean[] user_blocked = {false, false, false, false};
    static String[] user_favorites = {"", "", "", ""};
    static int currentUserIndex = -1; 
    static String UserNameInput;
    static int choice; // the user choice
    static int UserChoice;
    //-------------------------TRANSFER INFORMATION----------------------------------
    static String[] tx_id = {"t1", "", "", ""};
    static String[] tx_sender = {"ahmed", "", "", ""};
    static String[] tx_receiver = {"omar", "", "", ""};
    static double[] tx_amount = {2000, 0, 0, 0};
    static boolean[] tx_confirm = {true, false, false, false};
    static int tx_count = 1;
    // i have enterd this data randomly, and we might be able to chage it

    public static void main(String[] args) {
        do {
            System.out.println("================ WELCOME TO QUICK PAY ================\n");
            System.out.println("1. login as admin.");
            System.out.println("2. login as user.");
            System.out.println("3. Exit.");
            System.out.println("-----------------------------------------------");
            System.out.print("Enter your choice:");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
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
                                    //------------------------------------
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
                                    vewUserDetails();
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
                    USERLOGIN();
                    switch (UserChoice) {
                        case 1:
                            showBalance();
                            break;
                        case 2:

                            break;
                        case 3:

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

                            break;
                        case 8:

                            break;
                        case 9:

                            break;
                        case 10:
                            System.out.println("you are logged out from admin.");
                            System.out.println("============THANKS FOR USING=============");
                            break;
                        default:
                            System.out.println("Invalid choice. try again.");
                            break;
                    }
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
        int totalusers = user_id.length;
        int activeusers = 0;
        int blockedusers = 0;
        double totalbalance = 0;

        for (int i = 0; i < user_id.length; i++) {
            if (user_blocked[i]) {
                blockedusers++;
            } else {
                activeusers++;
            }
            totalbalance = totalbalance + user_balances[i];
        }
        System.out.println("=====system statistics=====");
        System.out.println("total users : " + totalusers);
        System.out.println(" active users : " + activeusers);
        System.out.println("blocked users : " + blockedusers);
        System.out.println("total balance : " + totalbalance);
        System.out.println("total transactions : " + tx_count);

    }

    //---------------for admin panel case 2--------------
    public static void searchUser() {
        System.out.print("Enter user iD : ");
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
            System.out.println("id : " + user_id[i]);
            System.out.println("name : " + user_name[i]);
            System.out.println("email : " + user_email[i]);
            System.out.println("phone : " + user_phone[i]);
            System.out.println("==================");
        }
    }
    //---------------for admin panel case 4-----------------
public static void  updateUser(){
System.out.println("Enter user id to update");
String id = input.nextLine();
int index=0;
for (int i = 0; i < user_id.length; i++) {
    if (id.equalsIgnoreCase(user_id[i])) {
index=i;
break;        
    }else{
        System.out.println("user not found");
        return;
    }
    
}
System.out.println("1: update name");
System.out.println("2: update email");
System.out.println("3: update password");
System.out.println("4: update phone");
System.out.println("5: update name");
System.out.println("chose to update");
int option = input.nextInt();
switch (option) {
    case 1:
        System.out.println("enter new name :");
        user_name [index]=input.nextLine();
        break;
        case 2:
                    System.out.println("enter new email :");
                    user_email=input.nextLine();
        break;
        case 3:
System.out.println("enter new pasword :");
user_password=input.nextInt();
        break;
System.out.println("enter new phone :");
user_phone=input.nextInt();
        break;

    default:
        
}System.out.println("information apdated succsessfully");

}

    //---------------for admin panel case 5--------------
    public static void showTransactionsHistory() {
        System.out.println("=================ALL TRANSACTIONS HOSTORY================");
        if (tx_count == 0)
            System.out.println("No transactions found in the system yet.");
        else if (tx_count > 0) {
            for (int i = 0; i < tx_count; i++) {
                System.out.println("transaction id #" + (i + 1) + " : " + tx_id[i]);
                System.out.println("transaction amount #" + (i + 1) + " : " + tx_amount[i]);
                System.out.println("transaction sender #" + (i + 1) + " : " + tx_sender[i]);
                System.out.println("transaction receiver #" + (i + 1) + " : " + tx_receiver[i]);
                System.out.println("transaction status #" + (i + 1) + " : " + tx_confirm[i]);
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
    public static void vewUserDetails() {
        System.out.println("===============Vew USER DETAILS===============");
        System.out.print("enter user id to vew user details : ");
        input.nextLine();
        String admin_id_input_to_vew = input.nextLine();
        for (int i = 0; i < user_id.length; i++) {
            if (admin_id_input_to_vew.equals(user_id[i])) {
                user_found_details = true;
                System.out.println("details about " + admin_id_input_to_vew + " : ");
                System.out.println("------------------------------------");
                System.out.println(" user id : " + user_id[i]);
                System.out.println(" user name : " + user_name[i]);
                System.out.println(" user email : " + user_email[i]);
                System.out.println(" user phone : " + user_phone[i]);
                System.out.println(" user password : " + user_password[i]);
                System.out.println(" user balance : " + user_balances[i]);
                if (user_blocked[i] == false) {
                    System.out.println("user " + admin_id_input_to_vew + " is active.");
                } else {
                    System.out.println("user " + admin_id_input_to_vew + " is blocked.");
                }
            }
        }
        if (user_found_details == false)
            System.out.println("user id not found.");
    }

    //=========================user methods=========================
    public static void USERLOGIN() {
        boolean Found = false;
        while (!Found) {
            System.out.println("--------------------------");
            System.out.print("Enter UserName :");
            UserNameInput = input.nextLine();
            for (int i = 0; i < user_name.length; i++) {
                if (UserNameInput.equalsIgnoreCase(user_name[i])) {
                    System.out.println("---------------------------------");
                    System.out.print("Enter Password :");
                    String UserPasswordInput = input.nextLine();
                    if (UserPasswordInput.equalsIgnoreCase(user_password[i])) {
                        System.out.println(" ");
                        System.out.println("You have successfully logged in.");
                        System.out.println("========== USER PANEL ==========");
                        System.out.println("");


                               System.out.println(
                                       "1. Show Balance\n2. Transfer Money\n3. Show Transaction History\n4. Add Favorites\n5. Remove Favorite\n6. Show Favorite\n7. Search Recipient\n8. View Profile\n9. Update Profile\n10. Logout");
                               Found = true;
                           } else
                        System.out.println("Wrong UserName Or Password pls try again");
                        break;
                    }
                }
            }
            System.out.print("Enter Your Choice :");
            UserChoice = input.nextInt();
        }


    //-------------user panel for case 1---------------------------
    public static void showBalance(){
        for (int i = 0 ; i < user_balances.length ; i++) {
            if (UserNameInput.equalsIgnoreCase(user_name[i])) {
                System.out.println("Your Balance Is: " + user_balances[i]);
            }
        }
    }
    //-----------------for user panel case 4----------------------
    public static void addFavorite() {
        System.out.println("=============== ADD TO FAVORITES ===============");
        System.out.print("Enter User ID to add to favorites (e.g., U_2): ");
        String target_id = input.nextLine();

        // to be sure the user does not add themselves
        if (target_id.equalsIgnoreCase(user_id[currentUserIndex])) {
            System.out.println("Error: You cannot add yourself to favorites.");
            return;
        }

        // Searching to verify the user's existence in the system.
        int target_index = -1;
        for (int i = 0; i < user_id.length; i++) {
            if (target_id.equalsIgnoreCase(user_id[i])) {
                target_index = i;
                break;
            }
        }

        if (target_index == -1) {
            System.out.println("Error: User ID not found in the system.");
            return;
        }

      
        if (user_favorites[currentUserIndex].equalsIgnoreCase(target_id)) {
            System.out.println("Notification: This user is already in your favorites.");
            return;
        }

        // Save in the designated field for the current connected user
        user_favorites[currentUserIndex] = user_id[target_index];
        System.out.println("Successfully added " + user_name[target_index] + " to your favorites!");
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
                if (currentFav.equalsIgnoreCase(user_id[i])) {
                    System.out.println("- ID: " + user_id[i] + " | Name: " + user_name[i] + " | Phone: " + user_phone[i]);
                    break; 
                }
            }
        }
        System.out.println("-----------------------------------------------------");
    }
       //-----------------------------------------------------------

}


