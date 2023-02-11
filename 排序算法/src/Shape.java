import java.util.Scanner;
interface Shape {
    double area(double x);
}
class Square implements Shape{
    public double area(double sideLength) {
        return sideLength*sideLength;
    }
}
class Circle implements Shape{
    public double area(double r) {
        return 3.14*r*r;
    }
}
class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape square = new Square();
        Shape circle = new Circle();
        double x = sc.nextDouble();
        System.out.println(circle.area(x));
        double y = sc.nextDouble();
        System.out.println(square.area(y));
    }
}