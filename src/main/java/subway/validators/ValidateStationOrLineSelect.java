package subway.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static subway.utils.Constant.*;

public class ValidateStationOrLineSelect {
    public static void validateStationOrLineSelect(String inputStationOrLineSelect) {
        List<String> mainSelects = new ArrayList<>(Arrays.asList(CONTENTS_NUMBER_FIRST,
                CONTENTS_NUMBER_SECOND, CONTENTS_NUMBER_THIRD, CONTENTS_NUMBER_BACK));
        if (!mainSelects.contains(inputStationOrLineSelect)) {
            throw new IllegalArgumentException("[ERROR] 잘못 입력하였습니다");
        }
    }
}
