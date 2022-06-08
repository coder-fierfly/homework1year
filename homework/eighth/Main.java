package homework.eighth;

/*
Дан двумерный массив (матрица) содержащий только 0 и 1. Матрица представляет собой землю, где 0 - впадина, 1 - равнина.
Впадины могут быть разные по размерам, организовываются они путем соединения соседних ячеек сверху, снизу, справа и
слева, но не по диагонали.
Необходимо написать функцию, которая принимает двумерный массив в качестве параметра и возвращает размеры всех впадин в
порядке возрастания также в виде массива. Ввод значений допускается в любом виде - главное, реализовать метод с
соблюдением необходимых параметров и возвращаемого значения. При выводе итоговых значений обязательно сохранить
отсортированный вид.
        Пример входных параметров
        [0 1 1 0 1]
        [0 1 0 1 1]
        [1 1 0 1 0]
        [0 1 0 1 0]
        [0 1 0 0 1]

        Ожидается на выходе
        [1 2 2 2 5]
        Пояснение
        [0     0  ]
        [0   0    ]
        [    0   0]
        [0   0   0]
        [0   0 0  ]
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество столбцов матрицы: ");
        int columns = sc.nextInt();
        System.out.println("Введите количество строк: ");
        int strings = sc.nextInt();
        int[][] matrix = newMatrix(columns, strings);
        int[] arr = countStart(matrix);
        System.out.println(Arrays.toString(arr));
    }

    public static int[][] newMatrix(int columns, int strings) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[columns][strings];
        for (int i = 0; i < columns; ++i) {
            for (int j = 0; j < strings; ++j) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static int[] countStart(int[][] matrix) {
        int columns = matrix.length;
        int strings = matrix[columns - 1].length;
        ArrayList<Integer> holes = new ArrayList<>();
        for (int x = 0; x < columns; ++x) {
            for (int y = 0; y < strings; ++y) {
                if (matrix[x][y] == 0) {
                    holes.add(countHoles(matrix, x, y, columns, strings));
                }
            }
        }
        int[] arr = new int[holes.size()];
        for (int i = 0; i < holes.size(); i++) {
            arr[i] = holes.get(i);
        }
        Arrays.sort(arr);
        return arr;
    }

    public static int countHoles(int[][] matrix, int x, int y, int columns, int strings) {
        int size = 0;
        if (matrix[x][y] == 0) {
            matrix[x][y] = 1;
            size++;
        } else {
            return size;
        }
        //влево
        if (x < columns - 1) {
            size += countHoles(matrix, x + 1, y, columns, strings);
        }
        //вправо
        if (x > 0) {
            size += countHoles(matrix, x - 1, y, columns, strings);
        }
        //вниз
        if (y < strings - 1) {
            size += countHoles(matrix, x, y + 1, columns, strings);
        }
        //вверх
        if (y > 0) {
            size += countHoles(matrix, x, y - 1, columns, strings);
        }
        return size;
    }
}