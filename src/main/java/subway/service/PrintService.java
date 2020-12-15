package subway.service;

import subway.view.OutputView;

public class PrintService implements MapService {

    private OutputView outputView;

    public PrintService(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public void run() {
        outputView.printMap();
    }
}
