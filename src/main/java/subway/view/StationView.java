package subway.view;

import subway.domain.station.Station;
import subway.domain.station.Stations;
import subway.domain.station.dto.StationFindResDto;
import subway.exception.ErrorCode;
import subway.exception.StationException;
import subway.service.output.OutputService;

import java.util.List;

public class StationView extends Screen {
    private static final String STATION_MAIN = Prefix.SHARP.getPrefix() + "역 관리 화면";
    private static final String STATION_ONE = Prefix.ONE.getPrefix() + "역 등록";
    private static final String STATION_TWO = Prefix.TWO.getPrefix() + "역 삭제";
    private static final String STATION_THREE = Prefix.THREE.getPrefix() + "역 조회";
    private static final String STATION_BACK = Prefix.BACK.getPrefix() + "돌아가기";
    private static final String PRINT_STATION = "역 목록";
    private static final String PRINT_ADD = "등록할 역 이름을 입력하세요";
    private static final String PRINT_DELETE = "삭제할 역 이름을 입력하세요";
    private static final String PRINT_AFTER_ADD = "지하철 역이 등록되었습니다.";
    private static final String PRINT_AFTER_DELETE = "지하철 역이 삭제되었습니다.";
    private static final int ZERO = 0;

    public StationView(OutputService outputService) {
        super(outputService);
    }

    @Override
    public void showOptions() {
        outputService.printOptions(new String[]{STATION_MAIN, STATION_ONE, STATION_TWO, STATION_THREE, STATION_BACK});
    }

    @Override
    public void showAdd() {
        outputService.printSharp(PRINT_ADD);
    }

    @Override
    public void showDelete() {
        outputService.printSharp(PRINT_DELETE);
    }

    @Override
    public void showAfterAdd() {
        outputService.printInfo(PRINT_AFTER_ADD);
    }

    @Override
    public void showAfterDelete() {
        outputService.printInfo(PRINT_AFTER_DELETE);
    }

    public void printAllStations(Stations stations) {
        validateLength(stations);
        outputService.printSharp(PRINT_STATION);
        List<Station> stationList = stations.getStations();
        for (Station station : stationList) {
            StationFindResDto stationFindResDto = new StationFindResDto(station.getName());
            outputService.printInfos(stationFindResDto.getName());
        }
    }

    private void validateLength(Stations stations) {
        if (stations.size() == ZERO) {
            throw new StationException(ErrorCode.STATION_NOT_EXIST);
        }
    }
}
