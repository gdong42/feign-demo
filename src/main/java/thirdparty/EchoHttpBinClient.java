package thirdparty;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Date: 2019/11/11 Time: 11:48 PM
 *
 * @author Gan Dong
 */
@FeignClient(name = "httpbin",
    url = "https://httpbin.org",
    contextId = "echo-httpbin-client"
)
public interface EchoHttpBinClient {

  @GetMapping("/anything")
  String echo(@RequestParam("input") String input);

}
