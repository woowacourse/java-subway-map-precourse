package subway.viewer;

public class SystemInputViewer {
    /* 초기에 가능한 구현 묶음 리스트를 보여주는 메소드 */
    public static void askMainScreen() {
        for (SystemInputInitiator oneMessage : SystemInputInitiator.values()) {
            System.out.println(oneMessage.getMessage());
        }
    }
}
