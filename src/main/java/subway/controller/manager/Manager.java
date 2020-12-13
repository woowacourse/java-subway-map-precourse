package subway.controller.manager;

import subway.controller.Controller;
import subway.screen.Choice;
import subway.screen.EntityType;
import subway.view.View;

public class Manager {
    private StationManager stationManager;
    
    public Manager(Controller controller, View view) {
        stationManager = new StationManager(controller, view);
    }
    
    public void manageEntity(Choice choice) {
        if(choice.entityTypeEquals(EntityType.STATION)) {
            stationManager.manageStation(choice.getActionType());
        }
        if(choice.entityTypeEquals(EntityType.LINE)) {
            // TODO 구현 예정
        }
        if(choice.entityTypeEquals(EntityType.ROUTE)) {
            // TODO 구현 예정
        }
        if(choice.entityTypeEquals(EntityType.MAP)) {
            // TODO 구현 예정
        }
    }
}
