package subway.service.input;

public interface InputService {
    int MAIN_OPTION_ONE = 1;
    int MAIN_OPTION_TWO = 2;
    int MAIN_OPTION_THREE = 3;
    int MAIN_OPTION_FOUR = 4;
    String MAIN_OPTION_QUIT = "Q";
    int OPTION_QUIT = -999;
    int OPTION_ERROR = -1;

    String getStationName();
    int getMainOption();
}
