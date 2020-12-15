package subway.domain;

import subway.controller.Edge;
import subway.view.InputView;

import java.util.ArrayList;

public class MenuRepository {
    private static final String INSERT_SIGN = "1";
    private static final String DELETE_SIGN = "2";
    private static final String LIST_SIGN = "3";
    private static final String BACK_SIGN = "B";
    private static final String STATION_MENU_TITLE = "역 ";
    private static final String LINE_MENU_TITLE = "노선 ";
    private static final String EDGE_MENU_TITLE = "구간 ";
    private static final String LIST_MENU_TITLE = "지하철 노선도";
    private static final String QUIT_TITLE = "";

    public static final Menu stationMenu = new Menu(STATION_MENU_TITLE, new ArrayList<Action>() {
        {
            add(ActionRepository.addAction);
            add(ActionRepository.deleteAction);
            add(ActionRepository.listAction);
            add(ActionRepository.backAction);
        }
    });

    public static final Menu lineMenu = new Menu(LINE_MENU_TITLE, new ArrayList<Action>() {
        {
            add(ActionRepository.addAction);
            add(ActionRepository.deleteAction);
            add(ActionRepository.listAction);
            add(ActionRepository.backAction);
        }
    });

    public static final Menu edgeMenu = new Menu(EDGE_MENU_TITLE, new ArrayList<Action>() {
        {
            add(ActionRepository.addAction);
            add(ActionRepository.deleteAction);
            add(ActionRepository.backAction);
        }
    });

    public static final Menu lineMap = new Menu(LIST_MENU_TITLE, new ArrayList<Action>() {});

    public static final Menu quit = new Menu(QUIT_TITLE, new ArrayList<Action>() {});

    private MenuRepository() {
    }

    public static boolean isCategoricalMenu(Menu menu) {
        if (menu.actionList.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean runCategoricalAction(InputView inputView, Menu menu, String subMenuAction) {
        if (menu == stationMenu) {
            return runStationMenu(inputView, subMenuAction);
        }
        if (menu == lineMenu) {
            return runLineMenu(inputView, subMenuAction);
        }
        if (menu == edgeMenu) {
            return runEdgeMenu(inputView, subMenuAction);
        }
        return false;
    }

    public static void runNonCategoricalAction(Menu menu) {
        if (menu == lineMap) {
            runLineMapMenu();
        }
    }

    private static boolean runStationMenu(InputView inputView, String subMenuAction) {
        if (subMenuAction.equals(INSERT_SIGN)) {
            StationRepository.add(inputView, STATION_MENU_TITLE);
        }
        if (subMenuAction.equals(DELETE_SIGN)) {
            StationRepository.delete(inputView, STATION_MENU_TITLE);
        }
        if (subMenuAction.equals(LIST_SIGN)) {
            StationRepository.catalogue(STATION_MENU_TITLE);
        }
        if (subMenuAction.equals(BACK_SIGN)) {
            return false;
        }
        return true;
    }

    private static boolean runLineMenu(InputView inputView, String subMenuAction) {
        if (subMenuAction.equals(INSERT_SIGN)) {
            LineRepository.add(inputView, LINE_MENU_TITLE, STATION_MENU_TITLE);
        }
        if (subMenuAction.equals(DELETE_SIGN)) {
            LineRepository.delete(inputView, LINE_MENU_TITLE);
        }
        if (subMenuAction.equals(LIST_SIGN)) {
            LineRepository.catalogue(LINE_MENU_TITLE);
        }
        if (subMenuAction.equals(BACK_SIGN)) {
            return false;
        }
        return true;
    }

    private static boolean runEdgeMenu(InputView inputView, String subMenuAction) {
        if (subMenuAction.equals(INSERT_SIGN)) {
            Edge.add(inputView);
        }
        if (subMenuAction.equals(DELETE_SIGN)) {
            Edge.delete(inputView);
        }
        if (subMenuAction.equals(BACK_SIGN)) {
            return false;
        }
        return true;
    }

    private static void runLineMapMenu() {
        LineRepository.runLineMap();
    }
}
