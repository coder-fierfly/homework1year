package homework.four;

/*
Найти такую точку заданного на плоскости множества точек, сумма расстояний от которой до остальных минимальна. На вход
подается количество точке, далее 3 координаты в формате (x, y, z), координаты целочисленные. Необходимо вывести
координаты такой точки и сумму расстояний до остальных точке через пробел (сумму округлить до второго знака после
запятой/точки)
        3
        (11, 22, 33)
        (21, 32, 43)
        (31, 42, 55)
        На выходе:
        (21, 32, 43) 35.87
*/
import java.util.Scanner;

public class NearestPoint {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.println("Enter the number of points");
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Enter digit");
                sc.next();
            }
            num = sc.nextInt();
        } while (num < 2);

        String[] line = new String[num];
        String[][] newLine = new String[num][3];

        for (int i = 0; i < num; ++i) {
            System.out.println("Enter (x,y,z):");
            do {
                line[i] = sc.nextLine();
            } while (!line[i].matches("^(\\((|-)\\d+,( ||( |)-)\\d+,( ||( |)-)\\d+\\))$"));
            newLine[i] = line[i].replaceAll("[,]", "\s").replaceAll("[(]|[)]", "").split("\s+");
        }

        Double[][] array = new Double[num][3];
        Double[] result = new Double[num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = Double.parseDouble(newLine[i][j]);
            }
        }

        for (int i = 0; i < num; ++i) {
            double helper = 0;
            for (int j = 0; j < num; ++j) {
                helper += Math.sqrt(((Math.pow((array[i][0] - array[j][0]), 2))
                        + (Math.pow((array[i][1] - array[j][1]), 2))
                        + (Math.pow((array[i][2] - array[j][2]), 2))));
            }
            result[i] = helper;
        }

        double sum = result[0];
        int number = 0;
        for (int i = 0; i < num - 1; ++i) {
            if (result[i] < sum) {
                sum = result[i];
                number = i;
            }
        }

        System.out.printf("(%.2f, %.2f, %.2f) %.2f",
                array[number][0], array[number][1], array[number][2], result[number]);
    }
}