# 지하철 노선도 미션
[프리코스를 통해 공부한 것들](https://www.notion.so/9186a1ce15b54fddb0c0ca0c8b99c39d)

[1주차 프리코스](https://www.notion.so/1-4c1e2bc9b4bc412a85ee72a1244ac86c)

[1주차 프리코스, 피드백을 피드백하다](https://www.notion.so/1-8b5157674d1340d7a4086641f602d542)

[2주차 프리코스](https://www.notion.so/2-b4853e276d7a42828a70f81439e97598)

[3주차 프리코스 계획](https://www.notion.so/3-8997d2c11e50483eb7d1b3d90996a3f2)

[피드백을 피드백하다 ver.2](https://www.notion.so/ver-2-2a63193924bd4deaa085ed94793d0471)

<br>

## 🚀 기능 구현 목록

 - 코드를 구현하다 꼬일대로 꼬여서, 다시 처음부터 계획하고 시작한다.
 - 생각보다 매우 복잡하고, 복잡하다.
 
 - 출력
    1. 출력되는 모든 스크린을 담당하는 클래스 (ScreenManager.java)
    2. 메인화면을 출력하고 다음 기능으로 안내하는 클래스(MainScreen.java)
    3. 다양한 관리화면을 역할에 맞게 띄워주는 클래스(ManagementScreen.java)
    
 - 입력
    1. 입력을 총괄하는 클래스(Input.java)
    
 - 데이터 관리
    1. 역에 관련된 기능들을 처리하는 클래스(StationManagement.java)
    2. 노선에 관련된 기능들을 처리하는 클래스(LineManagement.java)
    3. 구간에 관련된 기능들을 처리하는 클래스(RouteManagement.java)
    
 - 예외처리
    1. 이미 존재하는 노선 이름에 대한 예외 클래스(AlreadyExistLineNameException.java)
    2. 하행 종점을 변경하는 입력에 대한 예외 클래스(DownLineStationException.java)
    3. 상행 종점을 변경하는 입력에 대한 예외 클래스(UpLineStationException.java)
    4. 이름 입력이 3글자 미만('역'포함)인 입력에 대한 예외 클래스(NameLengthException.java)
    5. 존재하지 않는 노선 이름에 대한 예외 클래스(NoExistLineNameException.java)
    6. 존재하지 않는 역 이름에 대한 예외 클래스(NoExistStationNameException.java)
    7. 존재하지 않는 기능에 대한 예외 클래스(NoneFunctionException.java)
    8. 저장소에 데이터가 없을 때 처리하는 예외 클래스(NullRepositoryException.java)
    9. 이미 존재하는 역에 대한 예외 클래스 (UsedStationException.java)
    

## 작동 순서도
    - 클래스의 목적을 글로 쓰기보다는, 이런 식으로 순서도를 만들면 보기 편할 것 같아 만들어 보려고 한다.