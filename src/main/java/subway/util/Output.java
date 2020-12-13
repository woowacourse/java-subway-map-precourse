package subway.util;

public class Output {
	public static void mainView() {
		Output.title(Message.MAIN_VIEW);
		Output.print(Message.MAIN_STATION_MANAGEMENT);
		Output.print(Message.MAIN_LINE_MANAGEMENT);
		Output.print(Message.MAIN_LINE_SECTION);
		Output.print(Message.MAIN_SUBWAY_LINE_PRINT);
		Output.print(Message.MAIN_QUITE);
		Output.title(Message.FUNCTION_CHOICE);
	}
	
	public static void stationManagement() {
		Output.title(Message.STATION_VIEW);
		Output.print(Message.STATION_CREATE);
		Output.print(Message.STATION_REMOVE);
		Output.print(Message.STATION_READ);
		Output.print(Message.BACK);
		Output.title(Message.FUNCTION_CHOICE);
	}
	
 	public static void lineManagement() {
 		Output.title(Message.LINE_VIEW);
 		Output.print(Message.LINE_CREATE);
 		Output.print(Message.LINE_REMOVE);
 		Output.print(Message.LINE_READ);
 		Output.print(Message.BACK);
 		Output.title(Message.FUNCTION_CHOICE);
 	}
 	
 	public static void sectionManagement() {
 		Output.title(Message.SECTION_VIEW);
 		Output.print(Message.SECTION_CREATE);
 		Output.print(Message.SECTION_REMOVE);
 		Output.print(Message.BACK);
 		Output.title(Message.FUNCTION_CHOICE);
 	}
 	
 	public static void title(String message) {
 		System.out.println("\n## " + message);
 	}
 	
 	public static void print(String message) {
 		System.out.println(message);
 	}
	
	public static void info(String message) {
		System.out.println("[INFO] " + message);
	}
	
	public static void error(String message) {
		System.out.println("[ERROR] " + message);
	}
}
