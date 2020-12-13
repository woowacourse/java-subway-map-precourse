package subway.view;

public class StationListView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "역 목록";

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
