package subway.views;

public interface OutputView {
    String INFO_PREFIX = "[INFO] ";
    String LINE_WRAP = "\n";
    String SELECT_FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";

    static void printFeatureSelectMessage() {
        System.out.println(SELECT_FEATURE_MESSAGE);
    }
}
