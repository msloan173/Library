import java.util.ArrayList;
import java.util.Scanner;


/*
 * The Userinterface that allows the user to interact with the java.console to provide input.
 */
public class UserInterface {
    int id = 0; // Initial Book ID. We will increment this value each time a new Book is added to the system.
    Scanner myScan = new Scanner(System.in);
    ArrayList<Book> library = new ArrayList<Book>(); // An arrayList the can contain Book objects i.e. See Book.java

    /*
     * Load the menu that prompts the user for input.
     */
    public void startMenu() {
        String optionNum;
        //prompt
        System.out.print("\nPlease select one of the following options:");
        //options
        System.out.print("\n0-Exit\n1-Add Book\n2-Display Available Books\n" +
                "3-Display loaned books\n4-Make Loan\n5-Return Book\n6-Write to File\n");
        optionNum = myScan.next();

        /*
         * Respond to user input input.
         */
        switch (optionNum) {
            case "1":
                this.addBook();
                break;
            case "2":
                this.displayBooks("available");
                break;
            case "3":
                this.displayBooks("onLoan");
                break;
            case "4":
                this.makeLoan();
                break;
            case "5":
                this.returnBook();
                break;
            default:
                System.out.println("\n\nSorry there was a problem, please try again ");
                this.startMenu();
        }
        this.startMenu(); // Show the menu after each action
    }
    /*
     * Prompt the user with a series of instructions to enter details for creating a new book record.
     */
    public void addBook() {
        String inputTitle, inputAuthor, inputPublisher, inputGenre, confirmedGenre = "";
        boolean isAvailable, correctInput = false;

        System.out.print("\nPlease enter book details\n");
        id = id + 1;
        myScan.nextLine(); //bug

        System.out.print("Enter the book title: ");
        inputTitle = myScan.nextLine();

        System.out.print("Enter the book author: ");
        inputAuthor = myScan.nextLine();


        System.out.print("Enter the book publisher: ");
        inputPublisher = myScan.nextLine();



        /*
         * The user can only enter F or NF. This remediates the need for users to type out the full genre name.
         */
        System.out.print("Enter 'F' for Fiction or 'NF' for Non-Fiction?");
        while (confirmedGenre.isEmpty()) {
            inputGenre = myScan.nextLine();
            switch (inputGenre) {
                case "F":
                    confirmedGenre = inputGenre;
                    FictionBook Fiction = new FictionBook(id, inputTitle, inputAuthor, inputPublisher, true);
                    library.add(Fiction);
                    break;
                case "NF":
                    confirmedGenre = inputGenre;
                    NonFictionBook NonFiction = new NonFictionBook(id, inputTitle, inputAuthor, inputPublisher, true);
                    library.add(NonFiction);
                    break;
                default:
                    System.out.print("Sorry, please enter'F' for Fiction or 'NF' Non-Fiction");
            }
        }

//        Book.setId(id);
//        Book.setTitle(inputTitle);
//        Book.setAuthor(inputAuthor);
//
//        Book.setIsAvailable(true);
//        library.add(Book);
    }
    /*
     * Print the books from the library arrayList.
     * @param String type - accepts 'available' or 'onLoan' to print out the corresponding book details.
     */
    public void displayBooks(String type) {
        if (library.size() > 0) {
            System.out.format("+---------+-----------------------+----------------------+----------------+----------------+-----------+%n");
            System.out.format("| Book ID | Title                 | Author               | Publisher      | Genre          | Available |%n");
            System.out.format("+---------+-----------------------+----------------------+----------------+----------------+-----------+%n");
            for (int i = 0; i < library.size(); i++) {
                // Print the books that are available
                if (type == "available") {
                    if (library.get(i).isAvailable()) {
                        library.get(i).printBook();
                    }
                } else {
                    if (!library.get(i).isAvailable()) {
                        library.get(i).printBook();
                    }
                }
            }
            System.out.format("\n+---------+-----------------------+----------------------+----------------+----------------+-----------+%n");
        } else {
            System.out.println("No books have been recorded. Enter '1' from the menu to add a book to the system.");
        }
    }
    /*
     * Prompt the user to provide a Book ID. We use this ID to loop through the library arrayList and set the 'isAvailable'
     * boolean value to false. Note - when we print the books, we check the 'isAvailable' property to distinguish between
     * available books and books that are on loan.
     */
    public void makeLoan() {
        int bookId;

        System.out.println("Enter the Book ID you would like to loan: ");
        bookId = myScan.nextInt();
        for (int i = 0; i < library.size(); i++) {

            if (library.get(i).getId() == bookId) {
                library.get(i).setIsAvailable(false);
            }
        }

    }
    /*
     * Request a Book ID from the user and loop through the library arrayList to match the Book ID
     * to the book that has been loaned.
     *
     */
    public void returnBook() {
        int bookId;
        System.out.println("Enter the Book ID to return the book: ");
        bookId = myScan.nextInt();
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getId() == bookId) {
                if (!library.get(i).isAvailable()) {
                    library.get(i).setIsAvailable(true);
                    System.out.println("Book has been returned");
                }
            } else {
                System.out.println("Sorry, there are no books that match that Book ID.");
            }
        }
    }
}

