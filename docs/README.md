# 지하철 노선도 미션
- 지하철 역과 노선을 관리하는 지하철 노선도 기능을 구현한다.

## 🤞 구현할 기능 목록
### [사전 등록 정보 세팅]
- __총 7개 역 등록__ 
    - 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역 등록

- __총 3개 노선 등록__
    - 2호선, 3호선, 신분당선 등록 

- __노선에 역을 아래와 같이 등록 (왼쪽 끝이 상행 종점)__ 
   - 2호선: 교대역 - 강남역 - 역삼역
   - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
   - 신분당선: 강남역 - 양재역 - 양재시민의숲역

### [메인 화면]
- __원하는 기능 입력 받기__
    - 1,2,3,4,Q가 아니라면 예외처리

- __Q가 입력되면 프로그램 종료__

### [역 관리]
- __원하는 기능 입력 받기__
    - 1,2,3,B가 아니라면 예외처리
    
- __역 등록__
    - 등록할 역 이름 받기
        - 역 이름이 2자 미만이면 예외처리
        - 역 이름이 중복되면 예외처리
        - 역 이름이 빈칸이면 예외처리
        - 역 이름이 "역"으로 끝나지 않으면 예외처리
    - 해당 이름으로 Station 객체 생성
    - 해당 Station 객체 StationRepository에 추가
    
- __역 삭제__
    - 삭제할 역 이름 받기
        - 존재하지 않는 역이면 예외처리
        - 노선에 등록이 되어있는 역이면 예외처리
    - 해당 Station 객체 StationRepository에서 제거
        
- __역 조회__
    - 역 목록 출력하기

- __기능을 완료하거나, B가 입력되면 역 관리 종료__
    
### [노선 관리]
- __원하는 기능 입력 받기__
    - 1,2,3,B가 아니라면 예외처리
    
- __노선 등록__
    - 등록할 노선 이름 받기
        - 노선 이름이 2자 미만이면 예외처리
        - 노선 이름이 중복이면 예외처리
        - 노선 이름이 빈칸이면 예외처리
        - 노선 이름이 "선"으로 끝나지 않으면 예외처리
        - 입력 받은 상행/하행 종점역이 존재하지 않으면 예외처리
        - 입력 받은 상행/하행 종점역이 동일하면 예외처리
    - 해당 이름으로 Line 객체 생성
    - 해당 Line 객체의 구간으로 상행/하행 종점역 추가
    - 상행/하행 종점역의 소속 노선에 해당 Line 객체 추가
    - 해당 Line 객체 LineRepository에 추가 
    
- __노선 삭제__
    - 삭제할 노선 이름 받기
        - 존재하지 않는 노선이면 예외처리
    - 해당 Line 객체의 구간으로 소속된 역들의 소속 노선에서 해당 Line 객체 제거 
    - 해당 Line 객체 LineRepository에서 제거
        
- __노선 조회__
    - 노선 목록 출력
    
- __기능을 완료하거나, B가 입력되면 노선 관리 종료__

### [구간 관리]
- __원하는 기능 입력 받기__
    - 1,2,B가 아니라면 예외처리
    
- __구간 등록__
    - 구간 등록할 노선 이름 받기
        - 존재하지 않는 노선이면 예외처리
    - 구간 등록할 역 이름 받기
        - 존재하지 않는 역이면 예외처리
        - 이미 역이 노선에 등록되어 있다면 예외처리
    - 구간 등록할 순서 받기
        - 정수가 아니면 예외처리
        - 0 이하라면 예외처리
        - 해당 노선에 추가될 길이보다 더 큰 순서라면 예외처리
    - 해당 Station 객체의 소속 노선에 해당 Line 객체 추가
    - 입력된 정보에 맞게 해당 Station 객체를 해당 노선에 배치
    
