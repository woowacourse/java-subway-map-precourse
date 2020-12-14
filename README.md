# 지하철 노선도 미션
[프리코스를 통해 공부한 것들](https://www.notion.so/9186a1ce15b54fddb0c0ca0c8b99c39d)

[1주차 프리코스](https://www.notion.so/1-4c1e2bc9b4bc412a85ee72a1244ac86c)

[1주차 프리코스, 피드백을 피드백하다](https://www.notion.so/1-8b5157674d1340d7a4086641f602d542)

[2주차 프리코스](https://www.notion.so/2-b4853e276d7a42828a70f81439e97598)

[3주차 프리코스 계획](https://www.notion.so/3-8997d2c11e50483eb7d1b3d90996a3f2)

[피드백을 피드백하다 ver.2](https://www.notion.so/ver-2-2a63193924bd4deaa085ed94793d0471)

[3주차 시행착오](https://www.notion.so/3-56dde02fc32d4160bac11caa2f1d1187)
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
    2. 이미 존재하는 역에 대한 예외 클래스(AlreadyExistStationNameException.java)
    2. 하행 종점을 변경하는 입력에 대한 예외 클래스(DownLineStationException.java)
    3. 상행 종점을 변경하는 입력에 대한 예외 클래스(UpLineStationException.java)
    4. 이름 입력이 3글자 미만('역'포함)인 입력에 대한 예외 클래스(NameLengthException.java)
    5. 존재하지 않는 노선 이름에 대한 예외 클래스(NoExistLineNameException.java)
    6. 존재하지 않는 역 이름에 대한 예외 클래스(NoExistStationNameException.java)
    7. 존재하지 않는 기능에 대한 예외 클래스(NoneFunctionException.java)
    8. 저장소에 데이터가 없을 때 처리하는 예외 클래스(NullRepositoryException.java)
    9. 이미 존재하는 역에 대한 예외 클래스 (UsedStationException.java)
    10. 구간 입력이 잘못 되었을 때에 대한 예외 클래스(OverRangeException.java)
    

## input package

### Input.java
    -입력을 총괄하는 클래스.
        1. 역 이름 입력 받는 메소드
        2. 노선 이름 입력 받는 메소드
        3. 기능 입력 받는 메소드
        4. 순서 입력 받는 메소드
        
## management package

### StationManagement.java
    - 역 관리 기능을 총괄하는 클래스
        1. 관리화면에서 선택한 기능을 구분하는 메소드
        2. 역을 삽입하는 메소드
        3. 역을 삭제하는 메소드
        4. 모든 역을 조회하는 메소드
        
### LineManagement.java
    - 노선 관리 기능을 총괄하는 클래스
        1. 관리화면에서 선택한 기능을 구분하는 메소드
        2. 노선을 삽입하는 메소드
        3. 노선을 삭제하는 메소드
        4. 모든 노선을 조회하는 메소드
        
### RouteManagement.java
    - 구간 관리 기능을 총괄하는 클래스
        1. 관리화면에서 선택한 기능을 구분하는 메소드
        2. 구간에 역을 삽입하는 메소드
        3. 구간에 역을 삭제하는 메소드

---        
## output package

### ScreenManager.java
    - 메인화면과 관리화면을 관리하는 클래스
        1. 메인 화면을 실행하는 메소드
        2. 메인 화면에서 발생하는 예외를 처리하는 메소드
        3. 관리 화면에서 발생하는 예외를 처리하는 메소드
        4. 메인화면과 관리화면을 실행시켜주는 메소드
        
### SubwayMap.java
    - 저장되어 있는 지하철 노선도를 출력하는 클래스
    
---
### screen package

### MainScreen.java
    - 메인 화면에서의 기능들을 구분하고 관리하는 클래스
        1. 화면 요소들을 시각화해주는 메소드
        2. 선택을 입력 받는 메소드 
        3. 선택한 기능을 ManagementScreen로 연결해주는 메소드
        4. 기능을 나열하는 메소드 
    
### ManagementScreen.java
    - 모든 관리 화면을 구성하는 클래스
        1. 화면 요소들을 시각화해주는 메소드
        2. 선택을 입력 받는 메소드 
        3. 기능을 management package에 연결하는 메소드


## subway package

### Application.java
    - 지하철 노선도를 실행시키는 클래스
    
### BasicData.java
    - 노선도가 실행될 때, 기본 데이터들을 입력시키는 클래스 

### domain package

### Line.java
    - 노선을 저장하는 클래스
        1. 노선에 들어갈 역을 추가하는 메소드
        2. 노선에 있는 역을 삭제하는 메소드
        3. 처음 노선을 만들 때 쓰이는 메소드
        
### LineRepository.java
    - 노선들을 저장하는 저장소 클래스
        1. 노선을 추가하는 클래스
        2. 노선을 삭제하는 클래스
        
### Station.java
    - 역의 정보를 저장하는 클래스
        1. 역이 연관된 노선의 이름을 저장하는 클래스
        
### StationRepository.java
    - 역들을 저장하는 저장소 클래스
        1. 역을 추가하는 메소드
        2. 역을 삭제하는 메소드