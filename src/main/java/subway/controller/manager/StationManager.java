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
            // TODO 구현 예정
        }
        if(actionType == ActionType.SHOW) {
            // TODO 구현 예정
        }
    }
    
    private void registerStation() {
        Station newStation;

        try {
            newStation = controller.askStation(ActionType.REGISTER);
            StationRepository.addStation(newStation);
            view.printSuccessMessage(EntityType.STATION, ActionType.REGISTER);
        } catch (Exception exception) {
            view.printErrorMessage(exception);
        }
    }
}
