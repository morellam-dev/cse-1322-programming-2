package module_7.lab_7b;

import java.io.*;
import java.util.Arrays;
import java.util.regex.*;

/**
 * WordCount
 */
public class WordCounter {
    /**
     * Using a regular expression, count every occurence of a word. For example,
     * {@code "the."} is be counted, but {@code "then"} or {@code "at he"} is not
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

    private static String[] splitStringIntoChunks(String text, int count) {
        String[] lines = text.split("\n");
        int sliceLength = (int)Math.ceil(lines.length / count);

        String[] chunks = new String[count];
        for (int i = 0; i < count; i++) {
            int from = i * sliceLength;
            int to = Math.min((i + 1) * sliceLength, lines.length);
            String[] sub = Arrays.copyOfRange(lines, from, to);
            chunks[i] = String.join("\n", sub);
        }
        return chunks;
    }

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
            for (Thread t : threads) {
                t.join();
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

    public static void main(String[] args) {
        String file = "alice.txt";
        String fullText = readStringFromFile(file);
        // System.out.println(alice);

        long serialDuration = System.currentTimeMillis();
        int serialCount = wordCount(fullText, "the");
        serialDuration = System.currentTimeMillis() - serialDuration;
        System.out.println("=== SERIAL COUNT ===");
        System.out.printf("%s has %d occurences of \"the\". (took %,d ms)\n", file, serialCount, serialDuration);

        long parallelDuration = System.currentTimeMillis();
        int parallelCount = wordCount(fullText, "the");
        parallelDuration = System.currentTimeMillis() - parallelDuration;
        System.out.printf("=== PARALLEL COUNT (%d THREADS) ===\n", Runtime.getRuntime().availableProcessors());
        System.out.printf("%s has %d occurences of \"the\". (took %,d ms)\n", file, parallelCount, parallelDuration);
    }
}