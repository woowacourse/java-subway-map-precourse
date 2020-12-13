package subway.service.station;

import subway.type.InformationType;
import subway.type.TextType;

import java.util.List;

public class StationNameService {
    public static void readStationName(StringBuilder stringBuilder, List<String> stationNames) {
        appendStationNameText(stringBuilder);
        appendStationNames(stringBuilder, stationNames);
    }

    public static void appendStationNameText(StringBuilder stringBuilder) {
        stringBuilder.append(TextType.NEW_LINE.getText())
                .append(TextType.STATION_NAME_TEXT.getText())
                .append(TextType.NEW_LINE.getText());
    }

    public static void appendStationNames(StringBuilder stringBuilder, List<String> stationNames) {
        for (String stationName : stationNames) {
            stringBuilder.append(InformationType.INFORMATION.getInformation())
                    .append(stationName)
                    .append(TextType.NEW_LINE.getText());
        }
    }
}
