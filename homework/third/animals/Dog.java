package homework.third.animals;

public class Dog extends Animal {

    public Dog(String name, String food, String location) {
        super(name, food, location);
    }

    public void makeNoise() {
        System.out.println("Woof!");
    }

    public void eat() {
        System.out.println("Meat");
    }
}
