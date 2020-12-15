package subway.domain;

public class ActionRepository {
    private static final String INSERT_SIGN = "1";
    private static final String DELETE_SIGN = "2";
    private static final String LIST_SIGN = "3";
    private static final String BACK_SIGN = "B";
    private static final String INSERT_ACTION = "등록";
    private static final String DELETE_ACTION = "삭제";
    private static final String LIST_ACTION = "조회";
    private static final String BACK_ACTION = "돌아가기";

    public static final Action addAction = new Action(INSERT_SIGN, INSERT_ACTION);
    public static final Action deleteAction = new Action(DELETE_SIGN, DELETE_ACTION);
    public static final Action listAction = new Action(LIST_SIGN, LIST_ACTION);
    public static final Action backAction = new Action(BACK_SIGN, BACK_ACTION);
}
