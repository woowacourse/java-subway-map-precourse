package subway.view.output.util;

import subway.type.ExceptionType;

/**
 * FeatureChoiceExceptionView.java : 화면 기능 선택 예외 처리 문구 출력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class FeatureChoiceExceptionView {
    public static void printInvalidFeatureChoiceException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_FEATURE_CHOICE.getException());
    }

    public static boolean printInvalidChoiceException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_FEATURE_CHOICE.getException());
        return false;
    }
}
