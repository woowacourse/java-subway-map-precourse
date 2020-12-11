## 기능 구현 목록

1. 지하철 이름(StationName)
    - 지하철 역 이름을 담는 객체
2. 지하철 역(Station)
    - 지하철 역을 생성
    - Line을 여러개 갖을 수 있다. (List)
    - StationName이 같으면 같은 객체로 인식(Equals Override)
3. 노선 이름 (LineName)
    - 지하철 역 이름을 담는 객체
4. 지하철 노선 (Line)
    - 지하철 노선
    - Station을 여러개 갖을 수 있다.(List)
    - LineName이 같으면 같은 객체로 인식(Equals Override)
    - LineName의 사전순서를 기준으로 정렬한다.
5. 예시 추가
6. Station Repository
    - Staion에 대한 CRUD
7. Line Repository
    - Line에 대한 CRUD
8. InputView
    - 사용자 입력에 대한 콘솔 출력과 입력을 담당한다.
    - InputName : 노선,역에 대한 값을 입력받는다.
    - InputCommand : 화면 이동을 위한 1~n,Q,B등을 입력 받는다.
9. OutView
    - 결과 값에 대한 콘솔 출력을 담당한다.
10. Menu(Interface)
    - Enum이 구현할 인터페이스
    - 사용자 입력값에 대한 화면 화면 이동을 구현하기 위해서(State pattern)
11. XXMenu(Menu인터페이스 구현)
    - 각각의 메뉴화면을 나누기 위한 Enum
    - 메인 메뉴
    - 역 관리 메뉴
    - 노선 관리 메뉴
    - 구간 관리 메뉴
12. SubwayController(Interface)
    - 메뉴에 맞춰 Controller을 다르게 사용한다.
    - MainController, StationController, SectionController,LineController
    - ControllerFactory
13. Action(Enum)
    - 메뉴의 Enum값에 따라 Controller의 실행 메서드를 다르게 하기 위해 생성
    - SAVE, DELETE, SEARCH, BACK
14. Exception
    - 예외 클래스 및 메세지 설정