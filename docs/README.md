# 지하철 노선도 미션
우아한테크코스 웹 백엔드 프리코스 3주차 미션 프로젝트입니다.

<br>

## 👩‍💻 구현할 기능 목록
### 초기 설정
#### 지하철 역
- [x] 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역을 등록한다.

#### 지하철 노선
- [x] 2호선, 3호선, 신분당선을 등록한다.

#### 지하철 노선도
- [x] 2호선에는 `상행 종점` 교대역 - 강남역 - 역삼역 `하행 종점`을 등록한다.
- [x] 3호선에는 `상행 종점` 교대역 - 남부터미널역 - 양재역 - 매봉역 `하행 종점`을 등록한다.
- [x] 신분당선에는 `상행 종점` 강남역 - 양재역 - 양재시민의숲역 `하행 종점`을 등록한다.

### 지하철 역
- [x] 지하철 역을 등록한다. [`예외 1`](#exception1)
- [x] 지하철 역을 삭제한다. [`예외 2`](#exception2)
- [x] 지하철 역의 목록을 조회한다.

### 지하철 노선
- [x] 지하철 노선을 등록한다. [`예외 3`](#exception3)
    - [x] 지하철 노선 등록 시 상행 종점역과 하행 종점역을 입력한다. [`예외 4`](#exception4)
- [x] 지하철 노선을 삭제한다. [`예외 5`](#exception5)
- [x] 지하철 노선의 목록을 조회한다.

### 지하철 구간
- [x] 지하철 구간을 추가한다.
    - [x] 하나의 역은 여러 개의 노선에 추가될 수 있다.
    - [x] 새로운 역은 역과 역 사이에 추가될 수 있다.
        - [x] 새로운 역을 삽입할 노선을 입력한다. [`예외 6`](#exception6)
        - [x] 새로운 역의 이름을 입력한다. [`예외 7`](#exception7)
        - [x] 새로운 역의 순서를 입력한다. [`예외 8`](#exception8)
    - [x] 지하철 노선에 갈래길은 생길 수 없다.
- [x] 지하철 구간을 삭제한다.
    - [x] 지하철 노선에 등록된 역을 제거할 수 있다. [`예외 9`](#exception9)
        - [x] 삭제할 구간의 노선을 입력한다. [`예외 10`](#exception10)
        - [x] 삭제할 구간의 역을 입력한다. [`예외 11`](#exception11)
    - [x] 상행 종점역을 제거할 경우 다음 역이 종점이 된다.
    - [x] 하행 종점역을 제거할 경우 이전 역이 종점이 된다.

### 지하철 노선도
- [x] 지하철 노선도를 조회한다.
    - [x] 지하철 노선의 상행 종점부터 하행 종점까지 연결된 순서대로 역 목록을 조회한다.

### 입출력
#### 입력
- [x] 메인 화면에서 1~4 숫자 또는 Q 문자만 입력한다. [`예외 12`](#exception12)
- [x] 역 관리 화면에서 1~3 숫자 또는 B 문자만 입력한다. [`예외 13`](#exception13)
- [x] 노선 관리 화면에서 1~3 숫자 또는 B 문자만 입력한다. [`예외 14`](#exception14)
- [x] 구간 관리 화면에서 1~2 숫자 또는 B 문자만 입력한다. [`예외 15`](#exception15)

#### 출력
- [x] 메인 화면을 출력한다.
- [x] 역 관리 화면을 출력한다.
- [x] 노선 관리 화면을 출력한다.
- [x] 구간 관리 화면을 출력한다.
- [x] 각 화면 기능에 대한 실행 결과는 `[INFO]`를 붙여서 출력한다.
- [x] 각 화면 기능에 대한 에러 발생은 `[ERROR]`를 붙여서 출력한다.

### 돌아가기
- [x] 관리/출력 화면에서 메인 화면으로 돌아간다.
    - [x] B 문자를 입력한다.
    - [x] 기능 실행이 완료되면 자동으로 돌아간다.

### 종료
- [x] 메인 화면에서 프로그램을 종료한다.
    - [x] Q 문자를 입력한다.

### 에러
- [x] 에러가 발생하면 다음 입력을 기다린다.
    - [x] 프로그램은 강제 종료되지 않는다.

### 예외 처리
#### <a id="exception1">`예외 1` </a>
- [x] 지하철 역 이름이 중복되는 경우
- [x] 지하철 역 이름은 2글자 미만인 경우
- [x] 지하철 역 이름이 '역'으로 끝나지 않는 경우

#### <a id="exception2">`예외 2`</a>
- [x] 지하철 역이 지하철 노선에 등록된 경우
- [x] 삭제할 역이 없는 경우

#### <a id="exception3">`예외 3`</a>
- [x] 지하철 노선 이름이 중복되는 경우
- [x] 지하철 노선 이름이 2글자 미만인 경우
- [x] 지하철 노선 이름이 '선'으로 끝나지 않는 경우

#### <a id="exception4">`예외 4`</a>
- [x] 상행 종점역과 하행 종점역이 지하철 역에 존재하지 않는 경우
- [x] 상행 종점역과 하행 종점역이 같은 경우

#### <a id="exception5">`예외 5`</a>
- [x] 삭제할 노선이 없는 경우

#### <a id="exception6">`예외 6`</a>
- [x] 삽입할 노선이 없는 경우

#### <a id="exception7">`에외 7`</a>
- [x] 해당 역이 없는 경우
- [x] 해당 역이 이미 노선에 존재하는 경우

#### <a id="exception8">`예외 8`</a>
- [x] 순서가 문자인 경우
- [x] 순서가 음수 또는 0인 경우
- [x] 순서가 노선에 있는 역 개수+1 보다 큰 수인 경우

#### <a id="exception9">`예외 9`</a>
- [x] 지하철 노선에 포함된 역이 2개 이하인 경우

#### <a id="exception10">`예외 10`</a>
- [x] 해당 노선이 없는 경우

#### <a id="exception11">`예외 11`</a>
- [x] 해당 역이 없는 경우

#### <a id="exception12">`예외 12`<a>
- [x] 메인 화면에서 1~4 숫자 또는 Q 문자 이외를 입력하는 경우

#### <a id="exception13">`예외 13`<a>
- [x] 역 관리 화면에서 1~3 숫자 또는 B 문자 이외를 입력하는 경우

#### <a id="exception14">`예외 14`<a>
- [x] 노선 관리 화면에서 1~3 숫자 또는 B 문자 이외를 입력하는 경우

#### <a id="exception15">`예외 15`<a>
- [x] 구간 관리 화면에서 1~2 숫자 또는 B 문자 이외를 입력하는 경우

<br>

## ✅ 확인할 프로그래밍 목록
### 요구사항
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - [x] 들여쓰기는 `4 spaces`로 한다.
- [x] (1 <= indent depth) && (indent depth <= 2)이다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수의 길이는 `15라인`을 넘지 않는다.
    - [x] 함수가 한 가지 일만 하도록 최대한 작게 만든다.
- [x] else 예약어를 쓰지 않는다.
    - [x] `early return`하는 코드를 작성한다.
    - [x] switch/case 문도 사용하지 않는다.

### 추가사항
- [x] 코드 리팩토링을 진행한다.
    - [x] 1주차 피드백을 반영한다.
    - [x] 2주차 피드백을 반영한다.
- [x] 주석은 Javadoc 형태로 작성한다.
- [x] README 문서를 상세하게 작성한다.

## 📂 완성된 디렉토리 구조
```
└─java-subway-map-precourse
    │
    ├─docs
    │   └─README.md
    └─src
        └─main
            └─java
                └─subway
                    ├─controller
                    │   ├─LineController.java
                    │   ├─SectionController.java
                    │   ├─StationController.java
                    │   ├─SubwayController.java
                    │   └─TransitMapController.java
                    ├─domain
                    │   ├─Line.java
                    │   ├─Section.java
                    │   ├─Station.java
                    │   ├─Stations.java
                    │   └─TransitMap.java
                    ├─repository
                    │   ├─LineRepository.java
                    │   ├─StataionRepository.java
                    │   └─TransitMapRepository.java
                    ├─service
                    │   ├─initialization
                    │   │   ├─LineInitialization.java
                    │   │   ├─StationInitialization.java
                    │   │   └─TransitMapInitialization.java
                    │   ├─line
                    │   │   ├─addition
                    │   │   │   ├─LineAdditionService.java
                    │   │   │   └─LineAdditionValidation.java
                    │   │   ├─deletion
                    │   │   │   ├─LineDeletionService.java
                    │   │   │   └─LineDeletionValidation.java
                    │   │   ├─show
                    │   │   │   └─LineShowService.java
                    │   │   └─LineService.java
                    │   ├─section
                    │   │   ├─addition
                    │   │   │   ├─SectionAdditionService.java
                    │   │   │   └─SectionAdditionValidation.java
                    │   │   ├─deletion
                    │   │   │   ├─SectionDeletionService.java
                    │   │   │   └─SectionDeletionValidation.java
                    │   │   └─SectionService.java
                    │   ├─station
                    │   │   ├─addition
                    │   │   │   ├─StationAdditionValidation.java
                    │   │   │   └─StationAdditionValidationInterface.java
                    │   │   ├─deletion
                    │   │   │   ├─StationDeletionValidation.java
                    │   │   │   └─StationDeletionValidationInterface.java
                    │   │   ├─show
                    │   │   │   ├─StationShowInterface.java
                    │   │   │   └─StationShowService.java
                    │   │   └─StationService.java
                    │   ├─subway
                    │   │   ├─SubwayInterface.java
                    │   │   └─SubwayService.java
                    │   ├─transitmap
                    │   │   ├─show
                    │   │   │   └─TransitMapShowService.java
                    │   │   └─TransitMapService.java
                    │   └─util
                    │       ├─ChoiceInterface.java
                    │       ├─ChoiceService.java
                    │       └─FeatureInterface.java
                    ├─type
                    │   ├─BoundaryType.java
                    │   ├─CheckType.java
                    │   ├─ExceptionType.java
                    │   ├─InformationType.java
                    │   ├─InputType.java
                    │   ├─LineType.java
                    │   ├─ScreenType.java
                    │   ├─StationType.java
                    │   └─TextType.java
                    ├─view
                    │   ├─input
                    │   │   ├─line
                    │   │   │   └─LineScanView.java
                    │   │   ├─section
                    │   │   │   └─SectionScanView.java
                    │   │   ├─station
                    │   │   │   └─StationScanView.java
                    │   │   └─subway
                    │   │       └─SubwayScanView.java
                    │   └─output
                    │       ├─line
                    │       │   ├─LineExceptionView.java
                    │       │   ├─LineInformationView.java
                    │       │   └─LineTextView.java
                    │       ├─section
                    │       │   ├─SectionExceptionView.java
                    │       │   ├─SectionInformationView.java
                    │       │   └─SectionTextView.java
                    │       ├─station
                    │       │   ├─StationExceptionView.java
                    │       │   ├─StationInformationView.java
                    │       │   └─StationTextView.java
                    │       └─util
                    │           ├─FeatureChoiceExceptionView.java
                    │           └─ScreenView.java
                    └─Application.java
```
### subwaymap
- Application.java : 메인 클래스

#### controller
- LineController.java : 지하철 노선에 대한 컨트롤러 클래스
- SectionController.java : 지하철 구간에 대한 컨트롤러 클래스
- StationController.java : 지하철 역에 대한 컨트롤러 클래스
- SubwayController.java : 지하철에 대한 컨트롤러 클래스
- TransitMapController.java : 지하철 노선도에 대한 컨트롤러 클래스

#### domain
- Line.java : 지하철 노선에 대한 도메인 모델 클래스
- Section.java : 지하철 구간에 대한 도메인 모델 클래스
- Station.java : 지하철 역에 대한 도메인 모델 클래스
- Stations.java : 지하철 상행 종점역, 하행 종점역에 대한 도메인 모델 클래스
- TransitMap.java : 지하철 노선도에 대한 도메인 모델 클래스

#### repository
- LineRepository.java : 지하철 노선에 대한 저장소 클래스
- StationRepository.java : 지하철 역에 대한 저장소 클래스
- TransitMapRepository.java : 지하철 노선도에 대한 저장소 클래스

#### service
##### initialization
- LineInitialization.java : 지하철 노선 초기화에 대한 클래스
- StationInitialization.java : 지하철 역 초기화에 대한 클래스
- TransitMapInitialization.java : 지하철 노선도 초기화에 대한 클래스

##### line
- addition/LineAdditionService.java : 지하철 노선 추가 로직에 대한 서비스 클래스
- addition/LineAdditionValidation.java : 지하철 노선 추가 로직 검증에 대한 클래스
- deletion/LineDeletionService.java : 지하철 노선 삭제 로직에 대한 서비스 클래스
- deletion/LineDeletionValidation.java : 지하철 노선 삭제 로직 검증에 대한 클래스
- show/LineShowService.java : 지하철 노선 조회 로직에 대한 서비스 클래스
- LineService.java : 지하철 노선 비즈니스 로직에 대한 서비스 클래스

##### section
- addition/SectionAdditionService.java : 지하철 구간 추가 로직에 대한 서비스 클래스
- addition/SectionAdditionValidation.java : 지하철 구간 추가 로직 검증에 대한 클래스
- deletion/SectionDeletionService.java : 지하철 구간 삭제 로직에 대한 서비스 클래스
- deletion/SectionDeletionValidation.java : 지하철 구간 삭제 로직 검증에 대한 클래스
- SectionService.java : 지하철 구간 비즈니스 로직에 대한 서비스 클래스

##### station
- addition/StationAdditionValidation.java : 지하철 역 추가 로직 검증에 대한 클래스
- addition/StationAdditionValidationInterface.java : 지하철 역 추가 로직 검증에 대한 인터페이스
- deletion/StationDeletionValidation.java : 지하철 역 삭제 로직 검증에 대한 클래스
- deletion/StationDeletionValidationInterface.java : 지하철 역 삭제 로직 검증에 대한 인터페이스
- show/StationShowInterface.java : 지하철 역 조회 로직에 대한 인터페이스
- show/StationShowService.java : 지하철 역 조회 로직에 대한 서비스 클래스
- StationService.java : 지하철 역 비즈니스 로직에 대한 서비스 클래스

##### subway
- SubwayInterface.java : 지하철 비즈니스 로직에 대한 인터페이스
- SubwayService.java : 지하철 비즈니스 로직에 대한 서비스 클래스

##### transitmap
- show/TransitMapShowService.java : 지하철 노선도 출력 로직에 대한 서비스 클래스
- TransitMapService.java : 지하철 노선도 비즈니스 로직에 대한 서비스 클래스

##### util
- ChoiceInterface.java : 지하철 역, 지하철 노선 기능 선택에 대한 인터페이스
- ChoiceService.java : 지하철 역, 지하철 노선 기능 선택에 대한 서비스 클래스
- FeatureInterface.java : 지하철 역, 지하철 노선 기능에 대한 인터페이스

#### type
- BoundaryType.java : 경계 값 상수를 모아둔 Enum 클래스
- CheckType.java : 입력 값 마지막 문자 확인용 상수를 모아둔 Enum 클래스
- ExceptionType.java : 예외 처리 문구 상수를 모아둔 Enum 클래스
- InformationType.java : 실행 결과 문구 상수를 모아둔 Enum 클래스
- InputType.java : 화면 기능 입력 값 상수를 모아둔 Enum 클래스
- LineType.java : 지하철 노선 초기화용 상수를 모아둔 Enum 클래스
- ScreenType.java : 화면 문구 상수를 모아둔 Enum 클래스
- StationType.java : 지하철 역 초기화용 상수를 모아둔 Enum 클래스
- TextType.java : 화면 출력 문구 상수를 모아둔 Enum 클래스

#### view
##### input
- line/LineScanView.java : 지하철 노선 기능 입력에 대한 클래스
- section/SectionScanView.java : 지하철 구간 기능 입력에 대한 클래스
- station/StationScanView.java : 지하철 역 기능 입력에 대한 클래스
- subway/SubwayScanView.java : 지하철 기능 입력에 대한 클래스

##### output
- line/LineExceptionView.java : 지하철 노선 예외 처리 문구 출력에 대한 클래스
- line/LineInformationView.java : 지하철 노선 실행 결과 문구 출력에 대한 클래스
- line/LineTextView.java : 지하철 노선 화면 출력 문구 출력에 대한 클래스
- section/SectionExceptionView.java : 지하철 구간 예외 처리 문구 출력에 대한 클래스
- section/SectionInformationView.java : 지하철 구간 실행 결과 문구 출력에 대한 클래스
- section/SectionTextView.java : 지하철 구간 화면 출력 문구 출력에 대한 클래스
- station/StationExceptionView.java : 지하철 역 예외 처리 문구 출력에 대한 클래스
- station/StationInformationView.java : 지하철 역 실행 결과 문구 출력에 대한 클래스
- station/StationTextView.java : 지하철 역 화면 출력 문구 출력에 대한 클래스
- util/FeatureChoiceExceptionView.java : 화면 기능 선택 예외 처리 문구 출력에 대한 클래스
- util/ScreenView.java : 화면 출력에 대한 클래스

<br>

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-subway-map-precourse/blob/master/LICENSE.md) licensed.
