package subway.domain.station;

import subway.domain.section.SectionRepository;
import subway.util.PrefixPrinter;

import java.util.Optional;
import java.util.Scanner;

import static subway.util.InputManager.*;

public class StationService {
    private static final String ENTER_NEW_STATION_MSG = "등록할 역 이름을 입력하세요.";
    private static final String ENTER_DELETE_STATION_MSG = "삭제할 역 이름을 입력하세요.";

    public boolean addStation(Scanner scanner) {
        Optional<String> stationName = enterNewStationFromUser(scanner, ENTER_NEW_STATION_MSG);
        if(stationName.isEmpty()) {
            return false;
        }
        StationRepository.addStation(new Station(stationName.get()));
        PrefixPrinter.printInfo("지하철 역이 등록되었습니다.");
        return true;
    }

    public boolean deleteStation(Scanner scanner) {
        Optional<String> stationName = enterStationFromUser(scanner, ENTER_DELETE_STATION_MSG);
        if(stationName.isEmpty()) {
            return false;
        }
        if(!checkStationInLine(stationName.get())) {
            return false;
        }
        PrefixPrinter.printInfo("지하철 역이 삭제되었습니다.");
        return true;
    }

    public void getStation() {
        PrefixPrinter.printHeading("역 목록");
        StationRepository.stations().forEach(station -> PrefixPrinter.printSubway(station.getName()));
    }

    private boolean checkStationInLine(String stationName) {
        if (SectionRepository.checkStationInLine(stationName)) {
            PrefixPrinter.printError("노선에 등록된 역은 삭제할 수 없습니다.");
            return false;
        }
        return true;
    }
}
