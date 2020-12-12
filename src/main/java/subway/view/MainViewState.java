package subway.view;

import subway.SubwayLineMap;
import subway.controller.LineController;
import subway.domain.Line;
import subway.domain.Station;
import subway.view.component.CommonViewComponent;
import subway.view.component.MainViewComponent;
import subway.view.component.StationManagementViewComponent;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainViewState extends ViewState{
    private static final String BTN_STATION_MANAGEMENT = "1";
    private static final String BTN_LINE_MANAGEMENT = "2";
    private static final String BTN_SECTION_MANAGEMENT = "3";
    private static final String BTN_PRINT_SUBWAY_LINEMAP = "4";
    private static final String BTN_QUIT = "Q";

    private static MainViewState mainViewState;
    private LineController lineController = LineController.getLineController();

    private MainViewState(){
        featureSet.add(BTN_STATION_MANAGEMENT);
        featureSet.add(BTN_LINE_MANAGEMENT);
        featureSet.add(BTN_SECTION_MANAGEMENT);
        featureSet.add(BTN_PRINT_SUBWAY_LINEMAP);
        featureSet.add(BTN_QUIT);
    }

    public static synchronized MainViewState getMainView(){
        if(!Optional.ofNullable(mainViewState).isPresent()){
            mainViewState = new MainViewState();
        }
        return mainViewState;
    }

    @Override
    protected void printMenuWithInputRequirementMsg(){
        StringBuilder viewStringBuilder = new StringBuilder();
        viewStringBuilder.append(MainViewComponent.getMenuComponent());
        viewStringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        viewStringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        viewStringBuilder.append(CommonViewComponent.getSelectFeatureViewComponent());
        System.out.println(viewStringBuilder.toString());
    }

    @Override
    protected void runFeatureAtApplication(String feature, SubwayLineMap application, Scanner scanner) throws Exception {
        checkAndSwitchViewToStationManagement(feature, application);
        checkAndSwitchViewToLineManagement(feature, application);
        checkAndSwitchViewToSectionManagement(feature, application);
        checkAndPrintSubwayLineMap(feature, application);
        checkAndQuit(feature);
    }

    private void checkAndSwitchViewToStationManagement(String feature, SubwayLineMap application){
        if(feature.equals(BTN_STATION_MANAGEMENT)){
            switchViewToStationManagement(application);
        }
    }

    private void checkAndSwitchViewToLineManagement(String feature, SubwayLineMap application){
        if(feature.equals(BTN_LINE_MANAGEMENT)){
            switchViewToLineManagement(application);
        }
    }

    private void checkAndSwitchViewToSectionManagement(String feature, SubwayLineMap application){
        if(feature.equals(BTN_SECTION_MANAGEMENT)){
            switchViewToSectionManagement(application);
        }
    }

    private void checkAndPrintSubwayLineMap(String feature, SubwayLineMap application) throws Exception {
        if(feature.equals(BTN_PRINT_SUBWAY_LINEMAP)){
            printSubwayLineList();
        }
    }

    private void checkAndQuit(String feature){
        if(feature.equals(BTN_QUIT)){
            continuable = false;
        }
    }

    private void switchViewToStationManagement(SubwayLineMap application){
        application.setViewState(StationManagementViewState.getStationManagementViewState());
    }

    private void switchViewToLineManagement(SubwayLineMap application){
        application.setViewState(LineManagementViewState.getLineManagementViewState());
    }

    private void switchViewToSectionManagement(SubwayLineMap application){
        application.setViewState(SectionManagementViewState.getSectionManagementViewState());
    }

    public void printSubwayLineList(){
        List<Line> lineList = lineController.getLines();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MainViewComponent.getSubwayLineMapComponent());
        stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        appendSubwayLineListLog(stringBuilder, lineList);
        System.out.print(stringBuilder.toString());
    }

    private void appendSubwayLineListLog(StringBuilder stringBuilder, List<Line> lineList){
        for(Line line : lineList){
            stringBuilder.append(StationManagementViewComponent.getFinishPrefixComponent());
            stringBuilder.append(line.getName());
            stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
            appendStationsInLine(stringBuilder, line);
            stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        }
    }

    private void appendStationsInLine(StringBuilder stringBuilder, Line line){
        for(Station station : line.getStations()){
            stringBuilder.append(StationManagementViewComponent.getFinishPrefixComponent());
            stringBuilder.append(station.getName());
            stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        }
    }
}
