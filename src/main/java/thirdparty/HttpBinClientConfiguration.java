package thirdparty;

import thirdparty.UuidHttpBinClient.UuidHttpBinClientFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 2019/11/12 Time: 12:52 AM
 *
 * @author Gan Dong
 */
@Configuration
public class HttpBinClientConfiguration {

  @Bean
  public UuidHttpBinClientFallback uuidHttpBinClientFallback() {
    System.out.println("      **** UuidHttpBinClientFallback is actually created ****");
    return new UuidHttpBinClientFallback();
  }
}
