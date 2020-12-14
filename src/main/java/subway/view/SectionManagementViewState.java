package subway.view;

import subway.SubwayLineMap;
import subway.controller.LineController;
import subway.controller.StationController;
import subway.domain.Line;
import subway.domain.Station;
import subway.view.input.SectionManagementInputView;
import subway.view.output.SectionManagementOutputView;

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
    protected void printMenu(){
        SectionManagementOutputView.printMenuLog();
    }

    @Override
    protected void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner){
        checkAndAddSection(feature, application, scanner);
        checkAndRemoveSection(feature, application, scanner);
        checkAndSwitchViewToMain(feature, application);
    }

    private void checkAndAddSection(String feature, SubwayLineMap application, Scanner scanner){
        if(feature.equals(BTN_ADD_SECTION)){
            Line line = getLineToAdd();
            Station station = getStationToAdd();
            int position = SectionManagementInputView.getStationPosition();
            lineController.addStationInLine(station, line, position);
            SectionManagementOutputView.printSectionRegisterFinishLog();
            switchViewToStationManagement(application);
        }
    }

    private void checkAndRemoveSection(String feature, SubwayLineMap application, Scanner scanner){
        if(feature.equals(BTN_DELETE_SECTION)){
            Line line = getLineToRemove();
            Station station = getStationToRemove();
            lineController.removeStationInLine(station, line);
            SectionManagementOutputView.printSectionRemoveFinishLog();
            switchViewToStationManagement(application);
        }
    }

    private void checkAndSwitchViewToMain(String feature, SubwayLineMap application){
        if(feature.equals(BTN_BACK)){
            switchViewToStationManagement(application);
        }
    }

    private Line getLineToAdd(){
        String lineName = SectionManagementInputView.getLineNameAddInput();
        return lineController.getLine(lineName);
    }

    private Station getStationToAdd(){
        String stationName = SectionManagementInputView.getStationNameAddInput();
        return stationController.getStation(stationName);
    }

    private Line getLineToRemove(){
        String lineName = SectionManagementInputView.getLineNameRemoveInput();
        return lineController.getLine(lineName);
    }

    private Station getStationToRemove(){
        String stationName = SectionManagementInputView.getStationNameRemoveInput();
        return stationController.getStation(stationName);
    }

    private void switchViewToStationManagement(SubwayLineMap application){
        application.setViewState(MainViewState.getMainView());
    }
}
