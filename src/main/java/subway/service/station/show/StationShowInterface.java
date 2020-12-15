package subway.service.station.show;

import java.util.List;

public interface StationShowInterface {
    void readNames(StringBuilder stringBuilder, List<String> stationNames);
    void appendListText(StringBuilder stringBuilder);
    void appendNames(StringBuilder stringBuilder, List<String> stationNames);
}
