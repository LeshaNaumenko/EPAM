import controller.Controller;
import controller.service.ServiceWordProcessing;
import view.InputUtility;
import view.ViewWordProcessing;

public class Main {
    public static void main(String[] args) {
        new Controller(new ServiceWordProcessing(),new ViewWordProcessing(), new InputUtility()).run();
    }
}
