package subway.controller.menuhandler;

import static subway.util.TextConstant.*;

import subway.domain.LineRepository;
import subway.menu.LineMenu;
import subway.menu.SectionMenu;
import subway.menu.StationMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.function.Function;
import java.util.stream.Collectors;

public class MainMenuHandler {
    public static void stationManage() {
        OutputView.showStationMenu();
        StationMenu menuAction = StationMenu.findByCommand(InputView.nextLine());
        menuAction.run();
    }

    public static void lineManage() {
        OutputView.showLineMenu();
        LineMenu menuAction = LineMenu.findByCommand(InputView.nextLine());
        menuAction.run();
    }

    public static void sectionManage() {
        OutputView.showSectionMenu();
        SectionMenu menuAction = SectionMenu.findByCommand(InputView.nextLine());
        menuAction.run();
    }

    public static void showSubwayMap() {
        OutputView.showSubwayMap(
                LineRepository
                        .getLineNames().stream()
                        .collect(
                                Collectors.toMap(Function.identity()
                                        , lineName -> LineRepository
                                                .findLine(lineName)
                                                .sectionsNames())
                        )
        );
    }

    public static void end() {
        System.exit(ZERO);
    }
}
