package subway.common;

public class GuideMessage {
    public static final String GUIDE_PREFIX = "\n## ";

    private GuideMessage() {
    }

    public static void print(String message) {
        System.out.println(GUIDE_PREFIX + message);
    }

}
