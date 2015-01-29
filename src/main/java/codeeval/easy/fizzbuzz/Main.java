package codeeval.easy.fizzbuzz;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

/**
 * https://www.codeeval.com/open_challenges/1/
 */
public class Main {

    public static final String FIZZ = "F";
    public static final String BUZZ = "B";

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(FileSystems.getDefault().getPath(args[0]), Charset.defaultCharset());
        Main m = new Main();
        for (String string : strings) {
            System.out.println(m.convertToFizzbuzz(string));
        }
    }

    protected String convertToFizzbuzz(String numbers) {
        String[] split = numbers.split("\\s");

        int X = Integer.parseInt(split[0]);
        int Y = Integer.parseInt(split[1]);
        int number = Integer.parseInt(split[2]);

        StringBuffer result = new StringBuffer();
        for(int i=1; i<=number; i++) {
            if(i % X == 0 && i % Y == 0) {
                result.append(FIZZ).append(BUZZ);
            } else if(i % X == 0) {
                result.append(FIZZ);
            } else if(i % Y == 0) {
                result.append(BUZZ);
            } else {
                result.append(i);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}
