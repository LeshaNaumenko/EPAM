package Practice2.Task2_Shapes;

import Practice2.Task2_Shapes.controller.ShapeController;
import Practice2.Task2_Shapes.model.Shapes;
import Practice2.Task2_Shapes.view.ShapeView;

public class Main {
    public static void main(String[] args) {
        new ShapeController(new Shapes(), new ShapeView()).run();
    }
}
