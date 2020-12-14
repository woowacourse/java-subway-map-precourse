package subway.userinterface;

import java.util.Scanner;

public class UserInterface {
    private static boolean isApplicationRunning = true;

    private static View currentView = MainView.getInstance();

    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    static void setView(View view) {
        currentView = view;
    }

    static void applicationShutDown() {
        isApplicationRunning = false;
    }

    public void startApplication() {
        while (isApplicationRunning) {
            currentView.printGuidance();
            printInputGuidance();

            try {
                currentView.processCommand(scanner.nextLine());
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }

            printEmptyLine();
        }

        printApplicationShowDown();
    }

    private void printInputGuidance() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private void printApplicationShowDown() {
        System.out.println("[INFO] 애플리케이션을 종료합니다.");
    }
}
