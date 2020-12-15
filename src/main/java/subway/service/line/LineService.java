package subway.service.line;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.Stations;
import subway.repository.LineRepository;
import subway.service.util.StateService;
import subway.service.subway.SubwayService;
import subway.service.util.FeatureInterface;
import subway.service.line.addition.LineAdditionService;
import subway.service.line.addition.LineAdditionValidation;
import subway.service.line.deletion.LineDeletionService;
import subway.service.line.deletion.LineDeletionValidation;
import subway.service.line.show.LineShowService;
import subway.type.InputType;
import subway.view.input.line.LineScanView;
import subway.view.output.util.ScreenView;
import subway.view.output.util.StateView;
import subway.view.output.line.LineTextView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LineService extends SubwayService implements FeatureInterface {
    @Override
    public void manage(Scanner scanner){
        StateService stateService = new StateService();
        LineService lineService = new LineService();

        System.out.println();
        while (true) {
            ScreenView.printLineManagementScreen();
            String lineInput = scanner.nextLine();

            if ((stateService.check(lineInput))
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
            return StateView.printNewLine();
        }
        return false;
    }

    @Override
    public boolean add(Scanner scanner) {
        LineAdditionValidation lineAdditionValidation = new LineAdditionValidation();

        String lineName = LineScanView.scanLineName(scanner);
        String upStationName = LineScanView.scanUpStationName(scanner);
        String downStationName = LineScanView.scanDownStationName(scanner);

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

        LineTextView.printLineDeletionText();
        String lineName = scanner.nextLine();

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
