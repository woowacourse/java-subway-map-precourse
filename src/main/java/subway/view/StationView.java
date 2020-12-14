package subway.view;

import java.util.Scanner;

public class StationView {

	private static final String MAIN_MESSAGE = "## 역 관리 화면";
	private static final String REGISTER_MENU_MASSAGE = "1. 역 등록";
	private static final String DELETE_MENU_MESSAGE = "2. 역 삭제";
	private static final String LOOK_UP_MENU_MESSAGE = "3. 역 조회";
	private static final String SYSTEM_OUT_MESSAGE = "B. 돌아가기";
	private static final String REGISTER_MESSAGE ="\n## 등록할 역 이름을 입력하세요.";
	private static final String REGISTER_COMPLETE_MESSAGE ="\n[INFO] 지하철 역이 등록되었습니다.";
	private static final String DELETE_MESSAGE ="\n## 삭제할 역 이름을 입력하세요.";
	private static final String DELETE_COMPLETE_MESSAGE ="\n[INFO] 지하철 역이 삭제되었습니다.";
	
	public static void printMainScreen() {
		System.out.println(MAIN_MESSAGE);
		System.out.println(REGISTER_MENU_MASSAGE);
		System.out.println(DELETE_MENU_MESSAGE);
		System.out.println(LOOK_UP_MENU_MESSAGE);
		System.out.println(SYSTEM_OUT_MESSAGE);
		MainView.selectFunction();
	}

	public static void printRegisterScreen(Scanner scanner) {
		System.out.println(REGISTER_MESSAGE);
		String registerStation =  scanner.nextLine();
		System.out.println(REGISTER_COMPLETE_MESSAGE);
	}
	
	public static void printDeleteScreen(Scanner scanner) {
		System.out.println(DELETE_MESSAGE);
		String deleteStation =  scanner.nextLine();
		System.out.println(DELETE_COMPLETE_MESSAGE);
	}

}
