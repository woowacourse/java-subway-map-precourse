# 지하철 노선도 미션
- 지하철 역과 노선을 관리하는 지하철 노선도 기능을 구현한다.

## 기능 구현 목록

### 메뉴 선택 관련 기능

### 메뉴 선택, 관리 기능 공통
- [x] 입력받은 입력의 공백은 제거해야한다.
  - [x] 예외: 공백 제거 후 빈 문자열이 되는 경우

- [ ] 메뉴들을 출력할 수 있어야 한다.
```
메뉴목록:
  [x] 메인 메뉴
  ├ [x] 역 관리 메뉴
  ├ [x] 노선 관리 메뉴
  └ [ ] 구간 관리 메뉴
```

- [ ] 각 메뉴들에서 선택 값을 받을 수 있어야한다.
  - [x] 선택할 수 있는 문자가 아닌 경우를 검증한다
  - [ ] 선택에 따라 해당 메뉴가 실행된다.

### 역 관리 기능
- [x] 문자열로 등록된 역의 이름을 검색할 수 있어야한다.
- 생성
  - [x] 생성할 역 이름을 입력받는다.
  - [x] 인자로 받은 이름으로 객체를 생성한다.
    - [x] 예외: 역 이름이 2글자 미만인 경우
    - [x] 예외: 역 이름이 중복되는 경우
- 삭제
  - [x] 삭제할 역 이름을 입력받는다.
  - [x] 인자로 받은 이름으로 값으로 역 객체를 삭제한다.
    - [x] 예외: 해당 역이 없는 경우
- 조회
  - [x] 등록된 모든 역을 출력할 수 있어야 한다.
    - [x] 예외: 등록된 역이 하나도 없을 수 있다.

### 노선 관리 기능
- [ ] 문자열로 등록된 노선의 이름을 검색할 수 있어야한다.
- 생성
  - [x] 생성할 노선 이름을 입력받는다.
  - [x] 상행, 하행 종점역 이름을 입력 받는다.
    - [x] 예외: 해당 역이 없는 경우
  - [x] 입력 값으로 노선 객체를 생성한다.
    - [x] 예외: 노선 이름이 중복되는 경우
    - [x] 예외: 노선 이름이 2글자 미만인 경우
- 삭제
  - [ ] 삭제할 노선 이름을 입력받는다.
  - [ ] 입력 값으로 노선 객체를 삭제한다.
    - [ ] 예외: 해당 노선이 없는 경우
- 조회
  - [ ] 등록된 모든 노선을 출력할 수 있어야 한다.
    - [ ] 예외: 등록된 노선이 하나도 없을 수 있다.

### 구간 관리 기능
- 등록
  - [ ] 역을 등록할 노선 이름을 입력받는다.
    - [ ] 예외: 해당 노선이 없는 경우
  - [ ] 등록할 역 이름을 입력 받는다.
    - [ ] 예외: 해당 역이 없는 경우
    - [ ] 예외: 이미 역이 해당 노선에 등록되어 있는 경우
- 삭제
  - [ ] 역을 삭제할 노선을 입력받는다.
    - [ ] 예외: 해당 노선이 없는 경우
  - [ ] 삭제할 역을 입력 받는다.
    - [ ] 예외: 해당 역이 없는 경우
    - [ ] 예외: 해당 노선에 해당 역이 없는 경우
