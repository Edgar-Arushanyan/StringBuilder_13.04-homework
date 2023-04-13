import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

    }
    public static String readIntoString(File filename) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {

                stringBuilder.append(line).append(" ");
            }
        }
        return new String(stringBuilder).trim();
    }
}