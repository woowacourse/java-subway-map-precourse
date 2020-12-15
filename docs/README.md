# PKEUGINE 브랜치

pkeugine 브랜치 구현물은 다음과 같은 특징을 갖고 있습니다:

1. 사용자 입력 앞뒤에 있는 공백을 무시합니다.
2. 구간 추가에서 **순서 1**은 상행 종점역입니다. 이유는 [이 답변](https://github.com/woowacourse/java-subway-map-precourse/discussions/8#discussioncomment-203708)을 참조해주세요.
    * 따라서 구간 추가 기능으로 새로운 종점역을 지정할 수 있습니다.
3. 역과 노선의 이름은 (한글+숫자)역, (한글+숫자)선 형태만 가능합니다. (ex: 가산디지털단지역, 종로3가역, 3호선, 신분당선)
4. 노선에 같은 역을 중복해서 넣을 수 없습니다. 즉, 다음과 같은 상황을 만들 수 없습니다:
    * 상행 종점역과 하행 종점역이 같아 실제 2호선처럼 순환하는 구조 ⛔️
    * 어느 종점역을 노선의 다른 역과 연결하여 실제 6호선의 응암순환 구간처럼 만드는 구조 ⛔️
    * 노선의 종점역 위치가 아닌 서로 다른 두 곳에 어느 역을 넣어 만드는 메듭형 구조 (이 경우는 갈래길에 해당합니다.) ⛔️ 

## 🛠 기능 목록
- [x] 메인 메뉴를 출력한다.
    - [x] 사용자의 선택을 입력 받는다.
    - [x] 선택이 범위에서 벗어난 경우 에러를 출력한다.
    - [x] 종료가 선택된 경우 프로그램을 종료한다.
  
- [x] 역 이름을 입력받는다.
    - [x] 역 이름이 2글자 이상인지 확인한다.
    - [x] 역의 이름이 '역'으로 끝나는지 확인한다.
    - [x] 역이 이미 존재하는지 확인한다.
    - [x] 역을 지우는 경우 그 역이 노선에 포함되어 있는지 확인한다.
    - [x] 역을 등록한다.
    - [x] 역을 삭제한다.
    - [x] 등록된 역을 조회한다.
    
- [x] 노선 이름을 입력받는다.
    - [x] 노선 이름이 2글자 이상인지 확인한다.
    - [x] 노선의 이름이 '선'으로 끝나는지 확인한다.
    - [x] 노선이 이미 존재하는지 확인한다.
    - [x] 노선의 상행 종점역과 하행 종점역을 입력받는다.
    - [x] 노선을 등록한다.
    - [x] 노선을 삭제한다.
    - [x] 노선에 남은 역이 두 개 이하인 경우 역을 제거할 수 없다.
    - [x] 등록된 노선을 조회한다.
  
- [x] 역과 노선의 이름이 한글 또는 숫자로 이루어져 있는지 확인한다.
- [x] 역과 노선의 이름에 공백이 포함되어 있는지 확인한다.
- [x] 사용자 입력 앞뒤로 공백이 있어도 무시한다.
    
- [x] 원하는 노선의 구간에 역을 추가한다.
- [x] 원하는 노선의 구간의 역을 삭제한다.
  
- [x] 지하철 노선도를 출력한다.

- [x] 기본 데이터를 추가한다.
- [x] 데이터가 추가 / 삭제될 경우 그 사실을 출력한다.

## 📁 디렉토리 및 패키지 구조
```
|- docs
|- src/main/java/subway
    ㄴ Application.java
    ㄴ DummySetup.java
    |- controller
        ㄴ Controller.java
        |- menu
            ㄴ MenuController.java
            ㄴ MainMenuController.java
            ㄴ StationMenuController.java
            ㄴ LineMenuController.java
            ㄴ SectionMenuController.java
        |- station
            ㄴ StationAddController.java
            ㄴ StationDeleteController.java
            ㄴ StationViewController.java
        |- line
            ㄴ LineAddController.java
            ㄴ LineDeleteController.java
            ㄴ LineViewController.java
        |- section
            ㄴ SectionAddController.java
            ㄴ SectionDeleteController.java
        |- map
            ㄴ MapController.java
    |- domain
        |- line
            ㄴ Line.java
            ㄴ LineRepository.java
        |- station
            ㄴ Station.java
            ㄴ StationRepository.java
    |- utils
        ㄴ LineRepositoryValidator.java
        ㄴ LineValidator.java
        ㄴ MenuControllerValidator.java
        ㄴ NameValidator.java
        ㄴ StationRepositoryValidator.java
    |- view
        ㄴ OutputView.java
        ㄴ InputView.java
        ㄴ MenuMessage.java
        ㄴ InfoMessage.java
        ㄴ ErrorMessage.java
```

## 👨‍🏫 클래스 설명

### 일반
| 클래스 | 설명 |
|---|---|
| Application | 프로그램의 시작점입니다. 사용자가 종료할 때까지 MainController를 계속해서 실행합니다. |
| DummySetup | 기본적으로 포함해야할 역 정보와 노선 정보를 적절한 Repository에 넣어줍니다. |

### controller
| 클래스 | 설명 |
|---|---|
| Controller | 컨트롤러 인터페이스입니다. 해당 인터페이스를 이용하여 컨트롤러 컬렉션을 만듭니다. |
| **메뉴 관련** | |
| MenuController | 메뉴에 관련된 컨트롤러가 상속받을 추상 클래스입니다. 컨트롤러 컬렉션을 포함하고 있습니다. |
| MainMenuController | 메인 메뉴를 실행합니다. 컨트롤러 컬렉션 안에 다른 메뉴 컨트롤러를 포함합니다. |
| StationMenuController | 역 관련 메뉴를 실행합니다. 컨트롤러 컬렉션 안에 역 관련 컨트롤러를 포함합니다. |
| LineMenuController | 노선 관련 메뉴를 실행합니다. 컨트롤러 컬렉션 안에 노선 관련 컨트롤러를 포함합니다. |
| SectionMenuController | 구간 관련 메뉴를 실행합니다. 컨트롤러 컬렉션 안에 구간 관련 컨트롤러를 포함합니다. |
| **역 관련** | |
| StationAddController | 역을 등록하는 작업을 담당하는 클래스입니다. |
| StationDeleteController | 역을 삭제하는 작업을 담당하는 클래스입니다. |
| StationViewController | 역을 조회하는 작업을 담당하는 클래스입니다. |
| **노선 관련** | |
| LineAddController | 노선을 등록하는 작업을 담당하는 클래스입니다. |
| LineDeleteController | 노선을 삭제하는 작업을 담당하는 클래스입니다. |
| LineViewController | 노선을 조회하는 작업을 담당하는 클래스입니다. |
| **구간 관련** | |
| SectionAddController | 구간을 등록하는 작업을 담당하는 클래스입니다. |
| SectionDeleteController | 구간을 삭제하는 작업을 담당하는 클래스입니다. |
| **노선도 관련** | |
| MapController | 노선도를 출력하는 클래스입니다. 메뉴 컨트롤러가 아니지만, MainController의 컨트롤러 컬렉션에 포함되어 있습니다. |

### domain
| 클래스 | 설명 |
|---|---|
| Station | 지하철 역을 나타낸 클래스입니다. |
| Line | 지하철 노선을 나타낸 클래스입니다. 노선에 포함되는 역을 저장할 수 있습니다. |
| StationRepository | 해당 프로그램에 등록된 역 정보를 저장하는 클래스입니다. |
| LineRepository | 해당 프로그램에 등록된 노선 정보를 저장하는 클래스입니다. |

### utils
| 클래스 | 설명 |
|---|---|
| MenuRepositoryValidator | 메뉴 화면에서 사용자 입력의 유효성을 판단합니다. |
| StationValidator | 존재하지 않습니다. 관련 유효성 판단을 NameValidator에서 할 수 있습니다. |
| LineValidator | 노선에 역을 등록 / 삭제할 때의 유효성을 판단합니다. |
| StationRepositoryValidator| 역의 등록과 삭제에 관한 유효성을 판단합니다. |
| LineRepositoryValidator | 노선의 등록과 삭제에 관한 유효성을 판단합니다. |
| NameValidator | 역과 노선의 이름에 관련된 유효성을 확인합니다. |

### view
| 클래스 | 설명 |
|---|---|
| OutputView | 프로그램에서 정보 출력을 담당하는 클래스입니다. |
| InputView | 사용자의 입력을 받는 클래스입니다. |
| MenuMessage | 메뉴에 출력되는 정보를 담고 있습니다. |
| InfoMessage | 사용자의 입력에 따라 출력하는 알림을 담고 있습니다. |
| ErrorMessage | 사용자의 입력에 따라 출력하는 에러 정보를 담고 있습니다. |
