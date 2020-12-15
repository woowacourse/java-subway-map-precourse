package subway.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.repository.StationRepository;
import utils.Category;
import utils.ScriptUtils;

public class DetailView {
    private Category category;
    private int ADD = 1;
    private int DELETE = 2;

    public DetailView(Category category) {
        this.category = category;
    }

    public String ask(Scanner scanner, int selection) {
        System.out.println(ScriptUtils.ASK_ANSWER_FOR(category, selection));
        return inputName(scanner);
    }

    public String additionalAsk(Scanner scanner, String ask) {
        if (category == Category.LINE) {
            System.out.println(ask);
            String answer = inputName(scanner);
            return answer;
        }
        return null;
    }

    public String inputName(Scanner scanner) {
        String input = scanner.nextLine();
        try {
            return validateName(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String  validateName(String input) {
        if (input.length() < 2) {
            throw new IllegalArgumentException(ScriptUtils.ERROR_TOO_SHORT(category));
        }
        return input;
    }
}
