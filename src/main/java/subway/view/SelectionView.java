package subway.view;

public class SelectionView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "원하는 기능을 선택하세요.";

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
