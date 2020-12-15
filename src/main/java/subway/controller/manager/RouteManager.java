package subway.controller.manager;

import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.screen.ActionType;
import subway.screen.EntityType;
import subway.view.View;

public class RouteManager {
    private Controller controller;
    private View view;
    
    RouteManager(Controller controller, View view) {
        this.controller = controller;
        this.view = view;
    }
    
    void manageRoute(ActionType actionType) {
        if(actionType == ActionType.REGISTER) {
            registerStationToRoute();
        }
        if(actionType == ActionType.DELETE) {
            deleteStationFromRoute();
        }
    }
    
    private void registerStationToRoute() {
        String lineName;
        String stationName;
        int stationOrderInRoute;
        
        try {
            lineName = controller.askName(EntityType.ROUTE, ActionType.REGISTER);
            stationName = controller.askStationNameToRegisterToRoute(lineName);
            stationOrderInRoute = Integer.parseInt(controller.askStationOrderInRoute(lineName));
            LineRepository.addStationToRouteByName(lineName, stationName, stationOrderInRoute - Line.ROUTE_START);
            view.printSuccessMessage(EntityType.ROUTE, ActionType.REGISTER);
        } catch (Exception exception) {
            view.printErrorMessage(exception);
        }
    }
    
    private void deleteStationFromRoute() {
        String lineName;
        String stationName;
        
        try {
            lineName = controller.askName(EntityType.ROUTE, ActionType.DELETE);
            stationName = controller.askStationNameToDeleteFromRoute(lineName);
            LineRepository.deleteStationFromRouteByName(lineName, stationName);
            view.printSuccessMessage(EntityType.ROUTE, ActionType.DELETE);
        } catch (Exception exception) {
            view.printErrorMessage(exception);
        }
    }
}
