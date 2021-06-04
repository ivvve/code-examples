# Spring URL Shortener

## Skills

### Language
- Kotlin 1.5.x (Java 11)

### Frameworks
- Spring Boot 2.5.x
- Spring Webflux
- Spring Data R2JDBC

### DB
- H2 (RDBMS)

### Testing
- Rest Assured
- Kotest

## How to Execute

### Test
```bash
$ ./gradlew test
```

### Build
```bash
$ ./gradlew build
```

### Run
```bash
$ ./gradlew bootRun
```

## APIs

### Shortening URL

```
POST /shorten-url HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 33

{
    "url": "http://naver.com"
}
```

### Redirecting Shortened URL

```
GET /{shortened url code} HTTP/1.1
Host: localhost:8080
```
