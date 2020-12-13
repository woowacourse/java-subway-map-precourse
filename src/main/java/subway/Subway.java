package subway;

import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.Input;
import subway.util.Message;
import subway.util.Output;
import subway.util.View;

public class Subway {	
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
			Output.info("지하철 역이 등록되었습니다.");
			return;
		}
		Output.error("이미 등록된 역 이름입니다.");
	}
	
	public static void readStation() {
		for (Station station: StationRepository.getStations()) {
			Output.info(station.getName());
		}
	}
	
	public static void removeStation(String name) {
		if (StationRepository.deleteStation(name)) {
			Output.info("지하철 역이 삭제되었습니다.");
			return;
		}
		Output.error("등록되지 않은 역 이름입니다.");
	}
	
	public static void addLine(String name, String lineUpBoundTerminus, String downstreamTerminus) {
		if (!LineRepository.contains(name)) {
			if (!StationRepository.contains(lineUpBoundTerminus) || !StationRepository.contains(downstreamTerminus)) {
				Output.info("등록되지 않은 역 이름입니다.");
				return;
			}
			
			LineRepository.addLine(new Line(name, lineUpBoundTerminus, downstreamTerminus));
			Output.info("지하철 노선이 등록되었습니다.");
			return;
		}
		Output.error("이미 등록된 노선 이름입니다.");
	}
	
	public static void addLineUpBoundTerminus(String name) {
		if (!StationRepository.contains(name)) {
			StationRepository.addStation(new Station(name));
			Output.info("지하철 역이 등록되었습니다.");
			return;
		}
		Output.error("이미 등록된 역 이름입니다.");
	}
	
	public static void readLine() {
		for (Line line: LineRepository.getLines()) {
			Output.info(line.getName());
		}
	}
	
	public static void removeLine(String name) {
		if (LineRepository.deleteLineByName(name)) {
			Output.info("지하철 노선이 삭제되었습니다.");
			return;
		}
		Output.error("등록되지 않은 노선 이름입니다.");
	}
}
