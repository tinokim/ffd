### MSA 기반 예약구매 백엔드 시스템
ffd는 foot forward의 약자로 첫걸음이라는 뜻입니다.
이 프로젝트는 마이크로서비스 아키텍처(MSA)와 도커, Redis를 활용하여 예약구매 기능을 제공하는 백엔드 시스템입니다. 사용자는 이 시스템을 통해 원하는 상품을 구매할 수 있습니다.

## 주요 기능
구매 기능: 예약된 상품을 실제로 구매할 수 있습니다.
재고 관리: Redis를 활용하여 상품의 재고 정보를 실시간으로 관리합니다.
마이크로서비스 아키텍처: 서비스 간 독립성과 확장성을 높이기 위해 MSA 패턴을 적용했습니다.
도커 컨테이너: 각 서비스를 도커 컨테이너로 구현하여 배포와 운영을 용이하게 했습니다.

## 기술 스택
프레임워크: Spring Boot, Spring Cloud
데이터베이스: PostgreSQL
컨테이너: Docker

이 프로젝트는 다음과 같은 마이크로서비스로 구성되어 있습니다:

user-service: 사용자 관리와 인증을 담당하는 서비스
item-service: 상품 정보를 제공하는 서비스
order-service: 주문과 결제를 처리하는 서비스
batch: 배치 작업을 수행하는 서비스
gateway: 마이크로서비스들의 진입점 역할을 하는 API 게이트웨이
eureka: 서비스 디스커버리와 로드 밸런싱을 위한 Eureka 서비스 레지스트리

## 설치 및 실행
도커 및 도커 컴포즈를 설치합니다.
프로젝트 리포지토리를 클론합니다.
도커 컴포즈 파일을 실행하여 시스템을 구동합니다.

git clone https://github.com/tinokim/ffd.git
docker-compose up -d
