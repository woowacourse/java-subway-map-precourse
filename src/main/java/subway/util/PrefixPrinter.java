package subway.util;

public class PrefixPrinter {
    private static final String HEADING = "## ";
    public static final String INFO = "[INFO] ";
    public static final String ERROR = "[ERROR] ";

    public static void printHeading(String heading) {
        System.out.println(PrefixPrinter.HEADING + heading);
    }

    public static void printInfo(String info) {
        System.out.println(PrefixPrinter.INFO + info + "\n");
    }

    public static void printSubway(String subway) {
        System.out.println(PrefixPrinter.INFO + subway);
    }

    public static void printError(String error) {
        System.out.println(PrefixPrinter.ERROR + error + "\n");
    }
}
