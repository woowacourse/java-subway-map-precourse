package subway.service.station.show;

import subway.type.InformationType;
import subway.type.TextType;

import java.util.List;

/**
 * StationShowService.java : 지하철 역 조회 로직에 대한 서비스 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class StationShowService implements StationShowInterface {
    @Override
    public void readNames(StringBuilder stringBuilder, List<String> stationNames) {
        appendListText(stringBuilder);
        appendNames(stringBuilder, stationNames);
    }

    @Override
    public void appendListText(StringBuilder stringBuilder) {
        stringBuilder.append(TextType.NEW_LINE.getText())
                .append(TextType.STATION_LIST_TEXT.getText())
                .append(TextType.NEW_LINE.getText());
    }

    @Override
    public void appendNames(StringBuilder stringBuilder, List<String> stationNames) {
        for (String stationName : stationNames) {
            stringBuilder.append(InformationType.INFORMATION.getInformation())
                    .append(stationName)
                    .append(TextType.NEW_LINE.getText());
        }
    }
}
