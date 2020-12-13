package subway.view;

import java.util.Arrays;
import java.util.List;
import subway.console.Button;
import subway.console.Input;
import subway.console.Output;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class MainView {
    private static final List<String> MAIN_PAGE = Arrays.asList(
            "## 메인 화면",
            "1. 역 관리",
            "2. 노선 관리",
            "3. 구간 관리",
            "4. 지하철 노선도 출력",
            "Q. 종료",
            "\n## 원하는 기능을 선택하세요.");
    private static final List<String> MAIN_BUTTONS = Arrays.asList("1", "2", "3", "4", "Q");

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
        Output.printPage(MAIN_PAGE);
        selectPage(input.nextButton(MAIN_BUTTONS));
    }

    private void selectPage(final String button) {
        if (isEnd(button)) {
            return;
        }
        selectStationPage(button);
        selectLinePage(button);
        selectSectionPage(button);
        selectSubwayLinePage(button);

        loopMainPage();
    }

    private boolean isEnd(String button) {
        return button.equals(Button.END);
    }

    private void loopMainPage() {
        Output.printBlankLine();
        selectMainPage();
    }

    private void selectStationPage(final String button) {
        if (button.equals(Button.ONE)) {
            stationView.selectStationPage();
        }
    }

    private void selectLinePage(final String button) {
        if (button.equals(Button.TWO)) {
            lineView.selectLinePage();
        }
    }

    private void selectSectionPage(final String button) {
        if (button.equals(Button.THREE)) {
            sectionView.selectSectionPage();
        }
    }

    private void selectSubwayLinePage(final String button) {
        if (button.equals(Button.FOUR)) {
            subwayLineView.showSubwayLine();
        }
    }
}
