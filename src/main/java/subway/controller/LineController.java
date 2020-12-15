package subway.controller;

import subway.domain.Line;
import subway.service.LineService;
import subway.view.Input;
import subway.view.Output;

public class LineController {

    private LineController() {
    }

    public void save() {
        try {
            LineService.save(new Line(Input.input(Input.PLEASE_INPUT_LINE_MESSAGE)));
        } catch (IllegalArgumentException e) {
            Output.printNewLine();
            System.out.println(e.getMessage());
        }
    }

    public void remove() {
        try {
            LineService.remove(Input.input(Input.PLEASE_INPUT_REMOVE_LINE_NAME));
        } catch (IllegalArgumentException e) {
            Output.printNewLine();
            System.out.println(e.getMessage());
        }
    }

    public void getList() {
        Output.print(Output.LINE_LIST);
        Output.printByList(LineService.getAllLines());
    }

    public static LineController getInstance() {
        return LineController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LineController INSTANCE = new LineController();
    }
}
