import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class application {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean islogin = true;
        boolean mainMenu = true; 
        boolean bookMenu = true;
        boolean memberMenu = true;
        String bookName;  
        String bookAuthor; 
        String bookGenre; 
        String bookQuantity;
        String memberName;  
        String memberContactNumber; 
        String memberEmail; 

        List<String[]> books = new ArrayList<>();
        List<String[]> members = new ArrayList<>();

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
                                        clearConsole();
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
                                            break; 
                                        }
                                    
                                    } while (choiceupdate == 'Y');

                                } else if (bookMenuId == 3) {
                                    char choicedelete;
                                    do {
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

                                            System.out.print("\nDo you want to delete another book? (Y/N): ");
                                            choicedelete = input.nextLine().toUpperCase().charAt(0);
                                            System.out.println();

                                        } else {
                                            System.out.println("No books found to Delete.");
                                            input.nextLine();
                                            break; 
                                        }
                                    } while (choicedelete == 'Y');

                                } else if (bookMenuId == 4) {
                                    char choicesearch;

                                    do {
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

                                                // Assuming book[0] = ID, book[1] = Name, book[2] = Author, book[3] = Publisher, book[4] = Quantity
                                                if (book[0].equalsIgnoreCase(bookIdToSearch)) {
                                                    found = true;
                                                    System.out.println("      Book Found.");
                                                    System.out.println();
                                                    System.out.println("      ID        : " + book[0]);
                                                    System.out.println("      Name      : " + book[1]);
                                                    System.out.println("      Author    : " + book[2]); 
                                                    System.out.println("      Publisher : " + book[3]); 
                                                    System.out.println("      Quantity  : " + book[4]); 
                                                    break;
                                                }
                                            }

                                            if (!found) {
                                                System.out.println("      Book not found in the list.");
                                            }

                                            System.out.print("\nDo you want to search another book? (Y/N): ");
                                            choicesearch = input.nextLine().toUpperCase().charAt(0);
                                            System.out.println();

                                        } else {
                                            System.out.println("No books found.");
                                            input.nextLine();
                                            break;
                                        }
                                    } while (choicesearch == 'Y');
                                } else if (bookMenuId == 5) {
                                    clearConsole();
                                    if (!books.isEmpty()) {
                                        clearConsole();
                                        System.out.println("//////////////////////////////////// View All Books /////////////////////////////////////////");
                                        System.out.println();
                                        System.out.println();
                                        System.out.printf("%-5s %-10s %-25s %-20s %-20s %-10s\n", "No.", "ID", "Name", "Author", "Publisher", "Quantity");
                                        System.out.println("----------------------------------------------------------------------------------------------");
                                        
                                        for (int i = 0; i < books.size(); i++) {
                                            String[] book = books.get(i);
                                            
                                            System.out.printf("%-5d %-10s %-25s %-20s %-20s %-10s\n", 
                                                (i + 1), book[0], book[1], book[2], book[3], book[4]);
                                        }
                                        
                                        System.out.println("----------------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println("      Total Books: " + books.size());
                                        System.out.println();
                                        System.out.println("\nPress Enter to continue...");
                                        input.nextLine();
                                        break;
                                    } else {
                                        System.out.println("No books found.");
                                        input.nextLine();
                                    }
                                } else if (bookMenuId == 6) {
                                    clearConsole();
                                    mainMenu = true;
                                } else {
                                    System.out.println("Invalid option. Please try again.");
                                }
                        }    
                    } else if (menuid == 2) {
                        while (memberMenu) {
                            clearConsole();
                            System.out.println("///////////////////////////////// Manage Members //////////////////////////////////////");
                            System.out.println();
                            System.out.println("        1. Add Member");
                            System.out.println("        2. Update Member");
                            System.out.println("        3. Delete Member");
                            System.out.println("        4. Search Member");
                            System.out.println("        5. View All Members");
                            System.out.println("        6. Return to The Menu");
                            System.out.println();
                            System.out.print("        Please Enter Number to continue: ");
                            
                            int memberMenuId = input.nextInt();
                            input.nextLine(); 
                            if (memberMenuId == 1) {
                                clearConsole();
                                int memberCount = 0;
                                char choiceMember;
                                
                                do {
                                    int memberId = 1 + memberCount;
                                    clearConsole();
                                    System.out.println("///////////////////////////////// Add Member //////////////////////////////////////");
                                    System.out.println();
                                    System.out.print("     Please enter Name of the Member : ");
                                    memberName = input.nextLine();
                                    System.out.println();
                                    System.out.print("     Please enter Contact Number : ");
                                    memberContactNumber = input.nextLine();
                                    System.out.println();
                                    System.out.print("     Please enter Email of the Member : ");
                                    memberEmail = input.nextLine();

                                    boolean isDuplicate = false;
                                    for (String[] member : members) {
                                        if (member[1].equalsIgnoreCase(memberName) 
                                            || member[2].equalsIgnoreCase(memberContactNumber)
                                            || member[3].equalsIgnoreCase(memberEmail) )
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
                                            String.valueOf(memberId), memberName, memberContactNumber, memberEmail
                                        });
                                        System.out.println();
                                        System.out.println("\n           Book Added Successfully.");
                                        System.out.println();

                                        System.out.println("Full Book List (for Testing):");
                                        for (String[] book : books) {
                                            System.out.println(Arrays.toString(book));
                                        }
                                        memberCount++;
                                    }
                                    System.out.print("\nDo you want to add another book? (Y/N): ");
                                    choiceMember = input.nextLine().toUpperCase().charAt(0);
                                
                                } while (choiceMember == 'Y' );

                                // input.close();
                            } else if (memberMenuId == 2) {
                                
                                char choiceUpdateMember;

                                do {
                                    for (String[] member : members) {
                                        System.out.println(Arrays.toString(member));
                                    }

                                    if (!members.isEmpty()) {
                                        clearConsole();
                                        System.out.println("///////////////////////////////// Update Member //////////////////////////////////////");
                                        System.out.println();

                                        System.out.print("     Please enter ID of the Member to update: ");
                                        String memberIdToUpdate = input.nextLine();
                                        System.out.println();

                                        boolean found = false;

                                        for (int i = 0; i < members.size(); i++) {
                                            String[] member = members.get(i);

                                            if (member[0].equalsIgnoreCase(memberIdToUpdate)) {
                                                System.out.print("     Please enter new Name of the Member: ");
                                                memberName = input.nextLine();
                                                System.out.println();

                                                System.out.print("     Please enter new Contact Number: ");
                                                memberContactNumber = input.nextLine();
                                                System.out.println();

                                                System.out.print("     Please enter new Email of the Member: ");
                                                memberEmail = input.nextLine();
                                                System.out.println();

                                                // Update member details
                                                member[1] = memberName;
                                                member[2] = memberContactNumber;
                                                member[3] = memberEmail;

                                                members.set(i, member);
                                                found = true;

                                                System.out.println();
                                                System.out.println("            Member details updated successfully!");
                                                System.out.println();
                                                break;
                                            }
                                        }

                                        if (!found) {
                                            System.out.println("      Member not found in the list.");
                                        }

                                        System.out.print("\nDo you want to update another member? (Y/N): ");
                                        choiceUpdateMember = input.nextLine().toUpperCase().charAt(0);
                                        System.out.println();

                                    } else {
                                        System.out.println("No members found to update.");
                                        input.nextLine();
                                        break;
                                    }

                                } while (choiceUpdateMember == 'Y');

                            } else if (memberMenuId == 3) {
                                char choiceDeleteMember;
                                do {
                                    if (!members.isEmpty()) {
                                        clearConsole();
                                        System.out.println("///////////////////////////////// Delete Member //////////////////////////////////////");
                                        System.out.println();
                                        System.out.print("     Please enter ID of the Member to Delete: ");
                                        String memberIdToDelete = input.nextLine();  
                                        System.out.println();

                                        boolean foundMember = false;

                                        for (int i = 0; i < members.size(); i++) {
                                            String[] member = members.get(i);

                                            if (member[0].equalsIgnoreCase(memberIdToDelete)) {
                                                members.remove(i);
                                                foundMember = true;
                                                System.out.println("      Member \"" + memberIdToDelete + "\" has been deleted successfully.");
                                                break;
                                            }
                                        }

                                        if (!foundMember) {
                                            System.out.println("      Member not found in the list to Delete.");
                                        }

                                        System.out.print("\nDo you want to delete another member? (Y/N): ");
                                        choiceDeleteMember = input.nextLine().toUpperCase().charAt(0);
                                        System.out.println();

                                    } else {
                                        System.out.println("No members found to Delete.");
                                        input.nextLine();
                                        break; 
                                    }
                                } while (choiceDeleteMember == 'Y');

                            } else if (memberMenuId == 4) {
                                char choiceSearchMember;

                                do {
                                    if (!members.isEmpty()) {
                                        clearConsole();
                                        System.out.println("///////////////////////////////// Search Member //////////////////////////////////////");
                                        System.out.println();
                                        System.out.print("      Please enter Member ID for Search: ");
                                        String memberIdToSearch = input.nextLine();  
                                        System.out.println();

                                        boolean foundMember = false;

                                        for (int i = 0; i < members.size(); i++) {
                                            String[] member = members.get(i);

                                            // Assuming book[0] = ID, book[1] = Name, book[2] = Author, book[3] = Publisher, book[4] = Quantity
                                            if (member[0].equalsIgnoreCase(memberIdToSearch)) {
                                                foundMember = true;
                                                System.out.println("      Member Found.");
                                                System.out.println();
                                                System.out.println("      ID        : " + member[0]);
                                                System.out.println("      Name      : " + member[1]);
                                                System.out.println("      Author    : " + member[2]); 
                                                System.out.println("      Publisher : " + member[3]); 
                                                System.out.println("      Quantity  : " + member[4]); 
                                                break;
                                            }
                                        }

                                        if (!foundMember) {
                                            System.out.println("      Member not found in the list.");
                                        }

                                        System.out.print("\nDo you want to search another member? (Y/N): ");
                                        choiceSearchMember = input.nextLine().toUpperCase().charAt(0);
                                        System.out.println();

                                    } else {
                                        System.out.println("No members found.");
                                        input.nextLine();
                                        break;
                                    }
                                } while (choiceSearchMember == 'Y');
                            } else if (memberMenuId == 5) {
                                clearConsole();
                                if (!members.isEmpty()) {
                                    clearConsole();
                                    System.out.println("//////////////////////////////////// View All Members /////////////////////////////////////////");
                                    System.out.println();
                                    System.out.println();
                                    System.out.printf("%-5s %-10s %-25s %-20s %-20s %-10s\n", "No.", "ID", "Name", "Author", "Publisher", "Quantity");
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    
                                    for (int i = 0; i < members.size(); i++) {
                                        String[] member = members.get(i);
                                        
                                        System.out.printf("%-5d %-10s %-25s %-20s %-20s %-10s\n", 
                                            (i + 1), member[0], member[1], member[2], member[3], member[4]);
                                    }
                                    
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.println("      Total Members: " + members.size());
                                    System.out.println();
                                    System.out.println("\nPress Enter to continue...");
                                    input.nextLine();
                                    break;
                                } else {
                                    System.out.println("No member found.");
                                    input.nextLine();
                                }
                            } else if (memberMenuId == 6) {
                                clearConsole();
                                mainMenu = true;
                            } else {
                                System.out.println("Invalid option. Please try again.");
                            }
                        }   
                    } else if (menuid == 3) {
                        clearConsole();
                        System.out.println("Issue Book");
                        input.nextLine(); 
                    } else if (menuid == 4) {
                        clearConsole();            
                        System.out.println("Return Book");
                        input.nextLine(); 
                    } else if (menuid == 5) {
                        clearConsole();
                        System.out.println("View Reports");
                        input.nextLine(); 
                    } else if (menuid == 6) {
                        clearConsole();
                        mainMenu = false; 
                        islogin = true; 
                        // input.nextLine(); 
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