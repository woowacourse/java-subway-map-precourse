package subway.view;

import java.util.Scanner;

public class MainView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "메인 화면";
	private static final String FIRST_MENU_MESSAGE = "역 관리";
	private static final String SECOND_MENU_MESSAGE = "노선 관리";
	private static final String THIRD_MENU_MESSAGE = "구간 관리";
	private static final String FOURTH_MENU_MESSAGE = "지하철 노선도 출력";
	private static final String QUIT_MENU_MESSAGE = "종료";

	public MainView(Scanner scanner) {
		print();
		selectMenu(scanner);
	}
	
	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
		printFirstMenu(FIRST_MENU_MESSAGE);
		printSecondMenu(SECOND_MENU_MESSAGE);
		printThirdMenu(THIRD_MENU_MESSAGE);
		printFourthMenu(FOURTH_MENU_MESSAGE);
		printQuitMenu(QUIT_MENU_MESSAGE);
	}

	private void selectMenu(Scanner scanner) {
		String menuSelected = scanner.nextLine();
		if (menuSelected.equals(FIRST_MENU)) {
			new StationManagerView();
		} else if (menuSelected.equals(SECOND_MENU)) {
			new LineManagerView();
		} else if (menuSelected.equals(THIRD_MENU)) {
			new SectionManagerView();
		} else if (menuSelected.equals(FOURTH_MENU)) {
			new SubwayMapView();
		} else if (menuSelected.equals(QUIT_MENU)) {
			// Do nothing;
		}
	}
}
