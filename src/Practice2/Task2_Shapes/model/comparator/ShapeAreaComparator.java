package Practice2.Task2_Shapes.model.comparator;

import Practice2.Task2_Shapes.model.entity.Shape;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o1.calcArea(), o2.calcArea());
    }
}
