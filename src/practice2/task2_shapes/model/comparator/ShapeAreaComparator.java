package practice2.task2_shapes.model.comparator;

import practice2.task2_shapes.model.entity.Shape;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o1.calcArea(), o2.calcArea());
    }
}
