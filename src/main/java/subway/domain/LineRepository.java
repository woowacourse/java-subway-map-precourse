package subway.domain;

public class LineRepository {
    private static final Lines lines = new Lines();

    public static Lines lines() {
        return lines;
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.deleteLine(name);
    }
}
