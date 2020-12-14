package subway.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import subway.Subway;
import subway.model.MenuGroup.Menu;
import subway.util.Constants;
import subway.util.MessageUtils;

public class MainView extends AbstractView {

    private LineView lineView;
    private StationView stationView;
    private SectionView sectionView;

    private Map<String, Runnable> menuActionMap;

    public MainView(Subway subway, Scanner scanner) {
        super(subway, scanner);
    }

    @Override
    public void initView() {
        this.lineView = new LineView(subway, this.scanner);
        this.stationView = new StationView(subway, this.scanner);
        this.sectionView = new SectionView(subway, this.scanner);

        menuActionMap = Map.of(
            "1", stationView::start,
            "2", lineView::start,
            "3", sectionView::start,
            "4", this::showWholeSubway,
            Constants.EXIT_INPUT_CHARACTER, this::goBackward
        );
    }

    @Override
    public Menu getMenu() {
        return Constants.MENU_GROUPS.get(Constants.MAIN_MENU_STATE);
    }

    @Override
    public Map<String, Runnable> getMenuActionMap() {
        return menuActionMap;
    }

    public void showWholeSubway() {
        MessageUtils.printAnnouncement(Constants.TITLE_SUBWAY_MAP);
        Map<String, List<String>> wholeSubwayMap = subway.getSectionRepository().findAll();
        for (String lineTitle : wholeSubwayMap.keySet()) {
            MessageUtils.printInfoEntry(lineTitle);
            MessageUtils.printInfoEntry(Constants.SEPARATE_STRING_SUBWAY_MAP);
            for (Object stationTitle : wholeSubwayMap.get(lineTitle)) {
                MessageUtils.printInfoEntry((String) stationTitle);
            }
            MessageUtils.printBlankLine();
        }
    }
}
