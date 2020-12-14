package subway.view.navigationViews;

import subway.view.OutputView;
import subway.view.ViewStrategy;
import subway.view.ViewsContainer;
import subway.view.executeViews.exit.ExitView;

import java.util.Scanner;

public abstract class NavigationViewTemplate {
    private static final String NOT_EXIST = "존재하지 않는 보기입니다.";
    protected final Scanner scanner;
    private final ViewsContainer views;
    protected ViewStrategy viewStrategy;

    public NavigationViewTemplate(Scanner scanner) {
        this.scanner = scanner;
        this.views = setViewsContainer();
    }

    //선택 사항의 뷰를 담는 컨테이너를 구현하게끔 한다.
    protected abstract ViewsContainer setViewsContainer();

    public void show() {
        selectView();
        viewStrategy.execute();
        OutputView.enter();
    }

    private void selectView() {
        OutputView.selectView(navViewName());
        OutputView.printMessage(views.navigate());
        String viewKey = scanner.nextLine();
        viewStrategy = views.getView(viewKey);
        if (viewStrategy == null) {
            OutputView.errorView(NOT_EXIST);
            selectView();
        }
    }

    protected boolean isExit(){
        return viewStrategy instanceof ExitView;
    }

    //화면의 이름을 리턴하게 한다. (예 : 메인화면)
    protected abstract String navViewName();
}
