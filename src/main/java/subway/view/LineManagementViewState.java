package subway.view;

import subway.SubwayLineMap;
import subway.controller.LineController;
import subway.controller.StationController;
import subway.domain.Line;
import subway.domain.Station;
import subway.exceptions.DuplicatedLineNameException;
import subway.view.input.LineManagementInputView;
import subway.view.output.LineManagementOutputView;

import java.util.List;
import java.util.Optional;

public class LineManagementViewState extends ViewState {
    private static final String BTN_ADD_LINE = "1";
    private static final String BTN_DELETE_LINE = "2";
    private static final String BTN_READ_LINE = "3";
    private static final String BTN_BACK = "B";

    private static LineManagementViewState lineManagementViewState;
    private StationController stationController = StationController.getStationController();
    private LineController lineController = LineController.getLineController();

    private LineManagementViewState() {
        featureSet.add(BTN_ADD_LINE);
        featureSet.add(BTN_DELETE_LINE);
        featureSet.add(BTN_READ_LINE);
        featureSet.add(BTN_BACK);
    }

    public static synchronized LineManagementViewState getLineManagementViewState() {
        if (!Optional.ofNullable(lineManagementViewState).isPresent()) {
            lineManagementViewState = new LineManagementViewState();
        }
        return lineManagementViewState;
    }

    @Override
    protected void printMenu() {
        LineManagementOutputView.printMenuLog();
    }

    @Override
    protected void runFeatureAtApplication(String feature, SubwayLineMap application) {
        checkAndAddLine(feature, application);
        checkAndRemoveLine(feature, application);
        checkAndPrintSubwayLineMap(feature);
        checkAndSwitchViewToMain(feature, application);
    }

    private void checkAndAddLine(String feature, SubwayLineMap application) {
        if (feature.equals(BTN_ADD_LINE)) {
            String lineName = getLineName();
            Station startStation = getStartStation();
            Station endStation = getEndStation();
            lineController.addLine(lineName, startStation, endStation);
            LineManagementOutputView.printRegisterFinishLog();
            switchViewToStationManagement(application);
        }
    }

    private void checkAndRemoveLine(String feature, SubwayLineMap application) {
        if (feature.equals(BTN_DELETE_LINE)) {
            String lineName = LineManagementInputView.getLineNameInputRemove();
            lineController.removeLine(lineName);
            LineManagementOutputView.printLineRemoveFinishLog();
            switchViewToStationManagement(application);
        }
    }

    private void checkAndPrintSubwayLineMap(String feature) {
        if (feature.equals(BTN_READ_LINE)) {
            printLineList();
        }
    }

    private void checkAndSwitchViewToMain(String feature, SubwayLineMap application) {
        if (feature.equals(BTN_BACK)) {
            switchViewToStationManagement(application);
        }
    }

    public void printLineList() {
        List<Line> lineList = lineController.getLines();
        LineManagementOutputView.printLineListLog(lineList);
    }

    private String getLineName() {
        String lineName = LineManagementInputView.getLineNameInput();
        if (lineController.isExistingLineName(lineName)) {
            throw new DuplicatedLineNameException();
        }
        return lineName;
    }

    private Station getStartStation() {
        String startStationName = LineManagementInputView.getStartStationNameInput();
        return stationController.getStation(startStationName);
    }

    private Station getEndStation() {
        String endStationName = LineManagementInputView.getEndStationNameInput();
        return stationController.getStation(endStationName);
    }

    private void switchViewToStationManagement(SubwayLineMap application) {
        application.setViewState(MainViewState.getMainView());
    }
}
