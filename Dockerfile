# Use the official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Gradle files (build.gradle, settings.gradle, etc.) and the source code
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle
COPY src /app/src

# Download and install Gradle
RUN apt-get update && \
    apt-get install -y curl unzip && \
    curl -L https://services.gradle.org/distributions/gradle-7.3-bin.zip -o gradle.zip && \
    unzip gradle.zip && \
    rm gradle.zip && \
    mv gradle-7.3 /usr/local/gradle && \
    ln -s /usr/local/gradle/bin/gradle /usr/bin/gradle && \
    apt-get remove -y curl unzip && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Set Gradle and Java home
ENV GRADLE_HOME /usr/local/gradle
ENV PATH $PATH:$GRADLE_HOME/bin
ENV JAVA_HOME /usr/local/openjdk-17
ENV PATH $PATH:$JAVA_HOME/bin

# Build the project
RUN gradle build

# Expose the port that your application will run on
EXPOSE 8080

# Command to run the application
CMD ["gradle", "bootRun"]