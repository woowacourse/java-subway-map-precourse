package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.TransitMapRepository;
import subway.type.InformationType;
import subway.type.TextType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TransitMapService {
    public static void showTransitMap() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Line, LinkedList<Station>> transitMaps = TransitMapRepository.transitMaps();

        TransitMapService.readTransitMap(stringBuilder, transitMaps);
        System.out.println(stringBuilder);
    }

    public static void readTransitMap(StringBuilder stringBuilder, Map<Line, LinkedList<Station>> transitMaps) {
        appendTransitMapText(stringBuilder);

        for (Map.Entry<Line, LinkedList<Station>> entry : transitMaps.entrySet()) {
            Line key = entry.getKey();
            LinkedList<Station> values = entry.getValue();

            appendKey(stringBuilder, key);
            appendHorizontalLines(stringBuilder);
            appendValues(stringBuilder, values);

            if (!checkLastKey(key)) {
                stringBuilder.append(TextType.NEW_LINE.getText());
            }
        }
    }

    public static void appendTransitMapText(StringBuilder stringBuilder) {
        stringBuilder.append(TextType.NEW_LINE.getText())
                .append(TextType.TRANSIT_MAP_TEXT.getText())
                .append(TextType.NEW_LINE.getText());
    }

    public static void appendKey(StringBuilder stringBuilder, Line key) {
        stringBuilder.append(InformationType.INFORMATION.getInformation())
                .append(key.getName())
                .append(TextType.NEW_LINE.getText());
    }

    public static void appendHorizontalLines(StringBuilder stringBuilder) {
        stringBuilder.append(InformationType.INFORMATION.getInformation())
                .append(TextType.HORIZONTAL_LINES.getText())
                .append(TextType.NEW_LINE.getText());
    }

    public static void appendValues(StringBuilder stringBuilder, LinkedList<Station> values) {
        for (Station value : values) {
            stringBuilder.append(InformationType.INFORMATION.getInformation())
                    .append(value.getName())
                    .append(TextType.NEW_LINE.getText());
        }
    }

    public static boolean checkLastKey(Line key) {
        Map<Line, LinkedList<Station>> transitMaps = TransitMapRepository.transitMaps();
        Line lastKey = getLastKey(transitMaps);
        return lastKey.equals(key);
    }

    public static Line getLastKey(Map<Line, LinkedList<Station>> transitMaps) {
        List<Line> lineKeySet = new ArrayList<>(transitMaps.keySet());
        return lineKeySet.get(lineKeySet.size() - 1);
    }
}
