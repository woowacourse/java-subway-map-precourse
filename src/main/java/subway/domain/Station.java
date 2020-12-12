package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void validate(String name) {
        // 공백 제외 입력이 2글자 미만인지 확인
        // 입력에 특수문자가 들어갔는지 확인
        // 목록에 동일한 역이 존재하는지 확인 - 등록이면 존재하면 에러, 삭제면 존재하지 않으면 에러
    }
}
