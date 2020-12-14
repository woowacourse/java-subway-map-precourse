package subway.service.station;

import subway.type.InformationType;
import subway.type.TextType;

import java.util.List;

public class StationNameService {
    public void readNames(StringBuilder stringBuilder, List<String> stationNames) {
        appendNameText(stringBuilder);
        appendNames(stringBuilder, stationNames);
    }

    public void appendNameText(StringBuilder stringBuilder) {
        stringBuilder.append(TextType.NEW_LINE.getText())
                .append(TextType.STATION_NAME_TEXT.getText())
                .append(TextType.NEW_LINE.getText());
    }

    public void appendNames(StringBuilder stringBuilder, List<String> stationNames) {
        for (String stationName : stationNames) {
            stringBuilder.append(InformationType.INFORMATION.getInformation())
                    .append(stationName)
                    .append(TextType.NEW_LINE.getText());
        }
    }
}
