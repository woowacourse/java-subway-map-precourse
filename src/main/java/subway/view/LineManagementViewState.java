package subway.view;

import subway.SubwayLineMap;
import subway.controller.LineController;
import subway.controller.StationController;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exceptions.StationNotExistException;
import subway.view.component.CommonViewComponent;
import subway.view.component.LineManagementViewComponent;

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
    protected void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner) throws Exception {
        checkAndAddLine(feature, application, scanner);
        checkAndSwitchViewToMain(feature, application);
    }

    private void checkAndAddLine(String feature, SubwayLineMap application, Scanner scanner) throws Exception {
        if(feature.equals(BTN_ADD_LINE)){
            String lineName = getLineName(scanner);
            Station startStation = getStartStation(scanner);
            Station endStation = getEndStation(scanner);
            lineController.addLine(lineName, startStation, endStation);
            printStationRegisterFinishLog();
            switchViewToStationManagement(application);
        }
    }

    public void printLineRegisterLog(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LineManagementViewComponent.getLineRegisterComponent());
        System.out.println(stringBuilder.toString());
    }

    public void printRequiringStationBeginLog(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LineManagementViewComponent.getStationRequiringBeginComponent());
        System.out.println(stringBuilder.toString());
    }

    public void printRequiringStationEndLog(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LineManagementViewComponent.getStationRequiringEndComponent());
        System.out.println(stringBuilder.toString());
    }

    public void printStationRegisterFinishLog(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LineManagementViewComponent.getRegisterFinishComponent());
        stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        System.out.println(stringBuilder.toString());
    }

    private void checkAndSwitchViewToMain(String feature, SubwayLineMap application){
        if(feature.equals(BTN_BACK)){
            switchViewToStationManagement(application);
        }
    }

    private String getLineName(Scanner scanner){
        printLineRegisterLog();
        String lineName = getLineOrStationName(scanner);
        printWhiteSpace();
        return lineName;
    }

    private Station getStartStation(Scanner scanner) throws StationNotExistException {
        printRequiringStationBeginLog();
        String startStationName = getLineOrStationName(scanner);
        printWhiteSpace();
        return stationController.getStation(startStationName);
    }

    private Station getEndStation(Scanner scanner) throws StationNotExistException {
        printRequiringStationEndLog();
        String endStationName = getLineOrStationName(scanner);
        printWhiteSpace();
        return stationController.getStation(endStationName);
    }

    private String getLineOrStationName(Scanner scanner){
        return scanner.nextLine();
    }

    private void switchViewToStationManagement(SubwayLineMap application){
        application.setViewState(MainViewState.getMainView());
    }
}
