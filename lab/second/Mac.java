package lab.second;

// Написать регулярное выражение, определяющее является ли заданная строка правильным MAC-адресом
import java.util.Scanner;

public class Mac {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter MAC address: ");
        String mac = sc.nextLine();
        System.out.println(mac.matches("^((\\d|[A-F]){2}"
                + "(:|-)){5}(\\d|[A-F]){2}$"));
    }
}
