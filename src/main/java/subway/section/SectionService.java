package subway.section;

import subway.line.Line;
import subway.line.LineService;
import subway.line.validation.CheckAlreadyRegisteredStation;
import subway.line.validation.CheckNotExistStation;
import subway.line.validation.CheckRightSectionNumber;
import subway.station.Station;
import subway.station.StationService;
import subway.view.InputView;
import subway.view.section.SectionManagementView;

public class SectionService {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_EXIST = ERROR_PREFIX + "등록되지 않은 노선입니다.";
    private static final String STATION_NUMBER_LACK = ERROR_PREFIX + "등록된 역이 2개 이하이므로 삭제할 수 없습니다.";

    public static boolean addSection(String lineName, InputView inputView) {
        boolean isAdd = false;
        try {
            Line line = LineService.findLine(lineName);
            Station station = getSectionStation(line, inputView);
            int sectionNumber = getSectionPosition(line, inputView);
            line.addSection(station, sectionNumber);
            isAdd = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isAdd;
    }

    private static Station getSectionStation(Line line, InputView inputView) {
        SectionManagementView.askAddStationName();
        String stationName = inputView.stationName();
        CheckAlreadyRegisteredStation.validation(line, stationName);
        return StationService.findStation(stationName);
    }

    private static int getSectionPosition(Line line, InputView inputView) {
        SectionManagementView.askStationOrder();
        String number = inputView.sectionNumber();
        CheckRightSectionNumber.validation(line, number);
        return Integer.parseInt(number);
    }

    public static boolean deleteSection(String lineName, InputView inputView) {
        boolean isDelete = false;
        try {
            Line line = LineService.findLine(lineName);
            Station station = getDeleteSectionStation(line, inputView);
            isDelete = line.deleteSection(station);
            if (!isDelete) {
                throw new IllegalArgumentException(STATION_NUMBER_LACK);
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isDelete;
    }

    private static Station getDeleteSectionStation(Line line, InputView inputView) {
        SectionManagementView.askDeleteSectionStation();
        String stationName = inputView.stationName();
        CheckNotExistStation.validation(line, stationName);
        return StationService.findStation(stationName);
    }
}
