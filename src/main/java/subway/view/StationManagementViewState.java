package subway.view;

import subway.SubwayLineMap;
import subway.controller.StationController;
import subway.domain.Station;
import subway.view.component.StationManagementViewComponent;
import subway.view.component.common.OutputViewComponent;
import subway.view.input.StationManagementInputView;
import subway.view.output.StationManagementOutputView;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StationManagementViewState extends ViewState{
    private static final String BTN_ADD_STATION = "1";
    private static final String BTN_DELETE_STATION = "2";
    private static final String BTN_READ_STATION = "3";
    private static final String BTN_BACK = "B";

    public static StationManagementViewState stationManagementViewState;
    public StationController stationController;

    private StationManagementViewState(){
        stationController = StationController.getStationController();
        featureSet.add(BTN_ADD_STATION);
        featureSet.add(BTN_DELETE_STATION);
        featureSet.add(BTN_READ_STATION);
        featureSet.add(BTN_BACK);
    }

    public static synchronized StationManagementViewState getStationManagementViewState(){
        if(!Optional.ofNullable(stationManagementViewState).isPresent()){
            stationManagementViewState = new StationManagementViewState();
        }
        return stationManagementViewState;
    }

    @Override
    protected void printMenu(){
        StationManagementOutputView.printMenuLog();
    }

    @Override
    protected void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner){
        checkAndAddStation(feature, application);
        checkAndRemoveStation(feature, application);
        checkAndPrintStations(feature, application);
        checkAndSwitchViewToMain(feature, application);
    }

    private void checkAndAddStation(String feature, SubwayLineMap application){
        if(feature.equals(BTN_ADD_STATION)){
            String stationName = StationManagementInputView.getStationNameRegisterInput();
            stationController.addStation(stationName);
            StationManagementOutputView.printStationRegisterFinishLog();
            switchViewToStationManagement(application);
        }
    }

    private void checkAndRemoveStation(String feature, SubwayLineMap application){
        if(feature.equals(BTN_DELETE_STATION)){
            String stationName = StationManagementInputView.getStationNameRemoveInput();
            stationController.removeStation(stationName);
            StationManagementOutputView.printStationRemoveFinishLog();
            switchViewToStationManagement(application);
        }
    }

    private void checkAndPrintStations(String feature, SubwayLineMap application){
        if(feature.equals(BTN_READ_STATION)){
            List<Station> stationList = stationController.getStations();
            StationManagementOutputView.printStationList(stationList);
            switchViewToStationManagement(application);
        }
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
