package practice2.task2_shapes.model.entity;

public class Rectangle extends Shape {

    private int wide;
    private int length;

    public Rectangle(String shapeColor, int wide, int length) {
        super(shapeColor);
        this.wide = wide;
        this.length = length;
    }

    public int getWide() {
        return wide;
    }

    public void setWide(int wide) {
        this.wide = wide;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public double calcArea() {
        return wide * length;
    }

    @Override
    public void draw() {

    }

    @Override
    public String toString() {
        return "Rectangle\t{" +
                super.toString() +
                ",\twide=" + wide +
                ",\t\tlength=" + length +
                '}';
    }
}
