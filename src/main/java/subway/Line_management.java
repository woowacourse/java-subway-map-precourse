package subway;

import subway.domain.Line;
import subway.domain.LineRepository;

public class Line_management {
	public static void add_line(String name, String UP, String DOWN) {
		for (Line line : LineRepository.lines()) {
			if (name.equals(line.getName())) {
				System.out.println("[INFO] 이미 존재하는 노선입니다.");
				return;
			}
		}
		Line new_line = new Line(name, UP, DOWN);		
		LineRepository.addLine(new_line);		
	}
	
	public static void delete_line(String name) {
		if (LineRepository.deleteLineByName(name)) {
			System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
			return;
		}
		System.out.println("[ERROR] 존재하지 않는 지하철 노선입니다.");
	}
	
	public static void print_lines() {
		System.out.println("## 노선 목록");
		for (Line line : LineRepository.lines()) { 
			System.out.println("[INFO] "+line.getName());
		}
	}
}
