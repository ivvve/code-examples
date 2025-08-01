curl -L -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar

./gradlew build

JAVA_TOOL_OPTIONS="-javaagent:./opentelemetry-javaagent.jar" \
OTEL_EXPORTER_OTLP_ENDPOINT="http://127.0.0.1:4318" \
OTEL_EXPORTER_OTLP_HEADERS='authorization=187c3031-5aa0-4e7f-a764-7278c6af1dfd' \
OTEL_EXPORTER_OTLP_PROTOCOL=http/protobuf \
OTEL_LOGS_EXPORTER=otlp \
OTEL_SERVICE_NAME='example-service' \
OTEL_RESOURCE_ATTRIBUTES="deployment.environment=local" \
/Users/devson/Library/Java/JavaVirtualMachines/openjdk-24.0.1/Contents/Home/bin/java -jar ./build/libs/spring-opentelemetry-0.0.1-SNAPSHOT.jar
