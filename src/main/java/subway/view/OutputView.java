package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class OutputView {
	private static final String MAIN_MESSAGE = "## ���� ȭ��";
	private static final String MAIN_STATION_MESSAGE = "1. �� ����";
	private static final String MAIN_LINE_MESSAGE = "2. �뼱 ����";
	private static final String MAIN_SECTION_MESSAGE = "3. ���� ����";
	private static final String MAIN_MAP_PRINT_MESSAGE = "4. ����ö �뼱�� ���";

	private static final String STATION_MANAGE_MESSAGE = "## �� ���� ȭ��";
	private static final String STATION_REGISTER_MESSAGE = "1. �� ���";
	private static final String STATION_DELETE_MESSAGE = "2. �� ����";
	private static final String STATION_PRINT_MESSAGE = "3. �� ��ȸ";

	private static final String LINE_MANAGE_MESSAGE = "## �뼱 ���� ȭ��";
	private static final String LINE_REGISTER_MESSAGE = "1. �뼱 ���";
	private static final String LINE_DELETE_MESSAGE = "2. �뼱 ����";
	private static final String LINE_PRINT_MESSAGE = "3. �뼱 ��ȸ";

	private static final String SECTION_MANAGE_MESSAGE = "## ���� ���� ȭ��";
	private static final String SECTION_REGISTER_MESSAGE = "1. ���� ���";
	private static final String SECTION_DELETE_MESSAGE = "2. ���� ����";

	private static final String SYSTEM_OUT = "Q. ����\n";
	private static final String BACK_TO_MAIN = "B. ���ư���\n";
	private static final String INFOMATION = "[INFO]";
	private static final String DIVIDE_INFORMATION = "---";
	private static final String SUBWAY_MAP = "## ����ö �뼱��";
	public static final String SELETE_FUNCTION = "## ���ϴ� ����� �����ϼ���.";

	public static final String REGISTER_STATION = "## ����� �� �̸��� �Է��ϼ���.";
	public static final String DELETE_STATION = "## ������ �� �̸��� �Է��ϼ���.";

	public static final String REGISTER_LINE = "## ����� �뼱 �̸��� �Է��ϼ���.";
	public static final String ASCENDING_END_POINT = "## ����� �뼱�� ���� ������ �̸��� �Է��ϼ���.";
	public static final String DESCENDING_END_POINT = "## ����� �뼱�� ���� ������ �̸��� �Է��ϼ���.";
	public static final String DELETE_LINE = "## ������ �뼱 �̸��� �Է��ϼ���.";

	public static final String SELETE_LINE = "## �뼱�� �Է��ϼ���.";
	public static final String SELETE_STATION = "## ���̸��� �Է��ϼ���.";
	public static final String REGISTER_SEQUENCE = "## ������ �Է��ϼ���.";
	public static final String DELETE_SECTION_LINE = "## ������ ������ �뼱�� �Է��ϼ���.";
	public static final String DELETE_SECTION_STATION = "## ������ ������ ���� �Է��ϼ���.";

	public static void printMainMenu() {
		System.out.println(MAIN_MESSAGE);
		System.out.println(MAIN_STATION_MESSAGE);
		System.out.println(MAIN_LINE_MESSAGE);
		System.out.println(MAIN_SECTION_MESSAGE);
		System.out.println(MAIN_MAP_PRINT_MESSAGE);
		System.out.println(SYSTEM_OUT);
	}

	public static void printStationManagementMenu() {
		System.out.println(STATION_MANAGE_MESSAGE);
		System.out.println(STATION_REGISTER_MESSAGE);
		System.out.println(STATION_DELETE_MESSAGE);
		System.out.println(STATION_PRINT_MESSAGE);
		System.out.println(BACK_TO_MAIN);
	}

	public static void printLineManagementMenu() {
		System.out.println(SECTION_MANAGE_MESSAGE);
		System.out.println(LINE_REGISTER_MESSAGE);
		System.out.println(LINE_DELETE_MESSAGE);
		System.out.println(LINE_PRINT_MESSAGE);
		System.out.println(BACK_TO_MAIN);
	}

	public static void printSectionManagementMenu() {
		System.out.println(SELETE_LINE);
		System.out.println(SECTION_REGISTER_MESSAGE);
		System.out.println(SECTION_DELETE_MESSAGE);
		System.out.println(BACK_TO_MAIN);
	}

	public static void printTotalMap() {
		System.out.println(SUBWAY_MAP);
		for (Line line : LineRepository.lines()) {
			printCombineInfo(line.getName());
			printCombineInfo(DIVIDE_INFORMATION);
			printConbineInfoLine(line);
		}
	}

	private static void printCombineInfo(String message) {
		System.out.println(INFOMATION + message);
	}

	private static void printConbineInfoLine(Line line) {
		for (String stationName : line.getStationInLine()) {
			printCombineInfo(stationName);
		}
	}

	public static void printTotalStation() {
		for (Station station : StationRepository.stations()) {
			printCombineInfo(station.getName());
		}
	}

	public static void printTotalLine() {
		for (Line line : LineRepository.lines()) {
			printCombineInfo(line.getName());
		}
	}
}
