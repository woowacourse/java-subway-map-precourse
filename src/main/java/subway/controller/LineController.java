package subway.controller;

import subway.domain.Line;
import subway.service.LineService;
import subway.view.Input;
import subway.view.Output;

public class LineController implements IController {

    @Override
    public void save() {
        try {
            LineService.save(new Line(Input.input(Input.PLEASE_INPUT_LINE_MESSAGE)));
        } catch (IllegalArgumentException e) {
            Output.printNewLine();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove() {

    }

    @Override
    public void getList() {

    }

    public static LineController getInstance() {
        return LineController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LineController INSTANCE = new LineController();
    }
}
