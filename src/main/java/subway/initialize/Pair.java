package subway.initialize;

public class Pair {

    private String text;
    private String[] values;

    public Pair(String text, String[] values) {
        this.text = text;
        this.values = values;
    }

    public String getText() {
        return text;
    }

    public String[] getValues() {
        return values;
    }

}
