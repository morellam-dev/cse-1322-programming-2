package module_7.lab_7b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * WordCounter
 */
public class WordCounter extends Thread {
    private final String word;
    private final String[] strings;
    private final int startIndex;
    private final int endIndex;

    private int count;

    public WordCounter(String[] strings, String word, int startIndex, int endIndex) {
        this.word = word;
        this.strings = strings;
        this.startIndex = startIndex;
        this.endIndex = Math.min(endIndex, strings.length);
    }


    // Thread Activity

    @Override
    public void run() {
        count = 0;
        for (int i = startIndex; i < endIndex ; i++) {
            count += count(strings[i], word);
        }
    }

    private static int count(String str, String word) {
        int count = 0;
        int searchIndex = str.toLowerCase().indexOf(word.toLowerCase());
        while (searchIndex > -1) {
            count++;
            str = str.substring(searchIndex + 1);
            searchIndex = str.toLowerCase().indexOf(word.toLowerCase());
        }
        return count;
    }

    public int getCount() {
        return count;
    }



    public static int wordCount(String fullText, String word) {
        String[] strings = fullText.split("\n");
        return wordCount(strings, word);
    }

    public static int wordCount(String[] strings, String word) {
        final int THREAD_COUNT = 4;

        WordCounter[] threads = new WordCounter[THREAD_COUNT];
        int sliceLength = (int)Math.ceil(strings.length / THREAD_COUNT);
        for (int i = 0; i < 4; i++) {
            WordCounter t = new WordCounter(strings, word, i * sliceLength, (i + 1) * sliceLength);
            threads[i] = t;
            t.start();
        }
        int count = 0;
        for (WordCounter t : threads) {
            try {
                t.join();
                count += t.getCount();
            } catch (InterruptedException e) {}
        }
        return count;
    }
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("./alice.txt"))) {
            String fullText = "";
            while (reader.ready()) {
                fullText += reader.readLine() + "\n";
            }
            int wordCount = WordCounter.wordCount(fullText, "the");
            System.out.println(wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}