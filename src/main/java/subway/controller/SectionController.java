package subway.controller;

import jdk.internal.util.xml.impl.Input;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.SectionView;

public class SectionController {

    public static void selectionAdd() {
        try {
            SectionView.printLineReqMsg();
            String lineName = lineNameInput();
        } catch (IllegalArgumentException e) {

        }
    }

    private static String lineNameInput() throws IllegalArgumentException {
        String lineName = InputView.getInput();
        lineName = lineName.replace(" ", "");
        if (!Validator.isExistLineName(lineName)) {
            throw new IllegalArgumentException("DB에 존재하지 않는 노선 이름 입니다");
        }
        return lineName;
    }
}
