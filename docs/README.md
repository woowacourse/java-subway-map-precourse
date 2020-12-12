# Subway System

## Entire System
1. 지하철 역 Model 생성 및 오류 체크, 이름 조회 기능 추가.
2. 지하철 역 리스트 생성 및 오류 체크, 중복 체크 기능 추가.
3. 지하철 노선 생성 및 오류, 이름 조회 기능 추가.
4. 지하철 노선 리스트 생성 및 오류 체크. 중복 체크 기능 추가.
5. 입력값에 대한 InputViewer 추가.
6. 결과값에 대한 OutputViewer 추가.
7. Error 발생시에 ErrorViewer 추가.
8. Initiator 생성.
9. 역 관리 Controller 생성.
10. 노선 관리 Controller 생성.
11. 구간 관리 Controller 생성.
12. 지하철 노선도 출력 Controller 생성.
13. 전체 관리 Controller 생성.


### domain
#### Station
- 지하철역 생성 및 생성 시 오류 체크.
- 2글자 이상이야 한다.
- 지하철역 이름 보여주기.

#### StationRepository
- 지하철역 모음 중복 체크 해주기.
- 지하철역 전체 리스트에서 삭제 및 추가.

#### Line
- 지하철 노선 생성 및 생성 시 오류 체크.
- 2글자 이상이야 한다.
- 노선에 지하철역 추가 및 삭제.
- 중복된 역이 들어가 있으지 확인.
- 노선 안 지하철 역 삭제시 최소 2개의 역 있는지 확인.

#### LineRepository
- 노선 모음 및 중복 체크 해주기.
- 노선 자체에 중복이 있으면 안된다.
- 노선 전체 리스트에서 삭제 및 추가.

### Viewer
#### SystemInputViewer
- 전체 시스템 관련 인풋을 받아오는 객체.
#### StationInputViewer
- 역 관련 인풋 받아오는 객체.
#### LineInputViewer
- 노선 관련 인풋 받아오는 객체.
#### IntervalInputViewer
- 구간 관련 인풋을 받아오는 객체.
#### StationOutputViewer
- 역 관련 아웃풋을 보여주는 객체.
#### LineOutputViewer
- 노선 관련 아웃풋을 보여주는 객체.
#### IntervalOutputViewer
- 구간 관련 아웃풋을 보여주는 객체.
#### SystemOutputViewer
- 전체 시스템 관련 아웃풋을 보여주는 객체.
#### SystemErrorViewer
- 시스템 관련 오류를 보여주는 객체.
#### StationErrorViewer
- 역 관련 오류를 보여주는 객체.
#### LineErrorViewer
- 노선 관련 오류를 보여주는 객체.
#### IntervalErrorViewer
- 구간 관련 오류를 보여주는 객체.



### Controller
공통적으로 Input을 받을 시에 해당 항목 벗어나면 Error 발생.
#### EntireSystem
- 전체 시스템을 관장하는 객체.
#### Initiator
- 초기 값들을 생성해주는 객체.
#### StationManager
- 역 관리를 맡고 있는 객체.
#### LineManager
- 노선 관리를 맡고 있는 객체.
#### IntervalManager
- 구간 관리를 맡고 있는 객체.
#### EntireShowManager
- 전체 노선을 보여주는 객체.

