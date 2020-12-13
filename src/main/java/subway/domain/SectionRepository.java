package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final Map<String, List<String>> sections = new LinkedHashMap<>();

    public static Map<String, List<String>> sections() {
        return Collections.unmodifiableMap(sections);
    }

    public static void addSection(String line, String firstStation, String lastStation) {
        sections.put(line, new ArrayList<>(Arrays.asList(firstStation, lastStation)));
    }

    public static void insertSection(String line, String station, int index) {
        sections.get(line)
                .add(index, station);
    }

    public static int getLengthByLineName(String line){
        return sections().get(line)
                .size();
    }

    public static boolean searchStationInLine(String line, String station){
        return sections().get(line).contains(station);
    }
}
