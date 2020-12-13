package subway.utils;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.menu.MainMenu;
import subway.menu.MenuFeature;
import subway.menu.MenuModel;

import java.util.regex.Pattern;

public class Validator {

    public static final int STATION_NAME_LENGTH_MINIMUM = 2;

    public static void menu (Class<? extends MenuModel> menuType, String input) {
        if (!MenuFeature.exist(menuType, input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    public static void registerStation (String name) {
        validateStationName(name);
        if (StationRepository.exists(name)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 역입니다.");
        }
    }

    public static void removeStation (String name) {
        validateStationName(name);
        if (!StationRepository.exists(name)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    private static void validateStationName (String name) {
        String regExp =  "^[a-zA-Z가-힣0-9]*[역|station|Station|STATION]$";
        if (name.length() < STATION_NAME_LENGTH_MINIMUM) {
            throw new IllegalArgumentException("[ERROR] 역 이름은 두글자 이상이어야 합니다.");
        }
        if (!Pattern.matches(regExp, name)) {
            throw new IllegalArgumentException("[ERROR] 이름은 자음 모음이 결합된 한글, 숫자, 영어로 이루어져 있고 '역' 이나 'station' 으로 끝나야 합니다.");
        }
    }


}
