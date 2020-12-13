package subway.view.output;

import subway.type.ExceptionType;

public class ExceptionView {
    public static void printInvalidFeatureChoiceException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_FEATURE_CHOICE.getException());
    }
}
