package subway.common;

public enum Prefix {
    ERROR("[ERROR] "),
    INFO("[INFO] "),
    START("## ");

    private String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
