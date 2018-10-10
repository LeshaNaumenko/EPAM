package Practice2.Task1_Books.controler;

import Practice2.Task1_Books.data.DataSource;
import Practice2.Task1_Books.model.Books;
import Practice2.Task1_Books.model.entity.Book;
import Practice2.Task1_Books.view.BooksView;

import java.util.Scanner;

public class Controller {
    private Books model = new Books();
    private BooksView view = new BooksView();

    public void run() {
        model.setBooks(DataSource.getBooks());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.printMessage(
                    "Origin book array                      -       press 1\n" +
                            "All the books of a certain author      -       press 2\n" +
                            "All the books of a certain publisher   -       press 3\n" +
                            "Books published after a certain year   -       press 4\n" +
                            "Sort books by publishers               -       press 5\n" +
                            "Exit                                   -       press 0\n" +
                            ">>");
            if (scanner.hasNextInt()) {
                int valueInt = scanner.nextInt();
                switch (valueInt) {
                    case 1:
                        view.printBooks("All books:", model.getBooks());
                        continue;
                    case 2:
                        scanner = new Scanner(System.in);
                        String s = scanner.nextLine();
                        searchBooksBy(model.getByAuthor(s), "Books by author", s);
                        continue;
                    case 3:
                        scanner = new Scanner(System.in);
                        String ss = scanner.nextLine();
                        searchBooksBy(model.getByPublisher(ss), "Books by publisher", ss);
                        continue;
                    case 4:
                        scanner = new Scanner(System.in);
                        while (!scanner.hasNextInt()) {
                            view.printMessage(view.WRONG_INPUT_INT_DATA);
                            scanner.next();
                        }
                        int tempValue = scanner.nextInt();
                        searchBooksBy(model.getBooksLater(tempValue), "All the books later ", Integer.toString(tempValue));
                        continue;
                    case 5:
                        view.printBooks("Sorted books", model.getOrderedBooksByPublisher());
                        continue;
                    case 0:
                        System.exit(0);
                    default:
                        view.printMessage(view.WRONG_INPUT_INT_DATA+"\n");
                }

            } else {
                view.printMessage(view.WRONG_INPUT_INT_DATA+"\n");
                scanner.next();
            }

        }
    }

    private void searchBooksBy(Book[] result, String message, String input) {
        if (result.length == 0) {
            view.printMessage("No books - " + input);
        } else {
            view.printBooks(message + "\"" + input + "\":", result);
        }
    }
}
