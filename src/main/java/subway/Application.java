package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.exception.DomainIsNotExistedException;

import java.util.Scanner;

public class Application {
    static {
        try {
            initializeSecondLine();
            initializeThirdLine();
            initializeNewboondangLine();
        } catch (DomainIsNotExistedException domainIsNotExistedException) {
            throw new RuntimeException("애플리케이션 구동에 실패하였습니다");
        }
    }

    private static void initializeSecondLine() throws DomainIsNotExistedException {
        Line secondLine = LineRepository.getLine("2호선");

        secondLine.addStation(StationRepository.getStation("교대역"));
        secondLine.addStation(StationRepository.getStation("강남역"));
        secondLine.addStation(StationRepository.getStation("역삼역"));
    }

    private static void initializeThirdLine() throws DomainIsNotExistedException {
        Line thirdLine = LineRepository.getLine("3호선");

        thirdLine.addStation(StationRepository.getStation("교대역"));
        thirdLine.addStation(StationRepository.getStation("남부터미널역"));
        thirdLine.addStation(StationRepository.getStation("양재역"));
        thirdLine.addStation(StationRepository.getStation("매봉역"));
    }

    private static void initializeNewboondangLine() throws DomainIsNotExistedException {
        Line newboondangLine = LineRepository.getLine("신분당선");

        newboondangLine.addStation(StationRepository.getStation("교대역"));
        newboondangLine.addStation(StationRepository.getStation("양재역"));
        newboondangLine.addStation(StationRepository.getStation("양재시민의숲역"));
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println(LineRepository.lines());
    }
}
