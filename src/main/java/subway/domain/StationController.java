package subway.domain;

import subway.Constant;

import java.util.Scanner;

public class StationController {
    Scanner scanner;
    StationRepository stationRepository = new StationRepository();

    public StationController(Scanner scanner){
        this.scanner = scanner;
    }

    void printSelection(){
        System.out.println(Constant.STATION_ANNOUNCEMENT);
        String flag = scanner.next();
        if (flag.equals(Constant.FIRST_COMMAND)) {
            addStation();
        } else if (flag.equals(Constant.SECOND_COMMAND)) {
            deleteStation();
        } else if (flag.equals(Constant.THIRD_COMMAND)) {
            readStations();
        } else if (flag.equals(Constant.BACK_COMMAND)) {

        }
    }

    void addStation(){
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        String stationName = scanner.next();
        Station station = new Station(stationName);
        stationRepository.addStation(station);
        stationRepository.printStations();
    }

    void deleteStation(){
        System.out.println("## 삭제할 역 이름을 입력하세요.\n");
        String stationName = scanner.next();
        stationRepository.deleteStation(stationName);
    }

    void readStations(){

    }
}
