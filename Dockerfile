FROM openjdk:17-oracle
EXPOSE 9999
ADD target/diplom-backend-0.0.1-SNAPSHOT.jar cloudService.jar
CMD ["java", "-jar", "cloudService.jar"]