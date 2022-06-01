package lab.second;

// Написать регулярное выражение для проверки email
import java.util.Scanner;

public class Email {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email:");
        String str = sc.nextLine();
        System.out.println(str.matches("^(?=(.{1,64}@))(?=(.{7,255}$))"
                + "(?=(.{7,255}$))(((([a-zA-Z]|[а-яА-Я]|[ё]|[Ё])((\\w|[а-яА-ЯёЁ-]|\\.)*"
                + "([a-zA-Zа-яА-ЯёЁ]|\\d))*(\\+1){0,1}){1,64}@)(((([a-zA-Z]|[а-яА-Я]|[ё]|[Ё]|"
                + "\\d){2,}\\.)+([a-zA-Z]|[а-яА-Я]|[ё]|[Ё]){2,})|((\\d\\.|[1-9]\\d\\.|1\\d{2}\\.|"
                + "2[1-4]\\d\\.|25[0-5]\\.){3}(\\d|[1-9]\\d|1\\d{2}|2[1-4]\\d|25[0-5]))))$"));
    }
}
