package subway.view;

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

    public void ask(int selection) {
        System.out.println(ScriptUtils.ASK_ANSWER_FOR[category.ordinal()][selection-1]);
    }

    public String inputName(Scanner scanner, int selection) {
        String input = scanner.nextLine();
        try {
            validateName(input);
            return duplicateName(input, selection);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String duplicateName(String input, int selection) {
        boolean notDuplicate = StationRepository.findNoStation(input);
        if (!notDuplicate && selection == ADD) {
            throw new IllegalArgumentException(ScriptUtils.ERROR_DUPLICATE(category));
        }
        if (notDuplicate && selection == DELETE) {
            throw new IllegalArgumentException(ScriptUtils.ERROR_NO(category));
        }
        return input;
    }

    private void validateName(String input) {
        if (input.length() < 2) {
            throw new IllegalArgumentException(ScriptUtils.ERROR_TOO_SHORT(category));
        }
    }
}
