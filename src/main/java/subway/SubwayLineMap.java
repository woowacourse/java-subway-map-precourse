package subway;

import subway.view.MainViewState;
import subway.view.ViewState;

import java.util.Scanner;

public class SubwayLineMap {
    private ViewState viewState = MainViewState.getMainView();
    private Scanner scanner;

    public SubwayLineMap(Scanner scanner){
        this.scanner = scanner;
    }

    public void run(){
        startMainLoop();
    }

    private void startMainLoop(){
        boolean continuable = true;
        while(continuable){
            viewState.render(scanner, this);
            continuable = viewState.isContinuable();
        }
    }

    public void setViewState(ViewState viewState){
        this.viewState = viewState;
    }
}
