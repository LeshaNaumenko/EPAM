package Practice2.Task2_Shapes.model.comparator;

import Practice2.Task2_Shapes.model.entity.Shape;

import java.util.Comparator;

public class ShapeColorComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return o1.getShapeColor().compareTo(o2.getShapeColor());
    }
}
