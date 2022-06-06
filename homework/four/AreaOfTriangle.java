package homework.four;

/*
Выбрать три разные точки заданного на плоскости множества точек, составляющие треугольник с наибольшей площадью.
        На вход подается количество точке n, далее 2 координаты в формате (x, y), координаты целочисленные. Необходимо вывести площадь наибольшего треугольника, округлить до 2 знаков после запятой
        4
        (11, 10)
        (22, 22)
        (33, 11)
        (20, 15)
        На выходе:
        126.50
*/
import java.util.Scanner;

public class AreaOfTriangle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Enter the number of points");
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Enter digit");
                sc.next();
            }
            num = sc.nextInt();
        } while (num < 3);

        String[] line = new String[num];
        String[][] newLine = new String[num][2];

        for (int i = 0; i < num; ++i) {
            System.out.println("Enter (x,y):");
            do {
                line[i] = sc.nextLine();
            } while (!line[i].matches("^(\\((|-)\\d+,( ||-)\\d+\\))$"));
            newLine[i] = line[i].replaceAll("[,]", "\s").replaceAll("[(]|[)]", "").split("\s+");
        }

        Double[][] array = new Double[num][2];


        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = Double.parseDouble(newLine[i][j]);
            }
        }
        double maxArea = 0;
        double a, b, c;
        double p;
        double s = 0;
        for (int i = 0; i < (num - 2); ++i) {
            for (int j = i + 1; j < (num - 1); ++j) {
                for (int k = j + 1; k < num; ++k) {
                    a = Math.sqrt(Math.pow(((double) array[j][0] - array[i][0]), 2)
                            + Math.pow(((double) array[j][1] - array[i][1]), 2));
                    b = Math.sqrt(Math.pow(((double) array[k][0] - array[i][0]), 2)
                            + Math.pow(((double) array[k][1] - array[i][1]), 2));
                    c = Math.sqrt(Math.pow(((double) array[k][0] - array[j][0]), 2)
                            + Math.pow(((double) array[k][1] - array[j][1]), 2));
                    p = (a + b + c) / 2;
                    s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                    if (maxArea < s) {
                        maxArea = s;
                    }
                }
            }
        }
        System.out.printf("%.2f", maxArea);
    }
}
