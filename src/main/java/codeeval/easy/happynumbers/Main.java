package codeeval.easy.happynumbers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.codeeval.com/open_challenges/39/
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(FileSystems.getDefault().getPath(args[0]), Charset.defaultCharset());
        Main m = new Main();
        for (String string : strings) {
            System.out.println(m.isHappyNumber(string) ? 1 : 0);
        }
    }

    public boolean isHappyNumber(String number) {
        int i = getSumOfSquares(getDigits(Integer.parseInt(number)));
        Set<Integer> numbers = new HashSet<>();
        while(i != 1 && numbers.add(i)) {
            i = getSumOfSquares(getDigits(i));
        }
        return i == 1 ? true : false;
    }

    private int getSumOfSquares(List<Integer> digits) {
        int result = 0;
        for (Integer digit : digits) {
            result += Math.pow(digit, 2);
        }
        return result;
    }

    private List<Integer> getDigits(int i) {
        List<Integer> digits = new ArrayList<>();
        while(i > 0) {
            digits.add(i % 10);
            i /= 10;
        }
        return digits;
    }
}
