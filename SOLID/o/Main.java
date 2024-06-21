public class Main {
    public static void main(String[] args){
        Circle circle = new Circle(10);
        System.out.println("Circle area");
        System.out.println(circle.area());


        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println("Rectangle area");
        System.out.println(rectangle.area());


        AreaCalculator calculator = new AreaCalculator();

        System.out.println("Rectangle area by calculator");
        System.out.println(calculator.area(rectangle));


        System.out.println("Rectangle area by calculator");
        System.out.println(calculator.area(circle));
    }
}
