package subway.service.line;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.Stations;
import subway.repository.LineRepository;
import subway.service.subway.SubwayService;
import subway.service.util.FeatureInterface;
import subway.service.line.addition.LineAdditionService;
import subway.service.line.addition.LineAdditionValidation;
import subway.service.line.deletion.LineDeletionService;
import subway.service.line.deletion.LineDeletionValidation;
import subway.service.line.show.LineShowService;
import subway.type.InputType;
import subway.view.input.line.LineScanView;
import subway.view.output.util.FeatureChoiceExceptionView;
import subway.view.output.util.ScreenView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * LineService.java : 지하철 노선 비즈니스 로직에 대한 서비스 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class LineService extends SubwayService implements FeatureInterface {
    @Override
    public void manage(Scanner scanner){
        LineService lineService = new LineService();

        System.out.println();
        while (true) {
            String lineInput = LineScanView.scanLineInputForManagement(scanner);

            if (lineService.choose(lineInput, scanner)) {
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
            return ScreenView.printNewLine();
        }
        return FeatureChoiceExceptionView.printInvalidChoiceException();
    }

    @Override
    public boolean add(Scanner scanner) {
        LineAdditionValidation lineAdditionValidation = new LineAdditionValidation();

        String lineName = LineScanView.scanLineNameForAddition(scanner);
        String upStationName = LineScanView.scanUpStationNameForAddition(scanner);
        String downStationName = LineScanView.scanDownStationNameForAddition(scanner);

        if (lineAdditionValidation.checkNameAdditionValidation(
                lineName, new Stations(upStationName, downStationName))) {
            LinkedList<Station> stationNames =
                    LineAdditionService.addStationNames(upStationName, downStationName);
            LineAdditionService.addLineByStationNames(lineName, stationNames);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Scanner scanner) {
        LineDeletionValidation lineNameDeletionValidation = new LineDeletionValidation();

        String lineName = LineScanView.scanLineNameForDeletion(scanner);

        Line lineForDeletion = LineDeletionService.getLineForDeletion(lineName);

        if (lineNameDeletionValidation.checkNameDeletionValidation(lineName)) {
            LineDeletionService.deleteLineInTransitMap(lineForDeletion);
            return true;
        }
        return false;
    }

    @Override
    public boolean show() {
        LineShowService lineShowService = new LineShowService();

        StringBuilder stringBuilder = new StringBuilder();
        List<String> lineNames = LineRepository.lineNames();

        lineShowService.readNames(stringBuilder, lineNames);
        System.out.println(stringBuilder);
        return true;
    }
}
