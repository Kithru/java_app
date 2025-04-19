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
        String bookQuantity;
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
                                        System.out.print("     Please enter Title of the Book : ");
                                        bookName = input.nextLine();
                                        System.out.println();
                                        System.out.print("     Please enter Author's Name : ");
                                        bookAuthor = input.nextLine();
                                        System.out.println();
                                        System.out.print("     Please enter Genre of the Book : ");
                                        bookGenre = input.nextLine();
                                        System.out.println();
                                        System.out.print("     Please enter Quantity : ");
                                        bookQuantity = input.nextLine();

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
                                                String.valueOf(bookId), bookName, bookAuthor, bookGenre, bookQuantity
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
                                    
                                    } while (choice == 'Y' );

                                    // input.close();
                                } else if (bookMenuId == 2) {
                                    char choiceupdate;

                                    do {
                                        for (String[] book : books) {
                                            System.out.println(Arrays.toString(book));
                                        }
                                    
                                        if (!books.isEmpty()) {
                                            clearConsole();
                                            System.out.println("///////////////////////////////// Update Book //////////////////////////////////////");
                                            System.out.println();
                                            System.out.print("     Please enter ID of the Book to update: ");
                                            String bookIdToUpdate = input.nextLine();
                                            System.out.println();
                                    
                                            boolean found = false;
                                    
                                            for (int i = 0; i < books.size(); i++) {
                                                String[] book = books.get(i);
                                    
                                                if (book[0].equalsIgnoreCase(bookIdToUpdate)) {
                                                    System.out.print("     Please enter new Book Title: ");
                                                    bookName = input.nextLine();
                                                    System.out.println();
                                    
                                                    System.out.print("     Please enter new Author's Name: ");
                                                    bookAuthor = input.nextLine();
                                                    System.out.println();
                                    
                                                    System.out.print("     Please enter new Genre of the Book: ");
                                                    bookGenre = input.nextLine();
                                                    System.out.println();
                                    
                                                    System.out.print("     Please enter new Quantity: ");
                                                    bookQuantity = input.nextLine();
                                                    System.out.println();
                                    
                                                    // Update book details assuming the structure:
                                                    // [0] = ID, [1] = Title, [2] = Author, [3] = Genre, [4] = Quantity
                                                    book[1] = bookName;
                                                    book[2] = bookAuthor;
                                                    book[3] = bookGenre;
                                                    book[4] = bookQuantity;
                                    
                                                    books.set(i, book);
                                                    found = true;
                                    
                                                    System.out.println();
                                                    System.out.println("            Book updated successfully!");
                                                    System.out.println();
                                                    break;
                                                }
                                            }
                                    
                                            if (!found) {
                                                System.out.println("      Book not found in the list.");
                                            }
                                    
                                            System.out.print("\nDo you want to update another book? (Y/N): ");
                                            choiceupdate = input.nextLine().toUpperCase().charAt(0);
                                            System.out.println();
                                    
                                        } else {
                                            System.out.println("No books found to update.");
                                            input.nextLine();
                                            break; // Exit if list is empty
                                        }
                                    
                                    } while (choiceupdate == 'Y');

                                } else if (bookMenuId == 3) {
                                    for (String[] book : books) {
                                        System.out.println(Arrays.toString(book));
                                    }
                                    if (!books.isEmpty()) {
                                        clearConsole();
                                        System.out.println("///////////////////////////////// Delete Book //////////////////////////////////////");
                                        System.out.println();
                                        System.out.print("     Please enter ID of the Book to Delete: ");
                                        String bookIdToDelete = input.nextLine();  
                                        System.out.println();
                                    
                                        boolean found = false;
                                    
                                        for (int i = 0; i < books.size(); i++) {
                                            String[] book = books.get(i);

                                            if (book[0].equalsIgnoreCase(bookIdToDelete)) {
                                                books.remove(i);
                                                found = true;
                                                System.out.println("      Book \"" + bookIdToDelete + "\" has been deleted successfully.");
                                                break; 
                                            }
                                        }
                                    
                                        if (!found) {
                                            System.out.println("      Book not found in the list to Delete.");
                                        }
                                    
                                    } else {
                                        System.out.println("No books found to Delete.");
                                        input.nextLine();
                                    }
                                } else if (bookMenuId == 4) {
                                    if (!books.isEmpty()) {
                                        clearConsole();
                                        System.out.println("///////////////////////////////// Search Book //////////////////////////////////////");
                                        System.out.println();
                                        System.out.print("      Please enter Book ID for Search: ");
                                        String bookIdToSearch = input.nextLine();  
                                        System.out.println();
                                    
                                        boolean found = false;
                                    
                                        for (int i = 0; i < books.size(); i++) {
                                            String[] book = books.get(i);
                                    
                                            if (book[0].equalsIgnoreCase(bookIdToSearch)) {
                                                found = true;
                                                System.out.println("      Book Found.");
                                                System.out.println();
                                                System.out.println("      Name      : " + book[0]);
                                                System.out.println("      ID        : " + book[1]);
                                                System.out.println("      Author    : " + book[2]); 
                                                System.out.println("      Publisher : " + book[3]); 
                                                System.out.println("      Quantity  : " + book[4]); 
                                                input.nextLine();
                                                break;
                                            }
                                        }
                                    
                                        if (!found) {
                                            System.out.println("      Book not found in the list.");
                                        }
                                    
                                    } else {
                                        System.out.println("No books found.");
                                        input.nextLine();
                                    }
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