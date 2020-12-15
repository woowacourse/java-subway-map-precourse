package subway.view;

import static subway.console.Button.END;
import static subway.console.Button.FOUR;
import static subway.console.Button.ONE;
import static subway.console.Button.THREE;
import static subway.console.Button.TWO;

import java.util.Arrays;
import java.util.List;
import subway.console.Input;
import subway.console.Output;
import subway.console.Page;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class MainView {
    private static final List<String> MAIN_BUTTONS = Arrays.asList(ONE, TWO, THREE, FOUR, END);

    private final Input input;
    private final StationView stationView;
    private final LineView lineView;
    private final SectionView sectionView;
    private final SubwayLineView subwayLineView;

    public MainView(Input input) {
        this.input = input;
        this.stationView = new StationView(input);
        this.lineView = new LineView(input);
        this.sectionView = new SectionView(input);
        this.subwayLineView = new SubwayLineView();
    }

    public void selectMainPage() {
        Output.printPage(Page.MAIN.getPages());
        selectPage(input.nextButton(MAIN_BUTTONS));
    }

    private void selectPage(String button) {
        while (!isEnd(button)) {
            selectStationPage(button);
            selectLinePage(button);
            selectSectionPage(button);
            selectSubwayLinePage(button);

            button = inputButton();
        }
    }

    private String inputButton() {
        Output.printBlankLine();
        Output.printPage(Page.MAIN.getPages());
        return input.nextButton(MAIN_BUTTONS);
    }

    private boolean isEnd(String button) {
        return button.equals(END);
    }

    private void selectStationPage(final String button) {
        if (button.equals(ONE)) {
            stationView.selectStationPage();
        }
    }

    private void selectLinePage(final String button) {
        if (button.equals(TWO)) {
            lineView.selectLinePage();
        }
    }

    private void selectSectionPage(final String button) {
        if (button.equals(THREE)) {
            sectionView.selectSectionPage();
        }
    }

    private void selectSubwayLinePage(final String button) {
        if (button.equals(FOUR)) {
            subwayLineView.showSubwayLine();
        }
    }
}
