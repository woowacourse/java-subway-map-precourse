package subway;

import subway.domain.LineRepository;

import java.util.Scanner;

public class Application {
    private static final String APPLICATION_QUIT = "Q";
    private static final String SUBWAY_LINEMAP_MENU = "4";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Subway subway = new Subway(scanner);
        while (true) {
            String state = subway.selectState();
            if (state.equals(APPLICATION_QUIT)) {
                break;
            }
            if (state.equals(SUBWAY_LINEMAP_MENU)) {
                LineRepository.printLineAndStation();
                continue;
            }
            ((InputManager) subway.getMenus(state)).selectMenu();
        }
    }
}
