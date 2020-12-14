package subway.view.output;

import subway.domain.Line;
import subway.domain.Station;
import subway.view.component.CommonViewComponent;
import subway.view.component.MainViewComponent;
import subway.view.component.StationManagementViewComponent;
import subway.view.component.common.OutputViewComponent;

import java.util.List;

public class MainOutputView {
    public static void printMenuLog() {
        OutputViewComponent.printLogWithWhiteSpace(MainViewComponent.getMenu());
    }


    public static void printSubwayLineList(List<Line> lineList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MainViewComponent.getSubwayLineMap());
        stringBuilder.append(CommonViewComponent.getWhiteLine());
        appendSubwayLineListLog(stringBuilder, lineList);
        System.out.print(stringBuilder.toString());
    }

    private static void appendSubwayLineListLog(StringBuilder stringBuilder, List<Line> lineList) {
        for (Line line : lineList) {
            stringBuilder.append(StationManagementViewComponent.getFinishPrefix());
            stringBuilder.append(line.getName());
            stringBuilder.append(CommonViewComponent.getWhiteLine());
            appendStationsInLine(stringBuilder, line);
            stringBuilder.append(CommonViewComponent.getWhiteLine());
        }
    }

    private static void appendStationsInLine(StringBuilder stringBuilder, Line line) {
        for (Station station : line.getStations()) {
            stringBuilder.append(StationManagementViewComponent.getFinishPrefix());
            stringBuilder.append(station.getName());
            stringBuilder.append(CommonViewComponent.getWhiteLine());
        }
    }
}
