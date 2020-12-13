package subway.view;

import subway.SubwayLineMap;
import subway.exceptions.UnselectableFeatureException;
import subway.view.component.CommonViewComponent;
import subway.view.logger.ViewLogger;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public abstract class ViewState {
    protected static Set<String> featureSet= new HashSet<>();

    protected boolean continuable = true;

    public void render(Scanner scanner, SubwayLineMap application) {
        try {
            printMenuWithInputRequirementMsg();
            String feature = getMenuInputBtn(scanner);
            runFeatureAtApplication(feature, application, scanner);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean isContinuable() {
        return continuable;
    }

    protected String getMenuInputBtn(Scanner scanner) throws Exception {
        String menuInput = scanner.nextLine();
        ViewLogger.printWhiteSpace();
        if(!featureSet.contains(menuInput)){
            throw new UnselectableFeatureException();
        }
        return menuInput;
    }

    protected abstract void printMenuWithInputRequirementMsg();

    protected abstract void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner) throws Exception;
}
