package subway.controller;

import subway.view.CommonView;
import subway.view.MainMenuView;

import java.util.*;

public class MainMenuControllerState extends ControllerState {
    private static MainMenuControllerState mainController;

    private MainMenuControllerState(){
        featureRequiredInputNumMap.put("1", 0);
        featureRequiredInputNumMap.put("2", 0);
        featureRequiredInputNumMap.put("3", 0);
        featureRequiredInputNumMap.put("4", 0);
        featureRequiredInputNumMap.put("Q", 0);
    }

    public static synchronized MainMenuControllerState getMainController(){
        if(!Optional.ofNullable(mainController).isPresent()){
            mainController = new MainMenuControllerState();
        }
        return mainController;
    }

    @Override
    public void printMain() {
        MainMenuView.printMainView();
        CommonView.printSelectFeatureView();
    }

    @Override
    public void doFeature(String feature, int order, String param, ControllerState controllerState) {
        if(feature.equals(BTN_STATION_MANAGEMENT)){
            switchToStationControllerState(controllerState);
        }
        if(feature.equals(BTN_LINE_MANAGEMENT)){
            switchToLineControllerState(controllerState);
        }
        if(feature.equals(BTN_SECTION_MANAGEMENT)){
            switchToSectionControllerState(controllerState);
        }
        if(feature.equals(BTN_PRINT_SUBWAY_LINEMAP)){

        }
    }

    public void switchToStationControllerState(ControllerState controllerState){
        controllerState = LineControllerState.getLineController();
    }

    public void switchToLineControllerState(ControllerState controllerState){
        controllerState = LineControllerState.getLineController();
    }

    public void switchToSectionControllerState(ControllerState controllerState){
        controllerState = LineControllerState.getLineController();
    }

    public void printSubwayLinemap(){

    }
}
