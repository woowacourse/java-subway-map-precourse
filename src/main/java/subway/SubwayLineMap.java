package subway;

import subway.view.MainViewState;
import subway.view.ViewState;

public class SubwayLineMap {
    private ViewState viewState = MainViewState.getMainView();

    public SubwayLineMap() {
    }

    public void run() {
        startMainLoop();
    }

    private void startMainLoop() {
        boolean continuable = true;
        while (continuable) {
            viewState.render(this);
            continuable = viewState.isContinuable();
        }
    }

    public void setViewState(ViewState viewState) {
        this.viewState = viewState;
    }
}
