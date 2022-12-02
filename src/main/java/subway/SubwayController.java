package subway;

public class SubwayController {

    public void subwayRun() {
        while (true) {
            for (MainMessages value : MainMessages.values()) {
                System.out.printf(value.getSelectNumber() + value.getMessage() + "\n");
            }
            String input = InputView.getInput();
            if (isQuit(input)) {
                break;
            }
        }
    }

    private boolean isQuit(String input) {
        return input.equals("Q");
    }
}
