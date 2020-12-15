package subway.service;

import subway.constant.Function;
import subway.exception.InvalidInputException;
import subway.view.InputView;
import subway.view.OutputView;

public abstract class CrudService implements MapService {

    private InputView inputView;
    private OutputView outputView;
    private String information;

    public CrudService(InputView inputView, OutputView outputView, String information) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.information = information;
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    @Override
    public void run() {
        try {
            String selectedFunction = inputView.getFunctionInput(information);
            Function.validate(selectedFunction);
            runSelectedFunction(selectedFunction);
        } catch (InvalidInputException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void runSelectedFunction(String selectedFunction) {
        if (selectedFunction.equals(Function.ADD.getCode()))
            add();
        if (selectedFunction.equals(Function.DELETE.getCode()))
            delete();
        if (selectedFunction.equals(Function.SHOW.getCode()))
            show();
    }

    public abstract void add();

    public abstract void delete();

    public abstract void show();
}
