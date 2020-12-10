package subway.view.screen;

import java.util.List;
import subway.ActionType;
import subway.CategoryType;
import subway.utils.ErrorUtils;
import subway.view.InputView;
import subway.view.OutputView;

public class ManagementScreen implements Screen {

    public static final String MANAGEMENT_SCREEN_MESSAGE = "관리 화면";

    public CategoryType selectedCategoryType;

    public ManagementScreen(CategoryType selectedCategoryType) {
        this.selectedCategoryType = selectedCategoryType;
    }

    @Override
    public void visualize() {
        OutputView.printTitle(selectedCategoryType.getName() + SPACE + MANAGEMENT_SCREEN_MESSAGE);
        List<ActionType> actionOrder = selectedCategoryType.getActionOrder();
        for (int i = 1; i <= actionOrder.size(); i++) {
            OutputView.println(i + COMMA + actionOrder.get(i - 1).getName() + MANAGEMENT_MESSAGE);
        }

        OutputView.println(InputView.BACK_COMMAND + COMMA + ActionType.BACK.getName());
    }

    @Override
    public void logic(InputView inputView) {
        int actionOrderCommandNumber = (int) ErrorUtils.repeatingUntilNoException(() -> {
            OutputView.printTitle(Screen.SELECT_CATEGORY_MESSAGE);
            return inputView.readActionOrderCommandNumber(selectedCategoryType);
        });

        if (actionOrderCommandNumber == InputView.BACK) {
            ScreenManager.goBack();
            return;
        }

        ActionType actionType = selectedCategoryType.getActionOrder().get(actionOrderCommandNumber - 1);
    }
}
