package subway.service.line;

import subway.service.station.StationNameService;
import subway.type.InformationType;
import subway.type.TextType;

import java.util.List;

public class LineNameService extends StationNameService {
    @Override
    public void readNames(StringBuilder stringBuilder, List<String> lineNames) {
        appendNameText(stringBuilder);
        appendNames(stringBuilder, lineNames);
    }

    @Override
    public void appendNameText(StringBuilder stringBuilder) {
        stringBuilder.append(TextType.NEW_LINE.getText())
                .append(TextType.LINE_NAME_TEXT.getText())
                .append(TextType.NEW_LINE.getText());
    }

    @Override
    public void appendNames(StringBuilder stringBuilder, List<String> lineNames) {
        for (String lineName : lineNames) {
            stringBuilder.append(InformationType.INFORMATION.getInformation())
                    .append(lineName)
                    .append(TextType.NEW_LINE.getText());
        }
    }
}
