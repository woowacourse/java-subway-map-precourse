package controller;

import utils.ValidateUtils;
import view.SectionManageView;

public class SectionManageController {
    private SectionManageView view;

    public SectionManageController(SectionManageView view) {
        this.view = view;
    }

    public boolean validateInput(String input) {
        return ValidateUtils.validateSectionInput(input);
    }
}
