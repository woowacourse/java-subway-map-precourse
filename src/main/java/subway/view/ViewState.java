package subway.view;

import subway.SubwayLineMap;
import subway.exceptions.UnselectableFeatureException;
import subway.view.input.CommonInputView;
import subway.view.component.common.OutputViewComponent;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public abstract class ViewState {
    protected static Set<String> featureSet= new HashSet<>();
    protected boolean continuable = true;

    public void render(Scanner scanner, SubwayLineMap application) {
        try {
            printMenu();
            String feature = getMenuInputBtn();
            runFeatureAtApplication(feature, application, scanner);
        }catch (Exception e){
            OutputViewComponent.printLog(e.getMessage());
        }
    }

    public boolean isContinuable() {
        return continuable;
    }

    private String getMenuInputBtn(){
        String menuInput = CommonInputView.getMenuInputLog();
        if(!featureSet.contains(menuInput)){
            throw new UnselectableFeatureException();
        }
        return menuInput;
    }

    abstract void printMenu();

    abstract void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner) throws Exception;
}
