package subway.view;

import subway.SubwayLineMap;
import subway.exception.UnselectableFeatureException;
import subway.view.component.CommonViewComponent;

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

    protected String getMenuInputBtn(Scanner scanner) throws UnselectableFeatureException {
        String menuInput = scanner.nextLine();
        printWhiteSpace();
        if(!featureSet.contains(menuInput)){
            throw new UnselectableFeatureException();
        }
        return menuInput;
    }

    protected void printWhiteSpace(){
        System.out.println();
    }

    protected abstract void printMenuWithInputRequirementMsg();

    protected abstract void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner);
}
