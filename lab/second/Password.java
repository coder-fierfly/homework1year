package lab.second;

/*
Проверить, надежно ли составлен пароль. Пароль считается надежным, если он состоит из 8 или более символов.
Где символом может быть английская буква, цифра и знак подчеркивания. Пароль должен содержать хотя бы одну
заглавную букву, одну маленькую букву и одну цифру.
        – пример правильных выражений: C00l_Pass, SupperPas1.
        – пример неправильных выражений: Cool_pass, C00l.
*/
import java.util.Scanner;

public class Password {

    public static void main(String[] args) {

    String parole;
	System.out.println("Enter password: ");
        Scanner value = new Scanner(System.in);
        parole = value.nextLine();
	System.out.println(parole.matches("((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(\\_*).{8,})"));
    }
}
