package practice2.task2_shapes.model.entity;

public class Circle extends Shape {

    private int radius;

    public Circle(String shapeColor, int radius) {
        super(shapeColor);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {

    }

    @Override
    public String toString() {
        return "Circle\t\t{" +
                super.toString() +
                ",\tradius=" + radius +
                '}';
    }
}
