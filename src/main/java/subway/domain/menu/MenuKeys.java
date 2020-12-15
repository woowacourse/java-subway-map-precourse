package subway.domain.menu;

public enum MenuKeys {
    ONE("1"), TWO("2"), THREE("3"), FOUR("4"), EXIT("Q"), BACK("B");

    private String key;

    MenuKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
