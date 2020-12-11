package subway.view;

import subway.SubwayLineMap;
import subway.view.component.CommonViewComponent;
import subway.view.component.LineManagementViewComponent;

import java.util.Optional;
import java.util.Scanner;

public class LineManagementViewState extends ViewState {
    private static final String BTN_ADD_LINE = "1";
    private static final String BTN_DELETE_LINE = "2";
    private static final String BTN_READ_LINE = "3";
    private static final String BTN_BACK = "B";

    private static LineManagementViewState lineManagementViewState;

    private LineManagementViewState() {
        featureSet.add(BTN_ADD_LINE);
        featureSet.add(BTN_DELETE_LINE);
        featureSet.add(BTN_READ_LINE);
        featureSet.add(BTN_BACK);
    }

    public static synchronized LineManagementViewState getLineManagementViewState() {
        if (!Optional.ofNullable(lineManagementViewState).isPresent()) {
            lineManagementViewState = new LineManagementViewState();
        }
        return lineManagementViewState;
    }

    @Override
    protected void printMenuWithInputRequirementMsg() {
        StringBuilder viewStringBuilder = new StringBuilder();
        viewStringBuilder.append(LineManagementViewComponent.getMenuComponent());
        viewStringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        viewStringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        viewStringBuilder.append(CommonViewComponent.getSelectFeatureViewComponent());
        System.out.println(viewStringBuilder.toString());
    }

    @Override
    protected void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner) {
        checkAndSwitchViewToMain(feature, application);
    }

    private void checkAndSwitchViewToMain(String feature, SubwayLineMap application){
        if(feature.equals(BTN_BACK)){
            switchViewToStationManagement(application);
        }
    }

    private void switchViewToStationManagement(SubwayLineMap application){
        application.setViewState(MainViewState.getMainView());
    }
}
