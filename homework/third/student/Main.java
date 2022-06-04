package homework.third.student;
/*
Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость
(массив из пяти элементов). Создайте массив из N элементов такого типа(порядок чтения данных из консоли фамилия
и инициалы, номер группы, успеваемость (массив из пяти элементов)). Добавьте возможность вывода фамилии и номеров
групп студентов, имеющих оценки, равные только 9 или 10.
*/
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean verity = false;
        final int NUM = 5;
        int num = 0;
        int digit = 0;

        Scanner sk = new Scanner(System.in);
        System.out.println("Enter the number of students:");

        do {
            if (sk.hasNextInt()) {
                num = sk.nextInt();
                verity = true;
            } else {
                System.out.println("Enter the number. Try it again.");
                sk.nextLine();
                verity = false;
            }
        } while (!verity);

        Student[] students;
        students = new Student[num];
        for (int i = 0; i < num; ++i) {
            verity = false;
            sk.nextLine();
            System.out.println("Enter lastName:");
            String lastName = sk.nextLine();
            System.out.println("Enter initials:");
            String initials = sk.nextLine();
            System.out.println("Enter groupNumber:");
            String groupNumber = sk.nextLine();
            System.out.println("Enter marks:");
            float[] marks = new float[NUM];
            for (int j = 0; j < NUM; ++j) {
                do {
                    if (sk.hasNextFloat()) {
                        marks[j] = sk.nextFloat();
                        verity = true;
                    } else {
                        System.out.println("Enter float number. Try it again.");
                        sk.nextLine();
                        verity = false;
                    }
                } while (!verity);
            }
            students[i] = new Student(lastName, initials, groupNumber, marks);
        }
        verity = false;
        System.out.println("Do you want see only A students?(yes-1,no-0)");
        do {
            if (sk.hasNextInt()) {
                digit = sk.nextInt();
                verity = true;
            } else {
                System.out.println("Enter the number. Try it again.");
                sk.nextLine();
                verity = false;
            }
        } while (!verity);
        sk.close();

        if (digit == 0) {
            for (Student person : students) {
                System.out.println(person.getInfo());
            }
        }

        if (digit == 1) {
            boolean flag;
            for (Student person : students) {
                flag = true;
                for (float marks : person.marks) {
                    if (marks < 8) {
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println(person.getInfo());
                }
            }
        }
    }
}