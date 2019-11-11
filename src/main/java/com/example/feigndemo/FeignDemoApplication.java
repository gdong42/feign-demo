package com.example.feigndemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import thirdparty.EchoHttpBinClient;
import thirdparty.UuidHttpBinClient;

@EnableFeignClients(basePackages = "thirdparty")
@SpringBootApplication
public class FeignDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignDemoApplication.class, args);
	}

	@RestController
	static class EchoController {

		@Autowired
		private EchoHttpBinClient echoHttpBinClient;

		@Autowired
		private UuidHttpBinClient uuidHttpBinClient;

		@GetMapping("/echo")
		public String echoFromHttpbin(String input) {
			return echoHttpBinClient.echo(input);
		}

		@GetMapping("/uuid")
		public String uuidFromHttpbin() {
			return uuidHttpBinClient.uuid();
		}

	}

}
