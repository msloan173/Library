
public  class FictionBook extends Book {

    private String genre = "Fiction";

    public FictionBook() {
        super();
        genre = "Fiction";
    }

    public FictionBook(int id, String title , String author, String publisher, boolean isAvailable) {
        super(id, title, author, publisher, isAvailable);
        genre = "Fiction";
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void printBook() {
        String isAvailable;

        // Determine string to be displayed for Available column
        if (super.isAvailable()) {
            isAvailable = "Yes";
        } else {
            isAvailable = "No";
        }
        System.out.printf("\n%-10s%-24s%-23s%-17s%-17s%-12s%1s", "| " + super.getId(), "| " + super.getTitle(), "| " + super.getAuthor(),
                "| " + super.getPublisher(), "| " + this.genre, "| " + isAvailable, "|");
    }
    /* What methods shall we implement */

}
