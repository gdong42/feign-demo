# feign-demo: Demo of https://github.com/spring-cloud/spring-cloud-openfeign/issues/173

## Reproducing Steps

1. Clone the repo

2. Start the application by running
    ```bash
    $ ./mvnw clean spring-boot:run
    ```

    **Expected Result:**

    * Application starts successfully
    * `curl http://localhost:8080/echo?input=hello` returns something like below:
      ```json
      {
        "args": {
          "input": "hello"
        },
        "data": "",
        "files": {},
        "form": {},
        "headers": {
          "Accept": "*/*",
          "Host": "httpbin.org",
          "User-Agent": "Java/11"
        },
        "json": null,
        "method": "GET",
        "origin": "111.196.63.161, 111.196.63.161",
        "url": "https://httpbin.org/anything?input=hello"
      }
      ```
    * `curl http://localhost:8080/uuid` returns something like following:
      ```json
      {
        uuid: "e562208e-79ca-4203-ae82-539702042d67"
      }
      ```

    **Actual Results**
    * Start fails and following exception is thrown:
    ```
    Caused by: java.lang.IllegalStateException: No fallback instance of type class thirdparty.UuidHttpBinClient$UuidHttpBinClientFallback found for feign client httpbin
    ```
