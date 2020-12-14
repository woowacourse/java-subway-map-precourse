package subway;

import java.util.Objects;
import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.Message;
import subway.util.Output;

public class Subway {	
	private static boolean isUseableSection(String lineName, String stationName) {
		if (!LineRepository.contains(lineName)) {
			Output.error(Message.NOT_CREATED_LINE_NAME);
			return false;
		} else if (!StationRepository.contains(stationName)) {
			Output.error(Message.NOT_CREATED_STATION_NAME);
			return false;
		}
		return true;
	}
	
	private static boolean isUseableSequence(Line line, int seq) {
		if (seq < 1 || seq > line.getStations().size() + 1) {
			return false;
		}
		return true;
	}
	
	private static boolean isDuplicateStationInLine(Line line, String stationName) {
		if (!line.getStations().contains(stationName)) {
			return false;
		}
		return true;
	}
	 
	private static void addSectionByLine(Line line, String lineName, String stationName, int seq) {
		if (Objects.equals(line.getName(), lineName)) {
			if (isDuplicateStationInLine(line, stationName)) {
				Output.error(Message.DUPLICATED_STATION_IN_LINE);
				return;
			}
			if (isUseableSequence(line, seq)) {
				line.addStation(seq - 1, stationName);
				Output.info(Message.SECTION_CREATE_SUCCESS);
				return;
			}
			Output.error(Message.NOT_USEABLE_SEQUENCE);			
		}
	}
	
	private static void removeSectionByLine(Line line, String lineName, String stationName) {
		if (Objects.equals(line.getName(), lineName)) {
			if (line.removeStation(stationName)) {
				Output.info(Message.SECTION_WAS_REMOVE);
				return;
			}
			Output.error(lineName + Message.HAVE_NOT_STATION);
		}
	}
	
	public static void run(Scanner scanner) {
		View view = new View(scanner);
		Initializer.run();
		
		while (true) {
			view.main();
		}
	}
	
	public static void addStation(String name) {
		if (!StationRepository.contains(name)) {
			StationRepository.addStation(new Station(name));
			Output.info(Message.STATION_WAS_CREATE);
			return;
		}
		Output.error(Message.ALREADY_CREATED_STATION);
	}
	
	public static void readStation() {
		for (Station station: StationRepository.getStations()) {
			Output.info(station.getName());
		}
	}
	
	public static void removeStation(String name) {
		if (StationRepository.deleteStation(name)) {
			Output.info(Message.STATION_WAS_REMOVE);
			return;
		}
		Output.error(Message.NOT_CREATED_STATION_NAME);
	}
	
	public static void addLine(String name, String lineUpBoundTerminus, String downstreamTerminus) {
		if (!StationRepository.contains(lineUpBoundTerminus) || !StationRepository.contains(downstreamTerminus)) {
			Output.error(Message.NOT_CREATED_STATION_NAME);
			return;
		}
		LineRepository.addLine(new Line(name, lineUpBoundTerminus, downstreamTerminus));
		Output.info(Message.LINE_WAS_CREATE);
	}
	
	public static void addLineUpBoundTerminus(String name) {
		if (!StationRepository.contains(name)) {
			StationRepository.addStation(new Station(name));
			Output.info(Message.STATION_WAS_REMOVE);
			return;
		}
		Output.error(Message.ALREADY_CREATED_STATION);
	}
	
	public static void readLine() {
		for (Line line: LineRepository.getLines()) {
			Output.info(line.getName());
		}
	}
	
	public static void removeLine(String name) {
		if (LineRepository.deleteLineByName(name)) {
			Output.info(Message.LINE_WAS_REMOVE);
			return;
		}
		Output.error(Message.NOT_CREATED_LINE_NAME);
	}
	
	public static void addSection(String lineName, String stationName, String seq) {
		if (isUseableSection(lineName, stationName)) {
			for (Line line: LineRepository.getLines()) {
				addSectionByLine(line, lineName, stationName, Integer.parseInt(seq));
			}
		}
	}
	
	public static void removeSection(String lineName, String stationName) {
		if (isUseableSection(lineName, stationName)) {
			for (Line line: LineRepository.getLines()) {
				removeSectionByLine(line, lineName, stationName);
			}
		}
	}
	
	public static void show() {
		for (Line line: LineRepository.getLines()) {
			System.out.println();
			Output.info(line.getName());
			Output.info("---");
			for (String station: line.getStations()) {
				Output.info(station);
			}
		}
	}
}
