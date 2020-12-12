package subway.message;

import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/13
 */
public class Output {

    private Output() {
    }

    public static void printPage(final List<String> page) {
        page.forEach(System.out::println);
    }

    public static void printLine(String output) {
        System.out.println(output);
    }
}
