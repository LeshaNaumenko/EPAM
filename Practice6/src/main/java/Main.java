import controller.Controller;
import controller.service.Service;
import location.ResourceManager;
import model.Books;
import view.BooksView;
import view.InputUtility;

public class Main {
    public static void main(String[] args) {

        //String string = ResourceManager.INSTANCE.getString("MENU_INTERNATIONALIZATION");
        //System.out.println(string);
        new Controller(new Books(),
                new BooksView(),
                new Service(),
                new InputUtility(),
                ResourceManager.INSTANCE)
                .run();
    }
}
