package subway.view;

import subway.domain.station.Station;
import subway.domain.station.Stations;
import subway.exception.ErrorCode;
import subway.exception.StationException;
import subway.service.output.OutputService;

import java.util.List;

public class StationView extends Screen{

    private static final String PRINT_STATION = "역 목록";
    private static final String PRINT_ADD = "지하철 역이 등록되었습니다.";
    private static final String PRINT_DELETE = "지하철 역이 삭제되었습니다.";

    public StationView(OutputService outputService) {
        super(outputService);
    }

    public void printAllStations(Stations stations) {
        validateStations(stations);
        outputService.printSharp(PRINT_STATION);
        List<Station> stationList = stations.getStations();
        for (Station station : stationList) {
            outputService.printInfos(station.getName());
        }
    }

    public void printAdd() {
        outputService.printInfo(PRINT_ADD);
    }

    public void printDelete(boolean isDelete) {
        if (isDelete) {
            outputService.printInfo(PRINT_DELETE);
            return;
        }
        throw new StationException(ErrorCode.STATION_NOT_FOUND);
    }


    private void validateStations(Stations stations) {
        if (stations.size() == 0) {
            throw new StationException(ErrorCode.STATION_NOT_EXIST);
        }
    }
}
