package subway.view;

import subway.domain.station.Station;
import subway.domain.station.Stations;
import subway.domain.station.dto.StationFindResDto;
import subway.exception.ErrorCode;
import subway.exception.StationException;
import subway.service.output.OutputService;

import java.util.List;

public class StationView extends Screen {
    private static final String PRINT_STATION = "역 목록";
    public static final String PRINT_ADD = "등록할 역 이름을 입력하세요";
    public static final String PRINT_DELETE = "삭제할 역 이름을 입력하세요";
    private static final String PRINT_AFTER_ADD = "지하철 역이 등록되었습니다.";
    private static final String PRINT_AFTER_DELETE = "지하철 역이 삭제되었습니다.";
    private static final int ZERO = 0;

    public StationView(OutputService outputService) {
        super(outputService);
    }

    public void printAllStations(Stations stations) {
        validateStations(stations);
        outputService.printSharp(PRINT_STATION);
        List<Station> stationList = stations.getStations();
        for (Station station : stationList) {
            StationFindResDto stationFindResDto = new StationFindResDto(station.getName());
            outputService.printInfos(stationFindResDto.getName());
        }
    }

    @Override
    public String getAdd() {
        return PREFIX_INFO + PRINT_ADD;
    }

    @Override
    public String getDelete() {
        return PREFIX_INFO + PRINT_DELETE;
    }

    @Override
    public String getAfterAdd() {
        return PREFIX_INFO + PRINT_AFTER_ADD;
    }

    @Override
    public String getAfterDelete() {
        return PREFIX_INFO + PRINT_AFTER_DELETE;
    }

    private void validateStations(Stations stations) {
        if (stations.size() == ZERO) {
            throw new StationException(ErrorCode.STATION_NOT_EXIST);
        }
    }
}
