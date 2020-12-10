package subway.view.screen.action;

import subway.CategoryType;
import subway.view.InputView;
import subway.view.screen.Screen;
import subway.view.screen.ScreenManager;

public abstract class BaseActionScreen implements Screen {

    public CategoryType selectedCategoryType;

    public BaseActionScreen(CategoryType selectedCategoryType) {
        this.selectedCategoryType = selectedCategoryType;
    }

    @Override
    public void logic(InputView inputView) {
        action(inputView);
        ScreenManager.goToFirstScreen();
    }

    protected abstract void action(InputView inputView);
}
