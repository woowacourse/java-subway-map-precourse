package controller;

import utils.ValidateUtils;
import view.LineManageView;

public class LineManageController {
    private LineManageView view;

    public LineManageController(LineManageView view) {
        this.view = view;
    }

    public boolean validateInput(String input) {
        return ValidateUtils.validateInput(input);
    }
}
