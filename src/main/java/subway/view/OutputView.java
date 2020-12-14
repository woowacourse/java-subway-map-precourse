package subway.view;

import java.util.List;

import subway.CommonConstants;
import subway.screen.ActionType;
import subway.screen.Choice;
import subway.screen.EntityType;
import subway.screen.Screen;

public class OutputView {
    private static String NEW_MESSAGE_PREFIX = "##";
    private static String ERROR_MESSAGE_PREFIX = "[ERROR]";
    private static String INFO_MESSAGE_PREFIX = "[INFO]";
    private static String LIST_SUFFIX = "목록";
    private static String SELECT_FEATURE_MESSAGE = "원하는 기능을 선택하세요.";
    private static String STATION_REGISTER_ASK_MESSAGE = "등록할 역 이름을 입력하세요.";
    private static String STATION_DELETE_ASK_MESSAGE = "삭제할 역 이름을 입력하세요.";
    private static String STATION_REGISTER_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    private static String STATION_DELETE_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";
    private static String LINE_REGISTER_ASK_MESSAGE = "등록할 노선 이름을 입력하세요.";
    private static String LINE_DELETE_ASK_MESSAGE = "삭제할 노선 이름을 입력하세요.";
    private static String LINE_REGISTER_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static String LINE_DELETE_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.";
    private static String UPWARD_END_STATION_ASK_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static String DOWNWARD_END_STATION_ASK_MESSAGE = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    
    OutputView() {
    }
    
    void printScreen(Screen screen) {
        System.out.println(NEW_MESSAGE_PREFIX + CommonConstants.SPACE + screen.getScreenType().toString());
        for (Choice choice : screen.getChoices()) {
            System.out.println(choice.toString());
        }
    }
    
    void printSelectFeature() {
        System.out.println(NEW_MESSAGE_PREFIX + CommonConstants.SPACE + SELECT_FEATURE_MESSAGE);
    }
    
    void printMessage(String message) {
        System.out.println(message);
    }
    
    void printAskMessage(EntityType entityType, ActionType actionType) {
        if (entityType == EntityType.STATION) {
            printStationAskMessage(actionType);
        }
        if (entityType == EntityType.LINE) {
            printLineAskMessage(actionType);
        }
        if (entityType == EntityType.ROUTE) {
            printRouteAskMessage(actionType);
        }
    }
    
    void printErrorMessage(Exception exception) {
        System.out.println(ERROR_MESSAGE_PREFIX + CommonConstants.SPACE + exception.getMessage());
    }
    
    void printSuccessMessage(EntityType entityType, ActionType actionType) {
        if (entityType == EntityType.STATION) {
            printStationSuccessMessage(actionType);
        }
        if (entityType == EntityType.LINE) {
            printLineSuccessMessage(actionType);
        }
        if (entityType == EntityType.ROUTE) {
            printRouteSuccessMessage(actionType);
        }
    }
    
    void printNames(EntityType entityType, List<String> names) {
        System.out.println(NEW_MESSAGE_PREFIX + CommonConstants.SPACE + entityType.toString() + CommonConstants.SPACE
                + LIST_SUFFIX);
        
        names.stream().map(name -> INFO_MESSAGE_PREFIX + CommonConstants.SPACE + name)
                .forEachOrdered(System.out::println);
    }
    
    void printAskUpwardEndRouteMessage() {
        System.out.println(NEW_MESSAGE_PREFIX + UPWARD_END_STATION_ASK_MESSAGE);
    }
    
    void printAskDownwardEndRouteMessage() {
        System.out.println(NEW_MESSAGE_PREFIX + DOWNWARD_END_STATION_ASK_MESSAGE);
    }
    
    void printEmptyLine() {
        System.out.println(CommonConstants.EMPTY);
    }
    
    private void printStationAskMessage(ActionType actionType) {
        if (actionType == ActionType.REGISTER) {
            System.out.println(STATION_REGISTER_ASK_MESSAGE);
        }
        if (actionType == ActionType.DELETE) {
            System.out.println(STATION_DELETE_ASK_MESSAGE);
        }
    }
    
    private void printLineAskMessage(ActionType actionType) {
        if (actionType == ActionType.REGISTER) {
            System.out.println(LINE_REGISTER_ASK_MESSAGE);
        }
        if (actionType == ActionType.DELETE) {
            System.out.println(LINE_DELETE_ASK_MESSAGE);
        }
    }
    
    private void printRouteAskMessage(ActionType actionType) {
        // TODO 구현 예정
    }
    
    private void printStationSuccessMessage(ActionType actionType) {
        if (actionType == ActionType.REGISTER) {
            System.out.println(INFO_MESSAGE_PREFIX + CommonConstants.SPACE + STATION_REGISTER_SUCCESS_MESSAGE);
        }
        if (actionType == ActionType.DELETE) {
            System.out.println(INFO_MESSAGE_PREFIX + CommonConstants.SPACE + STATION_DELETE_SUCCESS_MESSAGE);
        }
    }
    
    private void printLineSuccessMessage(ActionType actionType) {
        if (actionType == ActionType.REGISTER) {
            System.out.println(INFO_MESSAGE_PREFIX + CommonConstants.SPACE + LINE_REGISTER_SUCCESS_MESSAGE);
        }
        if (actionType == ActionType.DELETE) {
            System.out.println(INFO_MESSAGE_PREFIX + CommonConstants.SPACE + LINE_DELETE_SUCCESS_MESSAGE);
        }
    }
    
    private void printRouteSuccessMessage(ActionType actionType) {
        // TODO 구현 예정
    }
}
