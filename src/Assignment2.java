import java.util.Scanner;
import java.util.ArrayList;

public class Assignment2 {

    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        Scanner key = new Scanner(System.in);
        int input;
        ArrayList books = bookManager.getList();

        while (true) {
            System.out.println("Welcome to book manager.exe, what would you like to do?\n"
                    + "1. Add book\n2. Remove book\n3. Replace book\n4. Check inventory\n"
                    + "5. Check book\n6. Quit");
            input = key.nextInt();
            key.nextLine();
            if (input == 1) {
                System.out.println(
                        "Please type the title, the author, the ISBN and then the amount of that book in that order.");
                bookManager.addBook(new Book(key.nextLine(), key.nextLine(), key.nextLine(), key.nextInt()));
                System.out.println("Book added!");
            } else if (input == 2) {
                System.out.println("Please input the index (starts at zero) of the book you would like to remove.");
                input = key.nextInt();

                if (input < 0 || input > books.size() - 1) {
                    System.out.println("ERROR: Non valid index.");
                } else {
                    bookManager.removeBook(input);
                    System.out.println("Book removed!");
                }
            } else if (input == 3) {
                System.out.println("Please input the index (starts of zero) of the book you want to replace.");
                input = key.nextInt();

                if (input < 0 || input > books.size() - 1) {
                    System.out.println("ERROR: Non valid index.");
                } else {
                    System.out.println(
                            "Please type the title, the author, the ISBN and the the amount of that book in that order.");
                    bookManager.replaceBook(input,
                            new Book(key.nextLine(), key.nextLine(), key.nextLine(), key.nextInt()));
                    System.out.println("Book replaced!");
                }
            } else if (input == 4) {
                System.out.println(bookManager.getInventory());
            } else if (input == 5) {
                System.out.println("Please input the index (starts at zero) of the book you would like to check.");
                input = key.nextInt();

                if (input < 0 || input > books.size() - 1) {
                    System.out.println("ERROR: Non valid index.");
                } else {
                    System.out.println(bookManager.getBook(input));
                }
            } else if (input == 6) {
                System.out.println("Thank you for using my program, goodbye.");
                break;
            } else {
                System.out.println("ERROR: Not a valid input.");
            }

        }
        key.close();

    }

}

class Book {
    private String title, author, iSBN;
    private int quantity;

    public Book(String t, String a, String i, int q) {
        title = t;
        author = a;
        iSBN = i;
        quantity = q;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public void setISBN(String i) {
        iSBN = i;
    }

    public void setQuantity(int q) {
        quantity = q;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return iSBN;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "The book " + title + " is written by " + author + ", has an ISBN of " + iSBN + " and there are "
                + quantity + " copies.";
    }
}

class BookManager {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void removeBook(int i) {
        books.remove(i);
    }

    public void replaceBook(int i, Book b) {
        books.set(i, b);
    }

    public ArrayList getList() {
        return books;
    }

    public String getInventory() {
        String result = "";
        for (int i = 0; i < books.size(); i++) {
            result += books.get(i).toString() + "\n";
        }
        return result;
    }

    public String getBook(int i) {
        String result = books.get(i).toString();
        return result;
    }
}