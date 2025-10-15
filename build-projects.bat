call mvn -f ./customer-service/pom.xml clean install -U -DskipTests
call mvn -f ./reservation-service/pom.xml clean install -U -DskipTests
call mvn -f ./payment-service/pom.xml clean install -U -DskipTests
call mvn -f ./hotel-management-service/pom.xml clean install -U -DskipTests
call mvn -f ./notification-service/pom.xml clean install -U -DskipTests
call mvn -f ./api-gateway/pom.xml clean install -U -DskipTests
call mvn -f ./eureka-registry/pom.xml clean install -U -DskipTests