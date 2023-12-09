package subway.view;

import static subway.view.OutputView.OutputMessage.ADD_STATION_SUCCESS;
import static subway.view.OutputView.OutputMessage.REMOVE_STATION_SUCCESS;

public class OutputView {

    public void printAddStation() {
        System.out.println(ADD_STATION_SUCCESS.getMessage());
    }

    public void printRemoveStation() {
        System.out.println(REMOVE_STATION_SUCCESS.getMessage());
    }

    protected enum OutputMessage {
        ADD_STATION_SUCCESS("[INFO] 지하철 역이 등록되었습니다."),
        REMOVE_STATION_SUCCESS("[INFO] 지하철 역이 삭제되었습니다."),
        ;
        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
