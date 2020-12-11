package subway.view;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class LineView {
    private final Input input;

    public LineView(final Input input) {
        this.input = input;
    }

    public void selectLineMenu() {
        Message.printLineMenu();
        selectMenu(input.nextLineButton());
    }

    private void selectMenu(final String button) {
        if (isBack(button)) {
            return;
        }
        registerLine(button);
        deleteLine(button);
        readLine(button);
    }

    private boolean isBack(final String button) {
        return button.equals(Button.BACK);
    }

    private void registerLine(String button) {
        if (button.equals(Button.ONE)) {
        }
    }

    private void deleteLine(String button) {
        if (button.equals(Button.TWO)) {
        }
    }

    private void readLine(String button) {
        if (button.equals(Button.THREE)) {
        }
    }
}
