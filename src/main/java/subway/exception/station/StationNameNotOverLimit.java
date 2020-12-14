package subway.exception.station;

import subway.util.PrintUtils;

public class StationNameNotOverLimit extends StationException {

    @Override
    public void printError() {
        PrintUtils.printError(super.getHeader() + "역 이름은 두 글자 이상이어야 합니다.");
    }
}
