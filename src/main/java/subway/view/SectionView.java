package subway.view;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class SectionView {
    private final Input input;

    public SectionView(final Input input) {
        this.input = input;
    }

    public void selectLineMenu(final String button) {
        if (isBack(button)) {
            return;
        }

        registerSection(button);
        deleteSection(button);
    }

    private boolean isBack(String button) {
        return button.equals(Button.BACK);
    }

    private void registerSection(String button) {
        if (button.equals(Button.ONE)) {
        }
    }

    private void deleteSection(String button) {
        if (button.equals(Button.TWO)) {
        }
    }
}
