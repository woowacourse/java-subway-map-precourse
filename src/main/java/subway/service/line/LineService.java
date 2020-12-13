package subway.service.line;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.service.InputService;
import subway.service.abstraction.feature.FeatureChoiceInterface;
import subway.service.abstraction.feature.FeatureInterface;
import subway.type.InputType;
import subway.view.output.ScreenView;
import subway.view.output.line.LineInformationView;
import subway.view.output.line.LineTextView;

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
            // TODO: 노선 삭제 기능 구현
            return false;
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            // TODO: 노선 조회 기능 구현
            return false;
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Scanner scanner) {
        LineNameAddingValidation lineNameAddingValidation = new LineNameAddingValidation();

        String lineName = scanLineName(scanner);
        String upStationName = scanUpStationName(scanner);
        String downStationName = scanDownStationName(scanner);

        if ((lineNameAddingValidation.checkAddingValidation(lineName))
                && (lineNameAddingValidation.checkStationNamesAddingValidation(upStationName, downStationName))) {
            LineRepository.addLine(new Line(lineName));
            LineInformationView.printLineAddingInformation();
            System.out.println();
            return true;
        }
        return false;
    }

    public static String scanLineName(Scanner scanner) {
        LineTextView.printLineAddingText();
        return scanner.nextLine();
    }

    public static String scanUpStationName(Scanner scanner) {
        LineTextView.printLineUpStationNameText();
        return scanner.nextLine();
    }

    public static String scanDownStationName(Scanner scanner) {
        LineTextView.printLineDownStationNameText();
        return scanner.nextLine();
    }

    @Override
    public boolean delete(Scanner scanner) {
        return false;
    }

    @Override
    public boolean show() {
        return false;
    }
}
