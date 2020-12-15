package subway.controller;

import static subway.views.StationControlView.showStationAddView;
import static subway.views.StationControlView.showStationDeleteView;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.views.ErrorMessage;
import subway.views.StationControlView;

public class StationController {

    public static void manageStation(Scanner scanner) {
        StationControlView.showStationControlView(scanner);
    }

    public static void addStation(String userInput, Scanner scanner) {
        if (ErrorValidator.checkSameStationName(userInput)) {
            ErrorMessage.showStationSameNameError();
            showStationAddView(scanner);
        }
        if (ErrorValidator.checkNameLength(userInput)) {
            ErrorMessage.showStationNameLengthError();
            showStationAddView(scanner);
        }
        StationRepository.addStation(new Station(userInput));
    }

    public static void deleteStation(String userInput, Scanner scanner) {
        if (!ErrorValidator.checkSameStationName(userInput)) {
            ErrorMessage.showStationDeleteError();
            showStationDeleteView(scanner);
        }
        for (int i = 0; i < StationRepository.stations().size(); i++) {
            if (StationRepository.stations().get(i).getName().equals(userInput) && StationRepository
                .stations().get(i).checkInLine()) {
                ErrorMessage.showStationInLineError();
                StationControlView.showStationControlView(scanner);
            }
        }
        StationRepository.deleteStation(userInput);
    }
}
