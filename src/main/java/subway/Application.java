package subway;

import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class Application {
	final static Scanner scanner = new Scanner(System.in);
	static String select = null;

	public static void main(String[] args) {
		while(true) {
			if (main_selected_function()) {
				break;
			}
		}
	}

	private static void print_main_menu() {
		System.out.println("## 메인 화면");
		System.out.println("1. 역 관리");
		System.out.println("2. 노선 관리");
		System.out.println("3. 구간 관리");
		System.out.println("4. 지하철 노선도 출력");
		System.out.println("Q. 종료");
		System.out.println("\n## 원하는 기능을 선택하세요.");
		select = scanner.next();
	}

	private static boolean main_selected_function() {		
		print_main_menu();
		if (select.equals("Q")) {
			return true;
		}
		if (select.equals("1")) {
			station_function();
			return false;
		}
		if (select.equals("2")) {
			select_line_function();
			return false;
		}
		if (select.equals("3")) {

			return false;
		}
		if (select.equals("4")) {
			print_all_stations_of_lines();
			return false;
		}
		return false;
	}
	
	private static void line_function() {
		while(true) {
			if (select_line_function()) {
				break;
			}
		}
	}
	
	private static void station_function() {
		while (true) {
			if (select_station_function()) {
				break;
			}
		}
	}
	
	private static void print_all_stations_of_lines() {
		System.out.println("## 지하철 노선도");
		for (Line line : LineRepository.lines()) {
			line.print_stationOfLine();
			System.out.println();
		}
	}

	private static void print_station_management_menu() {
		System.out.println("## 역 관리 화면");
		System.out.println("1. 역 등록");
		System.out.println("2. 역 삭제");
		System.out.println("3. 역 조회");
		System.out.println("B. 돌아가기");
		System.out.println("\n## 원하는 기능을 선택하세요.");
		select = scanner.next();
	}

	private static void station_regist() {
		System.out.println("## 등록할 역 이름을 입력하세요.");
		Station_management.add_station(scanner.next());
	}

	private static void station_delete() {
		System.out.println("## 삭제할 역 이름을 입력하세요.");
		Station_management.delete_station(scanner.next());
	}

	private static boolean select_station_function() {
		print_station_management_menu();
		if (select.equals("B")) {
			return true;
		}
		if (select.equals("1")) {
			station_regist();
			return false;
		}
		if (select.equals("2")) {
			station_delete();
			return false;
		}
		if (select.equals("3")) {
			Station_management.print_stations();
			return false;
		}
		return false;
	}

	private static void print_line_management_menu() {
		System.out.println("## 노선 관리 화면");
		System.out.println("1. 노선 등록");
		System.out.println("2. 노선 삭제");
		System.out.println("3. 노선 조회");
		System.out.println("B. 돌아가기");
		System.out.println("\n## 원하는 기능을 선택하세요.");
		select = scanner.next();
	}

	private static void line_regist() {
		System.out.println("## 등록할 노선 이름을 입력하세요.");
		String new_line_name = scanner.next();
		System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
		String UP = scanner.next();
		System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
		String DOWN = scanner.next();
		Line_management.add_line(new_line_name, UP, DOWN);
	}

	private static void line_delete() {
		System.out.println("## 삭제할 역 이름을 입력하세요.");
		Line_management.delete_line(scanner.next());
	}	

	private static boolean select_line_function() {
		print_line_management_menu();
		if (select.equals("B")) {
			return true;
		}
		if (select.equals("1")) {
			line_regist();
			return false;
		}
		if (select.equals("2")) {
			line_delete();
			return false;
		}
		if (select.equals("3")) {
			Line_management.print_lines();
			return false;
		}
		System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
		return false;
	}

	private static void print_section_management_menu() {
		System.out.println("1. 구간 등록");
		System.out.println("2. 구간 삭제");
		System.out.println("B. 돌아가기");
		System.out.println("\n## 원하는 기능을 선택하세요.");
		select = scanner.next();
	}

}
