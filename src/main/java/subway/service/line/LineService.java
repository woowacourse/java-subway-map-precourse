package subway.service.line;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.service.InputService;
import subway.service.abstraction.feature.FeatureInterface;
import subway.type.InputType;
import subway.view.output.ScreenView;
import subway.view.output.line.LineTextView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LineService implements FeatureInterface {
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
        LineAddingValidation lineNameAddingValidation = new LineAddingValidation();

        String lineName = LineAddingService.scanLineName(scanner);
        if (!lineNameAddingValidation.checkAddingValidation(lineName)) {
            return false;
        }
        String upStationName = LineAddingService.scanUpStationName(scanner);
        String downStationName = LineAddingService.scanDownStationName(scanner);
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
        List<Line> lines = LineRepository.lines();

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
