package subway.service.output;

import subway.exception.ErrorCode;

public interface OutputService {
    String MAIN = "## 메인 화면";
    String MAIN_ONE = "1. 역 관리";
    String MAIN_TWO = "2. 노선 관리";
    String MAIN_THREE = "3. 구간 관리";
    String MAIN_FOUR = "4. 지하철 노선도 출력";
    String MAIN_QUIT = "Q. 종료";
    String CHOOSE_FUNCTION = "## 원하는 기능을 선택하세요.";
    String ENTER = "\n";

    void printMain();
    void printError(ErrorCode errorCode);
}
