package subway.view;

public class ErrorView {

    private static final String NAME_LENGTH_ERROR = "[ERROR] 2글자 이상을 입력해주세요.\n";
    private static final String WRITE_APPROPRIATE_NUMBER = "[ERROR] 적절한 숫자를 입력하세요.\n";
    private static final String DUPLICATE_NAME = "[ERROR] 중복된 이름입니다.\n";
    private static final String NOT_EXIST_NAME = "[ERROR] 존재하지 않는 이름입니다.\n";

    public static void print(String string){
        System.out.println(string);
    }

    public static void nameLengthError() {
        print(NAME_LENGTH_ERROR);
    }

    public static void writeAppropriateNumber() {
        print(WRITE_APPROPRIATE_NUMBER);
    }

    public static void duplicateName() {
        print(DUPLICATE_NAME);
    }

    public static void notExistName() {
        print(NOT_EXIST_NAME);
    }
}
