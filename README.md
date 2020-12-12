# java-chicken-2019

## 기능 구현 목록
- [x] 메인 화면 출력 [Checked]
- [x] 원하는 기능 입력 [Checked]
    - [x] [예외처리] 기능에 없는 값을 입력 받을 경우 예외 처리 [Checked]
- [x] 메인 화면에서 기능 선택하기 [Checked]
    - [x] [예외처리] 기능에 없는 값을 입력 받을 경우 예외 처리 [Checked]
- [x] 사전 등록 정보로 초기 설정하기 [Checked]

### 역 관리
- [x] 역 관리 화면 출력 [Checked]
- [x] 역 등록 [Checked]
    - [x] 역 이름 입력 [Checked]
    - [ ] [예외처리] 지하철 역 이름은 2글자 이상이어야 한다.(글자 처음과 끝에 붙어있는 공백 제거 후 체크)
    - [ ] [예외처리] 지하철 노선 이름은 공백일 수 없습니다.
    - [x] [예외처리] 중복된 지하철 역 이름은 등록될 수 없다. [Checked]
- [x] 역 삭제 [Checked]
    - [x] 역 이름 입력 [Checked]
    - [x] [예외처리] 노선에 등록된 역은 삭제 불가능 [Checked]
    - [ ] [예외처리] 등록되어 있지 않는 역일 경우 삭제 불가능
- [x] 역 조회 [Checked]
- [x] 메인화면으로 돌아가기 [Checked]

### 노선 관리
- [x] 노선 관리 화면 출력 [Checked]
- [x] 노선 등록
    - [x] 노선 이름 입력
    - [ ] [예외처리] 지하철 노선 이름은 2글자 이상이어야 한다. (글자 처음과 끝에 붙어있는 공백 제거 후 체크)
    - [ ] [예외처리] 지하철 노선 이름은 공백일 수 없습니다.
    - [x] [예외처리] 중복된 지하철 노선 이름은 등록될 수 없다. 
    - [x] 노선의 상행 종점역 이름 입력
        - [ ] [예외처리] 등록된 역이여야만 가능
        - [ ] [예외처리] 지하철 역 이름은 2글자 이상이어야 한다.(글자 처음과 끝에 붙어있는 공백 제거 후 체크)
        - [ ] [예외처리] 지하철 노선 이름은 공백일 수 없다.
    - [x] 노선의 하행 종점역 이름 입력
        - [ ] [예외처리] 등록된 역이여야만 가능
        - [ ] [예외처리] 지하철 역 이름은 2글자 이상이어야 한다.(글자 처음과 끝에 붙어있는 공백 제거 후 체크)
        - [ ] [예외처리] 지하철 노선 이름은 공백일 수 없다.
        - [ ] [예외처리] 방금 전에 입력한 상행 종점역과 이름이 같으면 안 된다.
- [x] 노선 삭제
    - [x] 삭제할 노선 이름 입력
    - [x] [예외처리] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다.
    - [x] [예외처리] 노선에 등록되어 있지 않은 노선은 삭제할 수 없다.
- [x] 노선 조회 
- [x] 메인화면으로 돌아가기

### 구간 관리
- [x] 구간 관리 화면 출력
- [x] 구간 등록
    - [x] 노선 이름 입력
    - [x] 역 이름 입력
    - [x] 순서 입력
- [x] 구간 삭제
    - [x] 노선 이름 입력
    - [x] 노선 역 입력

### 지하철 노선도 출력
- [x] 지하철 노선도 출력

### 종료
- [x] 종료하기