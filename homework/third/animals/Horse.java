package homework.third.animals;

public class Horse extends Animal {

    public Horse(String name, String food, String location) {
        super(name, food, location);
    }

    public void makeNoise() {
        System.out.println("Neigh!");
    }

    public void eat() {
        System.out.println("Hay");
    }
}
