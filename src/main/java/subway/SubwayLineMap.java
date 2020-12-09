package subway;

import java.util.Scanner;
import subway.controller.ControllerState;
import subway.controller.MainControllerState;
import subway.view.CommonView;

public class SubwayLineMap {
    private ControllerState controllerState = MainControllerState.getMainController();
    private Scanner scanner;

    public SubwayLineMap(Scanner scanner){
        this.scanner = scanner;
    }

    public void run(){
        while(true){
            controllerState.printMain();
            String feature = scanner.next();
            if(controllerState.isValidFeature(feature)){
                continue;
            }
            int requiredInputNum = controllerState.getRequiredInputNum(feature);
            startFunction(feature, requiredInputNum);
        }
    }

    public void startFunction(String feature, int requiredInputNum){
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
