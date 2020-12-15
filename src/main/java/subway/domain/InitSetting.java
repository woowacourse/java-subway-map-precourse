package subway.domain;

public class InitSetting {

    private static String[] initStation = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static String[][] initLine = {{"2호선", "교대역", "역삼역"}, {"3호선", "교대역", "매봉역"}, {"신분당선", "강남역", "양재시민의숲역"}};
    private static String[][] initSection = {{"강남역"}, {"남부터미널역", "양재역"}, {"양재역"}};

    public static void initSetting() {
        initStation();
        initLine();
    }

    private static void initStation() {
        for (String name : initStation) {
            StationRepository.addStation(name);
        }
    }

    private static void initLine(){
        for (int i = 0; i < initLine.length; i++) {
            String line = initLine[i][0];
            String firstStation = initLine[i][1];
            String lastStation = initLine[i][2];
            String[] sections = initSection[i];
            LineRepository.addLine(line, firstStation, lastStation);
            int idx = Constants.START_ORDER;
            for (String section : sections) {
                LineRepository.addSection(String.valueOf(idx++), line, section);
            }
        }
    }
}
