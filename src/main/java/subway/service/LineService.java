package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.service.abstraction.feature.FeatureChoiceInterface;
import subway.service.abstraction.feature.FeatureInterface;
import subway.type.InputType;
import subway.type.LineType;
import subway.view.output.ExceptionView;
import subway.view.output.ScreenView;

import java.util.Scanner;

public class LineService implements FeatureChoiceInterface, FeatureInterface {
    public static void initializeLines() {
        LineRepository.addLine(new Line(LineType.TWO.getLine()));
        LineRepository.addLine(new Line(LineType.THREE.getLine()));
        LineRepository.addLine(new Line(LineType.SHINBUNDANG.getLine()));
    }

    public static void manageLine(Scanner scanner){
        InputService inputService = new InputService();
        LineService lineService = new LineService();

        System.out.println();
        while (true) {
            ScreenView.printLineManagementScreen();
            String lineInput = scanner.nextLine();
            if (inputService.isInput(lineInput)) {
                lineService.chooseFeature(lineInput, scanner);
                break;
            }
            ExceptionView.printInvalidFeatureChoiceException();
        }
    }

    @Override
    public boolean chooseFeature(String input, Scanner scanner) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            // TODO: 노선 등록 기능 구현
            return false;
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
        return false;
    }

    @Override
    public void delete(Scanner scanner) {

    }
}
