import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class application {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean islogin = true; // declare and initializ islogin 
        boolean mainMenu = true; // declare and initializ mainMenu
        boolean bookMenu = true; // declare and initializ bookMenu 
        boolean memberMenu = true;  // declare and initializ memberMenu 
        boolean reportMenu = true; // declare and initializ reportMenu 
        String username01 = "Test"; // declare and initializ username01
        String password01 = "1234"; // declare and initializ password01
        int bookCount = 0; // declare and initializ bookCount
        int memberCount = 0; // declare and initializ memberCount
        int issuedCount = 0; // declare and initializ issuedCount
        String bookName;   // declare bookName
        String bookAuthor; // declare bookAuthor
        String bookGenre;  // declare bookGenre
        String bookQuantity; // declare bookQuantity
        String memberName;  // declare memberName
        String memberContactNumber; // declare memberContactNumber
        String memberEmail; // declare memberEmail

        String[][] books = new String[10][5]; // 10 values
        String[][] members = new String[10][4]; // 10 values
        String[][] issuedBooks = new String[10][4]; // 10 values

        while (islogin) { 
            String login;
            while (true) {
                // Syetem login (Username is - Test , Password is - 1234 )
                clearConsole(); 
                System.out.println();
                System.out.println("////////////////////////////// SYSTEM LOGIN //////////////////////////////////////");
                System.out.println();
                System.out.print("     Please enter Username : "); 
                String username = input.nextLine(); // need to enter username
                System.out.println();
                System.out.print("     Please enter Password : ");
                String password = input.nextLine(); // need to enter password
                clearConsole();

                if (username.equals(username01) && password.equals(password01)) {
                    System.out.println();
                    System.out.println("              Successfully Logged in; Press Enter to continue."); // successfull alert
                    System.out.println();
                    mainMenu = true;  // set mainMenu as true
                    islogin = false;  // set islogin as ture
                    login = "success"; // set login as success
                    input.nextLine(); 
                    clearConsole(); // clear cli
                    break;

                } else {
                    clearConsole(); 
                    System.out.println();
                    System.out.println("                        Invalid User Credentials."); // error alert
                    System.out.println();
                    System.out.println("                        Press Enter to continue.");
                    System.out.println();
                    input.nextLine(); // clear cli
                    islogin = true; 
                }
            }
            
            while (mainMenu) { 
                // main manu of the application
                if (login.equals("success")) { // check is login equals to 'success'
                    System.out.println("///////////////////////////////// MAIN MENU //////////////////////////////////////");
                    System.out.println();
                    System.out.println("        1. Manage Books");
                    System.out.println("        2. Manage Members");
                    System.out.println("        3. Issue Books");
                    System.out.println("        4. Return Books");
                    System.out.println("        5. View Reports");
                    System.out.println("        6. Logout");
                    System.out.println();
                    System.out.print("        Please Enter Number to continue : "); 
                    
                    int menuid = input.nextInt(); // input feild for get option number
                    // String userInput = input.nextLine().trim();
                    // int menuid = Integer.parseInt(userInput);
                    input.nextLine(); 
                    if (menuid == 1) {  // first option of the main menu is 'Manage Books'
                        bookMenu = true;
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
                                
                                String inputId = input.nextLine().trim(); // get trimed input , trim helps to remove spaces 
                                int bookMenuId = Integer.parseInt(inputId);
                                // input.nextLine(); 

                                if (inputId.isEmpty()) {
                                    System.out.println("        Input cannot be empty. Please enter a number."); // Empty feild validation
                                    mainMenu = true;
                                    break;
                                }

                                if (bookMenuId == 1) {
                                    clearConsole(); // Clear CLI
                                    char choice;

                                    do {
                                        int bookId = 1 + bookCount;  // declare and initializ bookId 
                                        clearConsole();
                                        System.out.println("///////////////////////////////// Add Book //////////////////////////////////////");
                                        System.out.println();
                                        System.out.print("     Please enter Title of the Book : ");
                                        bookName = input.nextLine(); // Input bookName
                                        System.out.println();
                                        System.out.print("     Please enter Author's Name : ");
                                        bookAuthor = input.nextLine(); // Input bookAuthor
                                        System.out.println();
                                        System.out.print("     Please enter Genre of the Book : ");
                                        bookGenre = input.nextLine(); // Input bookGenre
                                        System.out.println();
                                        System.out.print("     Please enter Quantity : ");
                                        bookQuantity = input.nextLine(); // Input bookQuantity

                                        boolean isDuplicate = false;
                                        for (int i = 0; i < bookCount; i++) {
                                            String[] book = books[i];
                                            if (book[1] != null && book[1].equalsIgnoreCase(bookName) ) {  // check duplicates using book name
                                                // && book[2] != null && book[2].equalsIgnoreCase(bookAuthor)
                                                // && book[3] != null && book[3].equalsIgnoreCase(bookGenre)
                                                // && book[4] != null && book[4].equals(bookQuantity)) 
                                               
                                                isDuplicate = true;
                                                break;
                                            }
                                        }
                                        if (isDuplicate) { // if duplicates available display alert
                                            System.out.println();
                                            System.out.println("\n    This book already exists in the system. Duplicate not added.");
                                            System.out.println();
                                        } else {
                                            books[bookCount][0] = String.valueOf(bookId); // add book id into books array
                                            books[bookCount][1] = bookName;      // add bookName into books array
                                            books[bookCount][2] = bookAuthor;    // add bookAuthor into books array
                                            books[bookCount][3] = bookGenre;     // add bookGenre into books array
                                            books[bookCount][4] = bookQuantity;  // add bookQuantity into books array
                            
                                            System.out.println();
                                            System.out.println("\n           Book Added Successfully.");  // Display alert after
                                            System.out.println();

                                            // System.out.println("Full Book List (for Testing):");
                                            // for (String[] book : books) {
                                            //     System.out.println(Arrays.toString(book));
                                            // }
                                            bookCount++;  // increases the value by 1
                                        }
                                        System.out.print("\nDo you want to add another book? (Y/N): ");
                                        choice = input.nextLine().toUpperCase().charAt(0);  // get Input for 'choice' variable.
                                    
                                    } while (choice == 'Y' );

                                    // input.close();
                                } else if (bookMenuId == 2) {
                                    char choiceupdate;

                                    do {
                                        if (bookCount > 0) {  // if count of the book is more that 0                                          
                                            // Update books if books are available
                                            clearConsole();
                                            System.out.println("///////////////////////////////// Update Book //////////////////////////////////////");
                                            System.out.println();
                                            System.out.print("     Please enter ID of the Book to update: ");
                                            String bookIdToUpdate = input.nextLine();
                                            System.out.println();

                                            boolean found = false;

                                            for (int i = 0; i < bookCount; i++) {
                                                if (books[i][0].equalsIgnoreCase(bookIdToUpdate)) {
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

                                                    books[i][1] = bookName;
                                                    books[i][2] = bookAuthor;
                                                    books[i][3] = bookGenre;
                                                    books[i][4] = bookQuantity;

                                                    found = true;
                                                    System.out.println();
                                                    System.out.println("            Book updated successfully!");
                                                    System.out.println();
                                                    break;
                                                }
                                            }

                                            if (!found) {
                                                System.out.println();
                                                System.out.println("      Book not found in the list.");
                                                System.out.println();
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
                                        // allow to delte books if books are available
                                        if (bookCount > 0) {
                                            clearConsole();
                                            System.out.println("///////////////////////////////// Delete Book //////////////////////////////////////");
                                            System.out.println();
                                            System.out.print("     Please enter ID of the Book to Delete: ");
                                            String bookIdToDelete = input.nextLine();  // get book id for delete books
                                            System.out.println();

                                            boolean found = false;

                                            for (int i = 0; i < bookCount; i++) { // get book count and start loop according to the count
                                                if (books[i][0].equalsIgnoreCase(bookIdToDelete)) {
                                                    for (int j = i; j < bookCount - 1; j++) {
                                                        books[j] = books[j + 1];
                                                    }
                                                    books[bookCount - 1] = new String[5];
                                                    bookCount--; 

                                                    found = true;
                                                    System.out.println();
                                                    System.out.println("      Book with ID \"" + bookIdToDelete + "\" has been deleted successfully.");
                                                    break;
                                                }
                                            }

                                            if (!found) {
                                                System.out.println("      Book not found in the list to Delete.");
                                                System.out.println();
                                            }

                                            System.out.print("\nDo you want to delete another book? (Y/N): ");
                                            choicedelete = input.nextLine().toUpperCase().charAt(0);
                                            System.out.println();

                                        } else {
                                            System.out.println("No books found to Delete."); // check book availablity
                                            input.nextLine();
                                            break; 
                                        }
                                    } while (choicedelete == 'Y');

                                } else if (bookMenuId == 4) {
                                    char choicesearch;

                                    do {
                                        if (bookCount > 0) {
                                            clearConsole();
                                            System.out.println("///////////////////////////////// Search Book //////////////////////////////////////");
                                            System.out.println();
                                            System.out.print("      Please enter Book ID for Search: ");
                                            String bookIdToSearch = input.nextLine();  
                                            System.out.println();

                                            boolean found = false;

                                            for (int i = 0; i < bookCount; i++) {
                                                String[] book = books[i];

                                                // Assuming book[0] = ID, book[1] = Name, book[2] = Author, book[3] = Genre, book[4] = Quantity
                                                if (book[0].equalsIgnoreCase(bookIdToSearch)) {
                                                    found = true;
                                                    System.out.println("      Book Found.");
                                                    System.out.println();
                                                    System.out.println("      ID        : " + book[0]);
                                                    System.out.println("      Name      : " + book[1]);
                                                    System.out.println("      Author    : " + book[2]); 
                                                    System.out.println("      Genre     : " + book[3]); 
                                                    System.out.println("      Quantity  : " + book[4]); 
                                                    break;
                                                }
                                            }

                                            if (!found) {
                                                System.out.println("      Book not found in the list.");
                                                System.out.println();
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
                                    if (bookCount > 0) {
                                        clearConsole();
                                        System.out.println("//////////////////////////////////// View All Books /////////////////////////////////////////");
                                        System.out.println();
                                        System.out.printf("%-5s %-10s %-25s %-20s %-20s %-10s\n", "No.", "ID", "Name", "Author", "Genre", "Quantity");
                                        System.out.println("----------------------------------------------------------------------------------------------");

                                        for (int i = 0; i < bookCount; i++) {
                                            String[] book = books[i];

                                            System.out.printf("%-5d %-10s %-25s %-20s %-20s %-10s\n",
                                                (i + 1), book[0], book[1], book[2], book[3], book[4]);
                                        }

                                        System.out.println("----------------------------------------------------------------------------------------------");
                                        System.out.println();
                                        System.out.println("      Total Books: " + bookCount);
                                        System.out.println();
                                        System.out.println("\nPress Enter to continue...");
                                        input.nextLine();
                                        bookMenu = true;
                                        menuid = 1;
                                        break;
                                    } else {
                                        System.out.println("No books found.");
                                        input.nextLine();
                                    }

                                } else if (bookMenuId == 6) {
                                    clearConsole();
                                    mainMenu = true; 
                                    // islogin = false; 
                                    // login = "success";
                                    bookMenu = false;
                                    break;
                                } else {
                                    System.out.println();
                                    System.out.println("Invalid option. Please try again.");
                                }
                        }    
                    } else if (menuid == 2) { // second option of the main menu is 'Manage Members'
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
                                    for (int i = 0; i < memberCount; i++) {
                                        String[] member = members[i];
                                        if (member[1] != null && member[1].equalsIgnoreCase(memberName)   // check duplicates using member name
                                            && member[2] != null && member[2].equalsIgnoreCase(memberContactNumber)  // check duplicates using contact numbr
                                            && member[3] != null && member[3].equalsIgnoreCase(memberEmail) ) {   // check duplicates using email
                                            // && book[4] != null && book[4].equals(bookQuantity)) 
                                           
                                            isDuplicate = true;
                                            break;
                                        }
                                    }

                                    if (isDuplicate) {
                                        System.out.println();
                                        System.out.println("\n    This book already exists in the system. Duplicate not added.");
                                        System.out.println();
                                    } else {

                                        members[memberCount][0] = String.valueOf(memberId);
                                        members[memberCount][1] = memberName;
                                        members[memberCount][2] = memberContactNumber;
                                        members[memberCount][3] = memberEmail;

                                        System.out.println();
                                        System.out.println("\n           Member Added Successfully.");
                                        System.out.println();

                                        memberCount++;
                                    }
                                    System.out.print("\nDo you want to add another book? (Y/N): ");
                                    choiceMember = input.nextLine().toUpperCase().charAt(0);
                                
                                } while (choiceMember == 'Y' );

                                // input.close();
                            } else if (memberMenuId == 2) {
                                
                                char choiceUpdateMember;

                                do {
                                    // for (String[] member : members) {
                                    //     System.out.println(Arrays.toString(member));
                                    // }

                                    if (memberCount > 0) { 
                                        clearConsole();
                                        System.out.println("///////////////////////////////// Update Member //////////////////////////////////////");
                                        System.out.println();

                                        System.out.print("     Please enter ID of the Member to update: ");
                                        String memberIdToUpdate = input.nextLine();
                                        System.out.println();

                                        boolean found = false;

                                        for (int i = 0; i < memberCount; i++) {
                                            if (members[i][0].equalsIgnoreCase(memberIdToUpdate)) {
                                            
                                                System.out.print("     Please enter new Name of the Member: ");
                                                memberName = input.nextLine();
                                                System.out.println();

                                                System.out.print("     Please enter new Contact Number: ");
                                                memberContactNumber = input.nextLine();
                                                System.out.println();

                                                System.out.print("     Please enter new Email of the Member: ");
                                                memberEmail = input.nextLine();
                                                System.out.println();

                                                members[i][1] = memberName;
                                                members[i][2] = memberContactNumber;
                                                members[i][3] = memberEmail;

                                                found = true;
                                                System.out.println();
                                                System.out.println("            Member details updated successfully!");
                                                System.out.println();
                                                break;
                                            }
                                        }

                                        if (!found) {
                                            System.out.println("      Member not found in the list.");
                                            System.out.println();
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
                                    if (memberCount > 0) {
                                        clearConsole();
                                        System.out.println("///////////////////////////////// Delete Member //////////////////////////////////////");
                                        System.out.println();
                                        System.out.print("     Please enter ID of the Member to Delete: ");
                                        String memberIdToDelete = input.nextLine();  
                                        System.out.println();

                                        boolean foundMember = false;

                                        for (int i = 0; i < memberCount; i++) {

                                            if (members[i][0].equalsIgnoreCase(memberIdToDelete)) {
                                                for (int j = i; j < memberCount - 1; j++) {
                                                    members[j] = members[j + 1];
                                                }
                                                members[memberCount - 1] = new String[5];
                                                memberCount--;
                                                foundMember = true;
                                                System.out.println("      Member \"" + memberIdToDelete + "\" has been deleted successfully.");
                                                break;
                                            }
                                        }

                                        if (!foundMember) {
                                            System.out.println("      Member not found in the list to Delete.");
                                            System.out.println();
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
                                    if (memberCount > 0) {
                                        clearConsole();
                                        System.out.println("///////////////////////////////// Search Member //////////////////////////////////////");
                                        System.out.println();
                                        System.out.print("      Please enter Member ID for Search: ");
                                        String memberIdToSearch = input.nextLine();  
                                        System.out.println();

                                        boolean foundMember = false;

                                        for (int i = 0; i < memberCount; i++) {
                                            String[] member = members[i];

                                            // Assuming book[0] = ID, book[1] = Name, book[2] = Author, book[3] = Publisher, book[4] = Quantity
                                            if (member[0].equalsIgnoreCase(memberIdToSearch)) {
                                                foundMember = true;
                                                System.out.println("      Member Found.");
                                                System.out.println();
                                                System.out.println("      ID                : " + member[0]);
                                                System.out.println("      Name              : " + member[1]);
                                                System.out.println("      Contact Number    : " + member[2]); 
                                                System.out.println("      Email             : " + member[3]); 
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
                                if (memberCount > 0) {
                                    clearConsole();
                                    System.out.println("///////////////////////////////// View All Members //////////////////////////////////////");
                                    System.out.println();
                                    System.out.printf("%-5s %-10s %-25s %-20s %-30s\n", "No.", "ID", "Name", "Contact Number", "Email");
                                    System.out.println("----------------------------------------------------------------------------------------------");

                                    for (int i = 0; i < memberCount; i++) {
                                        String[] member = members[i];

                                        System.out.printf("%-5d %-10s %-25s %-20s %-30s\n", 
                                            (i + 1), member[0], member[1], member[2], member[3]);
                                    }
                                    
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    System.out.println();
                                    System.out.println("      Total Members: " + memberCount);
                                    System.out.println();
                                    System.out.println("\nPress Enter to continue...");
                                    input.nextLine();
                                    clearConsole();
                                    menuid = 2;
                                    memberMenu = true;
                                    break;
                                } else {
                                    System.out.println("No member found.");
                                    input.nextLine();
                                }
                            } else if (memberMenuId == 6) {
                                clearConsole();
                                mainMenu = true; 
                                    // islogin = false; 
                                    // login = "success";
                                bookMenu = false;
                                break;
                            } else {
                                System.out.println();
                                System.out.println("Invalid option. Please try again.");
                                input.nextLine();
                            }
                        }   
                    } else if (menuid == 3) { // third option of the main menu is 'Issue Books'
                        char choiceIssueBook = 'N';
                        do {
                            clearConsole();
                            System.out.println("///////////////////////////////// Issue Book //////////////////////////////////////");
                            System.out.println();

                            boolean issueMember = false;
                            boolean issueBook = false;

                            System.out.print("      Please enter Member ID for Issue Book: ");
                            String memberIdToIssueBook = input.nextLine().trim();
                            System.out.println();

                            for (int i = 0; i < memberCount; i++) {
                                if (members[i][0].equalsIgnoreCase(memberIdToIssueBook)) {
                                    issueMember = true;
                                    break;
                                }
                            }

                            if (!issueMember) {
                                System.out.println("      Member not found in the list to Issue Book.");
                                System.out.println();
                                System.out.println("               Press Enter to continue.");
                                System.out.println();
                                input.nextLine();
                                // continue;
                            } 

                            System.out.print("      Please enter Book ID for Issue Book: ");
                            String bookIdToIssueBook = input.nextLine().trim();
                            System.out.println();

                            int bookIndex = -1;
                            for (int i = 0; i < bookCount; i++) {
                                if (books[i][0].equalsIgnoreCase(bookIdToIssueBook)) {
                                    bookIndex = i;
                                    int qty = Integer.parseInt(books[i][4]);
                                    if (qty > 0) {
                                        issueBook = true;
                                    }
                                    break;
                                }
                            }

                            if (!issueBook) {
                                if (bookIndex >= 0) {
                                    System.out.println("      Sorry, that book is currently out of stock.");
                                } else {
                                    System.out.println("      Book not found in the list to Issue Book.");
                                }
                                System.out.println("\n               Press Enter to continue.\n");
                                input.nextLine();
                                continue; 
                            } 
                            int currentQty = Integer.parseInt(books[bookIndex][4]); // get current quantity of books from books array
                            books[bookIndex][4] = String.valueOf(currentQty - 1);  // reduce 1 from current quantity from books array

                            LocalDate issueDate = LocalDate.now(); // get current date (date of a PC)
                            System.out.print("      Please enter number of days until due date: ");
                            String dDate = input.nextLine().trim();  // get number of dates for due date
                            System.out.println();

                            try {
                                int daysToAdd = Integer.parseInt(dDate);  // convert string into INT
                                LocalDate dueDate = issueDate.plusDays(daysToAdd); // plus date count to current date

                                issuedBooks[issuedCount][0] = memberIdToIssueBook;
                                issuedBooks[issuedCount][1] = bookIdToIssueBook;
                                issuedBooks[issuedCount][2] = issueDate.toString();
                                issuedBooks[issuedCount][3] = dueDate.toString();
                                issuedCount++;

                                System.out.println("    Book successfully issued!");
                                System.out.println("      Issue Date: " + issueDate);
                                System.out.println("      Due Date: " + dueDate);
                                System.out.println();
                            } catch (NumberFormatException e) {
                                System.out.println("      Invalid number entered for due date. Please try again.");
                            }

                            System.out.print("Do you want to issue another Book? (Y/N): ");
                            choiceIssueBook = input.nextLine().toUpperCase().charAt(0);
                            System.out.println();

                        } while (choiceIssueBook == 'Y');
                        
                    } else if (menuid == 4) { // forth option of the main menu is 'Return Books'
                        char choiceReturnBook = 'N';
                        do {
                            clearConsole();
                            System.out.println("/////////////////////////////// Return Book ///////////////////////////////");
                            System.out.println();

                            boolean foundMember = false;
                            boolean foundIssued = false;

                            System.out.print("      Please enter Member ID for Return Book: ");
                            String memberIdToReturnBook = input.nextLine().trim();
                            System.out.println();

                            for (int i = 0; i < memberCount; i++) {
                                if (members[i][0].equalsIgnoreCase(memberIdToReturnBook)) {
                                    foundMember = true;
                                    break;
                                }
                            }

                            if (!foundMember) {
                                System.out.println("      Invalid Member ID.");
                                System.out.println();
                                System.out.println("\n               Press Enter to continue.\n");
                                input.nextLine();
                                continue;
                            }

                            System.out.print("      Please enter Book ID for Return Book: ");
                            String bookIdToReturnBook = input.nextLine().trim();
                            System.out.println();

                            int issuedIndex = -1;
                            for (int i = 0; i < issuedCount; i++) {  // check value in 'issueBooks' array after issuing books
                                if (issuedBooks[i][0] != null &&
                                    issuedBooks[i][0].equalsIgnoreCase(memberIdToReturnBook) &&  // check member id and book id is match according to the 'issueBooks' array
                                    issuedBooks[i][1].equalsIgnoreCase(bookIdToReturnBook)) {
                                    issuedIndex = i;
                                    foundIssued = true;
                                    break;
                                }
                            }

                            if (!foundIssued) {
                                System.out.println("      No record found for the given Member ID and Book ID.");
                                System.out.println();
                                System.out.println("\n               Press Enter to continue.\n");
                                input.nextLine();
                                continue;
                            }
                            
                            LocalDate currentDate = LocalDate.now(); // Get current date
                            String dueDateStr = issuedBooks[issuedIndex][3]; // get duedate from array
                            LocalDate dueDate = LocalDate.parse(dueDateStr);
                            long overdueDays = ChronoUnit.DAYS.between(dueDate, currentDate); // check date diff between due date and current date

                            int fine = 0;
                            if (overdueDays > 0) {  // if over due date count is more that '0'
                                fine = (int) overdueDays * (int) 0.5 ; // fine amount
                            }

                            for (int i = 0; i < bookCount; i++) {
                                if (books[i][0].equalsIgnoreCase(bookIdToReturnBook)) {  // check book id match with entered book id
                                    int qty = Integer.parseInt(books[i][4]); // check quantity of books array
                                    books[i][4] = String.valueOf(qty + 1); // add 1 to quantity of related book id
                                    break;
                                }
                            }
                            issuedBooks[issuedIndex][0] = null;
                            issuedBooks[issuedIndex][1] = null;
                            issuedBooks[issuedIndex][2] = null;
                            issuedBooks[issuedIndex][3] = null;

                            System.out.println("      Book returned successfully.");
                            System.out.println();
                            input.nextLine();
                            if (fine > 0) {
                                System.out.println();
                                System.out.println("      Overdue fine: " + fine + " $ "); // Display fine
                                System.out.println();
                            }

                            System.out.println();
                            System.out.print("Do you want to return another Book? (Y/N): ");
                            choiceReturnBook = input.nextLine().toUpperCase().charAt(0);
                            System.out.println();

                        } while (choiceReturnBook == 'Y');

                    } else if (menuid == 5) { // fifth option of the main menu is 'View Reports'
                        while (reportMenu) {
                            clearConsole();
                            System.out.println("///////////////////////////////// View Reports //////////////////////////////////////");
                            System.out.println();
                            System.out.println("        1. Overdue Books");
                            System.out.println("        2. Books Issued Per Member");
                            System.out.println("        3. Return to The Menu");
                            System.out.println();
                            System.out.print("        Please Enter Number to continue : ");
                            System.out.println();
                            
                            String inputReportId = input.nextLine().trim();
                            int reportId = Integer.parseInt(inputReportId);
                            // input.nextLine(); 

                            if (inputReportId.isEmpty()) {
                                System.out.println();
                                System.out.println("        Input cannot be empty. Please enter a number.");
                                System.out.println();
                                mainMenu = true;
                                break;
                            }

                            if (reportId == 1) {
                                final double FINE_PER_DAY = 0.50; // Overdue fine amount per day
                                LocalDate today = LocalDate.now();

                                System.out.println("/////////////////////////////// Overdue Books Report ///////////////////////////////");
                                System.out.println();
                                System.out.printf("%-10s %-10s %-15s %-15s %-10s\n", "Book ID", "Member ID", "Due Date", "Days Overdue", "Fine");

                                boolean foundOverdue = false;
                                for (int i = 0; i < issuedCount; i++) {
                                    String dueDateStr = issuedBooks[i][3];
                                    if (dueDateStr == null || dueDateStr.trim().isEmpty()) {
                                        foundOverdue = true;
                                    }

                                    LocalDate dueDate = LocalDate.parse(dueDateStr);

                                    if (today.isAfter(dueDate)) {
                                        foundOverdue = true;
                                        long daysOverdue = java.time.temporal.ChronoUnit.DAYS.between(dueDate, today);
                                        double fine = daysOverdue * FINE_PER_DAY;

                                        String bookId = issuedBooks[i][1];
                                        String memberId = issuedBooks[i][0];

                                        System.out.printf("%-10s %-10s %-15s %-15d $%.2f\n", bookId, memberId, dueDate, daysOverdue, fine);
                                    }
                                }

                                if (!foundOverdue) {
                                    System.out.println();
                                    System.out.println("No overdue books found.");
                                    System.out.println();
                                    input.nextLine();
                                }

                                System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                                System.out.println();
                                System.out.println("\nPress Enter to continue...");
                                System.out.println();
                                new Scanner(System.in).nextLine();

                            } else if (reportId == 2) {
                                System.out.println("/////////////////////////////// Books Issued Per Member ///////////////////////////////");
                                System.out.println();
                                System.out.printf("%-15s %-20s\n", "Member ID", "Total Books Issued");

                                String[] memberIds = new String[issuedCount];
                                int[] bookCounts = new int[issuedCount];
                                int uniqueMemberCount = 0;

                                for (int i = 0; i < issuedCount; i++) {
                                    String memberId = issuedBooks[i][0]; // get member id from 'issuedBooks' array in each row

                                    if (memberId == null || memberId.trim().isEmpty()) {
                                        continue;
                                    }

                                    boolean found = false;
                                    for (int j = 0; j < uniqueMemberCount; j++) {
                                        if (memberIds[j].equals(memberId)) {  // get count of books
                                            bookCounts[j]++;
                                            found = true;
                                            break;
                                        }
                                    }

                                    if (!found) {
                                        memberIds[uniqueMemberCount] = memberId; // member ids
                                        bookCounts[uniqueMemberCount] = 1; // bookcount
                                        uniqueMemberCount++;
                                    }
                                }

                                if (uniqueMemberCount == 0) {
                                    System.out.println();
                                    System.out.println("No issued books found.");
                                    System.out.println();
                                } else {
                                    for (int i = 0; i < uniqueMemberCount; i++) {
                                        System.out.println();
                                        System.out.printf("%-15s %-20d\n", memberIds[i], bookCounts[i]); // Display values
                                    }
                                }

                                System.out.println();
                                System.out.println("////////////////////////////////////////////////////////////////////////////////////////");
                                System.out.println();
                                System.out.println("\nPress Enter to continue...");
                                System.out.println();
                                new Scanner(System.in).nextLine();

                            } else if (reportId == 3) {
                                clearConsole();
                                reportMenu = false;
                                break;
                            }
                        }
                    } else if (menuid == 6) { // sixth option of the main menu is 'Logout'
                        clearConsole();
                        mainMenu = false; 
                        islogin = true; 
                        // input.nextLine(); 
                    } else {
                        clearConsole();
                        System.out.println("            Invalid option. Please try again.");
                        System.out.println();
                        System.out.println("            Press Enter to return main menu.");
                        System.out.println();
                        input.nextLine(); 
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