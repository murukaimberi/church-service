FROM openjdk:17-alpine

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/church-gateway/gateway.jar"]
# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib           /usr/share/church-gateway/lib
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/church-gateway/gateway.jar