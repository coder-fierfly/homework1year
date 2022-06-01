package lab.second;

import java.util.Scanner;

/*
Написать регулярное выражение, определяющее является ли данная строчка валидным URL адресом. В данной задаче
правильным URL считаются адреса http и https, явное указание протокола также может отсутствовать.
Учитываются только адреса, состоящие из символов, т.е. IP адреса в качестве URL не присутствуют при проверке.
Допускаются поддомены, указание порта доступа через двоеточие, GET запросы с передачей параметров, доступ к
подпапкам на домене, допускается наличие якоря через решетку. Однобуквенные домены считаются запрещенными.
Запрещены спецсимволы, например «–» в начале и конце имени домена. Запрещен символ «_» и пробел в имени домена.
При составлении регулярного выражения ориентируйтесь на список
*/
public class Url {

    public static void main(Str[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter URL: ");
        String line = sc.nextLine();
        System.out.println(line.matches("^(http(|s):\\/\\/)?([0-9a-zA-Zа-яА-ЯёЁ]"
                + "[0-9a-zA-Zа-яА-ЯёЁ-]*[0-9a-zA-Zа-яА-ЯёЁ]\\.)+([a-z]{2,})(:([0-9]|"
                + "[1-9][0-9]|[1-9][0-9]{2}|[1-9][0-9]{3}|[1-5][0-9]{4}|(6[0-4][0-9]{3})|"
                + "(65[0-4][0-9]{2})|(655[0-2][0-9]{2})|(6553[0-5])))?(\\/([0-9a-zA-Zа-яА-ЯёЁ]"
                + "[0-9a-zA-Zа-яА-ЯёЁ._-]*)*([?][0-9a-zA-Zа-яА-ЯёЁ]+=[0-9a-zA-Zа-яА-ЯёЁ_-]+"
                + "(&[0-9a-zA-Zа-яА-ЯёЁ]+=[0-9a-zA-Zа-яА-ЯёЁ_-]+)*)*(#[0-9a-zA-Zа-яА-ЯёЁ]"
                + "[0-9a-zA-Zа-яА-ЯёЁ_-]+)*)*\\/?$"));
    }
}