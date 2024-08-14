**목차**

## 1.1 영속성에 대한 이해

**영속성**

영속화 : 어플리케이션의 상태와 상관 없이 물리적인 저장소(DBMS)를 이용해 데이터를 저장하는 행위

- 데이터를 어떤 공간에 어떤 형태로 저장할 것인지에 따라 영속화 방식은 달라질 수 있음
- 보편적으로 적용되는 RDBMS에 데이터를 저장하기 위해서는 **SQL을 이용**

**JDBC 인터페이스**

- Java 어플리케이션에서 DB에 접근할 때 기본적으로 사용하는 방법
- Java 어플리케이션과 DB의 소통을 위한 기능들 정의

**Driver**

- JDBC 인터페이스를 구현하는 클래스들을 제공 (각 DB 제조사들 마다)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c5eb2073-f203-4dc1-8619-c289cdc82c78/dc341a22-a527-43d7-aa7c-0136645c35a7/Untitled.png)

⇒ 순수 JDBC 기반의 영속적 데이터 관리는 개발 과정에서 다소 많은 시간과 비용이 발생, 효율성도 떨어짐

## 1.2 Resource 접근 레이어

Client :  UI(데이터를 어떻게 보여줄 것인가, event handling)

Server :  Controller, Service(비즈니스 로직), **Repository(Store)(실제 DB에서 데이터 작업) : 자원접근**

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c5eb2073-f203-4dc1-8619-c289cdc82c78/363550e7-2c93-47e6-9d67-92c84a9afc33/Untitled.png)

- 비즈니스 컴포넌트 ⇒ 비즈니스 로직 레이어 , 자원 접근 모듈 ⇒ 자원 접근 레이어에 놓여있음

## 1.3 객체의 세상과 테이블의 세상

객체 중심의 객체지향 어플리케이션과 테이블 중심의 관계형 데이터베이스는 서로 목표가 다름

⇒ 이를 맞춰주는 과정이 필요 (mapping하는 과정에서 시간과 비용이 듦)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c5eb2073-f203-4dc1-8619-c289cdc82c78/7f01b354-e701-4954-8190-16dfdd9fff37/Untitled.png)

Persistence Framework

- 자바 어플리케이션과 관계형 DB의 사용을 돕는 프레임워크
- SQL 매핑과 OR 매핑으로 구분
- 로직에서 DB 연결 설정을 분리하여 개발자가 비즈로직에 집중할 수 있게 도움
- 상황에 맞게 적용하면, 개발의 편의성 뿐만 아니라 성능 및 유지보수에도 큰 이점이 됨
- **SQL Mapping**

자바 코드와 SQL을 분리, **개발자가 작성한 SQL**의 수행결과를 객체로 매핑, 즉 **자바 객체와 쿼리 결과를 매핑**

- **OR Mapping**

객체와 관계형 DB 사이에서 매핑을 담당하며, **SQL을 생성**하여 패러다임의 불일치를 해결, 즉, **자바 객체와 데이터베이스 릴레이션을 매핑**


![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c5eb2073-f203-4dc1-8619-c289cdc82c78/aad777cd-b7eb-44e0-8c18-5014a41477f2/Untitled.png)

## 1.4 JPA (Java Persistence API)의 이해

JPA

- 자바 프로그램과 관계형 DB에 접근하는 방식을 명세화한 인터페이스
- ORM(Object-Relational Mapping) rltnf vywns
- 구현체는 Hibernate 라이브러리 사용
- JPA를 적용할 경우 도메인 객체는 기술에 의존적이지 않으며 재사용을 높일 수 있음
- JPA를 사용해서 객체를 영속화 하기 위해서는 객체에 annotation을 추가하여 별도의 메타 데이터 구성이 필요함

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c5eb2073-f203-4dc1-8619-c289cdc82c78/5ba6f853-44c5-4de5-9fb3-9b9de41d2e5c/Untitled.png)