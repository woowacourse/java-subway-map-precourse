package subway.service.line;

import subway.type.InformationType;
import subway.type.TextType;

import java.util.List;

public class LineNameService {
    public static void readLineNames(StringBuilder stringBuilder, List<String> lineNames) {
        appendLineNameText(stringBuilder);
        appendLineNames(stringBuilder, lineNames);
    }

    public static void appendLineNameText(StringBuilder stringBuilder) {
        stringBuilder.append(TextType.NEW_LINE.getText())
                .append(TextType.LINE_NAME_TEXT.getText())
                .append(TextType.NEW_LINE.getText());
    }

    public static void appendLineNames(StringBuilder stringBuilder, List<String> lineNames) {
        for (String lineName : lineNames) {
            stringBuilder.append(InformationType.INFORMATION.getInformation())
                    .append(lineName)
                    .append(TextType.NEW_LINE.getText());
        }
    }
}
