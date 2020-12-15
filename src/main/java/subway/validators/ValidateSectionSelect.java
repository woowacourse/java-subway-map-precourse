package subway.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static subway.utils.Constant.*;
import static subway.utils.Constant.CONTENTS_NUMBER_BACK;

public class ValidateSectionSelect {
    public static void validateSectionSelect(String inputSectionSelect) {
        List<String> mainSelects = new ArrayList<>(Arrays.asList(CONTENTS_NUMBER_FIRST,
                CONTENTS_NUMBER_SECOND, CONTENTS_NUMBER_BACK));
        if (!mainSelects.contains(inputSectionSelect)) {
            throw new IllegalArgumentException("[ERROR] 잘못 입력하였습니다");
        }
    }
}
