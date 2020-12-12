package subway.userinterface;

import subway.domain.MenuRepository;

public class Error {
    private static final String ERROR = "[ERROR] ";

    public static boolean isWrongMainMenuInput(String input) {
        boolean status = MenuRepository.mainMenuButtons.stream().noneMatch(button -> button.equals(input));
        if (status) {
            System.out.println(ERROR + "선택할 수 없는 기능입니다.");
        }
        return status;
    }
}
