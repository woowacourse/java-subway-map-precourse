package subway.service.line;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.service.InputService;
import subway.service.abstraction.feature.FeatureChoiceInterface;
import subway.service.abstraction.feature.FeatureInterface;
import subway.type.InputType;
import subway.view.output.ScreenView;
import subway.view.output.line.LineInformationView;
import subway.view.output.line.LineTextView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LineService implements FeatureChoiceInterface, FeatureInterface {
    public static void manageLine(Scanner scanner){
        InputService inputService = new InputService();
        LineService lineService = new LineService();

        System.out.println();
        while (true) {
            ScreenView.printLineManagementScreen();
            String lineInput = scanner.nextLine();
            if (inputService.isInput(lineInput)
                    && lineService.chooseFeature(lineInput, scanner)) {
                break;
            }
        }
    }

    @Override
    public boolean chooseFeature(String input, Scanner scanner) {
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
        LineNameAddingValidation lineNameAddingValidation = new LineNameAddingValidation();

        String lineName = LineNameAddingService.scanLineName(scanner);
        if (!lineNameAddingValidation.checkAddingValidation(lineName)) {
            return false;
        }
        String upStationName = LineNameAddingService.scanUpStationName(scanner);
        String downStationName = LineNameAddingService.scanDownStationName(scanner);
        if (!lineNameAddingValidation.checkStationNamesAddingValidation(upStationName, downStationName)) {
            return false;
        }

        LinkedList<Station> stationNames = LineNameAddingService.addStationNames(upStationName, downStationName);
        LineNameAddingService.addNames(lineName, stationNames);
        return true;
    }

    @Override
    public boolean delete(Scanner scanner) {
        LineNameDeletionValidation lineNameDeletionValidation = new LineNameDeletionValidation();

        LineTextView.printLineDeletionText();
        String lineName = scanner.nextLine();

        if (lineNameDeletionValidation.checkDeletionValidation(lineName)) {
            LineNameDeletionService.deleteLineName(lineName);
            LineInformationView.printLineDeletionInformation();
            System.out.println();
            return true;
        }
        return false;
    }

    @Override
    public boolean show() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> lineNames = LineRepository.lineNames();

        LineNameService.readLineNames(stringBuilder, lineNames);
        System.out.println(stringBuilder);
        return true;
    }
}
