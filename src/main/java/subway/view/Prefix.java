package subway.view;

public enum Prefix {
    ERROR("[ERROR] "),
    INFO("[INFO] "),
    SHARP("## "),
    ONE("1. "),
    TWO("2. "),
    THREE("3. "),
    FOUR("4. "),
    QUIT("Q. "),
    BACK("B. "),
    ENTER ("\n"),
    CONTOUR("---"),
    CHOOSE_FUNCTION(SHARP.getPrefix() + "원하는 기능을 선택하세요.");


    private String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
