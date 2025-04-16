import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class coursework {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean islogin = true;
        boolean mainMenu = true; 
        boolean bookMenu = true;
        String bookName;  
        String bookAuthor; 
        String bookGenre; 
        int bookQuantity;
        List<String[]> books = new ArrayList<>();

        while (islogin) { 
            String login;
            while (true) {
                clearConsole(); 
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
                    mainMenu = true; 
                    islogin = false; 
                    login = "success";
                    input.nextLine(); 
                    clearConsole(); 
                    break;

                } else {
                    clearConsole(); 
                    System.out.println();
                    System.out.println("                        Invalid User Credentials.");
                    System.out.println();
                    System.out.println("                        Press Enter to continue.");
                    System.out.println();
                    input.nextLine(); 
                    islogin = true; 
                }
            }
            
            while (mainMenu) { 
                
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

                    if (menuid == 1) {
                        while (bookMenu) {
                                clearConsole();
                                System.out.println("///////////////////////////////// Manage Books //////////////////////////////////////");
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
                                if (bookMenuId == 1) {
                                    clearConsole();
                                    int bookCount = 0;
                                    char choice;

                                    do {
                                        int bookId = 1 + bookCount;

                                        System.out.println("///////////////////////////////// Add Book //////////////////////////////////////");
                                        System.out.println();
                                        System.out.print("     Please enter Name of the Book : ");
                                        bookName = input.nextLine();
                                        System.out.println();
                                        System.out.print("     Please enter Author's Name : ");
                                        bookAuthor = input.nextLine();
                                        System.out.println();
                                        System.out.print("     Please enter Genre of the Book : ");
                                        bookGenre = input.nextLine();
                                        System.out.println();
                                        System.out.print("     Please enter Quantity : ");
                                        bookQuantity = input.nextInt();

                                        boolean isDuplicate = false;
                                        for (String[] book : books) {
                                            if (book[1].equalsIgnoreCase(bookName) )
                                                // || book[2].equalsIgnoreCase(bookAuthor)
                                                // || book[3].equalsIgnoreCase(bookGenre)
                                                // || book[4].equals(bookQuantity)) 
                                                {
                                                isDuplicate = true;
                                                break;
                                            }
                                        }
                                        if (isDuplicate) {
                                            System.out.println();
                                            System.out.println("\n    This book already exists in the system. Duplicate not added.");
                                            System.out.println();
                                        } else {

                                            books.add(new String[] {
                                                String.valueOf(bookId), bookName, bookAuthor, bookGenre, Integer.toString(bookQuantity)
                                            });
                                            System.out.println();
                                            System.out.println("\n           Book Added Successfully.");
                                            System.out.println();

                                            System.out.println("Full Book List (for Testing):");
                                            for (String[] book : books) {
                                                System.out.println(Arrays.toString(book));
                                            }
                                            bookCount++;
                                        }
                                        System.out.print("\nDo you want to add another book? (Y/N): ");
                                        choice = input.nextLine().toUpperCase().charAt(0);
                                    
                                    } while (choice == 'Y' ) ;

                                    // input.close();
                                } else if (bookMenuId == 2) {
                                    
                                    for (String[] book : books) {
                                        System.out.println(Arrays.toString(book));
                                    }
                                    if (!books.isEmpty()) {
                                        System.out.println("///////////////////////////////// Update Book //////////////////////////////////////");
                                        System.out.println();
                                        System.out.print("     Please enter Name of the Book to update: ");
                                        String bookNameToUpdate = input.nextLine();
                                        System.out.println();

                                        boolean found = false;

                                        for (int i = 0; i < books.size(); i++) {
                                            String[] book = books.get(i);

                                            if (book[1].equalsIgnoreCase(bookNameToUpdate)) {
                                                System.out.print("     Please enter new Author's Name: ");
                                                bookAuthor = input.nextLine();
                                                System.out.println();

                                                System.out.print("     Please enter new Genre of the Book: ");
                                                bookGenre = input.nextLine();
                                                System.out.println();

                                                System.out.print("     Please enter new Quantity: ");
                                                bookQuantity = input.nextInt();
                                                input.nextLine(); 
                                                System.out.println();

                                                book[2] = bookAuthor;
                                                book[3] = bookGenre;
                                                book[4] = String.valueOf(bookQuantity);

                                                books.set(i, book); 
                                                System.out.println("      Book updated successfully!");
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (!found) {
                                            System.out.println("      Book not found in the list.");
                                        }

                                    } else {
                                        System.out.println("No books found to update.");
                                        input.nextLine();
                                    }
                                   
                                    System.out.println("Update Books");
                                    input.nextLine();

                                    // clearConsole();
                                    // System.out.println("Update Books");
                                } else if (bookMenuId == 3) {
                                    clearConsole();
                                    System.out.println("Delete Books");
                                } else if (bookMenuId == 4) {
                                    clearConsole();
                                    System.out.println("Search Books");
                                } else if (bookMenuId == 5) {
                                    clearConsole();
                                    System.out.println("View All Books");
                                } else if (bookMenuId == 6) {
                                    clearConsole();
                                    mainMenu = true;
                                }  else {
                                    System.out.println("Invalid option. Please try again.");
                                }
                        }    
                    } else if (menuid == 2) {
                        clearConsole();
                        System.out.println("Manage Members");
                        input.nextLine(); 
                    } else if (menuid == 3) {
                        clearConsole();
                        System.out.println("Manage Members");
                        input.nextLine(); 
                    } else if (menuid == 4) {
                        clearConsole();            
                        System.out.println("Manage Members");
                        input.nextLine(); 
                    } else if (menuid == 5) {
                        clearConsole();
                        System.out.println("Manage Members");
                        input.nextLine(); 
                    } else if (menuid == 6) {
                        clearConsole();
                        mainMenu = false; 
                        islogin = true; 
                        input.nextLine(); 
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
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