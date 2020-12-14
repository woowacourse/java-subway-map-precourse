package subway.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static subway.utils.Constant.*;

public class ValidateMainSelect {

    public static void validateMainSelect(String inputMainSelect) {
        List<String> mainSelects = new ArrayList<>(Arrays.asList(CONTENTS_NUMBER_FIRST,
                CONTENTS_NUMBER_SECOND, CONTENTS_NUMBER_THIRD, CONTENTS_NUMBER_FOURTH, CONTENTS_NUMBER_QUIT));
        if (!mainSelects.contains(inputMainSelect)) {
            throw new IllegalArgumentException("[ERROR] 잘못 입력하였습니다");
        }
    }
}
