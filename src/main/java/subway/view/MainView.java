package subway.view;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class MainView {
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

    public void selectMainMenu() {
        Message.printMainMenu();
        selectMenu(input.nextMainButton());
    }

    private void selectMenu(final String button) {
        if (isEnd(button)) {
            return;
        }
        selectStationMenu(button);
        selectLineMenu(button);
        selectSectionMenu(button);
        selectSubwayLineMenu(button);

        loopMainMenu();
    }

    private boolean isEnd(String button) {
        return button.equals(Button.END);
    }

    private void loopMainMenu() {
        Message.printLine();
        selectMainMenu();
    }

    private void selectStationMenu(final String button) {
        if (button.equals(Button.ONE)) {
            stationView.selectStationMenu();
        }
    }

    private void selectLineMenu(final String button) {
        if (button.equals(Button.TWO)) {
            lineView.selectLineMenu();
        }
    }

    private void selectSectionMenu(final String button) {
        if (button.equals(Button.THREE)) {
            sectionView.selectSectionMenu();
        }
    }

    private void selectSubwayLineMenu(final String button) {
        if (button.equals(Button.FOUR)) {
            subwayLineView.showSubwayLine();
        }
    }
}
