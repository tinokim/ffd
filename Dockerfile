## openjdk:21 이미지를 기반으로 새로운 이미지를 생성
## 이 기반 이미지에는 Java 21 런타임이 포함
#FROM openjdk:21
#
## JAR_FILE 환경 변수를 설정하고, 해당 환경 변수에 "*.jar"와 일치하는 파일을 할당
## 이 변수는 빌드 시 사용자가 지정할 수 있다
#ARG JAR_FILE=*.jar
#
## JAR_FILE에 할당된 파일을 app.jar로 복사
## 이렇게 하면 컨테이너 내부에 app.jar 파일이 생성된다
#COPY ${JAR_FILE} app.jar
#
## 컨테이너 내부에서 사용할 포트를 9201로 노출
## 이 포트를 통해 컨테이너에 접근할 수 있다
#EXPOSE 8080
#
## 컨테이너가 시작될 때 실행할 명령어를 지정
## java -jar app.jar 명령어를 실행하여 Spring Boot 애플리케이션을 시작
#ENTRYPOINT ["java","-jar","app.jar"]

FROM openjdk:21
ARG JAR_FILE=/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#FROM <이미지명>:<태그>
#- Docker 기본 이미지, openjdk:[프로젝트의 jdk버전]
#ARG
#- 선언합니다. JAR_FILE을 *.jar파일로 입력
#COPY
#- JAR_FILE을 컨테이너의 app.jar로 복사
#ENTRYPOINT
#-컨텍스트 시작 시 펼쳐보기