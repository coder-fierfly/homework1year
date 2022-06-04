package homework.third.shape;

public abstract class Shape {

    private String сolor;

    public Shape(String color) {
        this.сolor = color;
    }

    public String getСolor() {
        return сolor;
    }

    public abstract void draw();
}
