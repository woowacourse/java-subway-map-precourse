package subway.util;

import java.util.Scanner;

public class DialogUtils {

    public static String ask(Scanner scanner, String constantName) {
        MessageUtils.printAnnouncement(constantName);
        String response = scanner.next();
        MessageUtils.printBlankLine();
        return response;

    }
}
