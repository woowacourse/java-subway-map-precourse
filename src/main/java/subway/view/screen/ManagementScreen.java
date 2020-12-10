package subway.view.screen;

import java.util.List;
import subway.ActionType;
import subway.CategoryType;
import subway.HandlerMapping;
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
            OutputView.println(
                i + COMMA + selectedCategoryType.getName() + SPACE + actionOrder.get(i - 1).getName());
        }

        OutputView.println(InputView.BACK_COMMAND.toUpperCase() + COMMA + ActionType.BACK.getName());
    }

    @Override
    public void logic(InputView inputView) {
        int actionOrderCommandNumber = getActionOrderCommandNumber(inputView);
        if (actionOrderCommandNumber == InputView.BACK) {
            ScreenManager.goBack();
            return;
        }

        ActionType actionType = selectedCategoryType.getActionOrder()
            .get(actionOrderCommandNumber - 1);

        HandlerMapping.mapping(selectedCategoryType, actionType);
    }

    public int getActionOrderCommandNumber(InputView inputView) {
        return (int) ErrorUtils.repeatingUntilNoException(() -> {
            OutputView.printTitle(Screen.SELECT_CATEGORY_MESSAGE);
            return inputView.readActionOrderCommandNumber(selectedCategoryType);
        });
    }
}
