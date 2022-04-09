package lab.first;
/*
В тексте найти все пары слов, из которых одно является обращением другого.
*/
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] argv) {

        int num = 0;
        String[] words;
        String temp;
        String reg = "[^a-zA-Zа-яА-Я| ]+";
        String regular = "[a-zA-Zа-яА-Я]+";
        System.out.println("Enter your string: ");
        Scanner line = new Scanner(System.in);
        temp = line.nextLine().replaceAll(reg, " ");
        words = temp.split(" ");
        System.out.println("Palindromes from the text.");

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                StringBuilder newWords = new StringBuilder(words[i]);
                newWords.reverse();
                if (words[j].equalsIgnoreCase(newWords.toString())
					&& words[j].matches(regular)
                        && 1 != words[j].length()) {
                    System.out.println(words[i] + " " + words[j]);
                    num++;
                }
            }
        }
        if (num == 0) {
            System.out.println("No such words were found.");
        }
    }
}
