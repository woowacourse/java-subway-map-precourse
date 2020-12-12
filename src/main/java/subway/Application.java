package subway;

import java.util.Scanner;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // TODO - 디버깅용 (개발 완료 후 지우기)
        System.out.println(LineRepository.lines());
        System.out.println(StationRepository.stations());

        Machine machine = new Machine();
        machine.start(scanner);
    }
}
