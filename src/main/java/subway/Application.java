package subway;

public class Application {
    public static void main(String[] args) {
        SubwayLineMapInitializer subwayLineMapInitializer = new SubwayLineMapInitializer();
        subwayLineMapInitializer.initialize();
        SubwayLineMap subwayLineMap = new SubwayLineMap();
        subwayLineMap.run();
    }
}
