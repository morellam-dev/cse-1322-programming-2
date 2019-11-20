package module_7.lab_7b;

import java.io.*;
import java.util.Arrays;
import java.util.regex.*;

/**
 * Counts the number of times a word occurs in a body of text.
 * 
 * @implNote Determines the {@link Runtime}'s number of available processors,
 *           then divides the text into that many equal chunks, which are split
 *           across multiple threads.
 */
public class WordCounter {
    /**
     * Using a regular expression, count every occurence of a word in a body of text
     * 
     * @param text The body of text to search through
     * @param word The word or phrase to search for
     * @return
     */
    public static int wordCount(String text, String word) {
        Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        int i = 0;
        while (matcher.find(i)) {
            i = matcher.end();
            count++;
        }
        return count;
    }

    /**
     * @return The full text of the file located at {@code path}, or {@code null} if
     *         no such file exists.
     */
    private static String readStringFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String text = "";
            while (reader.ready()) {
                text += reader.readLine() + "\n";
            }
            return text;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Divides a long string into {@code count} segments, each with an equal number
     * of lines.
     */
    private static String[] splitStringIntoChunks(String text, int count) {
        String[] lines = text.split("\n"); // Split into lines to avoid breaking around a word.
        int sliceLength = (int) Math.ceil(lines.length / count);

        String[] chunks = new String[count];
        for (int i = 0; i < count; i++) {
            int from = i * sliceLength;
            int to = Math.min((i + 1) * sliceLength, lines.length);
            String[] sub = Arrays.copyOfRange(lines, from, to);
            chunks[i] = String.join("\n", sub);
        }
        return chunks;
    }

    public static int wordCountParallel(String str, String word) {
        final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[THREAD_COUNT];
        int[] results = new int[THREAD_COUNT];

        String[] chunks = splitStringIntoChunks(str, THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int index = i; // Lambda expression requires final variables
            Thread t = new Thread(() -> results[index] = wordCount(chunks[index], word));
            threads[i] = t;
            t.start();
        }
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int totalCount = 0;
        for (int partialCount : results) {
            totalCount += partialCount;
        }
        return totalCount;
    }

    /**
     * Demonstrate this class's functionality by reading from the fulltext of Alice
     * in Wonderland
     */
    public static void main(String[] args) {
        String file = "alice.txt";
        String fullText = readStringFromFile(file);

        System.out.println(fullText);

        long parallelDuration = System.currentTimeMillis();
        int parallelCount = wordCount(fullText, "the");
        parallelDuration = System.currentTimeMillis() - parallelDuration;
        System.out.printf("=== PARALLEL COUNT (%d THREADS) ===\n", Runtime.getRuntime().availableProcessors());
        System.out.printf("%s has %d occurences of \"the\". (took %,d ms)\n", file, parallelCount, parallelDuration);

        long serialDuration = System.currentTimeMillis();
        int serialCount = wordCount(fullText, "the");
        serialDuration = System.currentTimeMillis() - serialDuration;
        System.out.println("=== SERIAL COUNT ===");
        System.out.printf("%s has %d occurences of \"the\". (took %,d ms)\n", file, serialCount, serialDuration);
    }
}
