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
    private static final int ZERO = 48;
    private static final int NINE = 57;


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
        line.addStations(upstreamStation, downstreamStation);
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
        if (!isValidStreamStationName(upstreamStation=InputView.upstreamStationName())) {
            return false;
        }
        if (!isValidStreamStationName(downstreamStation=InputView.downstreamStationName())) {
            return false;
        }
        return true;
    }

    private boolean isValidStreamStationName(String s) {
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
        LineRepository.printLines();
        System.out.println();
        return true;
    }

    public Boolean registerSection() {
        if (!isExistLine()) {
            return false;
        }
        if (!isValidStationNameLength()) {
            return false;
        }
        if (!isValidOrder()) {
            return false;
        }
        boolean result = LineRepository.searchByName(lineName).addStation(Integer.parseInt(order), stationName);
        OutputViewOfInfo.registerSectionComplete();
        return result;
    }

    private boolean isExistLine() {
        lineName = InputView.registerLineInSection();
        if (!LineRepository.isExistLine(lineName)) {
            OutputViewOfError.isNotExistLine();
            return false;
        }
        return true;
    }

    private boolean isValidStationNameLength() {
        stationName = InputView.registerStationInSection();
        if (stationName.length() < MIN_NAME_LENGTH) {
            OutputViewOfError.isNotValidNameLength();
            return false;
        }
        return true;
    }

    private boolean isValidOrder() {
        order = InputView.registerOrderInSection();
        if (isNum(order) && Integer.parseInt(order) >= 1 // 상행 종점으로 추가 될 경우 1부터 가능하다.
                && Integer.parseInt(order) <= LineRepository.searchByName(lineName).getStations().size()+1){ // 하행 종점으로 구간 추가될 경우 노선에 등록된 역 개수 +1 이 된다.
            return true;
        }
        OutputViewOfError.isNotValidOrder();
        return false;
    }

    private boolean isNum(String order) {
        return order.chars().allMatch(this::isDigit);
    }

    private boolean isDigit(int c) {
        return ZERO <= c && c <= NINE;
    }

    public Boolean deleteSection() {
        String lineName = InputView.deleteLineInSection();
        String stationName = InputView.deleteStationInSection();
        Line deleteLine = LineRepository.searchByName(lineName);
        boolean result = LineRepository.deleteStationByName(deleteLine, stationName);
        if (result) {
            OutputViewOfInfo.deleteSectionComplete();
        }
        if (!result) {
            OutputViewOfError.cannotDeleteError();
        }
        return result;
    }

    public Boolean back() {
        return true;
    }

}
