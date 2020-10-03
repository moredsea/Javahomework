package laba4;

public class test {
    public static void main(String[] args) {


        Circle var = new Circle(14);
        var.calcArea();
        var.calcPerimeter();
        System.out.println(var.getArea());
        System.out.println(var.getPerimeter());
        Rectangle oga = new Rectangle(7,9);
        oga.calcArea();
        oga.calcPerimeter();
        System.out.println(oga.getArea());
        System.out.println(oga.getPerimeter());
        Triangle pir = new Triangle(3,4,5);
        pir.calcArea();
        pir.calcPerimeter();
        System.out.println(pir.getArea());
        System.out.println(pir.getPerimeter());
    }
}
