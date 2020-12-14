package subway.controller.manager;

import subway.controller.Controller;
import subway.screen.Choice;
import subway.screen.EntityType;
import subway.view.View;

public class Manager {
    private StationManager stationManager;
    private LineManager lineManager;
    private RouteManager routeManager;
    
    public Manager(Controller controller, View view) {
        stationManager = new StationManager(controller, view);
        lineManager = new LineManager(controller, view);
        routeManager = new RouteManager(controller, view);
    }
    
    public void manageEntity(Choice choice) {
        if(choice.entityTypeEquals(EntityType.STATION)) {
            stationManager.manageStation(choice.getActionType());
        }
        if(choice.entityTypeEquals(EntityType.LINE)) {
            lineManager.manageLine(choice.getActionType());
        }
        if(choice.entityTypeEquals(EntityType.ROUTE)) {
            routeManager.manageRoute(choice.getActionType());
        }
        if(choice.entityTypeEquals(EntityType.MAP)) {
            // TODO 구현 예정
        }
    }
}
