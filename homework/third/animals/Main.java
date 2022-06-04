package homework.third.animals;

/*
Создать класс Animal и расширяющие его классы Dog, Cat, Horse. Класс Animal содержит переменные food, location
и методы makeNoise, eat, sleep. Метод makeNoise, например, может выводить на консоль "Такое-то животное спит".
Dog, Cat, Horse переопределяют методы makeNoise, eat. Добавьте переменные в классы Dog, Cat, Horse,
характеризующие только этих животных. Создайте класс Ветеринар, в котором определите метод
void treatAnimal(Animal animal). Пусть этот метод распечатывает food и location пришедшего на прием животного.
В методе main создайте массив типа Animal, в который запишите животных всех имеющихся у вас типов.
В цикле отправляйте их на прием к ветеринару.
*/
public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Vita", "meat", "yard");
        Cat cat = new Cat("Fluffy", "fish", "house");
        Horse horse = new Horse("Mila", "hay", "field");

        Animal[] animal = new Animal[]{dog, cat, horse};

        Vet veterinar = new Vet();

        for (int i = 0; i < animal.length; ++i) {
            veterinar.treatAnimal(animal[i]);
        }
    }
}
