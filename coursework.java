
import java.util.Scanner;

class coursework {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) { 
            String login;
            while (true) {
                System.out.println();
                System.out.println("////////////////////////////// SYSTEM LOGIN //////////////////////////////////////");
                System.out.println();
                System.out.print("     Please enter Username : ");
                String username = input.nextLine();
                System.out.println();
                System.out.print("     Please enter Password : ");
                String password = input.nextLine();
                clearConsole();

                if ((username.equals("Test")) && (password.equals("1234"))) {
                    System.out.println();
                    System.out.println("              Successfully Logged in; Press Enter to continue.");
                    System.out.println();
                    login = "success";
                    input.nextLine(); 
                    clearConsole(); 
                    break;

                } else {
                    System.out.println();
                    System.out.println("                        Invalid User Credentials.");
                    System.out.println();
                }
            }

            if (login.equals("success")) {
                System.out.println("///////////////////////////////// MAIN MENU //////////////////////////////////////");
                System.out.println();
                System.out.println("        1. Manage Books");
                System.out.println("        2. Manage Members");
                System.out.println("        3. Issue Books");
                System.out.println("        4. Return Books");
                System.out.println("        5. View Reports");
                System.out.println("        6. Logout");
                System.out.println();
                System.out.print("        Please Enter Number to continue: ");
                
                int menuid = input.nextInt();
                input.nextLine(); 
            
                int menu = -1; 
            
                switch (menuid) {
                    case 1:
                        clearConsole();
                        menu = 1;
                        break;
                    case 2:
                        clearConsole();
                        menu = 2; 
                        break;
                    case 3:
                        clearConsole();
                        menu = 3;
                        System.out.println("Issue Books");
                        break;
                    case 4:
                        clearConsole();
                        menu = 4;
                        System.out.println("Return Books");
                        break;
                    case 5:
                        clearConsole();
                        menu = 5;
                        System.out.println("View Reports");
                        break;
                    case 6:
                        clearConsole();
                        menu = 6;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            
                if (menu == 1) {
                        clearConsole();
                        System.out.println("//////////  Manage Books  //////////");
                        System.out.println();
                        System.out.println("        1. Add Book");
                        System.out.println("        2. Update Book");
                        System.out.println("        3. Delete Book");
                        System.out.println("        4. Search Books");
                        System.out.println("        5. View All Books");
                        System.out.println("        6. Return to The Menu");
                        System.out.println();
                        System.out.print("        Please Enter Number to continue: ");
                        
                        int bookMenuId = input.nextInt();
                        input.nextLine(); 
                        int bookmenu = -1; 

                        switch (bookMenuId) {
                            case 1: 
                                bookmenu = 1;
                                break;
                            case 2:
                                bookmenu = 2; 
                                break;
                            case 3:
                                bookmenu = 3;
                                break;
                            case 4:
                                bookmenu = 4;
                                break;
                            case 5:
                                clearConsole();
                                bookmenu = 5;
                                System.out.println("View All Books");
                                break;
                            case 6:
                                clearConsole();
                                bookmenu = 6;
                                // break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;      
                        }
                        if (bookmenu == 1) {
                            clearConsole();
                            System.out.println("Add Books");
                            break; 
                        } else if (bookmenu == 2) {
                            clearConsole();
                            System.out.println("Update Books");
                            break; 
                        } else if (bookmenu == 3) {
                            clearConsole();
                            System.out.println("Delete Books");
                            break; 
                        } else if (bookmenu == 4) {
                            clearConsole();
                            System.out.println("Search Books");
                            break; 
                        } else if (bookmenu == 5) {
                            clearConsole();
                            System.out.println("View All Books");
                            break; 
                        } else if (bookmenu == 6) {
                            clearConsole();
                            input.nextLine(); 
                            // continue;
                        } else {

                        }
                } else if (menu == 2) {
                    clearConsole();
                    System.out.println("Manage Members");
                    input.nextLine(); 
                } else if (menu == 3) {
                    clearConsole();
                    System.out.println("Manage Members");
                    input.nextLine(); 
                } else if (menu == 4) {
                    clearConsole();            
                    System.out.println("ABCD");
                    System.out.println("Manage Members");
                    input.nextLine(); 
                } else if (menu == 5) {
                    clearConsole();
                    System.out.println("Manage Members");
                    input.nextLine(); 
                } else if (menu == 6) {
                    clearConsole();
                    // input.nextLine(); 
                } else {

                }
            }  
        }    
    }

    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Linux")) { // for linix OS
                System.out.print("\033\143");
            } else if (os.contains("Windows")) { // For Windows OS
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (final Exception e) {
            // Handle the exception
            System.err.println(e.getMessage());
        }
    }

}