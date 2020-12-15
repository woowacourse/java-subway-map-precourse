package subway.view.output.util;

import subway.type.ExceptionType;

public class FeatureExceptionView {
    public static void printInvalidFeatureChoiceException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_FEATURE_CHOICE.getException());
    }
}
