package subway.utils;

/**
 * 입력 값들의 유효성을 판단하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/10
 */
public class ValidateUtils {

    public boolean isValidMenuSelect(String selectMenu, int bound, char quit) {
        if (selectMenu.length() > 1) {
            return false;
        }
        char selectChar = selectMenu.charAt(0);
        if (selectChar == quit || (selectChar >= '1' && selectChar <= bound + '0')) {
            return true;
        }
        return false;
    }

    public boolean isValidStationName(String stationName) {
        if (stationName.length() < 2) {
            return false;
        }
        return true;
    }

    public boolean isValidLineName(String lineName) {
        if (lineName.length() < 2) {
            return false;
        }
        if (lineName.charAt(lineName.length() - 1) != '선') {
            return false;
        }
        return true;
    }

    public boolean isValidOrder(int stationNumber, int inputOrder) {
        if (inputOrder < 0) {
            return false;
        }
        if (inputOrder > stationNumber) {
            return false;
        }
        return true;
    }
}
