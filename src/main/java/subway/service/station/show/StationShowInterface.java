package subway.service.station.show;

import java.util.List;

/**
 * StationShowInterface.java : 지하철 역 조회 로직에 대한 인터페이스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public interface StationShowInterface {
    void readNames(StringBuilder stringBuilder, List<String> stationNames);
    void appendListText(StringBuilder stringBuilder);
    void appendNames(StringBuilder stringBuilder, List<String> stationNames);
}
