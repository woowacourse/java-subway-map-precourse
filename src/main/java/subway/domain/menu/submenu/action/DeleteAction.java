package subway.domain.menu.submenu.action;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.menu.constant.CategoryType;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.submenu.action.constant.ActionMessage;
import subway.view.InputView;

public class DeleteAction extends Action {
    public DeleteAction(char order, String category, String actionType, InputView inputView) {
        super(order, category, actionType, inputView);
    }

    @Override
    public void runAction() {
        String name;

        // 미구현 - 구간 추가할 때 고칠 예정.
        if (category.equals(CategoryType.SECTION)) {
            deleteSection();
        }

        printDeleteMessage();
        name = requestInputDelete();
        if (name.equals(CommonMessage.ERROR)) {
            return;
        }

        runDetailAction(name);
    }

    private void runDetailAction(String name) {
        if (category.equals(CategoryType.STATION)) {
            deleteStation(name);
        }

        if (category.equals(CategoryType.LINE)) {
            deleteLine(name);
        }

        if (category.equals(CategoryType.SECTION)) {
            deleteSection();
        }
        printSuccessMessage();
    }

    private void printDeleteMessage() {
        System.out.println(CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + ActionMessage.INPUT_DELETE
                + CommonMessage.SPACE + category + CommonMessage.SPACE + ActionMessage.INPUT_DELETE_NAME);
    }

    private void printDeleteMessage(String type) {
        System.out.print(CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + ActionMessage.INPUT_DELETE
                + CommonMessage.SPACE + category + ActionMessage.INPUT_POSTPOSITION + CommonMessage.SPACE);

        if (type.equals(CategoryType.LINE)) {
            System.out.print(CategoryType.LINE + ActionMessage.DELETE_SECTION_POSTPOSITION + CommonMessage.SPACE);
        }

        if (type.equals(CategoryType.STATION)) {
            System.out.print(CategoryType.STATION + ActionMessage.DELETE_SECTION_POSTPOSITION + CommonMessage.SPACE);
        }

        System.out.println(ActionMessage.INPUT_SECTION_MESSAGE);
    }

    private String requestInputDelete() {
        return inputView.inputDelete();
    }

    // 임시 - 컴파일 에러 방지.
    private String inputDelete() {
        String name = inputView.getScanner().nextLine();
        System.out.println();
        return name;
    }

    private void deleteStation(String name) {
        StationRepository.deleteStation(name);
    }

    private void deleteLine(String name) {
        LineRepository.deleteLineByName(name);
    }

    private void deleteSection() {
        printDeleteMessage(CategoryType.LINE);
        String line = inputDelete();

        printDeleteMessage(CategoryType.STATION);
        String name = inputDelete();

        LineRepository.lines().stream().filter(item -> item.getName().equals(line)).findFirst().get()
                .deleteStation(name);

        printSuccessMessage();
    }

    private void printSuccessMessage() {
        System.out.println(CommonMessage.INFO + CommonMessage.SPACE + ActionMessage.SUCCESS_SUBWAY + CommonMessage.SPACE
                + category + ActionMessage.SUCCESS_POSTPOSITION + CommonMessage.SPACE + ActionMessage.SUCCESS_DELETE);
        System.out.println();
    }
}
