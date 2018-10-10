package Practice2.Task2_Shapes.model;

import Practice2.Task2_Shapes.model.comparator.ShapeAreaComparator;
import Practice2.Task2_Shapes.model.comparator.ShapeColorComparator;
import Practice2.Task2_Shapes.model.entity.Shape;

import java.util.Arrays;

public class Shapes {

    Shape[] shapes;

    public Shape[] getShapes() {
        return shapes;
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }

    public double sumOfTheAreas() {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.calcArea();
        }
        return sum;
    }

    public double sumOfTheAreasACertainColor(String color) {
        double sum = -1;
        for (Shape shape : shapes) {
            if (shape.getShapeColor().equals(color)) {
                sum += shape.calcArea();
            }
        }
        return sum;
    }

    public Shape[] getOrderedShapeByArea() {
        Shape[] temp = Arrays.copyOf(this.shapes, shapes.length);
        Arrays.sort(temp, new ShapeAreaComparator());
        return temp;
    }

    public Shape[] getOrderedShapeByColor() {
        Shape[] temp = Arrays.copyOf(this.shapes, shapes.length);
        Arrays.sort(temp, new ShapeColorComparator());
        return temp;
    }

}
