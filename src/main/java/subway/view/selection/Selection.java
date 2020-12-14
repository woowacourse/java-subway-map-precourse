package subway.view.selection;

/**
 * 메뉴의 선택지를 뜻합니다. 각 선택지는 선택할 수 있는 key와 설명으로 이루어져있습니다.
 */
public class Selection {
    private static final String SELECTION_FORMAT = "%s. %s";

    private String key;
    private String description;

    public Selection(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return String.format(SELECTION_FORMAT, this.key, this.description);
    }
}
