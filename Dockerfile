FROM openjdk:17

EXPOSE 8585

ADD target/ss-project-management.jar ss-project-management.jar

ENTRYPOINT [ "java","-jar","/ss-project-management.jar" ]