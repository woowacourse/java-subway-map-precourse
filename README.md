# 지하철 노선도 미션
- 지하철 역과 노선을 관리하는 지하철 노선도 기능을 구현한다.

<br>

## 🚀 프로젝트

### 주제

지하철 역 (역, 노선, 구간)을 관리하는 시스템을 만드는 프로젝트.

<br>

### 초기 설정 
- 프로그램 시작 시 역, 노선 등 필요한 정보를 미리 셋팅할 수 있다.

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

## 👨‍💻 기능 목록 및 객체 설계

**웹에서 사용되는 "클라이언트 - 서버 아키텍처"를 착안하여 기능 목록과 객체 설계를 하였습니다.**

### Front (View)

> 책임 : 입력 (예외처리), 출력 (결과), 메시지 요청

#### 뷰 템플릿

* 모든 뷰 객체는 2가지의 책임을 가진다 : 내용 출력, 뷰 이름 반환.
* 모든 뷰 객체는 템플릿 뷰(`AbstractView`)객체를 상속받으며, 뷰의 책임을 구현한다.
* 모든 뷰 객체는 생성시 이름을 초기화 한다.

#### 메뉴 선택 뷰

> ex. 메인 화면, 역 관리 화면, 노선 관리 화면등등

* 이동할 수 있는 뷰 목록을 추가할 수 있다.
* 뷰 목록에 따라 메뉴를 출력한다.
* 뷰 목록에 따라 숫자 입력값을 입력한다.
  * 예외 처리 : 숫자 혹은 뒤로가기 이외의 문자 / 뷰 목록 범위 밖 숫자

#### 일반 내용 뷰

> ex. 역 등록, 역 삭제, 노선 등록, 노선 삭제등등

* 2글자 이상의 입력값을 받을 수 있다. (역 이름, 노선 이름 등등의 입력)
  * 예외 처리 : 2글자 이하

* 숫자를 입력할 수 있다. (구간 추가 순서 입력)
  * 예외 처리 : 숫자 이외의 문자 / 음수

#### 뷰 구성

* 메뉴 선택 뷰
  * 메인 화면, 역 관리 화면, 노선 관리 화면, 구간 관리 화면
* 일반 내용 뷰
  * 역 관리
    * 역 등록, 역 삭제, 역 조회
  * 노선 관리
    * 노선 등록, 노선 삭제, 노선 조회
  * 구간 관리
    * 구간 등록, 구간 삭제
  * 지하철 노선도 출력

<br>

### Back (Business)

>  책임 : Front(View)에서의 요청을 받아 처리 후 결과 반환

### 지하철 역 관리 - StationService

* 역 등록
  * 예외 처리
    * 중복(존재)되는 역이 없어야 한다.
* 역 삭제
  * 예외 처리
    * 존재하지 않는 역은 삭제할 수 없다.
    * 노선에 등록된 역은 삭제할 수 없다.
* 역 조회

#### 지하철 노선 관리 - LineService

* 노선 등록
  * 예외 처리
    * 중복되는 노선이 없어야 한다.
    * 상행 종점과 하행 종점역이 존재하는 역이어야 한다.
    * 상행 종점과 하행 종점역이 같을 수 없다.
* 노선 삭제
  * 예외 처리
    * 존재하지 않는 노선은 삭제할 수 없다.
* 노선 조회
#### 지하철 구간 관리 - SectionService
* 구간 등록
  * 예외 처리
    * 노선에는 갈래길이 생길 수 없다.
    * 존재하지 않는 노선은 등록할 수 없다.
    * 존재하지 않는 역은 등록할 수 없다.
    * 해당 노선에 이미 존재하는 역은 등록할 수 없다.
    * 노선의 범위를 벗어나는 위치에는 등록할 수 없다.

* 구간 삭제

  * 종점을 제거할 경우 다음 역이 종점이 된다.

  * 예외 처리
    * 노선에 포함된 역이 두개 이하면 역을 제거할 수 없다.

#### 지하철 노선도 출력

* 노선의 상행 종점부터 하행 종점까지 연결된 순서대로 역 목록 조회.

<br>

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-subway-map-precourse/blob/master/LICENSE.md) licensed.
