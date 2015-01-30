package codeeval.medium.detectingcycles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

/**
 * https://www.codeeval.com/open_challenge_scores/?pkbid=5
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(FileSystems.getDefault().getPath(args[0]), Charset.defaultCharset());
        Main m = new Main();
        for (String string : strings) {
            System.out.println(m.detectCycle(string));
        }
    }

    public String detectCycle(String numbers) {
        String[] split = numbers.split("\\s");
        int hare = 0;
        StringBuilder sequence = new StringBuilder();
        for(int tortoise = 0; tortoise < split.length; tortoise++) {
            if(tortoise > 0 && matches(split, tortoise, hare)) {
                int delta = getDeltaToFirstMatch(split, tortoise, hare);
                tortoise -= delta;
                hare -= delta;
                String sequenceStart = split[tortoise];
                while(matches(split, tortoise++, hare++)) {
                    sequence.append(split[tortoise-1]).append(" ");
                    if(sequenceStart.equals(split[tortoise])) {
                        break;
                    }
                }
                break;
            }
            hare += 2;
            if(hare >= split.length) {
                hare = split.length-1;
            }
        }

        return sequence.toString().trim();
    }

    private int getDeltaToFirstMatch(String[] sequence, int tortoise, int hare) {
        int x = 1;
        while(matches(sequence, tortoise-x, hare-x)) {
            x++;
        }
        return --x;
    }

    private boolean matches(String[] split, int tortoise, int hare) {
        return tortoise >= 0 && hare < split.length && tortoise < split.length && split[tortoise].equals(split[hare]);
    }
}
