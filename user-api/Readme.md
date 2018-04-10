# Secure API Example
This API Example demonstrates  AUTO configured JWT validation 

To setup validation, include the following dependency in your POM
```
<dependency
    <groupId>com.wileyng</groupId>
    <artifactId>api-security</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Docker Instructions
docker run  --rm -d --name user-api -p 8446:8446 -t wpng/user-api:latest