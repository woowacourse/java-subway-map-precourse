package subway.domain;

import subway.controller.SectionController;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SectionManageMenu {
    private enum SectionManageMenuEnums {
        SECTION_ADD() {
            @Override
            public void SectionManageMenuSelect() {
                // 구간 등록 호출
                SectionController.sectionAdd();
            }
        },
        SECTION_DELETE() {
            @Override
            public void SectionManageMenuSelect() {
                // 구간 삭제 호출
                SectionController.sectionDelete();
            }
        };

        public abstract void SectionManageMenuSelect();
    }

    private static boolean isSectionManageMenuRun = true;

    private static boolean getIsSectionManageMenuRun() {
        return isSectionManageMenuRun;
    }

    public static void sectionManageMenuStop() {
        isSectionManageMenuRun = false;
    }

    public static void sectionManageMenuRun() {
        isSectionManageMenuRun = true;
        while (getIsSectionManageMenuRun()) {
            try {
                OutputView.sectionManageView();
                sectionManageMenuInput();
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println("[ERROR] " + e.getMessage());
                System.out.println();
            }
        }
    }

    private static void sectionManageMenuInput() throws IllegalArgumentException {
        String inputMsg = InputView.getInput();
        if (!Validator.isValidSectionManageMenuInput(inputMsg)) {
            throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
        }
        sectionManageMenuController(inputMsg);
    }

    private static void sectionManageMenuController(String inputMsg) {
        List<String> sectionManageMenuOrders = new ArrayList<>(Arrays.asList("SECTION_ADD", "SECTION_DELETE"));
        if (inputMsg.equals("B")) {
            sectionManageMenuStop();
            return;
        }
        int selectNumber = Integer.parseInt(inputMsg);
        SectionManageMenuEnums sectionEnums = SectionManageMenuEnums.valueOf(sectionManageMenuOrders.get(selectNumber - 1));
        sectionEnums.SectionManageMenuSelect();
    }
}
