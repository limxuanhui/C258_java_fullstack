package exercises;
/* Created by limxuanhui on 20/6/22 */

abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    abstract public double getArea();

    abstract public double getPerimeter();
}

class Square extends Shape {
    private double width;

    public Square(String color, double width) {
        super(color);
        this.width = width;
    }

    @Override
    public double getArea() {
        return width*width;
    }

    @Override
    public double getPerimeter() {
        return 4*width;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return 2*(width+height);
    }
}

class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s-side1) * (s-side2) * (s-side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
}

public class ShapesAndPerimeters {
    public static void main(String[] args) {
        Square square = new Square("red", 20);
        Rectangle rectangle = new Rectangle("green", 20, 30);
        Triangle triangle = new Triangle("blue", 20, 30, 40);
        Circle circle = new Circle("red", 20);

        System.out.println("Square");
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter() + "\n");

        System.out.println("Rectangle");
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter() + "\n");

        System.out.println("Triangle");
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter() + "\n");

        System.out.println("Circle");
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter() + "\n");
    }
}
