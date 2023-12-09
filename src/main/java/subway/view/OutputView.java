package subway.view;

import static subway.view.OutputView.OutputMessage.ADD_STATION_SUCCESS;
import static subway.view.OutputView.OutputMessage.FIND_STATION_SUCCESS;
import static subway.view.OutputView.OutputMessage.INFO;
import static subway.view.OutputView.OutputMessage.REMOVE_STATION_SUCCESS;

import java.util.List;
import subway.domain.Station;

public class OutputView {

    public void printAddStation() {
        System.out.println(ADD_STATION_SUCCESS.getMessage());
    }

    public void printRemoveStation() {
        System.out.println(REMOVE_STATION_SUCCESS.getMessage());
    }

    public void printAllStations(List<Station> stations) {
        System.out.println(FIND_STATION_SUCCESS.getMessage());
        stations.forEach(station -> System.out.println(String.format(INFO.getMessage(), station.getName())));
        System.out.println();
    }

    protected enum OutputMessage {
        ADD_STATION_SUCCESS("[INFO] 지하철 역이 등록되었습니다."),
        REMOVE_STATION_SUCCESS("[INFO] 지하철 역이 삭제되었습니다."),
        FIND_STATION_SUCCESS("## 역 목록"),
        INFO("[INFO] %s"),
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
