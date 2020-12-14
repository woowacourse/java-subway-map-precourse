package subway.controller.manager;

import subway.controller.Controller;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.screen.ActionType;
import subway.screen.EntityType;
import subway.view.View;

public class StationManager {
    private Controller controller;
    private View view;
    
    StationManager(Controller controller, View view) {
        this.controller = controller;
        this.view = view;
    }
    
    void manageStation(ActionType actionType) {
        if(actionType == ActionType.REGISTER) {
            registerStation();
        }
        if(actionType == ActionType.DELETE) {
            deleteStation();
        }
        if(actionType == ActionType.SHOW) {
            showStations();
        }
    }
    
    private void registerStation() {
        try {
            StationRepository.addStation(new Station(controller.askName(EntityType.STATION, ActionType.REGISTER)));
            view.printSuccessMessage(EntityType.STATION, ActionType.REGISTER);
        } catch (Exception exception) {
            view.printErrorMessage(exception);
        }
    }
    
    private void deleteStation() {
        try {
            StationRepository.deleteStationByName(controller.askName(EntityType.STATION, ActionType.DELETE));
            view.printSuccessMessage(EntityType.STATION, ActionType.DELETE);
        } catch (Exception exception) {
            view.printErrorMessage(exception);
        }
    }
    
    private void showStations() {
        view.printNames(EntityType.STATION, StationRepository.stationNames());
    }
}
