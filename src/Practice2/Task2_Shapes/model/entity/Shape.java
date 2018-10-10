package Practice2.Task2_Shapes.model.entity;

import java.util.Comparator;

public abstract class Shape implements Drawable {

    private String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return "shapeColor=" + shapeColor;
    }
}
