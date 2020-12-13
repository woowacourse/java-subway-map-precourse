# 지하철 노선도 미션
- 지하철 역과 노선을 관리하는 지하철 노선도 기능을 구현한다.

## 🎯 구현할 기능 목록
> 살아있는 문서를 만들도록 노력한다! 

### 초기 설정 
- [ ] 프로그램 시작 시 역, 노선 등 필요한 정보를 미리 셋팅하는 기능 

> 아래의 사전 등록 정보로 반드시 초기 설정을 하기
> 
```
 1. 지하철역으로 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역이 등록되어 있다.
 2. 지하철 노선으로 2호선, 3호선, 신분당선이 등록되어 있다.
 3. 노선에 역이 아래와 같이 등록되어 있다.(왼쪽 끝이 상행 종점)
   - 2호선: 교대역 - 강남역 - 역삼역
   - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
   - 신분당선: 강남역 - 양재역 - 양재시민의숲역
 ```

### 지하철 역 관련 기능
- [x] 지하철 역을 등록하는 기능 
  - [x] 중복된 지하철 역 이름이 등록될 수 없다.
  - [x] 지하철 역 이름이 2글자 미만이면 예외를 던진다   
- [x] 지하철 역을 삭제하는 기능
  - [ ] 노선에 등록된 역을 삭제하면 예외를 발생시킨다
- [x] 지하철 역의 목록을 조회하는 기능 
- [x] 모든 지하철 역을 제거하는 기능 (테스트를 위한 용도)

### 지하철 노선 관련 기능
- [x] 지하철 노선을 등록하는 기능
- [x] 중복된 노선 이름을 등록하면 예외를 발생시킨다 
- [x] 지하철 노선 이름이 2글자 미만이면 예외를 던진다
- [x] 지하철 노선을 삭제하는 기능
- [x] 노선 등록 시 상행 종점역과 하행 종점역을 입력받는 기능
- [x] 상행, 하행 종점역이 등록되지 않은 역인 경우 예외를 던진다
- [x] 노선의 역 갯수 초기값이 2가 아닌 경우 예외를 던진다 
- [x] 지하철 노선의 목록을 조회하는 기능 

### 지하철 구간 추가 기능
- [x] 지하철 노선에 구간을 추가하는 기능(= 노선에 역을 추가하는 기능)

### 지하철 구간 삭제 기능
- [ ] 노선에 등록된 역을 제거하는 기능 
  - [ ] 종점을 제거할 경우 다음 역이 종점이 된다.
  - [ ] 노선에 포함된 역이 두개 이하일 때는 예외를 발생시킨다 (역을 제거하지 못한다)

### 지하철 노선에 등록된 역 조회 기능
- [ ] 노선의 상행 종점부터 하행 종점까지 연결된 순서대로 역 목록을 조회하는 기능 

## ✍ 입출력 요구사항
- [ ] `프로그래밍 실행 결과 예시`를 참고하여 입출력을 구현한다.
- [ ] 기대하는 출력 결과는 `[INFO]`를 붙여서 출력한다. 출력값의 형식은 예시와 동일하게 한다.
- [ ] 에러 발생 시 `[ERROR]`를 붙여서 출력한다. (에러의 문구는 자유롭게 작성한다.)

## ✅ 프로그래밍 요구사항 
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ] else 예약어를 쓰지 않는다.
- [ ] 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.
- [ ] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 `[ERROR]` 로 시작해야 한다.

### 프로그래밍 요구사항 - Application
- [ ] Application 클래스를 활용해 구현해야 한다.
- [ ] Application의 패키지 구조는 변경하지 않는다.

### 프로그래밍 요구사항 - Station, Line
- [ ] Station, Line 클래스를 활용하여 지하철역과 노선을 구현해야 한다.
- [ ] 제공하는 각 클래스의 기본 생성자를 추가할 수 없다.
- [ ] 필드(인스턴스 변수)인 name의 접근 제어자 private을 변경할 수 없다.
- [ ] 가능하면 setter 메소드(ex. setXXX)를 추가하지 않고 구현한다.

### 프로그래밍 요구사항 - StationRepository, LineRepository
- [ ] Station과 Line의 상태를 저장할 수 있는 StationRepository, LineRepository를 제공한다.
- [ ] 필요 시 StationRepository, LineRepository 이 외 추가로 Repository를 만들 수 있다.
- [ ] 추가로 생성되는 객체에 대해서 XXXRepository 네이밍으로 저장 클래스를 추가할 수 있다.
- [ ] 객체들의 상태를 관리하기 위해서 XXXRepository 클래스를 활용해 저장 로직을 구현해야 한다.
- [ ] 필요에 따라 자유롭게 수정이 가능하다.
 
