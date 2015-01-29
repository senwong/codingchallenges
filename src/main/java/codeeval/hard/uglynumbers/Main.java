package codeeval.hard.uglynumbers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * https://www.codeeval.com/open_challenges/42/
 *
 * Credits: This challenge has appeared in a google competition before.
 *
 * Once upon a time in a strange situation, people called a number ugly
 * if it was divisible by any of the one-digit primes (2, 3, 5 or 7).
 * Thus, 14 is ugly, but 13 is fine. 39 is ugly, but 121 is not. Note
 * that 0 is ugly. Also note that negative numbers can also be ugly:
 * -14 and -39 are examples of such numbers.
 *
 * One day on your free time, you are gazing at a string of digits,
 * something like:
 *
 * 123456
 *
 * You are amused by how many possibilities there are if you are allowed
 * to insert plus or minus signs between the digits. For example you can make:
 *
 * 1 + 234 - 5 + 6 = 236
 *
 * which is ugly. Or
 *
 * 123 + 4 - 56 = 71
 *
 * which is not ugly.
 *
 * It is easy to count the number of different ways you can play with the
 * digits: Between each two adjacent digits you may choose put a plus sign,
 * a minus sign, or nothing. Therefore, if you start with D digits there
 * are 3^(D-1) expressions you can make. Note that it is fine to have leading
 * zeros for a number. If the string is '01023', then '01023', '0+1-02+3' and
 * '01-023' are legal expressions.
 *
 * Your task is simple: Among the 3^(D-1) expressions, count how many of them
 * evaluate to an ugly number.
 *
 * INPUT SAMPLE:
 * Your program should accept as its first argument a path to a filename.
 * Each line in this file is one test case. Each test case will be a single
 * line containing a non-empty string of decimal digits. The string in each
 * test case will be non-empty and will contain only characters '0' through '9'.
 * Each string is no more than 13 characters long. E.g.
 *
 * 1
 * 9
 * 011
 * 12345
 *
 * OTPUT SAMPLE:
 * Print out the number of expressions that evaluate to an ugly number for
 * each test case, each one on a new line. E.g.
 *
 * 0
 * 1
 * 6
 * 64
 *
 */

public class Main {

    private static final int[] LOW_PRIMES = new int[]{2, 3, 5, 7};
    private static final char[] OPERATIONS = new char[]{'-', '+'};

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(FileSystems.getDefault().getPath(args[0]), Charset.defaultCharset());
        Main uglyNumbers = new Main();
        for (String string : strings) {
            System.out.println(uglyNumbers.countPossibleUglyNumbers(string));
        }
    }

    public int countPossibleUglyNumbers(String anyString) {
        Set<List<String>> possibleNumberCombinations = new HashSet<>();
        recursiveSplit(anyString, possibleNumberCombinations);

        int count = 0;
        for (List<String> possibleNumberCombination : possibleNumberCombinations) {
            count += getUglyNumberCount(possibleNumberCombination, new StringBuilder());
        }
        return count;
    }

    private void recursiveSplit(String s, Set<List<String>> result) {
        int splithere = 1;
        while(splithere != s.length()) {
            result.addAll(getNumbersAsString(s, splithere++));
        }
        result.add(Arrays.asList(s));
    }

    private Set<List<String>> getNumbersAsString(String s, int splitIndex) {
        String[] split = new String[]{s.substring(0, splitIndex), s.substring(splitIndex, s.length())};
        List<String> numbers = Arrays.asList(split);
        Set<List<String>> result = new HashSet<>();
        result.add(numbers);

        for (String substring : numbers) {
            if(substring.length() >= 2) {
                Set<List<String>> subset = new HashSet<>();
                recursiveSplit(substring, subset);
                for (List<String> subsetNumbers : subset) {
                    result.add(replace(numbers, substring, subsetNumbers));
                }
            }
        }
        return result;
    }

    private List<String> replace(List<String> originalNumbers, String numberToReplace, List<String> newNumbers) {
        List<String> result = new ArrayList<>();
        result.addAll(originalNumbers);
        int i = result.indexOf(numberToReplace);
        result.remove(i);
        for (String newNumber : newNumbers) {
            result.add(i++, newNumber);
        }
        return result;
    }

    public int getUglyNumberCount(List<String> numbers, StringBuilder operations) {
        int uglyNumberCount = 0;
        if(operations.length() == numbers.size() - 1) {
            if(isUglyNumber(calculate(numbers, operations.toString()))) {
                uglyNumberCount++;
            }
        } else {
            for (char c : OPERATIONS) {
                String previous = operations.toString();
                operations.append(c);
                uglyNumberCount += getUglyNumberCount(numbers, operations);
                operations = new StringBuilder(previous);
            }
        }
        return uglyNumberCount;
    }

    private double calculate(List<String> numbers, String operation) {
        Iterator<String> iterator = numbers.iterator();
        double result = Double.parseDouble(iterator.next());
        int index = 0;
        while (iterator.hasNext()) {
            double number = Double.parseDouble(iterator.next());
            if(operation.substring(index, ++index).equals("+")) {
                result += number;
            } else {
                result -= number;
            }
        }
        return result;
    }

    public static boolean isUglyNumber(double number) {
        for (int low_prime : LOW_PRIMES) {
            if(number % low_prime == 0) {
                return true;
            }
        }
        return false;
    }

}
