package subway.common;

import subway.main.validation.CheckValidOption;
import subway.view.InputView;
import subway.view.MainOutputView;

import java.util.List;

public class SelectOption {
    public static char choice(List<Character> optionList, InputView inputView) {
        char option;
        while (true) {
            try {
                MainOutputView.askOptionChoice();
                option = inputView.selectOption();
                CheckValidOption.validation(option, optionList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return option;
    }
}
