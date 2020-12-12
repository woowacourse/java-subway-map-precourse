package subway.service;

import subway.option.BaseOption;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class BaseService {
    private static final String ERROR_INVALID_CHOICE = "선택할 수 없는 기능입니다.";

    public static void getUserChoiceWithinOptionList(List<BaseOption> optionList, String header) {
        try {
            showSelectionOptionsScreen(header, optionList);
            executeNextActionBySelectedOption(optionList, InputView.getAnswer());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            getUserChoiceWithinOptionList(optionList, header);
        }
    }

    private static void showSelectionOptionsScreen(String header, List<BaseOption> optionList) {
        OutputView.printHeader(header);
        OutputView.printQuestionOptions(optionList.stream().map(BaseOption::getOption));
        OutputView.printChooseOptionMessage();
    }

    private static void executeNextActionBySelectedOption(List<BaseOption> optionList, String inputCode) {
        findByCode(optionList, inputCode).nextAction();
    }

    private static BaseOption findByCode(List<BaseOption> optionList, String inputCode) {
        return optionList.stream()
                .filter(option -> option.hasCode(inputCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_CHOICE));
    }
}
