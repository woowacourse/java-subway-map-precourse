package subway.util;

import java.util.Scanner;

import subway.Subway;
import subway.domain.LineRepository;

public class ViewManager {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void createStation() {
		System.out.println(Message.STATION_CREATE_NAME_INPUT);
		Subway.addStation(Input.nextLine(scanner));
	}
	
	public static void removeStation() {
		System.out.println(Message.STATION_REMOVE_NAME_INPUT);
		Subway.removeStation(Input.nextLine(scanner));
	}
	
	public static void createLine() {
		String upBoundTerminus;
		String downstreamTerminus;
		
		System.out.println(Message.LINE_CREATE_NAME_INPUT);
		String lineName = Input.nextLine(scanner);
		
		if (!LineRepository.contains(lineName)) {
			System.out.println(Message.LINE_UP_BOUND_TERMINUS);
			upBoundTerminus = Input.nextLine(scanner);
			
			System.out.println(Message.LINE_DOWNSTREAM_TERMINUS);
			downstreamTerminus = Input.nextLine(scanner);
			
			Subway.addLine(lineName, upBoundTerminus, downstreamTerminus);
		}
	}
	
	public static void removeLine() {
		System.out.println(Message.LINE_REMOVE_NAME_INPUT);
		Subway.removeLine(Input.nextLine(scanner));
	}
}
