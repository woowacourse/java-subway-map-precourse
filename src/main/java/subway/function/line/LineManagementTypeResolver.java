//package subway.function.line;
//
//import java.util.Scanner;
//import subway.common.ResolveResultType;
//import subway.main.UserSelections;
//
//public class LineManagementTypeResolver {
//    public static ResolveResultType resolveUserSelection(LineManagementSelectionType type, Scanner scanner) {
//        if (type == LineManagementSelectionType.LINE_REGISTRATION) {
//            return LineManagement.registerNewLine(scanner);
//        }
//        if (type == LineManagementSelectionType.LINE_DELETE) {
//            return LineManagement.deleteLine(scanner);
//        }
//        if (type == LineManagementSelectionType.PRINT_ALL_LINES) {
//            return LineManagement.printLineList();
//        }
//        return ResolveResultType.ERROR;
//    }
//
//    public static LineManagementSelectionType getLineManagementSelectionType(String userInput) {
//        if (userInput.equals(UserSelections.FIRST)) {
//            return LineManagementSelectionType.LINE_REGISTRATION;
//        }
//        if (userInput.equals(UserSelections.SECOND)) {
//            return LineManagementSelectionType.LINE_DELETE;
//        }
//        if (userInput.equals(UserSelections.THIRD)) {
//            return LineManagementSelectionType.PRINT_ALL_LINES;
//        }
//        return LineManagementSelectionType.GO_BACK;
//    }
//}
