package subway.main.validation;

import subway.common.Prefix;

import java.util.List;

public class CheckValidOption {
    private static final String INVALID_OPTION = Prefix.ERROR.getPrefix() + "선택할 수 없는 기능입니다.";

    public static void validation(char option, List<Character> optionList) {
        if (!optionList.contains(option)) {
            throw new IllegalArgumentException(INVALID_OPTION);
        }
    }
}
