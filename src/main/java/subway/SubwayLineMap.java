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

    private void startMainLoop(){
        while(true){
            controllerState.printMain();
            String feature = scanner.next();
            if(!controllerState.isValidFeature(feature)){
                continue;
            }
            boolean canQuit = startFeature(feature);
            if(canQuit) return;
        }
    }

    private boolean startFeature(String feature){
        int requiredInputNum = controllerState.getRequiredInputNum(feature);
        if(isQuitable(feature)){
            return true;
        }
        startSpecificFunction(feature, requiredInputNum);
        return false;
    }

    private void startSpecificFunction(String feature, int requiredInputNum){
        int requiredInputNumLeft = requiredInputNum;
        while(requiredInputNumLeft >= 0){
            String input = "";
            if(requiredInputNumLeft != 0){
                input = scanner.next();
                CommonView.printWhiteLine();
            }
            controllerState.doFeature(feature, requiredInputNum, input, controllerState);
            requiredInputNumLeft--;
        }
    }

    private boolean isQuitable(String input){
        if(controllerState.equals(MainMenuControllerState.getMainController()) && input.equals("Q")){
            return true;
        }
        return false;
    }
}
