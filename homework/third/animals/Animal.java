package homework.third.animals;

public class Animal {

    String food;
    String location;
    String name;

    public Animal(String name, String food, String location) {
        this.food = food;
        this.location = location;
        this.name = name;
    }

    public void makeNoise() {
        System.out.println("The animal makes a sound ");
    }

    public void eat() {
        System.out.println("The animal eats ");
    }

    public void sleep() {
        System.out.println("Cute animal sleeping.");
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }
}
