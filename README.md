### BACKEND

#### 1. Install dependencies
```
 mvn clean install -DskipTests
```

#### 2. Up database postgresql
```
docker-compose up -d
```

#### 3. Run application
```
mvn spring-boot:run
```