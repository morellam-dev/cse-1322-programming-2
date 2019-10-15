package module_4.assignment_4;

/**
 * StringReverser
 * @author M Morella
 */
public class StringReverser {

    public static void printString(String str) {
        if (str.length() == 0) {
            System.out.print('\n');
        } else {
            System.out.print(str.charAt(0));
            printString(str.substring(1));
        }
    }

    public static void printStringReverse(String str) {
        if (str.length() == 0) {
            System.out.print('\n');
        } else {
            char lastChar = str.charAt(str.length() - 1);
            System.out.print(lastChar);
            printStringReverse(str.substring(0, str.length() - 1));
        }
    }
    public static void main(String[] args) {
        System.out.println();
        String demo = "Hello world!";
        printString(demo);
        printStringReverse(demo);
    }
}