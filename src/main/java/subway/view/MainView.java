package subway.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import subway.Subway;
import subway.util.Constants;
import subway.util.MessageUtils;

public class MainView {

    private boolean isRunning = true;
    private Scanner scanner;
    private Subway subway;
    private LineView lineView;
    private StationView stationView;
    private SectionView sectionView;

    private String menuState = Constants.MAIN_MENU_STATE;

    private Map<String, Runnable> menuActionMap;


    public MainView(Scanner scanner, Subway subway) {
        this.subway = subway;
        this.scanner = scanner;
        this.lineView = new LineView(subway, this.scanner);
        this.stationView = new StationView(subway, this.scanner);
        this.sectionView = new SectionView(subway, this.scanner);

        menuActionMap = Map.of(
            "1", stationView::start,
            "2", lineView::start,
            "3", sectionView::start,
            "4", this::showWholeSubwayMap,
            Constants.EXIT_INPUT_CHARACTER, this::goBackward
        );
    }

    public void start() {
        isRunning = true;
        while (isRunning) {
            menuSelector();
        }
    }

    private void menuSelector() {
        MessageUtils.printMenu(Constants.MENU_GROUPS.get(Constants.MAIN_MENU_STATE));
        MessageUtils.printInputAnnouncement(Constants.ANNOUNCEMENT_FEATURE_SELECT_COMMENT);

        String input = scanner.next().toUpperCase();
        MessageUtils.printBlankLine();
        Runnable action = menuActionMap.get(input);

        if (action == null) {
            MessageUtils.printError(Constants.INVALID_STRING_OUTPUT_COMMENT);
            return;
        }
        action.run();
    }

    public void showWholeSubwayMap() {
        MessageUtils.printBlankLine();
        MessageUtils.printInputAnnouncement(Constants.TITLE_WHOLE_SUBWAY_MAP_TEXT);
        Map<String, List> wholeSubwayMap = subway.getSectionRepository().findAll();
        for (String lineTitle : wholeSubwayMap.keySet()) {
            MessageUtils.printInfo(lineTitle);
            MessageUtils.printInfo(Constants.SEPARATE_STRING_WHOLE_SUBWAY_MAP_TEXT);
            for (Object stationTitle : wholeSubwayMap.get(lineTitle)) {
                MessageUtils.printInfo((String) stationTitle);
            }
            MessageUtils.printBlankLine();
        }
    }

    public void goBackward() {
        isRunning = false;
    }
}
