package subway.view;

public class LineListView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "노선 목록";

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
