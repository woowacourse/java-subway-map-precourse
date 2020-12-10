package subway.exception;

import subway.view.OutputView;

/**
 * 커스텀 예외 처리 클래스
 */
public class SubwayCustomException extends IllegalArgumentException {

    public SubwayCustomException(String message) {
        super(OutputView.showErrorMessage(message));
        System.out.println();
    }
}
