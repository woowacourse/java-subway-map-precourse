package subway.service.line.show;

import subway.service.station.show.StationShowService;
import subway.type.InformationType;
import subway.type.TextType;

import java.util.List;

public class LineShowService extends StationShowService {
    @Override
    public void readNames(StringBuilder stringBuilder, List<String> lineNames) {
        appendListText(stringBuilder);
        appendNames(stringBuilder, lineNames);
    }

    @Override
    public void appendListText(StringBuilder stringBuilder) {
        stringBuilder.append(TextType.NEW_LINE.getText())
                .append(TextType.LINE_LIST_TEXT.getText())
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
