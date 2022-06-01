package lab.second;

/*
Написать регулярное выражение, определяющее является ли данная строчка шестнадцатиричным идентификатором цвета в HTML.
Где #FFFFFF для белого, #000000 для черного, #FF0000 для красного и т.д.
*/
import java.util.Scanner;

public class Colors {

    public static void main(String[] args) {
        String color;
        System.out.println("Enter HTML color: ");
        Scanner value = new Scanner(System.in);
        color = value.nextLine();
        System.out.println(color.matches("^(#[A-F|0-9]{6})$"));
    }
}
