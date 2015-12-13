import java.util.Scanner;
import java.util.ArrayList;

//Subclass FictionBook
     public class FictionBook extends Book {
        Scanner keyboard = new Scanner(System.in);
        private String genre;//Delcaring variables
        private String title;
        private String author;

         public FictionBook (String title ,String author, String genre){
             super(title, author);//Calls constructor of superclass
             this.genre = genre;
             this.author = author;//Declaring variables
             this.title = title;

             FictionBook [] FictionBooks = new FictionBook[5];//Setting array

             for( int x = 0; x <5; x++) {

                 System.out.print("Enter title of book");
                 title = keyboard.nextLine();
                 System.out.print("Enter author of book");//Entering in the details for title, author, genre
                 author = keyboard.nextLine();
                 System.out.print("Enter genre of book");
                 genre = keyboard.nextLine();
                 FictionBooks[x] = new FictionBook(title, author, genre);//Array for Fiction Books
             }


             }

         }