- __구간 삭제__
    - 구간 삭제할 노선 이름 받기
        - 존재하지 않는 노선이면 예외처리
        - 현재 노선에 남아있는 역이 2개 이하면 예외처리
    - 구간 삭제할 역 이름 받기
        - 존재하지 않는 역이면 예외처리
        - 현재 노선에 속한 역이 아니라면 예외처리
    - 해당 Station 객체의 소속 노선에서 해당 Line 객체 제거
    - 입력된 정보에 맞게 해당 Station 객체를 해당 노선에서 제거
    
- __기능을 완료하거나, B가 입력되면 구간 관리 종료__

### [지하철 노선도 출력]
- __지하철 노선도 노선-역 순서로 출력__
    - 등록된 노선이 없다면 등록된 노선이 없다고 안내문구 출력

<br>

## 📜 디렉토리 구조
- 제가 작업한 디렉토리는 다음과 같습니다
```bash
|-- docs
|   `-- README.md
`-- src
    |-- main
    |   `-- java
    |       `-- subway
    |           |-- Application.java                        - 어플리케이션을 실행
    |           |
    |           |-- controller                              [프로그램 실행에 필요한 domain-view 연결]
    |           |   |-- InitialSetupController.java         - 사전 등록 정보 설정
    |           |   |-- MainController.java                 - 메인 화면 기능 제어
    |           |   `-- functioncontroller 
    |           |       |-- FunctionController.java         - 공통 기능 제어 (부모 클래스)
    |           |       |-- LineController.java                 - 노선 관리
    |           |       |-- LineSectionController.java          - 구간 관리
    |           |       |-- MapPrintController.java             - 지하철 노선도 출력
    |           |       `-- StationController.java              - 역 관리
    |           |
    |           |-- domain                                  [노선과 역 정보를 저장 및 관리]
    |           |   |-- Line.java                           - 노선 생성, 노선 소속의 역에 대한 CRUD 제공
    |           |   |-- LineRepository.java                 - 생성된 노선 관리
    |           |   |-- Station.java                        - 역 생성, 역이 소속된 노선들의 목록 관리 
    |           |   `-- StationRepository.java              - 생성된 역 관리
    |           |
    |           |-- exception
    |           |   `-- UserInputException.java
    |           |
    |           |-- validator                               [사용자 Input 검증]
    |           |   |-- Validation.java                     - 공통 Validation (부모 클래스)
    |           |   |-- LineValidation.java                     - 노선 관리 Validation
    |           |   |-- MainValidation.java                     - 메인 화면 Validation
    |           |   |-- StationValidation.java                  - 역 관리 Validation
    |           |   `-- LineSectionValidation.java              - 구간 관리 Validation
    |           |
    |           `-- view                                    [사용자에게 보여지는 UI]
    |               |-- ErrorView.java                      - Error 출력 (부모 클래스)
    |               |-- InfoView.java                       - Info 출력 (부모 클래스)
    |               |-- OutputView.java                     - Instruction 출력 (부모 클래스) 
    |               |-- InputView.java                      - 사용자 Input 입력 받기
    |               |-- lineoutput
    |               |   |-- LineErrorView.java
    |               |   |-- LineInfoView.java
    |               |   `-- LineOutputView.java
    |               |-- linesectionoutput
    |               |   |-- LineSectionErrorView.java
    |               |   |-- LineSectionInfoView.java
    |               |   `-- LineSectionOutputView.java
    |               |-- mainoutput
    |               |   |-- MainErrorView.java
    |               |   |-- MainInfoView.java
    |               |   `-- MainOutputView.java
    |               |-- mapprintoutput
    |               |   |-- MapPrintErrorView.java
    |               |   |-- MapPrintInfoView.java
    |               |   `-- MapPrintOutputView.java
    |               `-- stationoutput
    |                   |-- StationErrorView.java
    |                   |-- StationInfoView.java
    |                   `-- StationOutputView.java
    `-- test
        `-- java
            `-- subway
                `-- empty.txt

```

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-subway-map-precourse/blob/master/LICENSE.md) licensed.
