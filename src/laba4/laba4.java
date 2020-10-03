package laba4;

public class laba4{}
abstract class Shape {
    protected double area;
    protected double perimeter;
    public abstract void calcArea();
    public abstract void calcPerimeter();
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Circle extends Shape {
    private double D, R;

    public Circle(double r) {
        this.R = r;
        this.D = 2 * this.R;
    }

    public void calcArea() {
        area = Math.PI * Math.pow(this.R, 2);
        System.out.println("Area of circle = " + area);
    }

    public void calcPerimeter() {
        perimeter = 2 * Math.PI * this.R;
        System.out.println("Perimeter of circle =" + perimeter);
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }
}

class Rectangle extends Shape {

    private double A, B;

    public Rectangle(double a, double b) {
        this.A = a;
        this.B = b;
    }

    public void calcArea() {
        area = this.A * this.B;
        System.out.println("Area of rectangle = " + area);
    }

    public void calcPerimeter() {
        perimeter = 2 * (this.B + this.A);
        System.out.println("Perimeter of rectangle = " + perimeter);
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }
}
class Triangle extends Shape {
    double A,B,C;
    public Triangle(double a, double b,double c)
    {
        this.A=a;
        this.B=b;
        this.C=c;
    }
    public void calcArea() {
        double PP=(this.A+this.B+this.C)/2;
        area=Math.sqrt(PP*(PP-this.A)*(PP-this.B)*(PP-this.C));
        System.out.println("Area of triangle = "+ area);
    }

    public void calcPerimeter() {
        perimeter = this.A+this.B+this.C;
        System.out.println("Perimeter of triangle = "+perimeter);
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }
}
