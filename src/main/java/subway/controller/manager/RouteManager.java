package subway.controller.manager;

import subway.controller.Controller;
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
            // TODO 구현 예
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
            LineRepository.addStationToRouteByName(lineName, stationName, stationOrderInRoute - LineRepository.ROUTE_START);
        } catch (Exception exception) {
            view.printErrorMessage(exception);
        }
    }
}
