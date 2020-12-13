package subway.view.route;

import java.util.Scanner;

public class RouteMenuInputView {

    private static final String ROUTE_ENROLL_MENU = "1";
    private static final String ROUTE_DELETE_MENU = "2";
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String BACK_MENU = "B";

    public static String getRouteMenuCommand(Scanner scanner) {
        RouteMenuOutputView.printRouteMenu();
        try {
            String routeMenuCommand = scanner.nextLine();
            validateRouteMenuCommand(routeMenuCommand);
            return routeMenuCommand;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getRouteMenuCommand(scanner);
        }
    }

    private static void validateRouteMenuCommand(String routeMenuCommand) {
        if (!routeMenuCommand.equals(ROUTE_ENROLL_MENU) && !routeMenuCommand.equals(ROUTE_DELETE_MENU) &&
                !routeMenuCommand.equals(BACK_MENU)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
