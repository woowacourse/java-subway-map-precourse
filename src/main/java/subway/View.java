package subway;

import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mainView() {
        MainQuestion.printQuestions();
        String x = scanner.nextLine();
        MainQuestion.findByAnswerCode(x).nextAction(this);
    }

    public void stationView() {
        StationQuestion.printQuestions();
        String x = scanner.nextLine();
        StationQuestion.findByAnswerCode(x).nextAction(this);
    }

    public void lineView() {
        LineQuestion.printQuestions();
        String x = scanner.nextLine();
        LineQuestion.findByAnswerCode(x).nextAction(this);
    }

    public void sectionView() {
        SectionQuestion.printQuestions();
        String x = scanner.nextLine();
        SectionQuestion.findByAnswerCode(x).nextAction(this);
    }
}
