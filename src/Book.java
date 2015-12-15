/**
 * Created by asharma on 14/12/2015.
 */

public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String genre;
    private boolean isAvailable;

    public Book() {

    }
    public Book(int id, String title , String author, String publisher, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void printBook() {
        String isAvailable;

        // Determine string to be displayed for Available column
        if (this.isAvailable()) {
            isAvailable = "Yes";
        } else {
            isAvailable = "No";
        }
        System.out.printf("\n%-10s%-24s%-23s%-17s%-17s%-12s%1s", "| " + this.getId(), "| " + this.getTitle(), "| " + this.getAuthor(),
                "| " + this.getPublisher(), "| Not Specified", "| " + isAvailable, "|");
    }
}