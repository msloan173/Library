import java.util.Scanner;
import java.util.ArrayList;
/**
 * Created by B00645567 on 29/11/2015.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String genre;
    private boolean isAvailable;

    //declare Scanner
    static Scanner myScan = new Scanner(System.in);

    //bookTitle
    static ArrayList<String> bookTitle = new ArrayList<String>();
    //bookAuthor
    static ArrayList<String> bookAuthor = new ArrayList<String>();
    //publisher
    static ArrayList<String> bookPublisher = new ArrayList<String>();
    //bookID
    static ArrayList<Integer> bookID = new ArrayList<Integer>();
    //loanOption
    static ArrayList<Boolean> loanOption = new ArrayList<Boolean>();

    //creating object
    static Book BookObject = new Book();

    //main arraylist for all books!
    static ArrayList library = new ArrayList();

    //testing
    static ArrayList<Boolean> testCondition = new ArrayList<Boolean>();

    static String line=("\n------------------------------------------------------------------------------------\n");

    public Book(int id, String title , String author, String publisher, String genre, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }




    //Add book method

    private void addBook(){
        String inputTitle, inputAuthor, inputPublisher;
        int bookCount=0, amountAdded, counter=0;

        System.out.print("How many books would you like to add: ");
        amountAdded = myScan.nextInt();

        for (int i =1; i<=amountAdded;i++){


            System.out.print("\nPlease enter book details\n");
            //bookID
            bookID.add(bookCount);
            library.add(bookID.get(counter));


            System.out.print("Enter the book title: ");
            inputTitle = myScan.next();
            bookTitle.add(inputTitle);
            library.add(bookTitle.get(counter));


            System.out.print("Enter the book author: ");
            inputAuthor = myScan.next();
            bookAuthor.add(inputAuthor);
            library.add(bookAuthor.get(counter));


            System.out.print("Enter the book publisher: ");
            inputPublisher = myScan.next();
            bookPublisher.add(inputPublisher);
            library.add(bookPublisher.get(counter));


            //loan option of book
            loanOption.add(true);
            library.add(loanOption.get(counter));

            //incrementing book counter for bookID
            bookCount++;
            counter++;
        }//for loop for how many book to add, value entered by user
        BookObject.userInterface();
    }//add book method



    //DisplayLoan method
    //
    private void displayLoan(){

        int size=bookID.size();

        System.out.print(line+"\n||Book ID\t\t||Title\t\t||Author\t\t||publisher\t\t||loaned\n"+line);
        int b=0,c=1,d=2,e=3,f=4;
        for (int i = 0; i < size; i++) {

            if(loanOption.get(i)!=testCondition.get(0)) {
                //print library values for each book
                System.out.print("|-|" + library.get(b) + "\t\t\t\t");
                System.out.print("|-|" + library.get(c) + "\t\t");
                System.out.print("|-|" + library.get(d) + "\t\t");
                System.out.print("|-|" + library.get(e) + "\t\t\t");
                System.out.println("|-|" + library.get(f));
            }
            b = b + 5;
            c = c + 5;
            d = d + 5;
            e = e + 5;
            f = f + 5;
        }
        BookObject.userInterface();
    }



    //DisplayAvailable method
    //
    private void displayAvailable() {

        int size=bookID.size();

        System.out.print(line+"\n||Book ID\t\t||Title\t\t||Author\t\t||publisher\t\t||loaned\n"+line);
        int b=0,c=1,d=2,e=3,f=4;
        for (int i = 0; i < size; i++) {

            if(loanOption.get(i)==testCondition.get(0)) {
                //print library values for each book
                System.out.print("||" + library.get(b) + "\t\t\t");
                System.out.print("||" + library.get(c) + "\t\t");
                System.out.print("||" + library.get(d) + "\t\t");
                System.out.print("||" + library.get(e) + "\t\t");
                System.out.println("||" + library.get(f));
            }
            b = b + 5;
            c = c + 5;
            d = d + 5;
            e = e + 5;
            f = f + 5;
        }
        BookObject.userInterface();
    }



    //loanBookOut method
    //
    public void loanBook(){

        int inputID,change;
        System.out.print("Enter the bookID for the book you wish to loan");
        inputID = myScan.nextInt();
        loanOption.remove(inputID);
        loanOption.add(inputID, false);
        change=((inputID+1)*5)-1;
        library.remove(change);
        library.add(change, false);

        BookObject.userInterface();
    }



    //returnbook method
    //
    private void returnBook(){
        int inputID,change;
        System.out.print("Enter the bookID for the book you wish to return: ");
        inputID = myScan.nextInt();
        loanOption.remove(inputID);
        loanOption.add(inputID, true);
        change=((inputID+1)*5)-1;
        library.remove(change);
        library.add(change, true);

        BookObject.userInterface();
    }



    //userInterFace method
    //
    public void userInterface(){
        //declaring variables for following conditions
        boolean correct, nonNumber;
        int optionNum=0;
        do {
            correct = true;
            nonNumber = true;
            try {
                //prompt
                System.out.print("\nPlease select one of the following options:");
                //options
                System.out.print("\n0-Exit\n1-Add Book\n2-Display Available Books\n" +
                        "3-Display loaned books\n4-Make Loan\n5-Return Book\n6-Write to File");
                optionNum = myScan.nextInt();

                if (optionNum == 0 || optionNum == 1 || optionNum == 2 || optionNum == 3 || optionNum == 4 || optionNum == 5 || optionNum == 6) {
                    correct = false;
                }//if
                else {
                    System.out.println("\n\nSorry the value entered was not on the list!");
                }//else
            }//try
            catch (Exception e) {
                System.out.println("\n\nSorry there was a problem, please try again ");
                nonNumber = false;

            }//catch
            myScan.nextLine();//catches the return character for the next time round the loop
        } while (correct == true || nonNumber == false);

        //menu system method
        //
        if (optionNum == 1) {
            try {
                System.out.print("\nAdd book\n");
                BookObject.addBook();
                BookObject.userInterface();
            }//HOW TO LOOP IT BACK TO THE ADD BOOK MENU?????????????????
            catch (Exception e) {
                System.out.println("Sorry, you entered the wrong value, please try again");
                BookObject.userInterface();

            }
        }



        if (optionNum == 2) {
            //Display books available for loan
            //a method to print details for fiction and non fiction books available for loan
            System.out.println("\nDisplay books available for loan\n");
            BookObject.displayAvailable();
        }
        if (optionNum == 3) {
            //Display books currently out on loan
            //a method to print the details of fictin and non fiction books out on loan with student info
            System.out.println("\nBooks out on loan\n");
            BookObject.displayLoan();

        }
        if (optionNum == 4) {
            //Make book loan
            //user to enter book ID, and code to swap book details from array to array from available to loaned out
            System.out.println("\nPlease enter the name of the book you wish to loan:\n");
            BookObject.loanBook();
        }
        if (optionNum == 5) {
            //Return Book
            //user to enter book ID, and code to swap book details from array to array from loaned to available
            System.out.println("\nReturn Book\n");
            BookObject.returnBook();
        }
        if (optionNum == 6) {
            //Write details to file?
            //ask simon
            System.out.println("\nwrite details to file\n");

        }
        if (optionNum == 0) {
            System.out.print("\nYou have chosen to end the program,\nGoodbye! ");
            //because of the if statement this would repeat however many times the program ran option 1 or 2 if it was
            //under else, putting it here stops it repeating.
        } else ;
    }



    //main method
    //
    public static void main(String[] args) {

        testCondition.add(true);

        //go to user interface method
        BookObject.userInterface();

    }//main method
}//class
