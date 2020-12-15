package subway;

import subway.domain.Constants;
import subway.domain.LineRepository;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Subway subway = new Subway(scanner);
        while (true) {
            String state = subway.selectState();
            if (state.equals(Constants.APPLICATION_QUIT)) {
                break;
            }
            if (state.equals(Constants.SUBWAY_LINEMAP_MENU)) {
                LineRepository.printLineAndStation();
                continue;
            }
            ((InputManager) subway.getMenus(state)).selectMenu();
        }
    }
}
