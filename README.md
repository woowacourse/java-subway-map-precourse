## 구현할 기능 목록

### 지하철 관리 프로그램

- [x]  프로그램 시작
- [x]  데이터 초기화

### 역 관리

- [x]  역 등록(역 이름)
    - [x]  예외 처리: 역 이름 길이
    - [x]  예외 처리: 중복된 역 이름
- [x]  역 삭제(역 이름)
    - [x]  예외 처리: 존재하지 않는 역 이름
    - [ ]  예외 처리: 노선에 이미 등록된 역
- [x]  모든 역 조회

### 노선 관리

- [x]  노선 등록(노선 이름, 상행 종점역 이름, 하행 종점역 이름)
    - [x]  노선에 두 역 등록
    - [x]  예외 처리: 노선 이름 길이
    - [x]  예외 처리: 두 종점역이 서로 같은 역
    - [x]  예외 처리: 두 종점역 중 등록안 된 역이 존재
- [x]  노선 삭제(노선 이름)
    - [x]  예외 처리: 존재하지 않는 노선 이름
- [x]  모든 노선 조회 (모든 노선)
- [x]  지하철 노선도 조회 (모든 노선과 속한 역)

### 구간 관리

- [x]  구간 추가 (노선, 역 이름, 순서)
    - [x]  예외 처리: 없는 노선 이름
    - [x]  예외 처리: 역 레포지토리에 없는 역 이름
    - [x]  예외 처리: 이미 있는 역 이름
    - [x]  예외 처리: 너무 짧은 역 이름 길이
    - [x]  예외 처리: 잘못된 순서
- [x]  구간 삭제 (노선, 역 이름)
    - [x]  예외 처리: 존재하지 않는 역
    - [x]  예외 처리: 노선에 포함된 역이 두 개 이하일 때 제거 불가

### 화면 관리

- [x]  메인 화면 출력
    - [x]  역 관리 화면 출력
    - [x]  노선 관리 화면 출력
    - [x]  구간 관리 화면 출력
- [x]  예외 처리: 잘못된 기호 입력