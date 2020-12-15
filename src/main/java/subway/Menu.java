package subway;

import subway.controller.Edge;
import subway.controller.MenuController;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.InputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Menu {
    private static final String INSERT_SIGN = "1";
    private static final String DELETE_SIGN = "2";
    private static final String LIST_SIGN = "3";
    private static final String BACK_SIGN = "B";
    private static final String INSERT_ACTION = "등록";
    private static final String DELETE_ACTION = "삭제";
    private static final String LIST_ACTION = "조회";
    private static final String BACK_ACTION = "돌아가기";
    private static final String STATION_MENU_TITLE = "역 ";
    private static final String LINE_MENU_TITLE = "노선 ";
    private static final String EDGE_MENU_TITLE = "구간 ";
    private static final String LIST_MENU_TITLE = "지하철 노선도";
    private static final int SUB_MENU_INDEX = 0;
    private static final int SUB_MENU_ACTION_INDEX = 1;
    public static final String MENU_TITLE_SIGN = "title";

    public static final SubMenu stationMenu = new SubMenu(
        new LinkedHashMap<String, String>() {
            {
                put(MENU_TITLE_SIGN, STATION_MENU_TITLE);
                put(INSERT_SIGN, INSERT_ACTION);
                put(DELETE_SIGN, DELETE_ACTION);
                put(LIST_SIGN, LIST_ACTION);
                put(BACK_SIGN, BACK_ACTION);
            }
        }
    );

    public static final SubMenu lineMenu = new SubMenu(
        new LinkedHashMap<String, String>() {
            {
                put(MENU_TITLE_SIGN, LINE_MENU_TITLE);
                put(INSERT_SIGN, INSERT_ACTION);
                put(DELETE_SIGN, DELETE_ACTION);
                put(LIST_SIGN, LIST_ACTION);
                put(BACK_SIGN, BACK_ACTION);
            }
        }
    );

    public static final SubMenu edgeMenu = new SubMenu(
        new LinkedHashMap<String, String>() {
            {
                put(MENU_TITLE_SIGN, EDGE_MENU_TITLE);
                put(INSERT_SIGN, INSERT_ACTION);
                put(DELETE_SIGN, DELETE_ACTION);
                put(BACK_SIGN, BACK_ACTION);
            }
        }
    );

    public static final SubMenu lineMap = new SubMenu(
        new LinkedHashMap<String, String>() {
            {
                put(MENU_TITLE_SIGN, LIST_MENU_TITLE);
            }
        }
    );

    public static final SubMenu quit = new SubMenu(
        new LinkedHashMap<String, String>() {}
    );

    private Menu() {
    }

    public static boolean isCategoricalMenu(SubMenu menu) {
        if (menu.actionSign.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean runStationMenu(InputView inputView, String subMenuAction) {
        if (subMenuAction.equals(INSERT_SIGN)) {
            StationRepository.add(inputView, STATION_MENU_TITLE);
        }
        if (subMenuAction.equals(DELETE_SIGN)) {
            StationRepository.delete(inputView, STATION_MENU_TITLE);
        }
        if (subMenuAction.equals(LIST_SIGN)) {
            StationRepository.printList(STATION_MENU_TITLE);
        }
        if (subMenuAction.equals(BACK_SIGN)) {
            return false;
        }
        return true;
    }

    public static boolean runLineMenu(InputView inputView, String subMenuAction) {
        if (subMenuAction.equals(INSERT_SIGN)) {
            LineRepository.add(inputView, LINE_MENU_TITLE, STATION_MENU_TITLE);
        }
        if (subMenuAction.equals(DELETE_SIGN)) {
            LineRepository.delete(inputView, LINE_MENU_TITLE);
        }
        if (subMenuAction.equals(LIST_SIGN)) {
            LineRepository.printList(LINE_MENU_TITLE);
        }
        if (subMenuAction.equals(BACK_SIGN)) {
            return false;
        }
        return true;
    }

    public static boolean runEdgeMenu(InputView inputView, String subMenuAction) {
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

    public static void runLineMapMenu() {
        LineRepository.runLineMap();
    }
}
