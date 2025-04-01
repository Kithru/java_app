
import java.util.Scanner;

class coursework {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
            System.out.println("////////////////////////////// MAIN MENU //////////////////////////////////////");
            System.out.println();
            System.out.println("        1. Manage Books");
            System.out.println("        2. Manage Members");
            System.out.println("        3. Issue Books");
            System.out.println("        4. Return Books");
            System.out.println("        5. View Reports");
            System.out.println("        6. Logout");
            System.out.println();
            System.out.print("        Please Enter Number for continue : ");
            int menuid = input.nextInt();
            input.nextLine(); 
            clearConsole();

            if (menuid == 1) {
                System.out.println("Manage Books");
            } else if (menuid == 2) {
                System.out.println("Manage Members");
            } else if (menuid == 3) {
                System.out.println("Issue Books");
            } else if (menuid == 4) {
                System.out.println("Return Books");
            } else if (menuid == 5) {
                System.out.println("View Reports");
            } else if (menuid == 6) {
                System.out.println("Logout");
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