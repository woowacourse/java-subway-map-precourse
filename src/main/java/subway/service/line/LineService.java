package subway.service.line;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.service.SubwayService;
import subway.service.abstraction.FeatureInterface;
import subway.service.station.StationService;
import subway.type.InputType;
import subway.view.input.line.LineInputView;
import subway.view.output.ScreenView;
import subway.view.output.line.LineTextView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LineService extends SubwayService implements FeatureInterface {
    @Override
    public void manage(Scanner scanner){
        StationService stationService = new StationService();
        LineService lineService = new LineService();

        System.out.println();
        while (true) {
            ScreenView.printLineManagementScreen();
            String lineInput = scanner.nextLine();

            if ((stationService.check(lineInput))
                    && (lineService.choose(lineInput, scanner))) {
                break;
            }
        }
    }

    @Override
    public boolean choose(String input, Scanner scanner) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return add(scanner);
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return delete(scanner);
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            return show();
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            System.out.println();
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Scanner scanner) {
        LineAddingValidation lineNameAddingValidation = new LineAddingValidation();

        String lineName = LineInputView.scanLineName(scanner);
        if (!lineNameAddingValidation.checkAddingValidation(lineName)) {
            return false;
        }
        String upStationName = LineInputView.scanUpStationName(scanner);
        String downStationName = LineInputView.scanDownStationName(scanner);
        if (!lineNameAddingValidation.checkStationNamesAddingValidation(upStationName, downStationName)) {
            return false;
        }

        LinkedList<Station> stationNames = LineAddingService.addStationNames(upStationName, downStationName);
        LineAddingService.addNames(lineName, stationNames);
        return true;
    }

    @Override
    public boolean delete(Scanner scanner) {
        LineDeletionValidation lineNameDeletionValidation = new LineDeletionValidation();

        LineTextView.printLineDeletionText();
        String lineName = scanner.nextLine();

        Line lineForDeletion = LineDeletionService.getLineForDeletion(lineName);

        if (lineNameDeletionValidation.checkDeletionValidation(lineName)) {
            LineDeletionService.deleteName(lineForDeletion);
            return true;
        }
        return false;
    }

    @Override
    public boolean show() {
        LineNameService lineNameService = new LineNameService();

        StringBuilder stringBuilder = new StringBuilder();
        List<String> lineNames = LineRepository.lineNames();

        lineNameService.readNames(stringBuilder, lineNames);
        System.out.println(stringBuilder);
        return true;
    }
}
