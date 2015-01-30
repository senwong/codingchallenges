package codeeval.medium.detectingcycles;

public class Main {

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
