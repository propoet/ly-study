package cn.itcast.service;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker // 开启熔断*/
@SpringCloudApplication // 相当于以上三个总和
@EnableFeignClients // 开启feign客户端
public class ItcastServiceConsumerApplication {

 /* @Bean
  @LoadBalanced // 开启负载均衡
  public RestTemplate restTemplate(){
    return  new RestTemplate();
  }
*/
  public static void main(String[] args) {
    SpringApplication.run(ItcastServiceConsumerApplication.class, args);
  }
}
