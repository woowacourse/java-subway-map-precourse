package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputViewOfError;
import subway.view.OutputViewOfInfo;

public class LineController {
    private static final String INQUIRY_LINE_MESSAGE = "## 역 목록";

    private static LineController lineController;
    private String lineName;
    private String stationName;
    private String order;
    private String upstreamStation;
    private String downstreamStation;
    private static final int MIN_NAME_LENGTH = 2;


    public static LineController getInstance() {
        if (lineController==null) {
            lineController = new LineController();
        }
        return lineController;
    }

    public Boolean registerLine() {
        if (!validLineInput()) {
            return false;
        }
        Line line = new Line(lineName);
        line.addStreamStation(upstreamStation, downstreamStation);
        boolean result = LineRepository.addLine(line);
        if (result) {
            OutputViewOfInfo.registerLineComplete();
        }
        return result;
    }

    private boolean validLineInput() {
        if ((lineName = InputView.registerLineName()).length() < MIN_NAME_LENGTH) {
            OutputViewOfError.isNotValidNameLength();
            return false;
        }
        if (isNotValidStreamStationName(upstreamStation=InputView.upstreamStationName())) {
            return false;
        }
        if (isNotValidStreamStationName(downstreamStation=InputView.downstreamStationName())) {
            return false;
        }
        return true;
    }

    private boolean isNotValidStreamStationName(String s) {
        if (s.length() < MIN_NAME_LENGTH) {
            OutputViewOfError.isNotValidNameLength();
            return false;
        }
        if(StationRepository.stations().stream().noneMatch(station -> station.getName().equals(s))) {
            OutputViewOfError.isNotExistStation();
            return false;
        }
        return true;
    }

    public Boolean deleteLine() {
        String name = InputView.deleteLineName();
        boolean result = LineRepository.deleteLineByName(name);
        if (result) {
            OutputViewOfInfo.deleteLineComplete();
        }
        if (!result) {
            OutputViewOfError.cannotDeleteError();
        }
        return result;
    }

    public Boolean inquiryLine() {
    }

    public Boolean back() {
    }
}
