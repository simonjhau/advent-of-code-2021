import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Day1 {
    public static void main(String[] args) throws IOException {
        String[] lines = Files.readAllLines(Paths.get("./_2023/input/day1" +
                ".txt")).toArray(
                new String[0]);

        long start = System.nanoTime();
        int part1 = part1(lines);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.printf("Part 1: %d (%dus)\n", part1, timeElapsed / 1000);

        start = System.nanoTime();
        int part2 = part2(lines);
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.printf("Part 2: %d (%dus)\n", part2, timeElapsed / 1000);
    }

    static int part1(String[] lines) {
        int calibrationValuesSum = 0;

        for (String line : lines) {
            int i = 0;
            while (!Character.isDigit(line.charAt(i))) {
                i++;
            }
            int first = line.charAt(i) - '0';

            i = line.length() - 1;
            while (!Character.isDigit(line.charAt(i))) {
                i--;
            }
            int last = line.charAt(i) - '0';

            int calibrationValue = first * 10 + last;
            calibrationValuesSum += calibrationValue;
        }

        return calibrationValuesSum;
    }

    static final Map<String, Integer> mapping = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("1", 1),
            new AbstractMap.SimpleEntry<>("2", 2),
            new AbstractMap.SimpleEntry<>("3", 3),
            new AbstractMap.SimpleEntry<>("4", 4),
            new AbstractMap.SimpleEntry<>("5", 5),
            new AbstractMap.SimpleEntry<>("6", 6),
            new AbstractMap.SimpleEntry<>("7", 7),
            new AbstractMap.SimpleEntry<>("8", 8),
            new AbstractMap.SimpleEntry<>("9", 9),
            new AbstractMap.SimpleEntry<>("one", 1),
            new AbstractMap.SimpleEntry<>("two", 2),
            new AbstractMap.SimpleEntry<>("three", 3),
            new AbstractMap.SimpleEntry<>("four", 4),
            new AbstractMap.SimpleEntry<>("five", 5),
            new AbstractMap.SimpleEntry<>("six", 6),
            new AbstractMap.SimpleEntry<>("seven", 7),
            new AbstractMap.SimpleEntry<>("eight", 8),
            new AbstractMap.SimpleEntry<>("nine", 9)
    );
    static final List<String> numbers = mapping.keySet().stream().toList();

    static int part2(String[] lines) {
        int calibrationValuesSum = 0;

        for (String line : lines) {
            int first = -1;
            int i = 0;

            while (first == -1) {
                for (String number : numbers) {
                    if (line.startsWith(number, i)) {
                        first = mapping.get(number);
                        break;
                    }
                }
                i++;
            }

            int last = -1;
            while (last == -1) {
                for (String number : numbers) {
                    if (line.endsWith(number)) {
                        last = mapping.get(number);
                        break;
                    }
                }
                line = line.substring(0, line.length() - 1);
            }

            int calibrationValue = first * 10 + last;
            calibrationValuesSum += calibrationValue;
        }

        return calibrationValuesSum;
    }
}