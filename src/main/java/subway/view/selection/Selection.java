package subway.view.selection;

public class Selection {
    private String value;
    private String description;

    public Selection(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
