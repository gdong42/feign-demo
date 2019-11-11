package thirdparty;

import thirdparty.UuidHttpBinClient.UuidHttpBinClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Date: 2019/11/11 Time: 11:48 PM
 *
 * @author Gan Dong
 */
@FeignClient(name = "httpbin",
    url = "https://httpbin.org",
    contextId = "uuid-httpbin-client",
    configuration = HttpBinClientConfiguration.class,
    fallback = UuidHttpBinClientFallback.class
)
public interface UuidHttpBinClient {

  @GetMapping("/uuid")
  String uuid();

  class UuidHttpBinClientFallback implements UuidHttpBinClient {

    @Override
    public String uuid() {
      return "fake_uuid";
    }
  }
}
