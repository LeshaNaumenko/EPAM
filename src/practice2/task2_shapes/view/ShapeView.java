package practice2.task2_shapes.view;

import practice2.task2_shapes.model.entity.Shape;

public class ShapeView {
    public static final String WRONG_INPUT_INT_DATA = "Wrong input. Repeat please.";
    public static final String SUM_OF_THE_AREAS = "Sum of the areas";
    public static final String SUM_OF_THE_AREAS_A_CERTAIN_SHAPE = "Sum of the areas a certain shape";

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printShapes(String message, Shape[] shapes) {
        System.out.println(message);
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println();
    }

    public void printShapesWithArea(String message, Shape[] shapes) {
        System.out.println(message);
        for (Shape shape : shapes) {
            System.out.print(shape + "\t\t\tarea = ");
            System.out.println(shape.calcArea());
        }
        System.out.println();
    }

    public void printResult(String message, double result) {
        System.out.print(message + " = ");
        System.out.println(result + "\n");
    }
}
