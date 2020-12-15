package subway.exception.line;

import subway.util.PrintUtils;

public class AllStationListIsNotExistException extends LineException {

    public void printError() {
        PrintUtils.printError(super.getHeader() + "노선에 등록할 역이 존재하지 않습니다.");
    }
}
