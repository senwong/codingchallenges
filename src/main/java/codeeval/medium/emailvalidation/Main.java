package codeeval.medium.emailvalidation;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codeeval.com/open_challenges/35/
 */
public class Main {

    private static final Pattern PATTERN = Pattern.compile("[\\w\\.\\-\\+\\%]*@[\\w\\.\\-]+?\\.[a-zA-Z]{2,4}");

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(FileSystems.getDefault().getPath(args[0]), Charset.defaultCharset());
        Main m = new Main();
        for (String string : strings) {
            if(string != null && !string.trim().isEmpty()) {
                System.out.println(m.validateEmail(string));
            }
        }
    }

    public boolean validateEmail(String email) {
        Matcher matcher = PATTERN.matcher(email);
        return matcher.matches();
    }

}
