package subway;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.dto.station.StationRequestDto;
import subway.dto.station.StationResponseDto;
import subway.service.station.StationService;
import subway.view.main.MainMenuInputView;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        System.out.println("start");

        System.out.println(MainMenuInputView.getMainMenuCommand(scanner));
//        List<Station> stationList = StationRepository.save(Station.getStation(scanner.nextLine()));
//        System.out.println(StationResponseDto.StationEntityToList(stationList));
//        System.out.println(StationService.save(new StationRequestDto(scanner.nextLine())));
    }
}
