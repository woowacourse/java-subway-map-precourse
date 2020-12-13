package subway.view.selection;

public class Selection {
    private static final String SELECTION_FORMAT = "%s. %s";

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

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return String.format(SELECTION_FORMAT, this.value, this.description);
    }
}
