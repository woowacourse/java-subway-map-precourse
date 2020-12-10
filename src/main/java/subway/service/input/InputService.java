package subway.service.input;

public interface InputService {
    int MANAGE_STATION = 1;
    int MANAGE_ROUTE = 2;
    int MANAGE_SECTION = 3;
    int MANAGE_MAP = 4;
    String MAIN_OPTION_QUIT = "Q";
    int OPTION_QUIT = -999;
    int OPTION_ERROR = -1;

    String getStationName();
    int getMainOption();
}
