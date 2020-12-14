package subway.view;

import subway.model.ResultDto;
import subway.model.Status;
import subway.utils.ErrorUtils;
import subway.utils.InputValidator;

/**
 * 이 클래스는 일반적인 입력을 받는 뷰 클래스입니다.
 * 모든 일반적인 입력을 받는 뷰은 이 클래스를 상속받아 사용합니다.
 * 예 ) 역 등록, 역 삭제, 노선 등록, 노선 삭제 등등
 */
public abstract class GeneralView extends AbstractView{

    public GeneralView() {
        super();
    }

    protected String inputMoreThanTwoWords(String guideMessage) {
        return (String) ErrorUtils.repeatInputUntilNoException(() -> {
            println(guideMessage);
            String input = scanner.nextLine();
            InputValidator.validateMoreThanTwoWords(input);
            return input;
        });
    }

    protected int inputNumber(String guideMessage) {
        return (int) ErrorUtils.repeatInputUntilNoException(() -> {
            println(guideMessage);
            String input = scanner.nextLine();
            int result = Integer.parseInt(input);
            InputValidator.validatePositiveNumber(result);
            return result;
        });
    }

    protected void processRequestResult(ResultDto result) {
        println(result.getMessage());
        isBadResult(result);
    }

    private void isBadResult(ResultDto resultDto) {
        if (resultDto.getStatus() == Status.BAD) {
            throw new IllegalArgumentException(resultDto.getMessage());
        }
    }
}
