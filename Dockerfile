FROM openjdk:8
EXPOSE 9095 9096
ARG PROFILE
VOLUME /tmp
ADD build/libs/kotlin-dockerized-0.0.1.jar /app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENV SPRING_PROFILE=${PROFILE}
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=$SPRING_PROFILE -jar /app.jar" ]