package subway.view;

import subway.SubwayLineMap;
import subway.view.component.CommonViewComponent;
import subway.view.component.StationManagementViewComponent;

import java.util.Optional;
import java.util.Scanner;

public class StationManagementViewState extends ViewState{
    private static final String BTN_ADD_STATION = "1";
    private static final String BTN_DELETE_STATION = "2";
    private static final String BTN_READ_STATION = "3";
    private static final String BTN_BACK = "B";

    public static StationManagementViewState stationManagementViewState;

    private StationManagementViewState(){
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
    protected void printMenuWithInputRequirementMsg(){
        StringBuilder viewStringBuilder = new StringBuilder();
        viewStringBuilder.append(StationManagementViewComponent.getMenuComponent());
        viewStringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        viewStringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        viewStringBuilder.append(CommonViewComponent.getSelectFeatureViewComponent());
        System.out.println(viewStringBuilder.toString());
    }

    @Override
    protected void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner){
        checkAndSwitchViewToMain(feature, application);
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
