package subway.view;

import subway.SubwayLineMap;
import subway.controller.LineController;
import subway.controller.StationController;
import subway.domain.Line;
import subway.domain.Station;
import subway.exceptions.DuplicatedStartAndEndStationNameException;
import subway.exceptions.LineNotExistException;
import subway.exceptions.MinimumLineLengthException;
import subway.exceptions.StationNotExistException;
import subway.view.component.CommonViewComponent;
import subway.view.component.SectionManagementViewComponent;
import subway.view.logger.ViewLogger;

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
    protected void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner){
        checkAndAddSection(feature, application, scanner);
        checkAndRemoveSection(feature, application, scanner);
        checkAndSwitchViewToMain(feature, application);
    }

    private void checkAndAddSection(String feature, SubwayLineMap application, Scanner scanner){
        if(feature.equals(BTN_ADD_SECTION)){
            Line line = printRegisterInputLogAndGetInputLineName(scanner);
            Station station = printRegisterLogAndGetInputStationNameAtLine(scanner, line);
            printLogAndGetInputStationPositionAtLine(scanner, station, line);
            ViewLogger.printLogWithWhiteSpace(SectionManagementViewComponent.getSectionRegisterFinishComponent());
            switchViewToStationManagement(application);
        }
    }

    private void checkAndRemoveSection(String feature, SubwayLineMap application, Scanner scanner){
        if(feature.equals(BTN_DELETE_SECTION)){
            Line line = printRemoveInputLogAndGetInputLineName(scanner);
            printRemoveInputLogAndGetInputStationNameAtLine(scanner, line);
            ViewLogger.printLogWithWhiteSpace(SectionManagementViewComponent.getSectionRemoveFinishComponent());
            switchViewToStationManagement(application);
        }
    }

    private Line printRegisterInputLogAndGetInputLineName(Scanner scanner){
        ViewLogger.printLog(SectionManagementViewComponent.getSectionRegisterLineNameInputComponent());
        String lineName = getStationOrLineName(scanner);
        ViewLogger.printWhiteSpace();
        return lineController.getLine(lineName);
    }

    private Station printRegisterLogAndGetInputStationNameAtLine(Scanner scanner, Line line){
        ViewLogger.printLog(SectionManagementViewComponent.getSectionRegisterLineNameInputComponent());
        String stationName = getStationOrLineName(scanner);
        Station station = stationController.getStation(stationName);
        ViewLogger.printWhiteSpace();
        if(line.getStations().contains(station)){
            throw new DuplicatedStartAndEndStationNameException();
        }
        return station;
    }

    private void printLogAndGetInputStationPositionAtLine(Scanner scanner, Station station, Line line){
        ViewLogger.printLog(SectionManagementViewComponent.getSectionRegisterStationOrderComponent());
        int position = getPosition(scanner);
        ViewLogger.printWhiteSpace();
        lineController.addStationInLine(station, line, position);
    }

    private Line printRemoveInputLogAndGetInputLineName(Scanner scanner){
        ViewLogger.printLog(SectionManagementViewComponent.getSectionRemoveLineNameInputComponent());
        String lineName = getStationOrLineName(scanner);
        ViewLogger.printWhiteSpace();
        return lineController.getLine(lineName);
    }

    private void printRemoveInputLogAndGetInputStationNameAtLine(Scanner scanner, Line line){
        ViewLogger.printLog(SectionManagementViewComponent.getSectionRemoveStationNameInputComponent());
        String stationName = getStationOrLineName(scanner);
        Station station = stationController.getStation(stationName);
        ViewLogger.printWhiteSpace();
        lineController.removeStationInLine(station, line);
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
