package subway.view;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class StationView {
    private final Input input;

    public StationView(Input input) {
        this.input = input;
    }

    public void selectStationMenu() {
        Message.printStatinMenu();
        selectMenu(input.nextStationButton());
    }

    private void selectMenu(String button) {
        if (isBack(button)) {
            return;
        }
        registerStation(button);
        deleteStation(button);
        readStations(button);
    }

    private boolean isBack(String button) {
        return button.equals(Button.BACK);
    }

    private void registerStation(String button) {
        if (button.equals(Button.ONE)) {
        }
    }

    private void deleteStation(String button) {
        if (button.equals(Button.TWO)) {
        }
    }

    private void readStations(String button) {
        if (button.equals(Button.THREE)) {
        }
    }
}
