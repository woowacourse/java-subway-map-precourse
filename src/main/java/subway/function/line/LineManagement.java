//package subway.function.line;
//
//import java.util.Scanner;
//import subway.common.ResolveResultType;
//import subway.common.SelectionValidationResultDto;
//import subway.common.print.info.CommonInfoPrinter;
//import subway.common.validator.CommonValidator;
//import subway.domain.line.LineRepository;
//import subway.domain.LineStationMappingRepository;
//import subway.function.line.printer.LineManagementPrinter;
//import subway.function.line.printer.PrintLineManagementScreen;
//
//public class LineManagement {
//    public static void start(Scanner scanner) {
//        while (true) {
//            SelectionValidationResultDto resultDto = validateUserSelection(scanner);
//            if (!resultDto.isValid()) {
//                continue;
//            }
//            LineManagementSelectionType type = LineManagementTypeResolver
//                .getLineManagementSelectionType(resultDto.getUserInput());
//            if (type == LineManagementSelectionType.GO_BACK) {
//                return;
//            }
//            ResolveResultType resultType = LineManagementTypeResolver
//                .resolveUserSelection(type, scanner);
//            if (resultType == ResolveResultType.ERROR) {
//                continue;
//            }
//            return;
//        }
//    }
//
//    private static void validateUserSelection(Scanner scanner) throws Exception{
//        String userInput = printAndGetUserSelection(scanner);
//        CommonValidator.validateSelectionInput(CommonValidator.SELECTION_INPUT_PATTERN_123B, userInput)
//    }
//
//    private static String printAndGetUserSelection(Scanner scanner) {
//        PrintLineManagementScreen.printLineManagementScreen();
//        CommonInfoPrinter.printUserFunctionSelectionMessage();
//        return scanner.nextLine();
//    }
//
//    public static ResolveResultType registerNewLine(Scanner scanner) {
//        LineManagementPrinter.printNewLineNameInputMessage();
//        String newLineNameInput = scanner.nextLine();
//
//        LineManagementPrinter.printLineUpEndStationNameInputMessage();
//        String upEndStationNameInput = scanner.nextLine();
//
//        LineManagementPrinter.printLineDownEndStationNameInputMessage();
//        String downEndStationNameInput = scanner.nextLine();
//
//        LineStationMappingRepository
//            .createNewLine(newLineNameInput, upEndStationNameInput, downEndStationNameInput);
//
//        LineManagementPrinter.printNewLineRegistrationSuccessMessage();
//    }
//
//    public static ResolveResultType deleteLine(Scanner scanner) {
//        LineManagementPrinter.printLineNameToDeleteInputMessage();
//        String lineNameToDeleteInput = scanner.nextLine();
//        LineStationMappingRepository.deleteLine(lineNameToDeleteInput);
//        LineManagementPrinter.printLineDeleteSuccessMessage();
//    }
//
//    public static ResolveResultType printLineList() {
//        LineManagementPrinter.printLineListTitle();
//        LineRepository.printAllLines();
//        return ResolveResultType.SUCCESS;
//    }
//}
