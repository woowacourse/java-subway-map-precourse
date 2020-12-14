package subway.domain;

import subway.controller.LineController;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineManageMenu {
    public enum LineManageMenuEnums {
        LINE_ADD() {
            @Override
            public void lineManageMenuSelect() {
                // 라인 등록 호출
                LineController.lineAdd();
                lineManageMenuStop();
            }
        },
        LINE_DELETE() {
            @Override
            public void lineManageMenuSelect() {
                // 라인 삭제 호출
                LineController.lineDelete();
                lineManageMenuStop();
            }
        },
        LINE_CHECK() {
            @Override
            public void lineManageMenuSelect() {
                // 라인 조회 호출
                LineController.lineCheck();
                lineManageMenuStop();
            }
        };

        public abstract void lineManageMenuSelect();
    }


    private static boolean isLineMenuRun = true;

    public static boolean getIsLineMenuRun() {
        return isLineMenuRun;
    }

    private static void lineManageMenuStop() {
        isLineMenuRun = false;
    }

    public static void lineManageMenuRun() {
        isLineMenuRun = true;
        while (getIsLineMenuRun()) {
            try {
                OutputView.lineManageView();
                lineManageMenuInput();
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println("[ERROR] " + e.getMessage());
                System.out.println();
            }
        }
    }

    private static void lineManageMenuInput() throws IllegalArgumentException {
        String inputMsg = InputView.getInput();
        if (!Validator.isValidStationAndLineManageMenuInput(inputMsg)) {
            throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
        }
        lineManageMenuController(inputMsg);
    }

    private static void lineManageMenuController(String inputMsg) {
        List<String> lineManageMenuOrders = new ArrayList<>(Arrays.asList("LINE_ADD", "LINE_DELETE", "LINE_CHECK"));
        if (inputMsg.equals("B")) {
            lineManageMenuStop();
            return;
        }
        int lineManageMenuSelectNumber = Integer.parseInt(inputMsg);
        LineManageMenuEnums lineEnums = LineManageMenuEnums.valueOf(lineManageMenuOrders.get(lineManageMenuSelectNumber - 1));
        lineEnums.lineManageMenuSelect();
    }
}
