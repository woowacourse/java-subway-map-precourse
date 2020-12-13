package subway.common.domain;

public class Status {
    private enum Condition {
        CONTINUE, TERMINATE;
    }

    private static Condition condition = Condition.CONTINUE;

    public static void terminate() {
        condition = Condition.TERMINATE;
    }

    public static boolean isContinue() {
        return condition == Condition.CONTINUE;
    }
}
