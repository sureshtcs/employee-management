FROM openjdk:8
ADD target/k8s-employee-management.jar k8s-employee-management.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","k8s-employee-management.jar"]