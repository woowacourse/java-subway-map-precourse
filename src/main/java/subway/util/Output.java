package subway.util;

public class Output {
	public static void mainView() {
		System.out.println(Message.MAIN_VIEW);
		System.out.println(Message.MAIN_STATION_MANAGEMENT);
		System.out.println(Message.MAIN_LINE_MANAGEMENT);
		System.out.println(Message.MAIN_SUBWAY_LINE_PRINT);
		System.out.println(Message.MAIN_QUITE);
		System.out.println(Message.FUNCTION_CHOICE);
	}
	
	public static void stationManagement() {
		System.out.println(Message.STATION_VIEW);
		System.out.println(Message.STATION_CREATE);
		System.out.println(Message.STATION_REMOVE);
		System.out.println(Message.STATION_READ);
		System.out.println(Message.BACK);
		System.out.println(Message.FUNCTION_CHOICE);
	}
	
	public static void info(String name) {
		System.out.println("[INFO] " + name);
	}
	
	public static void error(String message) {
		System.out.println("[ERROR] " + message);
	}
}
