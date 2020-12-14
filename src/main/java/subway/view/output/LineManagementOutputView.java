package subway.view.output;

import subway.domain.Line;
import subway.view.component.CommonViewComponent;
import subway.view.component.LineManagementViewComponent;
import subway.view.component.StationManagementViewComponent;
import subway.view.component.common.OutputViewComponent;

import java.util.List;

public class LineManagementOutputView {
    public static void printMenuLog(){
        OutputViewComponent.printLogWithWhiteSpace(LineManagementViewComponent.getMenuComponent());
    }

    public static void printRegisterFinishLog(){
        OutputViewComponent.printLogWithWhiteSpace(LineManagementViewComponent.getRegisterFinishComponent());
    }

    public static void printLineRemoveFinishLog(){
        OutputViewComponent.printLogWithWhiteSpace(LineManagementViewComponent.getRemoveLineFinishComponent());
    }

    public static void printLineListLog(List<Line> lineList){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LineManagementViewComponent.getSubwayLineListLog());
        stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        appendSubwayLineMapLog(stringBuilder, lineList);
        System.out.println(stringBuilder.toString());
    }

    private static void appendSubwayLineMapLog(StringBuilder stringBuilder, List<Line> lineList){
        for(Line line : lineList){
            stringBuilder.append(StationManagementViewComponent.getFinishPrefixComponent());
            stringBuilder.append(line.getName());
            stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        }
    }
}
