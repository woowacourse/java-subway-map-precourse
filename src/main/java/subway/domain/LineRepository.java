package subway.domain;

public class LineRepository {
    private static final Lines lines = new Lines();

    public static Lines lines() {
        return lines;
    }

    public static void addLine(Line line) {
        lines.addLine(line);
    }

    public static void deleteLineByName(String name) {
        lines.deleteLine(name);
    }

    public static boolean isPresentLine(String name) {
        return lines.isPresentLine(name);
    }

    public static Line findLine(String name) {
        return lines.findLine(name);
    }
}
