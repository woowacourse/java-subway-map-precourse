package subway.controller.manager;

import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.screen.ActionType;
import subway.screen.EntityType;
import subway.view.View;

public class LineManager {
    private Controller controller;
    private View view;
    
    LineManager(Controller controller, View view) {
        this.controller = controller;
        this.view = view;
    }
    
    void manageLine(ActionType actionType) {
        if(actionType == ActionType.REGISTER) {
            registerLine();
        }
        if(actionType == ActionType.DELETE) {
            deleteLine();
        }
        if(actionType == ActionType.SHOW) {
            // TODO 구현 예정
        }
    }
    
    private void registerLine() {
        String newLineName;
        
        try {
            newLineName = controller.askName(EntityType.LINE, ActionType.REGISTER);
            LineRepository.addLine(new Line(newLineName), controller.askEndStationNames());
            view.printSuccessMessage(EntityType.LINE, ActionType.REGISTER);
        } catch (Exception exception) {
            view.printErrorMessage(exception);
        }
    }
    
    private void deleteLine() {
        try {
            LineRepository.deleteLineByName(controller.askName(EntityType.LINE, ActionType.DELETE));
            view.printSuccessMessage(EntityType.LINE, ActionType.DELETE);
        } catch (Exception exception) {
            view.printErrorMessage(exception);
        }
    }
}
