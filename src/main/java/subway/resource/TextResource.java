package subway.resource;

import static subway.resource.Config.MIN_STATION_NAME_LENGTH;

public class TextResource {

    public static final String PREFIX_ERROR = "[ERROR]";
    public static final String PREFIX_INFO = "[INFO]";

    public static final String ERROR_STATION_NAME_LENGTH
        = String.format(PREFIX_ERROR + "지하철역의 이름은 %d 글자 이상이어야 합니다.",
        MIN_STATION_NAME_LENGTH);

    public static final String ERROR_STATION_NAME_DUPLICATED = PREFIX_ERROR
        + "이미 해당 지하철역이 존재 합니다. 등록 할 수 없습니다.";
}
