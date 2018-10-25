import controller.Controller;
import controller.service.Service;
import model.Books;
import view.BooksView;
import view.InputUtility;

public class Main {
    public static void main(String[] args) {
        new Controller(new Books(), new BooksView(), new Service(), new InputUtility()).run();
    }
}
