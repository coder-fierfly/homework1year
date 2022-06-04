package homework.third.shape;

public class Circle extends Shape {

    private int a;
    private int b;
    private int c;

    public Circle(String color, int a, int b, int c) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void draw() {
        System.out.println("Drown circle");
    }

    public boolean equals (Circle our) {
            return our.a == a && our.b == b && our.c == c;
    }
}
