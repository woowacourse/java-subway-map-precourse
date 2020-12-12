package output.screen;

public interface Screen {
    public final static String HEAD = "## ";
    public final static String SPACE = " ";
    public final static String POINT = ".";
    public final static String ENTER = "\n";
    public final static String MANAGEMENT = "관리";

    void visualize();
    void logic();
}
