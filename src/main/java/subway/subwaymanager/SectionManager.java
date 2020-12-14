package subway.subwaymanager;

import subway.utils.InputView;
import subway.utils.OutputView;

import static subway.utils.Constant.*;

public class SectionManager {
    public static void sectionChoice() {
        while (true) {
            OutputView.printSectionContents();

            String inputSectionSelect = InputView.inputSelect();
            if (inputSectionSelect.equals(CONTENTS_NUMBER_FIRST)) {
            }
            if (inputSectionSelect.equals(CONTENTS_NUMBER_SECOND)) {
            }
            if (inputSectionSelect.equals(CONTENTS_NUMBER_BACK)) {
                break;
            }
        }
    }
}
