package subway.view;

import subway.SubwayLineMap;
import subway.controller.LineController;
import subway.controller.StationController;
import subway.domain.Line;
import subway.domain.Station;
import subway.exceptions.DuplicatedLineNameException;
import subway.view.component.CommonViewComponent;
import subway.view.component.LineManagementViewComponent;
import subway.view.component.StationManagementViewComponent;
import subway.view.logger.ViewLogger;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
    protected void printMenuWithInputRequirementMsg() {
        StringBuilder viewStringBuilder = new StringBuilder();
        viewStringBuilder.append(LineManagementViewComponent.getMenuComponent());
        viewStringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        viewStringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        viewStringBuilder.append(CommonViewComponent.getSelectFeatureViewComponent());
        System.out.println(viewStringBuilder.toString());
    }

    @Override
    protected void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner){
        checkAndAddLine(feature, application, scanner);
        checkAndRemoveLine(feature, application, scanner);
        checkAndPrintSubwayLineMap(feature);
        checkAndSwitchViewToMain(feature, application);
    }

    private void checkAndAddLine(String feature, SubwayLineMap application, Scanner scanner){
        if(feature.equals(BTN_ADD_LINE)){
            String lineName = getLineName(scanner);
            Station startStation = getStartStation(scanner);
            Station endStation = getEndStation(scanner);
            lineController.addLine(lineName, startStation, endStation);
            ViewLogger.printLogWithWhiteSpace(LineManagementViewComponent.getRegisterFinishComponent());
            switchViewToStationManagement(application);
        }
    }

    private void checkAndRemoveLine(String feature, SubwayLineMap application, Scanner scanner){
        if(feature.equals(BTN_DELETE_LINE)){
            ViewLogger.printLog(LineManagementViewComponent.getRemoveLineBeginComponent());
            String lineName = getLineOrStationName(scanner);
            lineController.removeLine(lineName);
            printLineRemoveFinishLog();
            switchViewToStationManagement(application);
        }
    }

    private void checkAndPrintSubwayLineMap(String feature){
        if(feature.equals(BTN_READ_LINE)){
            printSubwayLineMap();
        }
    }

    public void printLineRemoveFinishLog(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        stringBuilder.append(LineManagementViewComponent.getRemoveLineFinishComponent());
        stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        System.out.println(stringBuilder.toString());
    }

    public void printSubwayLineMap(){
        List<Line> lineList = lineController.getLines();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LineManagementViewComponent.getSubwayLineListLog());
        stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        appendSubwayLineMapLog(stringBuilder, lineList);
        System.out.println(stringBuilder.toString());
    }

    private void checkAndSwitchViewToMain(String feature, SubwayLineMap application){
        if(feature.equals(BTN_BACK)){
            switchViewToStationManagement(application);
        }
    }

    private String getLineName(Scanner scanner){
        ViewLogger.printLog(LineManagementViewComponent.getLineRegisterComponent());
        String lineName = getLineOrStationName(scanner);
        ViewLogger.printWhiteSpace();
        if(lineController.isExistingLineName(lineName)){
            throw new DuplicatedLineNameException();
        }
        return lineName;
    }

    private Station getStartStation(Scanner scanner){
        ViewLogger.printLog(LineManagementViewComponent.getStationRequiringBeginComponent());
        String startStationName = getLineOrStationName(scanner);
        ViewLogger.printWhiteSpace();
        return stationController.getStation(startStationName);
    }

    private Station getEndStation(Scanner scanner){
        ViewLogger.printLog(LineManagementViewComponent.getStationRequiringEndComponent());
        String endStationName = getLineOrStationName(scanner);
        ViewLogger.printWhiteSpace();
        return stationController.getStation(endStationName);
    }

    private void appendSubwayLineMapLog(StringBuilder stringBuilder, List<Line> lineList){
        for(Line line : lineList){
            stringBuilder.append(StationManagementViewComponent.getFinishPrefixComponent());
            stringBuilder.append(line.getName());
            stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        }
    }

    private String getLineOrStationName(Scanner scanner){
        return scanner.nextLine();
    }

    private void switchViewToStationManagement(SubwayLineMap application){
        application.setViewState(MainViewState.getMainView());
    }
}
