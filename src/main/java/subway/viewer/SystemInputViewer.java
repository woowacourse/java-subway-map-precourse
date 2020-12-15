package subway.viewer;

import subway.viewer.constants.SystemInputInitiator;

public class SystemInputViewer {
    public static void askMainScreen() {
        for (SystemInputInitiator oneMessage : SystemInputInitiator.values()) {
            System.out.println(oneMessage.getMessage());
        }
    }
}
