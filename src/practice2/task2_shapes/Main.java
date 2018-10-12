package practice2.task2_shapes;

import practice2.task2_shapes.controller.ShapeController;
import practice2.task2_shapes.model.Shapes;
import practice2.task2_shapes.view.ShapeView;

public class Main {
    public static void main(String[] args) {
        new ShapeController(new Shapes(), new ShapeView()).run();
    }
}
