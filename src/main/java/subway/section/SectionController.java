package subway.section;

import subway.view.InputView;
import subway.view.OutputView;

import static subway.view.resource.Strings.*;

public class SectionController {
    private SectionController() {
    }

    public static void execute() {
        OutputView.printGuide(SELECT_SECTION_FUNCTION);
        String command = InputView.getFunction();
        Runnable function = SectionFunctionMapper.matchFunction(command);
        function.run();
    }

    public static void register() {
        String lineName = InputView.getLineName();
        String stationName = InputView.getStationName();
        int order = InputView.getOrder();
        SectionService.register(lineName, stationName, order);
        OutputView.printlnResult(COMPLETE_SECTION_REGISTRATION);
    }

    public static void remove() {
        String lineName = InputView.getLineNameForRemoval();
        String stationName = InputView.getStationNameForRemoval();
        SectionService.remove(lineName, stationName);
        OutputView.printlnResult(COMPLETE_SECTION_REMOVAL);
    }
}
