package subway.view;

import subway.dto.LineDTO;
import subway.dto.StationDTO;
import subway.view.selection.Selection;
import subway.view.selection.Selections;

import java.util.List;

public class OutputView {
    private static final String SHARP_PREFIX = "## ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String MENU_FORMAT = "%s. %s";
    private static final String BORDERLINE = "---";
    private static final String SUBWAY_MAP = "지하철 노선도";

    public static void showErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
        newLine();
    }

    public static void showMenu(Selections selections, String viewName) {
        printWithSharpPrefix(viewName);
        for (Selection selection : selections.toList()) {
            System.out.println(String.format(MENU_FORMAT, selection.getValue(), selection.getDescription()));
        }
        newLine();
    }

    public static void printWithSharpPrefix(String string) {
        System.out.println(SHARP_PREFIX + string);
    }

    public static void printResponseMessage(String string) {
        System.out.println(INFO_PREFIX + string);
    }

    public static void showSubwayMap(List<LineDTO> Lines) {
        printWithSharpPrefix(SUBWAY_MAP);

        for (LineDTO line : Lines) {
            OutputView.printResponseMessage(line.getName());
            printResponseMessage(BORDERLINE);
            line.getStations().stream()
                    .map(StationDTO::getName)
                    .forEach(OutputView::printResponseMessage);
            newLine();
        }
    }

    public static void newLine() {
        System.out.println();
    }
}
