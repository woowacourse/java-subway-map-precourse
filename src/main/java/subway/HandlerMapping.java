package subway;

import subway.view.screen.ScreenManager;
import subway.view.screen.action.line.LineDeleteActionScreen;
import subway.view.screen.action.line.LineInsertActionScreen;
import subway.view.screen.action.line.LineSelectAllActionScreen;
import subway.view.screen.action.line.SectionDeleteActionScreen;
import subway.view.screen.action.line.SectionInsertActionScreen;
import subway.view.screen.action.station.StationDeleteActionScreen;
import subway.view.screen.action.station.StationInsertActionScreen;
import subway.view.screen.action.station.StationSelectAllActionScreen;

public class HandlerMapping {

    public static void mapping(CategoryType categoryType, ActionType actionType) {
        if (categoryType == CategoryType.STATION) {
            stationMapping(categoryType, actionType);
        }

        if (categoryType == CategoryType.LINE) {
            lineMapping(categoryType, actionType);
        }

        if (categoryType == CategoryType.SECTION) {
            sectionMapping(categoryType, actionType);
        }
    }

    private static void stationMapping(CategoryType categoryType, ActionType actionType) {
        if (actionType == ActionType.INSERT) {
            ScreenManager.push(new StationInsertActionScreen(categoryType));
            return;
        }

        if (actionType == ActionType.DELETE) {
            ScreenManager.push(new StationDeleteActionScreen(categoryType));
            return;
        }

        if (actionType == ActionType.SELECT) {
            ScreenManager.push(new StationSelectAllActionScreen(categoryType));
        }
    }

    private static void lineMapping(CategoryType categoryType, ActionType actionType) {
        if (actionType == ActionType.INSERT) {
            ScreenManager.push(new LineInsertActionScreen(categoryType));
            return;
        }

        if (actionType == ActionType.DELETE) {
            ScreenManager.push(new LineDeleteActionScreen(categoryType));
            return;
        }

        if (actionType == ActionType.SELECT) {
            ScreenManager.push(new LineSelectAllActionScreen(categoryType));
        }
    }

    private static void sectionMapping(CategoryType categoryType, ActionType actionType) {
        if (actionType == ActionType.INSERT) {
            ScreenManager.push(new SectionInsertActionScreen(categoryType));
            return;
        }

        if (actionType == ActionType.DELETE) {
            ScreenManager.push(new SectionDeleteActionScreen(categoryType));
        }
    }
}
