package subway;

import com.sun.tools.javac.Main;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Route;
import subway.domain.RouteRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.LineFunction;
import subway.menu.MainFunction;
import subway.menu.RouteFunction;
import subway.menu.StationFunction;
import subway.utils.InputUtils;
import subway.utils.PrintUtils;

/**
 * 지하철 프로그램을 관리하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/15
 */
public class Application {
    private static StationRepository stationRepository;
    private static LineRepository lineRepository;
    private static RouteRepository routeRepository;
    private static PrintUtils printUtils;
    private static InputUtils inputUtils;

    private static final List<String> initialStationList = Arrays
        .asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");

    private static final List<String[]> initialLineList = Arrays
        .asList(new String[]{"2호선", "교대역", "역삼역"}, new String[]{"3호선", "교대역","매봉역"}, new String[]{"신분당선", "강남역", "양재시민의숲역"});

    private static final List<String[]> initialRouteList = Arrays
        .asList(new String[]{"2호선", "강남역", "1"}, new String[]{"3호선", "남부터미널역","1"}, new String[]{"3호선", "양재역","2"}, new String[]{"신분당선", "양재역", "1"});

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        char mainFunction;

        setObjectValue();
        initializeSubwayProgram();
        while (true) {
            mainFunction = mainMenu();
            if (mainFunction == MainFunction.QUIT.getMenu()) {
                break;
            }
            selectDetailMenu(mainFunction);
        }
    }

    public static void setObjectValue() {
        printUtils = new PrintUtils();
        inputUtils = new InputUtils();
        stationRepository = new StationRepository();
        lineRepository = new LineRepository();
        routeRepository = new RouteRepository();
    }

    private static void initializeSubwayProgram(){
        initializeStation();
        initializeLines();
        initializeRoutes();
    }

    private static void initializeStation() {
        for (String stationList : initialStationList) {
            stationRepository.addStation(new Station(stationList));
        }
    }

    private static void initializeLines() {
        for (String[] lineList : initialLineList) {
            Line line = new Line(lineList[0]);
            Station upboundTerminal = new Station(lineList[1]);
            Station downboundTerminal = new Station(lineList[2]);
            lineRepository.addLine(line);
            routeRepository.addRoute(new Route(line,upboundTerminal,downboundTerminal));
        }
    }

    private static void initializeRoutes(){
        for(String[] routeList: initialRouteList) {
            routeRepository.addStationToLine(routeList[0], new Station(routeList[1]), Integer.parseInt(routeList[2]));
        }
    }

    private static char mainMenu() {
        printUtils.printMainMenu();
        printUtils.printSelectFunction();
        return inputUtils.inputFunctionSelect(4, MainFunction.QUIT.getMenu());
    }

    private static void selectDetailMenu(char menu) {
        if (menu == MainFunction.STATION_MANAGEMENT.getMenu()) {
            stationManagementMenu();
        }
        if (menu == MainFunction.LINE_MANAGEMENT.getMenu()) {
            lineManagementMenu();
        }
        if (menu == MainFunction.SECTION_MANAGEMENT.getMenu()) {
            routeManagementMenu();
        }
        if (menu == MainFunction.SUBWAY_MAP.getMenu()) {
            subwayMapPrint();
        }

    }

    private static void stationManagementMenu() {
        printUtils.printStationManagementMenu();
        printUtils.printSelectFunction();

        char menu = inputUtils.inputFunctionSelect(3, StationFunction.GET_BACK.getMenu());
        if (StationFunction.GET_BACK.matchMenu(menu)) {
            return;
        }
        if (StationFunction.ADD.matchMenu(menu)) {
            addStation();
        }
        if (StationFunction.DELETE.matchMenu(menu)) {
            deleteStation();
        }
        if (StationFunction.INQUIRY.matchMenu(menu)) {
            inquiryStationList();
        }
    }

    private static void addStation() {
        printUtils.printAddStationGuide();
        try {
            Station newStation = new Station(inputUtils.inputStationName());
            if (stationRepository.isStationExist(newStation)) {
                throw new IllegalArgumentException();
            }
            stationRepository.addStation(newStation);
            printUtils.printCompleteAddStation();
        } catch (IllegalArgumentException e) {
            printUtils.duplicateStationError();
            addStation();
            return;
        }
    }

    private static void deleteStation() {
        printUtils.printDeleteStationGuide();
        try {
            Station delStation = new Station(inputUtils.inputStationName());
            if (!stationRepository.isStationExist(delStation)) {
                throw new IllegalArgumentException();
            }
            stationRepository.deleteStation(delStation.getName());
            routeRepository.deleteStationOnAllRoute(delStation.getName());
            printUtils.printCompleteDeleteStation();
        } catch (IllegalArgumentException e) {
            printUtils.nonExistentStationError();
            deleteStation();
            return;
        }
    }

    private static void inquiryStationList() {
        printUtils.printStationsList();
        stationRepository.printStationsList();
    }

    private static void lineManagementMenu() {
        printUtils.printLineManagementMenu();
        printUtils.printSelectFunction();

        char menu = inputUtils.inputFunctionSelect(3, LineFunction.GET_BACK.getMenu());
        if (LineFunction.GET_BACK.matchMenu(menu)) {
            return;
        }
        if (LineFunction.ADD.matchMenu(menu)) {
            addLine();
        }
        if(LineFunction.DELETE.matchMenu(menu))
            deleteLine();
        if(LineFunction.INQUIRY.matchMenu(menu))
            inquiryLineList();
    }

    private static void addLine() {
        Line line = registerNewLine();
        Station upboundStation = new Station(upboundTerminal());
        Station downboundStation = new Station(downboundTerminal(upboundStation.getName()));
        routeRepository.addRoute(new Route(line,upboundStation,downboundStation));
        printUtils.printCompleteAddLine();
    }

    private static Line registerNewLine() {
        printUtils.printAddNewLineNameGuide();
        try {
            Line newline = new Line(inputUtils.inputLineName());
            if (lineRepository.isLineExist(newline)) {
                throw new IllegalArgumentException();
            }
            lineRepository.addLine(newline);
            return newline;
        } catch (IllegalArgumentException e) {
            printUtils.duplicateLineError();
            return registerNewLine();
        }
    }

    private static String upboundTerminal() {
        printUtils.printUpboundTerminalNameGuide();
        try {
            String upboundStation = inputUtils.inputStationName();
            if (!stationRepository.isStationExist(new Station(upboundStation))) {
                throw new IllegalArgumentException();
            }
            return upboundStation;
        } catch (IllegalArgumentException e) {
            printUtils.nonExistentStationError();
            return upboundTerminal();
        }
    }

    private static String downboundTerminal(String upboundStation) {
        printUtils.printDownboundTerminalNameGuide();
        try {
            String downboundStation = inputUtils.inputStationName();
            if (!stationRepository.isStationExist(new Station(downboundStation))) {
                throw new IllegalArgumentException();
            }
            if(upboundStation.equals(downboundStation))
                throw new InputMismatchException();
            return downboundStation;
        } catch (IllegalArgumentException e) {
            printUtils.nonExistentStationError();
        }catch (InputMismatchException e){
            printUtils.sameTerminalNameError();
        }
        return downboundTerminal(upboundStation);
    }

    private static void deleteLine() {
        printUtils.printDeleteLineGuide();
        try {
            Line delLine = new Line(inputUtils.inputLineName());
            if (!lineRepository.isLineExist(delLine)) {
                throw new IllegalArgumentException();
            }
            lineRepository.deleteLineByName(delLine.getName());
            routeRepository.deleteLine(delLine.getName());
            printUtils.printCompleteDeleteLine();
        } catch (IllegalArgumentException e) {
            printUtils.nonExistentStationError();
            deleteLine();
            return;
        }
    }

    private static void inquiryLineList() {
        printUtils.printLinesList();
        lineRepository.printLinesList();
    }

    private static void routeManagementMenu() {
        printUtils.printRouteManagementMenu();
        printUtils.printSelectFunction();

        char menu = inputUtils.inputFunctionSelect(2, RouteFunction.GET_BACK.getMenu());
        if (RouteFunction.GET_BACK.matchMenu(menu)) {
            return;
        }
        if(RouteFunction.ADD.matchMenu(menu)){
            addRoute();
        }
        if(RouteFunction.DELETE.matchMenu(menu)){
            deleteRoute();
        }

    }

    private static void addRoute() {
        String lineName = whichLineAdded();
        String stationName = whichStationAdd(lineName);
        int inputOrder = whichOrderAdd(routeRepository.numberOfStationsLineHave(lineName));

        routeRepository.addStationToLine(lineName,new Station(stationName),inputOrder);
        printUtils.printCompleteRouteRegistration();
    }

    private static String whichLineAdded(){
        printUtils.printLineNameInputGuide();
        try{
            String lineName = inputUtils.inputLineName();
            if(!routeRepository.isLineIncluded(lineName))
                throw new IllegalArgumentException();
            return lineName;
        }catch(IllegalArgumentException e){
            printUtils.nonExistentLineError();
            return whichLineAdded();
        }
    }

    private static String whichStationAdd(String lineName){
        printUtils.printStationNameInputGuide();
        try{
            String stationName = inputUtils.inputStationName();
            if(routeRepository.doesLineIncludeStation(lineName, stationName))
                throw new IllegalArgumentException();
            if(!stationRepository.isStationExist(new Station(stationName)))
                throw new IllegalCallerException();
            return stationName;
        }catch(IllegalArgumentException e){
            printUtils.duplicateStationError();
        }catch(IllegalCallerException e){
            printUtils.nonExistentStationError();
        }
        return whichStationAdd(lineName);
    }

    private static int whichOrderAdd(int stationNumber){
        printUtils.printOrderInputGuide();
        return inputUtils.inputStationOrder(stationNumber);
    }

    private static void deleteRoute() {
        String deleteLine = whichLineOfRouteDeleted();
        String deleteStation = whichStationOfRouteDeleted(deleteLine);
        boolean isPossibleDelete = routeRepository.deleteRoute(deleteLine,deleteStation);
        if(!isPossibleDelete){
            printUtils.impossibleRouteDeletion();
            return;
        }
        printUtils.printCompleteRouteDeletion();
    }

    private static String whichLineOfRouteDeleted(){
        printUtils.printLineOfRouteDeletedGuide();
        try{
            String lineName = inputUtils.inputLineName();
            if(!routeRepository.isLineIncluded(lineName))
                throw new IllegalArgumentException();
            return lineName;
        }catch(IllegalArgumentException e){
            printUtils.nonExistentLineError();
            return whichLineAdded();
        }
    }

    private static String whichStationOfRouteDeleted(String lineName){
        printUtils.printStationOfRouteDeletedGuide();
        try{
            String stationName = inputUtils.inputStationName();
            if(!routeRepository.doesLineIncludeStation(lineName,stationName))
                throw new IllegalArgumentException();
            return stationName;
        }catch(IllegalArgumentException e){
            printUtils.nonExistentStationError();
            return whichStationOfRouteDeleted(lineName);
        }
    }

    private static void subwayMapPrint() {
        System.out.println();
        for (Route route : routeRepository.routes()) {
            route.getInfo();
        }
    }
}
