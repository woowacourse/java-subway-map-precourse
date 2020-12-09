package subway;

import java.util.Scanner;
import subway.controller.ControllerState;
import subway.controller.MainMenuControllerState;
import subway.view.CommonView;

public class SubwayLineMap {
    private ControllerState controllerState = MainMenuControllerState.getMainController();
    private Scanner scanner;

    public SubwayLineMap(Scanner scanner){
        this.scanner = scanner;
    }

    public void run(){
        startMainLoop();
    }

    public void startMainLoop(){
        while(true){
            controllerState.printMain();
            String feature = scanner.next();
            if(controllerState.isValidFeature(feature)){
                continue;
            }
            startFeature(feature);
        }
    }

    public void startFeature(String feature){
        int requiredInputNum = controllerState.getRequiredInputNum(feature);
        startSpecificFunction(feature, requiredInputNum);
    }

    private void startSpecificFunction(String feature, int requiredInputNum){
        int requiredInputNumLeft = requiredInputNum;
        while(requiredInputNumLeft >= 0){
            String input = "";
            if(requiredInputNumLeft != 0){
                input = scanner.next();
                CommonView.printWhiteLine();
            }
            controllerState.doFeature(feature, requiredInputNum, input);
            requiredInputNumLeft--;
        }
    }

}
