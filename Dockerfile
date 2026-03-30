FROM eclipse-temurin:21-jdk

ENV DISPLAY=host.docker.internal:0.0

RUN apt-get update && \
    apt-get install -y maven wget unzip libgtk-3-0 libgbm1 libx11-6 fonts-noto-cjk && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

RUN wget https://download2.gluonhq.com/openjfx/21/openjfx-21_linux-x64_bin-sdk.zip -O /tmp/openjfx.zip && \
    unzip /tmp/openjfx.zip -d /opt && \
    rm /tmp/openjfx.zip

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

CMD ["java", "--module-path", "/opt/javafx-sdk-21/lib", "--add-modules", "javafx.controls,javafx.fxml", "-jar", "target/otp-2-inclass-assignments-1.0-SNAPSHOT.jar"]