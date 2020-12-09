package subway.controller;

import subway.view.CommonView;
import subway.view.MainMenuView;

import java.util.*;

public class MainMenuControllerState extends ControllerState {
    private static final String BTN_STATION_MANAGEMENT = "1";
    private static final String BTN_LINE_MANAGEMENT = "2";
    private static final String BTN_SECTION_MANAGEMENT = "3";
    private static final String BTN_PRINT_SUBWAY_LINEMAP = "4";
    private static final String BTN_QUIT = "Q";

    private static MainMenuControllerState mainController;

    private MainMenuControllerState(){
        featureRequiredInputNumMap.put(BTN_STATION_MANAGEMENT, 0);
        featureRequiredInputNumMap.put(BTN_LINE_MANAGEMENT, 0);
        featureRequiredInputNumMap.put(BTN_SECTION_MANAGEMENT, 0);
        featureRequiredInputNumMap.put(BTN_PRINT_SUBWAY_LINEMAP, 0);
        featureRequiredInputNumMap.put(BTN_QUIT, 0);
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
