
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
    - Input : 노선,역, 메뉴선택에 대한 값을 입력받는다.
    - InputNumber : 구간 등록할 때 순서를 입력 받는다.
9. OutView
    - 결과 값을 콘솔에 출력한다.
10. Menu(Interface)
    - Enum이 구현할 인터페이스
    - 화면 이동 및 각각 화면의 메서드 분리
11. XXMenu(Menu인터페이스 구현)
    - 각각의 메뉴화면을 나누기 위한 Enum
    - 메인 메뉴 MainMenu
    - 역 관리 메뉴 StationMenu
    - 노선 관리 메뉴 LineMenu
    - 구간 관리 메뉴 SectionMenu
12. SubwayController(Interface)
    - 메뉴에 맞춰 Controller을 다르게 사용한다.
    - MainController, StationController, SectionController,LineController
    - ControllerFactory : 메뉴 상황에 따라 사용하는 Controller를 다르게 반환한다.
13. Action
    - SAVE, DELETE, SEARCH, BACK의 로직을 실행
    - Menu의 값에 따라서 메서드의 기능이 다르도록 설정
14. Exception
    - 예외 클래스 및 메세지 설정
    
### 구현 클래스 설명

1. 역 (Station)
    - 자신의 이름을 갖는다. 접미사로 포함하는 3글자 이상
    - 자신의 포함되는 Line을 List로 갖고 있다.
    - 역이 삭제될 때, 해당 역을 포함하고 있는 노선에서 역을 함께 삭제한다.
2. 노선 (Line)
    - LineName으로 이름을 갖는다. "선","전철"을 접미사로 포함하는 3글자 이상
    - 자신에게 포함되어 있는 Staion을 List형태로 갖고 있다.
    - 노선이 삭제될 때, 해당 노선을 포함하고 있는 역에서 노선을 함께 삭제한다.
3. Menu(Interface)
    - Enum클래스의 역할을 묶기 위한 인터페이스
    - 메인, 역, 노선, 구간 네 가지 화면이 있다.
    - 화면 출력을 위한 정보 또한 포함하고 있다.
    - Action을 통해서 주어진 기능을 수행한다.
4. Action
    - 화면들의 기능을 Enum클래스로 모아놨다.
    - 기본적으로 저장, 삭제, 조회, 돌아가기(아무것도 안함)이 있다.
5. Controller
    - 각 화면들의 기능을 수행하기 위한 클래스
    - 기본적으로 저장 ,삭제, 단일 검색, 전체 검색이 구현되어 있다.
    - 주어진 예시에서 필요하지 않는 기능들은 구현하지 않았다.
    - ControllerFactory를 통해서 화면에 지정된 구현체를 얻을 수 있다.
6. InputView
    - 사용자 입력을 받기 위한 객체
    - Scanner를 꼭 주입받아야 사용할 수 있다. (NoInitialScannerException발생)
    - Scanner를 주입하면서 객체가 생성된다

    