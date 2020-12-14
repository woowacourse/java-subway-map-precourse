package subway.view;

public class Output {

    private Output() {
    }

    public static void print(String message) {
        printNewLine();
        System.out.println(message);
        printNewLine();
    }

    public static void printNewLine() {
        System.out.println();
    }
}
