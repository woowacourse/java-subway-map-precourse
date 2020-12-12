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
        while (!isBack(button)) {
            if (isCreate(button)) {
                break;
            }
            if (isDelete(button)) {
                break;
            }
            if (isRead(button)) {
                break;
            }
            button = inputButton();
        }
    }

    private String inputButton() {
        Output.printPage(STATION_PAGE);
        return input.nextButton(STATION_BUTTONS);
    }

    private boolean isBack(String button) {
        return button.equals(Button.BACK);
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
            return isNotExistNameCreateStation(name);
        }
        return false;
    }

    private boolean isNotExistNameCreateStation(String name) {
        if (stationController.isExist(name)) {
            Message.printIsExist();
            return false;
        }
        stationController.createStation(name);
        Message.printSuccessStation();
        return true;
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
        Message.printIsNotExist();
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
        Message.printStations();
        stationController.findAll().stream()
                .map(Station::getName)
                .forEach(Message::printStation);
    }
}
