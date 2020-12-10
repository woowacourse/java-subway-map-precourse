package subway.utils;

/**
 * 프로그램의 출력 부분을 담당하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/10
 */
public class PrintUtils {

    public void printMainMenu(){
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료\n");
    }

    public void printSelectFunction(){
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public void invalidMenuError(){
        System.out.println("[ERROR] 목록에 있는 메뉴 번호를 입력해주세요.");
    }
}
