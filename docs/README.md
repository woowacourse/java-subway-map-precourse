# 지하철 노선도 미션
- 지하철 역과 노선을 관리하는 지하철 노선도 기능을 구현한다.

<br>

## 🚀 기능 요구사항

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

<img src="image/domain.png" width="500">
  
### 지하철 역 관련 기능
- 지하철 역을 등록하고 삭제할 수 있다. (단, 노선에 등록된 역은 삭제할 수 없다)
- 중복된 지하철 역 이름이 등록될 수 없다.
- 지하철 역 이름은 2글자 이상이어야 한다.
- 지하철 역의 목록을 조회할 수 있다.

### 지하철 노선 관련 기능
- 지하철 노선을 등록하고 삭제할 수 있다.
- 중복된 지하철 노선 이름이 등록될 수 없다.
- 지하철 노선 이름은 2글자 이상이어야 한다.
- 노선 등록 시 상행 종점역과 하행 종점역을 입력받는다. 
- 지하철 노선의 목록을 조회할 수 있다.

### 지하철 구간 추가 기능
- 지하철 노선에 구간을 추가하는 기능은 노선에 역을 추가하는 기능이라고도 할 수 있다.
  - 역과 역사이를 구간이라 하고 이 구간들의 모음이 노선이다.  
- 하나의 역은 여러개의 노선에 추가될 수 있다.
- 역과 역 사이에 새로운 역이 추가 될 수 있다.
- 노선에서 갈래길은 생길 수 없다.

<img src="image/section1.png" width="500">

### 지하철 구간 삭제 기능
- 노선에 등록된 역을 제거할 수 있다.
- 종점을 제거할 경우 다음 역이 종점이 된다.
- 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.

<img src="image/section2.png" width="500">

### 지하철 노선에 등록된 역 조회 기능
- 노선의 상행 종점부터 하행 종점까지 연결된 순서대로 역 목록을 조회할 수 있다.

<br>

## ✍🏻 입출력 요구사항
- `프로그래밍 실행 결과 예시`를 참고하여 입출력을 구현한다.
- 기대하는 출력 결과는 `[INFO]`를 붙여서 출력한다. 출력값의 형식은 예시와 동일하게 한다.
- 에러 발생 시 `[ERROR]`를 붙여서 출력한다. (에러의 문구는 자유롭게 작성한다.)

### 💻 프로그래밍 실행 결과 
#### 역 관리
```
## 메인 화면
1. 역 관리
2. 노선 관리
3. 구간 관리
4. 지하철 노선도 출력
Q. 종료

## 원하는 기능을 선택하세요.
1

## 역 관리 화면
1. 역 등록
2. 역 삭제
3. 역 조회
B. 돌아가기

## 원하는 기능을 선택하세요.
1

## 등록할 역 이름을 입력하세요.
잠실역

[INFO] 지하철 역이 등록되었습니다.

## 메인 화면
1. 역 관리
2. 노선 관리
3. 구간 관리
4. 지하철 노선도 출력
Q. 종료

## 원하는 기능을 선택하세요.
1

## 역 관리 화면
1. 역 등록
2. 역 삭제
3. 역 조회
B. 돌아가기

## 원하는 기능을 선택하세요.
3

## 역 목록
[INFO] 교대역 
[INFO] 강남역
[INFO] 역삼역
[INFO] 남부터미널역
[INFO] 양재역
[INFO] 양재시민의숲역
[INFO] 매봉역
[INFO] 잠실역

## 메인 화면
1. 역 관리
2. 노선 관리
3. 구간 관리
4. 지하철 노선도 출력
Q. 종료

## 원하는 기능을 선택하세요.
1

## 역 관리 화면
1. 역 등록
2. 역 삭제
3. 역 조회
B. 돌아가기

## 원하는 기능을 선택하세요.
2

## 삭제할 역 이름을 입력하세요.
잠실역

[INFO] 지하철 역이 삭제되었습니다.

...
```

### 노선 관리

```

...

## 메인 화면
1. 역 관리
2. 노선 관리
3. 구간 관리
4. 지하철 노선도 출력
Q. 종료

## 원하는 기능을 선택하세요.
2

## 노선 관리 화면
1. 노선 등록
2. 노선 삭제
3. 노선 조회
B. 돌아가기

## 원하는 기능을 선택하세요.
1

## 등록할 노선 이름을 입력하세요.
1호선

## 등록할 노선의 상행 종점역 이름을 입력하세요.
강남역

## 등록할 노선의 하행 종점역 이름을 입력하세요.
잠실역

[INFO] 지하철 노선이 등록되었습니다.

## 메인 화면
1. 역 관리
2. 노선 관리
3. 구간 관리
4. 지하철 노선도 출력
Q. 종료

## 원하는 기능을 선택하세요.
2

## 노선 관리 화면
1. 노선 등록
2. 노선 삭제
3. 노선 조회
B. 돌아가기

## 원하는 기능을 선택하세요.
3

## 노선 목록
[INFO] 2호선
[INFO] 3호선
[INFO] 신분당선
[INFO] 1호선

## 메인 화면
1. 역 관리
2. 노선 관리
3. 구간 관리
4. 지하철 노선도 출력
Q. 종료

## 원하는 기능을 선택하세요.
2

## 노선 관리 화면
1. 노선 등록
2. 노선 삭제
3. 노선 조회
B. 돌아가기

## 원하는 기능을 선택하세요.
2

## 삭제할 노선 이름을 입력하세요.
1호선

[INFO] 지하철 노선이 삭제되었습니다.

...

```

