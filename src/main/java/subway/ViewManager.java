package subway;

import java.util.Scanner;

import subway.domain.LineRepository;
import subway.util.Input;
import subway.util.Message;
import subway.util.Output;

public class ViewManager {
	private static Scanner scanner = new Scanner(System.in);
	
	private static boolean isUseableName(String name) {
		if (name.length() >= 2) {
			return true;
		}
		return false;
	}
	
	private static String getUpBoundTerminus() {
		Output.title(Message.LINE_UP_BOUND_TERMINUS);
		return Input.nextLine(scanner);
	}
	
	private static String getDownstreamTerminus() {
		Output.title(Message.LINE_DOWNSTREAM_TERMINUS);
		return Input.nextLine(scanner);
	}
	
	public static void createStation() {
		Output.title(Message.STATION_CREATE_NAME_INPUT);
		String stationName = Input.nextLine(scanner);
		if (!isUseableName(stationName)) {
			Output.error(Message.NOT_USEABLE_STATION_NAME_LENGTH);
			return;
		}
		Subway.addStation(stationName);
	}
	
	public static void removeStation() {
		Output.title(Message.STATION_REMOVE_NAME_INPUT);
		Subway.removeStation(Input.nextLine(scanner));
	}
	
	public static void createLine() {		
		Output.title(Message.LINE_CREATE_NAME_INPUT);
		String lineName = Input.nextLine(scanner);
		
		if (!isUseableName(lineName)) {
			Output.error(Message.NOT_USEABLE_LINE_NAME_LENGTH);
			return;
		}
		
		if (!LineRepository.contains(lineName)) {
			Subway.addLine(lineName, getUpBoundTerminus(), getDownstreamTerminus());
			return;
		}
		Output.error(Message.ALREADY_CREATED_LINE);
	}
	
	public static void removeLine() {
		Output.title(Message.LINE_REMOVE_NAME_INPUT);
		Subway.removeLine(Input.nextLine(scanner));
	}
	
	public static void createSection() {
		Output.title(Message.SECTION_LINE);
		String lineName = Input.nextLine(scanner);
		
		Output.title(Message.SECTION_STATION);
		String stationName = Input.nextLine(scanner);
		
		Output.title(Message.SECTION_SEQUENCE);
		String sequence = Input.nextLine(scanner);
		
		Subway.addSection(lineName, stationName, sequence);
	}
	
	public static void removeSection() {
		Output.title(Message.SECTION_REMOVE_LINE);
		String lineName = Input.nextLine(scanner);
		
		Output.title(Message.SECTION_REMOVE_STATION);
		String stationName = Input.nextLine(scanner);
		
		Subway.removeSection(lineName, stationName);
	}
}
