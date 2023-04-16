import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
      /*
     1). Переписать первую задачу из вчерашнего задания с использованием StringBuilder:
       Есть текстовый файл. Написать метод, читающий файл и возвращающий строку,
        состоящую из строчек этого файла.
        Write a method to read a text file into a String using StringBuilder class
         *Есть  текстовый файл.  Написать метод,  читающий файл и  возвращающий строку,
    состоящую из строчек этого файла,  разделенных пробелом.
   Пример текстового файла:
     aaa
     bbbbbbb
     cc
    результат : aaa bbbbbbb cc
       */

        File filename = new File("input.txt");
        System.out.println(readIntoString(filename));

        // 2.--------------------------------------------------------------------\\
        System.out.println(reverseWords("The              weather today is great"));
        // output: great is today weather The

        // *3.---------------------------------------------------------------------\\

        System.out.println(countCharacters("aaaabbccccd")); // output: 4a2b4cd

    }

    public static String readIntoString(File filename) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {

                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
        }
        return new String(stringBuilder).trim();
    }

    /*
    Написать метод, возвращающий слова в строке в обратном порядке.
     Использовать StringBuilder. Слова разделяются пробелом.
     Пример: "The weather today is great" -> "great is today weather The "
     Write a method to reverse words in a String. Use StringBuilder
     */
    public static String reverseWords(String string) {

        String[] words = string.trim().split(" ");

        // Collections.reverse(Arrays.asList(words)); без стрингбилдера
        StringBuilder res = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty())
                res = res.append(words[i]).append(" ");
        }
        return new String(res).trim();
    }

    /* * 3. Есть строка, состоящая только из маленьких букв.
      Используя StringBuilder написать метод,подсчитывающий количество повторений буквы
       и возвращающий новую строку такого вида: aaaabbccccd -> 4a2b4cd
       Write a method to convert a string of lowercase letters into
       a string counting the number of these letters for each letter aaaabbccccd -> 4a2b4cd
       Это задача со звездочкой, не обязательная
     */
    public static String countCharacters(String str) {
        if (str.length() == 0)
            return "";

        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            if ((str.charAt(i - 1)) != str.charAt(i)) {
                if (count > 1) {
                    stringBuilder.append(count).append(str.charAt(i - 1));
                    count = 1;
                } else {
                    stringBuilder.append(str.charAt(i - 1));
                }
            } else {
                count++;
            }
        }
        if (count == 1){
            stringBuilder.append(str.charAt(str.length() - 1));
        }else {

            stringBuilder.append(count).append(str.charAt(str.length() - 1));
        }
        return stringBuilder.toString();

    }
}