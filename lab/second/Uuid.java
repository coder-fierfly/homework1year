package lab.second;

/*
Написать регулярное выражение, определяющее является ли данная строка UUID с или без скобок.
        Генерирвать можно тут (https://www.uuidgenerator.net/)
*/
import java.util.Scanner;

public class Uuid {

    public static void main(String[] args) {
        System.out.println("Enter UUIP: ");
        Scanner sc = new Scanner(System.in);
        String uuip = sc.nextLine();
        System.out.println(uuip.matches("^((\\({1}(\\d|[a-f]){8}-(\\d|[a-f]){4}"
                + "-1(\\d|[a-f]){3}-8(\\d|[a-f]){3}-(\\d|[a-f]){12}\\){1})|(\\d|[a-f]){8}"
                + "-(\\d|[a-f]){4}-1(\\d|[a-f]){3}-8(\\d|[a-f]){3}-(\\d|[a-f]){12}|"
                + "(\\({1}(\\d|[a-f]){8}-(\\d|[a-f]){4}-4(\\d|[a-f]){3}-(\\d|[a-f]){4}"
                + "-(\\d|[a-f]){12}\\){1}|(\\d|[a-f]){8}-(\\d|[a-f]){4}-4(\\d|[a-f]){3}"
                + "-(\\d|[a-f]){4}-(\\d|[a-f]){12})|(0{8}(-0{4}){3}-0{12})"
                + "|(\\(0{8}(-0{4}){3}-0{12}\\)))$"));
        //7c09dbb4-849b- 1 1eb- 8 dcd-0242ac130003
        //af1e5ff3-9709- 4 323-b62b-57c4032d2fd9
        //00000000-0000-0000-0000-000000000000
    }
}
