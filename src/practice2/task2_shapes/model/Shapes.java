package practice2.task2_shapes.model;

import practice2.task2_shapes.model.entity.Shape;

import java.util.Arrays;
import java.util.Comparator;

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

    public double sumOfTheAreasACertainShape(String shapeName) {
        double sum=0;
        for (Shape shape : shapes) {
            if (shape.getClass().getSimpleName().equals(shapeName)) {
                sum += shape.calcArea();
            }
        }
        return sum;
    }

    public Shape[] getOrderedShapeByArea() {
        Shape[] temp = Arrays.copyOf(this.shapes, shapes.length);
        Arrays.sort(temp, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return Double.compare(o1.calcArea(), o2.calcArea());
            }
        });
        return temp;
    }

    public Shape[] getOrderedShapeByColor() {
        Shape[] temp = Arrays.copyOf(this.shapes, shapes.length);
        Arrays.sort(temp, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return o1.getShapeColor().compareTo(o2.getShapeColor());
            }
        });
        return temp;
    }

}
