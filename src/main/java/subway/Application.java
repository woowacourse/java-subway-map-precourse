package subway;

import subway.domain.line.Line;
import subway.domain.station.Station;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        System.out.println("start");
        System.out.println("startStation");
        Station startStation = Station.getStation(scanner.nextLine());
        System.out.println("endStation");
        Station endStation = Station.getStation(scanner.nextLine());
        System.out.println(Line.getLine("2호", startStation, endStation));
//        System.out.println(MainMenuInputView.getMainMenuCommand(scanner));
//        List<Station> stationList = StationRepository.save(Station.getStation(scanner.nextLine()));
//        System.out.println(StationResponseDto.StationEntityToList(stationList));
//        System.out.println(StationService.save(new StationRequestDto(scanner.nextLine())));
    }
}
