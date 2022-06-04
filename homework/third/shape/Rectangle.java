package homework.third.shape;

public class Rectangle extends Shape {
    private int a;
    private int b;
    private int c;
    private int d;
    private String color;

    public Rectangle(String color, int a, int b, int c, int d) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void draw() {
        System.out.println("Drawm rectangle");
    }

    public boolean equals(Rectangle our) {
        return our.a == a && our.b == b && our.c == c && our.d == d;
    }
}
