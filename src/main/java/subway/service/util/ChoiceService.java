package subway.service.util;

import subway.service.station.StationService;
import subway.type.InputType;
import subway.view.output.util.FeatureChoiceExceptionView;
import subway.view.output.util.ScreenView;

import java.util.Scanner;

/**
 * ChoiceService.java : 지하철 역, 지하철 노선 기능 선택에 대한 서비스 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class ChoiceService implements ChoiceInterface {
    @Override
    public boolean choose(String input, Scanner scanner) {
        StationService stationService = new StationService();

        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return stationService.add(scanner);
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return stationService.delete(scanner);
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            return stationService.show();
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return ScreenView.printNewLine();
        }
        return FeatureChoiceExceptionView.printInvalidChoiceException();
    }
}
