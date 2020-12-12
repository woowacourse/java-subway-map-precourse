package subway;

import java.util.HashMap;

public class Menu {
    private static final String INSERT_SIGN = "1";
    private static final String DELETE_SIGN = "2";
    private static final String LIST_SIGN = "3";
    private static final String BACK_SIGN = "B";
    private static final String INSERT_ACTION = "insert";
    private static final String DELETE_ACTION = "delete";
    private static final String LIST_ACTION = "list";
    private static final String BACK_ACTION = "back";

    public static final SubMenu stationMenu = new SubMenu(
        new HashMap<String, String>() {
            {
                put(INSERT_SIGN, INSERT_ACTION);
                put(DELETE_SIGN, DELETE_ACTION);
                put(LIST_SIGN, LIST_ACTION);
                put(BACK_SIGN, BACK_ACTION);
            }
        }
    );

    public static final SubMenu lineMenu = new SubMenu(
        new HashMap<String, String>() {
            {
                put(INSERT_SIGN, INSERT_ACTION);
                put(DELETE_SIGN, DELETE_ACTION);
                put(LIST_SIGN, LIST_ACTION);
                put(BACK_SIGN, BACK_ACTION);
            }
        }
    );

    public static final SubMenu edgeMenu = new SubMenu(
        new HashMap<String, String>() {
            {
                put(INSERT_SIGN, INSERT_ACTION);
                put(DELETE_SIGN, DELETE_ACTION);
                put(BACK_SIGN, BACK_ACTION);
            }
        }
    );

    public static final SubMenu lineMap = new SubMenu(
        new HashMap<String, String>() {}
    );

    public static final SubMenu quit = new SubMenu(
        new HashMap<String, String>() {}
    );
}
