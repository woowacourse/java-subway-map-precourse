package subway.view;

public class StationInputView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "등록할 역 이름을 입력하세요";

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
