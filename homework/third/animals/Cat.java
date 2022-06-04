package homework.third.animals;

public class Cat extends Animal {

    public Cat(String name, String food, String location) {
        super(name, food, location);

    }

    public void makeNoise() {
        System.out.println("Weow!");
    }

    public void eat() {
        System.out.println("Fish");
    }
}
