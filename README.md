스프링 스터디



리액티브 프로그래밍
발행자와 구독자 사이의 간단한 계약을 정의하는 명세
수요 조절을 통해 트래픽을 제어할 수 있다



프로젝트 리액터
VMware에서 만든 리액티브 스트림 구현체
다음과 같은 특성을 따르는 리액티브 프로그래밍을 활용할 수 있음

​	논블로킹, 비동기 프로그래밍 모델
​	함수형 프로그래밍 스타일
​	스레드를 신경 쓸 필요 없는 동시성



리액티브 스트림 시그널
onNext
onError
onComplete



Netty
논블로킹, 비동기 웹 컨테이너
서블릿 스펙에 구속되지 않고 스프링 웹플럭스는 네티와 궁합이 잘 맞음
Spring Reactive Web 의존성을 추가하면 스프링 웹플럭스와 내장형 네티가 포함됨



Controller에서 Flux를 반환하면 적절한 타이밍에 스프링 웹플럭스가 구독한다



리액티브 프로그래밍의 요건
모든 과정이 리액티브여야 한다
웹 컨트롤러를 리액티브 방식으로 동작하게 만들고 서비스 계층도 리액티브 방식으로 동작하게 만들었는데
블로킹 방식의 데이터베이스를 호출하면 리액티브를 적용할 수 없다

리액티브 지원 데이터베이스(관계형 데이터베이스가 아님)
MongoDB
Redis
Cassandra
Elasticsearch
Neo4j
Couchbase

R2DBC는 리액티브 스트림을 활용해 관계형 데이터베이스에 연결할 수 있도록 설계된 명세

map과 flatMap
map은 '이것'을 '저것'으로 바꾸는 함수형 도구
flatMap은 '이것'의 스트림을 다른 크기로 된 '저것'의 스트림으로 바꾸는 함수형 도구



Example 쿼리
여러 조건을 조립해서 스프링 데이터에 전달하면, 스프링 데이터는 필요한 쿼리문을 만들어준다
검색 조건이 여러개이고 조건이 많아 유지보수가 힘들다면 사용
ReactiveQueryByExampleExecutor를 상속



DevTools
애플리케이션 재시작과 리로드 자동화
환경설정 정보 기본값 제공
자동설정 변경사항 로깅
정적 자원 제외
라이브 리로드 지원



BlockHound
개발자가 직접 작성한 코드 뿐만 아니라 서드파티 라이브러리에 사용된 블로킹 메소드 호출을 
모두 찾아내 알려주는 자바 에이전트이다



테스트

@ExtendWith(~~.class): 테스트 핸들러를 지정할 수 있는 JUnit5의 api	
@MockBean: Mockito를 사용해 가짜 객체를 만들고 빈으로 추가한다
@BeforeEach: JUnit5의 애너테이션, 모든 테스트 메소드 실행 전에 테스트 준비를 위함
StepVerifier::create: 리액터 타입 핸들러를 생성

리액티브 코드를 테스트할 때 핵심은 기능만을 검사하는 게 아니라 리액티브 스트림 시그널도 함께 검사해야한다

테스트 코드의 구독은 StepVeirifier가 한다



스프링 부트 액추에이터
서버 상태, ping, metrics를 확인 가능



테이블 키 생성 전략
AUTO(default): jpa 구현체(스프링 부트에서 Hibernate)가 생성 방식을 결정
IDENTITY: 사용하는 데이터베이스가 키 생성을 결정 MySQL이나 MariaDB의 경우 auto increment방식을 이용함
SEQUENCE: 데이터베이스의 sequence를 이용해서 키를 생성. @SequenceGenerator와 같이 사용
TABLE: 키 생성 전용 테이블을 생성해서 키 생성, @TableGenerator와 같이 사용



JpaRepository 인터페이스
Spring Data JPA의 구현체인 Hibernate를 이용하기위해 여러가지 API를 제공함
그중에 개발자가 많이 사용하는 것이 JpaRepository
상속 구조: Repository <= CrudRepository <= PagingAndSortRepository <= JpaRepository



findById와 getOne의 차이
findById는 실행한 순간에 SQL이 처리가 되고 getOne은 해당 객체가 필요한 순간에 SQL이 실행됨



Pageable 인터페이스
페이지 처리에 필요한 정보를 전달하는 용도의 타입
인터페이스이기 때문에 실제 객체를 생성할 때는 구현체인 PageRequest를 이용
PageRequest 클래스의 생성자는 protected로 선언되어 있어 new를 이용한 생성이 불가능해 of를 이용해 생성
PageRequest클래스의 생성자의 인자로 page, size, sort가 있음

of(int page, int size): 0부터 시작하는 페이지 번호와 개수(size), 정렬이 지정되지 않음
of(int page, int size, Sort.Direction direction, String...props): 0부터 시작하는 페이지 번호와 개수, 정렬의 방향과 정렬 기준 필드들
of(int page, int size, Sort sort): 페이지 번호와 개수, 정렬 관정 정보



Querydsl
JPA의 쿼리 메서드와 @Query는 선언할 때 고정된 형태의 값을 가진다는 단점이 존재
따라서 복잡한 조합을 이용하는 경우의 수가 많아지는 상황에서 동적으로 쿼리를 생성해 처리하는 기능이 필요함
Querydsl은 이러한 상황을 처리할 수 있는 기술

엔티티 클래스를 그대로 이용하는 것이 아닌 Q도메인을 이용해야함
Querydsl 설정을 마치고 compileQuerydsl을 실행하면 build폴더에 Q로 시작하는 엔티티 클래스가 생성됨
Repository에는 QuerydslPredicateExecutor 인터페이스를 상속받게 됨
Q도메인을 이용해 BooleanExpression을 만들고 BooleanBuider에 and나 or같은 키워드로 결합
find의 인자로 builder를 넘겨줌으로 검색 가능



지연 로딩
join의 경우 많은 연산이 필요하므로 필요할때 연산을 처리하도록 지연 로딩 처리
@ManyToOne(fetch = FetchType.LAZY)





