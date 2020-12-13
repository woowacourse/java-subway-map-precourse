package subway.view;

public class SubwayMapView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "지하철 노선도";
	
	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
