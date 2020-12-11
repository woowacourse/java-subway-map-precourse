# 지하철 노선도 미션
- 지하철 역과 노선을 관리하는 지하철 노선도 기능을 구현한다.

<br>

## 프로그래밍 요구 사항
 - 입출력 요구 사항
   - 기대하는 출력 결과는 [INFO]를 붙여서 출력한다.
   - 에러 발생시 [ERROR]를 붙여서 출력한다.
 - 자바 코드 컨벤션 지키기
 - indent depth 2 이하
 - 3항 연산자 X
 - 함수 길이 15라인 이하
 - else 예약어 X
 - 예외 상황 시 에러 문구 출력
 - 주어진 Application, Station, Line, StationRepository, LineRepository 사용
 
## 기능 구현 목록
 - 초기 설정
   1. 지하철역으로 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역이 등록되어 있다.
   2. 지하철 노선으로 2호선, 3호선, 신분당선이 등록되어 있다.
   3. 노선에 역이 아래와 같이 등록되어 있다.(왼쪽 끝이 상행 종점)
     - 2호선: 교대역 - 강남역 - 역삼역
     - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
     - 신분당선: 강남역 - 양재역 - 양재시민의숲역

 - 메인 화면
   - 4가지 기능
     - 역 관리
       - 역 등록, 삭제, 조회
       - 돌아가기
     - 노선 관리
       - 노선 등록, 삭제, 조회
       - 돌아가기
     - 구간 관리
       - 구간 등록, 삭제
       - 돌아가기
     - 지하철 노선도 출력
     - 종료
     
 - 역 관리 주의사항
   - 중복 X
   - 2글자 이상
   - 조회 가능
   - 노선에 등록된 역은 삭제할 수 없다.
 - 노선 관리 주의사항
   - 중복 X
   - 2글자 이상
   - 노선 등록 시 상행 종점역과 하행 종점역을 입력받아야함
   - 조회 가능
 - 구간 관리 주의사항
   - 노선에서 갈래길은 생길 수 없다.
   - 종점을 제거할 경우 다음 역이 종점이 된다.
   - 노선에 포함된 역이 두개 이하일 경우 역을 제거할 수 없다.

 - 예외 상황
   - 기능 번호 입력시 없는 번호
   - 중복된 역, 노선 이름
   - 역 삭제시 등록된 역