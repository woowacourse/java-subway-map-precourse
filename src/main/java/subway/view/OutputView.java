package subway.view;

import static subway.view.OutputView.OutputMessage.ADD_STATION_SUCCESS;
import static subway.view.OutputView.OutputMessage.FIND_STATION_SUCCESS;
import static subway.view.OutputView.OutputMessage.INFO;
import static subway.view.OutputView.OutputMessage.REMOVE_STATION_SUCCESS;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;

public class OutputView {

    public void printAddStation() {
        System.out.println(String.format(INFO.getMessage(), ADD_STATION_SUCCESS.getMessage()));
    }

    public void printRemoveStation() {
        System.out.println(String.format(INFO.getMessage(), REMOVE_STATION_SUCCESS.getMessage()));
    }

    public void printAllStations(List<Station> stations) {
        System.out.println(FIND_STATION_SUCCESS.getMessage());
        stations.forEach(station -> System.out.println(String.format(INFO.getMessage(), station.getName())));
        System.out.println();
    }

    public void printAddLine() {
        System.out.println(String.format(INFO.getMessage(), "지하철 노선이 등록되었습니다."));
    }

    public void printRemoveLine() {
        System.out.println(String.format(INFO.getMessage(), "지하철 노선이 삭제되었습니다."));
    }

    public void printAllLine(List<Line> lines) {
        System.out.println("## 노선 목록");
        lines.forEach(line -> System.out.println(String.format(INFO.getMessage(), line.getName())));
        System.out.println();
    }

    public void printAddSection() {
        System.out.println(String.format(INFO.getMessage(), "구간이 등록되었습니다."));
    }

    protected enum OutputMessage {
        ADD_STATION_SUCCESS("지하철 역이 등록되었습니다."),
        REMOVE_STATION_SUCCESS("지하철 역이 삭제되었습니다."),
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
