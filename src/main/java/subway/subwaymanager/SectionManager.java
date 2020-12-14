package subway.subwaymanager;

import subway.domain.LineRepository;
import subway.utils.InputView;
import subway.utils.OutputView;
import subway.validators.ValidateSectionSelect;

import static subway.utils.Constant.*;

public class SectionManager {
    public static void sectionChoice() {
        while (true) {
            OutputView.printSectionContents();

            String inputSectionSelect = InputView.inputSelect();
            ValidateSectionSelect.validateSectionSelect(inputSectionSelect);
            if (inputSectionSelect.equals(CONTENTS_NUMBER_FIRST)) {
                registerSection();
            }
            if (inputSectionSelect.equals(CONTENTS_NUMBER_SECOND)) {
            }
            if (inputSectionSelect.equals(CONTENTS_NUMBER_BACK)) {
                break;
            }
        }
    }

    private static void registerSection() {
        System.out.println("노선을 입력하세요. ");
        String lineName = InputView.inputSelect();
        System.out.println("역이름을 입력하세요.");
        String stationName = InputView.inputSelect();
        System.out.println("순서를 입력하세요.");
        int indexNum = InputView.inputNumber();
        LineRepository.addSectionLineOfStation(lineName, stationName, indexNum);
    }
}
