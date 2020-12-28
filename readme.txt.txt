DB 종류  : MariaDB (with Heidi SQL)
why? 이전에 사용한 MYSQL과 거의 같다는 점을 이용 세팅 부분에 있어서만 공부추가함

MariaDB Connector/J 2.7.1 Stable 이용함
why? 이용한 intellij의 Database Navigator 플러그인에는 mariaDB기본 셋팅이 존재하지 않음
        그러므로 연결을 위해 추가하였음

problem : 해당 변화내역을 수기로 작성하였음
	why? 깃의 디렉토리를 이번 프로젝트만 포함시키기 위해 새로운 디렉토리를
	        사용하였더니 플러그인 및 기타 외부 변화 내역은 해당 디렉토리에서
	        변화가 없어 따로 업데이트해야하는 불편함 존재(협업에서 지장이 갈 수 있음)
sol. 디렉토리를 인텔리제이 기본 디렉토리로 설정하거나 !?
 	추가공부!(인텔리제이 플러그인도 깃에 포함하는 법)


OOP : 객체지향

DDD : 도메인주도 설계

repository : jparepository, dbrepository가 같이 persistence layer에 존재하며
jparepository를 상속받을 경우 대부분의 기능을 전부 사용가능하다.

@repository : @component의 기능 명세 어노테이션중 하나로써 @service,@controller 등이 존재함
	이때, repository 어노테이션을 이용한다면, 마크인터페이스로써 명세적 표현이 가능하고
	선언된 클래스에서 기능을 추가 구현할 수 있다