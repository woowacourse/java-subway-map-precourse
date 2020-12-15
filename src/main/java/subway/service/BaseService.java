package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.option.BaseOption;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class BaseService {
    private static final String ERROR_INVALID_CHOICE = "선택할 수 없는 기능입니다.";

    protected static void getUserChoiceWithinOptionList(List<BaseOption> optionList, String header) {
        try {
            showSelectionOptionsScreen(header, optionList);
            executeNextActionBySelectedOption(optionList, InputView.getAnswer());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            getUserChoiceWithinOptionList(optionList, header);
        }
    }

    private static void showSelectionOptionsScreen(String header, List<BaseOption> optionList) {
        OutputView.printOptionHeader(header);
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

    protected static String getStationNameByQuestion(String question) {
        OutputView.printQuestion(question);
        return InputView.getStationName();
    }

    protected static String getLineNameByQuestion(String question) {
        OutputView.printQuestion(question);
        return InputView.getLineName();
    }

    protected static Station getStationByQuestion(String question) {
        OutputView.printQuestion(question);
        return StationRepository.getStation(InputView.getStationName());
    }

    protected static Line getLineByQuestion(String question) {
        OutputView.printQuestion(question);
        return LineRepository.getLine(InputView.getLineName());
    }
}
