package subway.service.input;

public interface InputService {
    int MANAGE_STATION = 1;
    int MANAGE_ROUTE = 2;
    int MANAGE_SECTION = 3;
    int MANAGE_MAP = 4;
    String MAIN_OPTION_QUIT = "Q";
    int OPTION_QUIT = -999;
    String MAIN_OPTION_BACK = "B";
    int OPTION_BACK = -888;
    int OPTION_ERROR = -1;
    int ADD = 1;
    int DELETE = 2;
    int FIND = 3;

    String getName();

    int getMainOption();

    int getManageStationOption();

    int getManageRouteOption();
}
