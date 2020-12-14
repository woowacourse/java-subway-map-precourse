package subway.domain.menu.submenu;

import subway.domain.LineRepository;
import subway.domain.menu.constant.ActionType;
import subway.domain.menu.constant.CommonMessage;
import subway.view.InputView;

public class StationLineMenu extends SubMenu {
    private static final String SEPARATOR = "---";

    public StationLineMenu(char order, String category, InputView inputView) {
        super(order, category, inputView);
    }

    @Override
    public String getTitle() {
        String title = CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + category;
        return title;
    }

    @Override
    public String getTitleActionMessage() {
        String titleActionMessage = order + CommonMessage.PUNCTUATION + CommonMessage.SPACE + category
                + CommonMessage.SPACE + ActionType.PRINT;

        return titleActionMessage;
    }

    @Override
    public void printSubMenu() {
        System.out.print(CommonMessage.INFO + CommonMessage.SPACE);
    }

    @Override
    public void runSubMenu() {
        System.out.println(getTitle());
        LineRepository.lines().stream().forEach(lines -> {
            printSubMenu();
            System.out.println(lines.getName());
            printSubMenu();
            System.out.println(SEPARATOR);

            lines.getStationList().stream().forEach(stations -> {
                printSubMenu();
                System.out.println(stations.getName());
            });
            System.out.println();
        });
    }
}
