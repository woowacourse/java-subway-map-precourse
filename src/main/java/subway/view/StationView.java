package subway.view;

import java.util.Arrays;
import java.util.List;
import subway.controller.StationController;
import subway.domain.Station;
import subway.message.Message;
import subway.message.Output;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class StationView {
    private static final List<String> STATION_PAGE = Arrays.asList(
            "\n## 역 관리 화면",
            "1. 역 등록",
            "2. 역 삭제",
            "3. 역 조회",
            "B. 돌아가기",
            "\n## 원하는 기능을 선택하세요.");
    private static final List<String> STATION_BUTTONS = Arrays.asList("1", "2", "3", "B");

    private final Input input;
    private final StationController stationController;

    public StationView(Input input) {
        this.input = input;
        this.stationController = new StationController();
    }

    public void selectStationPage() {
        String button = inputButton();
        while (isEndStationPage(button)) {
            button = inputButton();
        }
    }

    private String inputButton() {
        Output.printPage(STATION_PAGE);
        return input.nextButton(STATION_BUTTONS);
    }

    private boolean isEndStationPage(String button) {
        return !isCreate(button)
                && !isDelete(button)
                && !isRead(button)
                && !isBack(button);
    }

    private boolean isCreate(String button) {
        if (button.equals(Button.ONE)) {
            return isCreateStation();
        }
        return false;
    }

    private boolean isCreateStation() {
        Message.printCreateStation();
        String name = input.nextStation();
        if (input.validName(name)) {
            if (stationController.createStation(name)) {
                Message.printSuccessStation();
                return true;
            }
        }
        return false;
    }

    private boolean isDelete(String button) {
        if (button.equals(Button.TWO)) {
            return isDeleteStation();
        }
        return false;
    }

    private boolean isDeleteStation() {
        Message.printDeleteStation();
        if (stationController.deleteStation(input.nextStation())) {
            Message.deleteStationInfo();
            return true;
        }
        return false;
    }

    private boolean isRead(String button) {
        if (button.equals(Button.THREE)) {
            readStations();
            return true;
        }
        return false;
    }

    private void readStations() {
        Output.printStations(stationController.getStations());
    }

    private boolean isBack(String button) {
        return button.equals(Button.BACK);
    }
}
