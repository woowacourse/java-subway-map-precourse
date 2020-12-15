package subway.domain;

public class ErrorMessage {
    public static void displayErrorMessage(int errorCase) {
        if (errorCase == Constants.FUNCTION_INPUT_ERROR)
            System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
        if (errorCase == Constants.ALREADY_EXIST_ERROR)
            System.out.println("[ERROR] 이미 등록된 역/노선 이름입니다.");
        if (errorCase == Constants.NAME_LENGTH_ERROR)
            System.out.println("[ERROR] 이름을 2글자 이상 입력해주세요.");
        if (errorCase == Constants.NO_SUCH_NAME_ERROR)
            System.out.println("[ERROR] 등록되지 않은 역/노선 이름입니다.");
        if (errorCase == Constants.HAS_IN_LINE_ERROR)
            System.out.println("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
        if (errorCase == Constants.SAME_NAME_ERROR)
            System.out.println("[ERROR] 상행역과 하행역은 같을 수 없습니다.");
        if (errorCase == Constants.HAS_IN_SPECIFIC_LINE_ERROR)
            System.out.println("[ERROR] 이미 해당 노선에 존재하는 역입니다.");
        if (errorCase == Constants.UNVALID_INDEX_ERROR)
            System.out.println("[ERROR] Range 내의 정수만 입력할 수 있습니다.");
        if (errorCase == Constants.CANT_DELETE_SECTION_ERROR)
            System.out.println("[ERROR] 역이 2개 이하인 노선의 구간은 삭제할 수 없습니다.");
        if (errorCase == Constants.HAS_NOT_IN_SPECIFIC_LINE_ERROR)
            System.out.println("[ERROR] 해당 노선에 존재하지 않는 역입니다.");
    }
}
