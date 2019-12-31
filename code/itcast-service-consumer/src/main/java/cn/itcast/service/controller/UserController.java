package cn.itcast.service.controller;

import cn.itcast.service.client.UserClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer/user")
//@DefaultProperties(defaultFallback = "fallBackMethod") // 指定一个类的全局熔断方法
public class UserController {

	@Autowired
	private UserClient userClient;
	/*@Autowired
	private RestTemplate restTemplate;*/
//	@Autowired
//	private DiscoveryClient discoveryClient; // eureka客户端，可以获取到eureka中服务的信息
	@GetMapping
	@HystrixCommand/*(fallbackMethod = "queryUserByIdFallBack")*/
	public String queryUserById(@RequestParam("id")Long id){
//		List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");

//		ServiceInstance instance = instances.get(0);
//		String baseUrl = "http://service-provider/user/" + id;
//		String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
//		String user = restTemplate.getForObject(baseUrl,String.class);
//		return user;
		return  userClient.queryUserById(id).toString();
	}

	public String queryUserByIdFallBack(Long id){
		return "请求繁忙，请稍后再试！";
	}


	/**
	 * 熔断方法
	 * 返回值要和被熔断的方法的返回值一致
	 * 熔断方法不需要参数
	 * @return
	 */
	public String fallBackMethod(){
		return "请求繁忙，请稍后再试！";
	}
}
