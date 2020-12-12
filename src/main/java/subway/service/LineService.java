package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.type.LineType;
import subway.view.OutputView;

import java.util.Scanner;

public class LineService {
    public static void initializeLines() {
        LineRepository.addLine(new Line(LineType.TWO.getLine()));
        LineRepository.addLine(new Line(LineType.THREE.getLine()));
        LineRepository.addLine(new Line(LineType.SHINBUNDANG.getLine()));
    }

    public static void manageLine(Scanner scanner){
        FeatureService featureService = new FeatureService();

        System.out.println();
        while (true) {
            OutputView.printLineManagementScreen();
            String lineInput = scanner.next();
            if (featureService.isInput(lineInput)) {
                featureService.chooseFeature(lineInput);
                break;
            }
            OutputView.printInvalidFeatureChoiceException();
        }
    }
}
