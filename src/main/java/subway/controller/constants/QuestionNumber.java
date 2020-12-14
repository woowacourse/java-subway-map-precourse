package subway.controller.constants;

import java.util.Scanner;

public enum QuestionNumber {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    BACK("B"),
    TERMINATE("Q");

    private String option;

    QuestionNumber(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
