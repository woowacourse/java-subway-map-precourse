package subway.view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in); 
	
	public static String getSelectFunction() {
		System.out.println(OutputView.SELETE_FUNCTION);
		String select = scanner.nextLine();
		return select;
	}
	
	public static String getRegisterStation() {
		System.out.println(OutputView.REGISTER_STATION);
		String name = scanner.nextLine();
		return name;
	}
	
	public static String getRegisterLine() {
		System.out.println(OutputView.REGISTER_LINE);
		String name = scanner.nextLine();
		return name;
	}
	
	public static String getDeleteStation() {
		System.out.println(OutputView.DELETE_STATION);
		String name = scanner.nextLine();
		return name;
	}
	
	public static String getDeleteLine() {
		System.out.println(OutputView.DELETE_LINE);
		String name = scanner.nextLine();
		return name;
	}
	
	public static String getAscendingEndPointLine() {
		System.out.println(OutputView.ASCENDING_END_POINT);
		String name = scanner.nextLine();
		return name;
	}
	
	public static String getDescendingEndPointLine() {
		System.out.println(OutputView.DESCENDING_END_POINT);
		String name = scanner.nextLine();
		return name;
	}
	
	public static String getSelectLineSection() {
		System.out.println(OutputView.SELETE_LINE);
		String name = scanner.nextLine();
		return name;
	}
	
	public static String getSelectStationSection() {
		System.out.println(OutputView.SELETE_STATION);
		String name = scanner.nextLine();
		return name;
	}
	
	public static int getRegisterSequenceSection() {
		System.out.println(OutputView.REGISTER_SEQUENCE);
		int number = scanner.nextInt();
		return number;
	}
	
	public static String getDeleteLineSection() {
		System.out.println(OutputView.DELETE_SECTION_LINE);
		String name = scanner.nextLine();
		return name;
	}
	
	public static String getDeleteStationSection() {
		System.out.println(OutputView.DELETE_SECTION_STATION);
		String name = scanner.nextLine();
		return name;
	}
}
