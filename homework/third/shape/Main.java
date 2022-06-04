package homework.third.shape;

/*
Создайте супер класс Shape и его наследники Circle, Rectangle. Класс Shape содержит абстрактный метод draw() и
переменную хранящую цвет. Классы Circle, Rectangle содержат координаты точек. Создать массив содержащий эти фигуры.
В цикле нарисовать их (вызвать метод draw). Добавить метод equals() для классов Shape, Circle, Rectangle.
*/
public class Main {

    public static void main(String[] args) {

        Circle circle = new Circle("black", 3, 6, 9);
        Rectangle rectangle = new Rectangle("blue", 1, 4, 5, 8);

        Shape[] figura = new Shape[] {circle, rectangle};

        for(Shape fig : figura) {
            fig.draw();
        }
    }
}