### 구간 관리
- 순서는 1부터 시작한다.

```
...

## 메인 화면
1. 역 관리
2. 노선 관리
3. 구간 관리
4. 지하철 노선도 출력
Q. 종료

## 원하는 기능을 선택하세요.
3

## 구간 관리 화면
1. 구간 등록
2. 구간 삭제
B. 돌아가기

## 원하는 기능을 선택하세요.
1

## 노선을 입력하세요.
2호선

## 역이름을 입력하세요.
잠실역

## 순서를 입력하세요.
2

[INFO] 구간이 등록되었습니다.

## 메인 화면
1. 역 관리
2. 노선 관리
3. 구간 관리
4. 지하철 노선도 출력
Q. 종료

## 원하는 기능을 선택하세요.
3

## 구간 관리 화면
1. 구간 등록
2. 구간 삭제
B. 돌아가기

## 원하는 기능을 선택하세요.
2

## 삭제할 구간의 노선을 입력하세요.
2호선

## 삭제할 구간의 역을 입력하세요.
잠실역

[INFO] 구간이 삭제되었습니다.

...

```

### 지하철 노선도 출력

```
## 메인 화면
1. 역 관리
2. 노선 관리
3. 구간 관리
4. 지하철 노선도 출력
Q. 종료

## 원하는 기능을 선택하세요.
4

## 지하철 노선도
[INFO] 2호선
[INFO] ---
[INFO] 교대역
[INFO] 강남역
[INFO] 역삼역

[INFO] 3호선
[INFO] ---
[INFO] 교대역
[INFO] 남부터미널역
[INFO] 양재역
[INFO] 매봉역

[INFO] 신분당선
[INFO] ---
[INFO] 강남역
[INFO] 양재역
[INFO] 양재시민의숲역

```

#### 에러 출력 예시

```
## 메인 화면
1. 역 관리
2. 노선 관리
3. 구간 관리
4. 지하철 노선도 출력
Q. 종료

## 원하는 기능을 선택하세요.
5

[ERROR] 선택할 수 없는 기능입니다.

## 원하는 기능을 선택하세요.
1

## 역 관리 화면
1. 역 등록
2. 역 삭제
3. 역 조회
B. 돌아가기

## 원하는 기능을 선택하세요.
1

## 등록할 역 이름을 입력하세요.
강남역

[ERROR] 이미 등록된 역 이름입니다. 

## 역 관리 화면
1. 역 등록
2. 역 삭제
3. 역 조회
B. 돌아가기

## 원하는 기능을 선택하세요.

...

```

<br>

## 🎱 프로그래밍 요구사항
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 `[ERROR]` 로 시작해야 한다.

### 프로그래밍 요구사항 - Application
- Application 클래스를 활용해 구현해야 한다.
- Application의 패키지 구조는 변경하지 않는다.
```java
public class Application {
    public static void main(String[] args) {
        ...
    }
}
```

### 프로그래밍 요구사항 - Station, Line
- Station, Line 클래스를 활용하여 지하철역과 노선을 구현해야 한다.
- 제공하는 각 클래스의 기본 생성자를 추가할 수 없다.
- 필드(인스턴스 변수)인 name의 접근 제어자 private을 변경할 수 없다.
- 가능하면 setter 메소드(ex. setXXX)를 추가하지 않고 구현한다.
 
```java
public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}

```

### 프로그래밍 요구사항 - StationRepository, LineRepository
- Station과 Line의 상태를 저장할 수 있는 StationRepository, LineRepository를 제공한다.
- 필요 시 StationRepository, LineRepository 이 외 추가로 Repository를 만들 수 있다.
- 추가로 생성되는 객체에 대해서 XXXRepository 네이밍으로 저장 클래스를 추가할 수 있다.
- 객체들의 상태를 관리하기 위해서 XXXRepository 클래스를 활용해 저장 로직을 구현해야 한다.
- 필요에 따라 자유롭게 수정이 가능하다.
 
```java
public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
```

<br>

## 📈 진행 요구사항
- 미션은 [java-subway-map-precourse 저장소](https://github.com/woowacourse/java-subway-map-precourse) 를 fork/clone해 시작한다.
- 기능을 구현하기 전에 java-subway-map-precourse/docs/README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
  - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
- [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 절차를 따라 미션을 제출한다.
  - [프리코스 과제 FAQ](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse/faq) 문서를 참고하여 진행할 수 있다.
<br>

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-subway-map-precourse/blob/master/LICENSE.md) licensed.
