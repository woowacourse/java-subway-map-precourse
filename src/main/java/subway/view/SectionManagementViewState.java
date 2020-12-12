package subway.view;

import subway.SubwayLineMap;
import subway.controller.LineController;
import subway.controller.StationController;
import subway.domain.Line;
import subway.domain.Station;
import subway.exceptions.DuplicatedStartAndEndStationNameException;
import subway.exceptions.InvalidPositionException;
import subway.exceptions.LineNotExistException;
import subway.exceptions.StationNotExistException;
import subway.view.component.CommonViewComponent;
import subway.view.component.SectionManagementViewComponent;

import java.util.Optional;
import java.util.Scanner;

public class SectionManagementViewState extends ViewState{
    private static final String BTN_ADD_SECTION = "1";
    private static final String BTN_DELETE_SECTION = "2";
    private static final String BTN_BACK = "B";

    private static SectionManagementViewState sectionManagementViewState;
    private LineController lineController = LineController.getLineController();
    private StationController stationController = StationController.getStationController();

    private SectionManagementViewState(){
        featureSet.add(BTN_ADD_SECTION);
        featureSet.add(BTN_DELETE_SECTION);
        featureSet.add(BTN_BACK);
    }

    public static synchronized SectionManagementViewState getSectionManagementViewState(){
        if(!Optional.ofNullable(sectionManagementViewState).isPresent()){
            sectionManagementViewState = new SectionManagementViewState();
        }
        return sectionManagementViewState;
    }

    @Override
    protected void printMenuWithInputRequirementMsg(){
        StringBuilder viewStringBuilder = new StringBuilder();
        viewStringBuilder.append(SectionManagementViewComponent.getMenuComponent());
        viewStringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        viewStringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        viewStringBuilder.append(CommonViewComponent.getSelectFeatureViewComponent());
        System.out.println(viewStringBuilder.toString());
    }

    @Override
    protected void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner) throws Exception {
        checkAndAddSection(feature, application, scanner);
        checkAndSwitchViewToMain(feature, application);
    }

    private void checkAndAddSection(String feature, SubwayLineMap application, Scanner scanner) throws Exception {
        if(feature.equals(BTN_ADD_SECTION)){
            Line line = printLogAndGetInputLineName(scanner);
            Station station = printLogAndGetInputStationNameAtLine(scanner, line);
            printLogAndGetInputStationPositionAtLine(scanner, station, line);
            printSectionRegisterFinishLog();
            switchViewToStationManagement(application);
        }
    }

    private Line printLogAndGetInputLineName(Scanner scanner) throws LineNotExistException {
        printSectionRegisterLineNameInputLog();
        String lineName = getStationOrLineName(scanner);
        printWhiteSpace();
        Optional<Line> lineOptional = lineController.getLine(lineName);
        if(!lineOptional.isPresent()){
            throw new LineNotExistException();
        }
        return lineOptional.get();
    }

    private Station printLogAndGetInputStationNameAtLine(Scanner scanner, Line line) throws StationNotExistException,
            DuplicatedStartAndEndStationNameException {
        printSectionRegisterStationNameInputLog();
        String stationName = getStationOrLineName(scanner);
        Station station = stationController.getStation(stationName);
        printWhiteSpace();
        if(line.getStations().contains(station)){
            throw new DuplicatedStartAndEndStationNameException();
        }
        return station;
    }

    private void printLogAndGetInputStationPositionAtLine(Scanner scanner, Station station, Line line) throws
            InvalidPositionException {
        printSectionRegisterPositionInputLog();
        int position = getPosition(scanner);
        printWhiteSpace();
        lineController.addStationInLineAtCertainPosition(station, line, position);
    }

    private void printSectionRegisterLineNameInputLog(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SectionManagementViewComponent.getSectionRegisterLineNameInputComponent());
        System.out.println(stringBuilder.toString());
    }

    private void printSectionRegisterStationNameInputLog(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SectionManagementViewComponent.getSectionRegisterStationNameInputComponent());
        System.out.println(stringBuilder.toString());
    }

    private void printSectionRegisterPositionInputLog(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SectionManagementViewComponent.getSectionRegisterStationOrderComponent());
        System.out.println(stringBuilder.toString());
    }

    private void printSectionRegisterFinishLog(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SectionManagementViewComponent.getSectionRegisterFinishComponent());
        stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        System.out.println(stringBuilder.toString());
    }

    private int getPosition(Scanner scanner){
        return Integer.parseInt(scanner.nextLine());
    }

    private String getStationOrLineName(Scanner scanner){
        return scanner.nextLine();
    }

    private void checkAndSwitchViewToMain(String feature, SubwayLineMap application){
        if(feature.equals(BTN_BACK)){
            switchViewToStationManagement(application);
        }
    }

    private void switchViewToStationManagement(SubwayLineMap application){
        application.setViewState(MainViewState.getMainView());
    }
}
