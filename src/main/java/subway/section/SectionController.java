package subway.section;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.SectionMessage;

public class SectionController {
    private SectionController() {
    }

    public static void execute() {
        OutputView.printGuideMessage(SectionMessage.SELECT_FUNCTION);
        String command = InputView.getFunction();
        Runnable function = SectionFunctionMapper.matchFunction(command);
        function.run();
    }

    public static void register() {
        String lineName = InputView.getLineName();
        String stationName = InputView.getStationName();
        int order = InputView.getOrder();
        SectionService.register(lineName, stationName, order);
    }

    public static void remove() {
        String lineName = InputView.getLineNameForRemoval();
        String stationName = InputView.getStationNameForRemoval();
        SectionService.remove(lineName, stationName);
    }
}
