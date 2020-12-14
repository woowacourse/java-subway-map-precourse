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
	
}
