package com.itcast.springboot.config;

//@Configuration
//// @PropertySource("classpath:jdbc.properties")
//@EnableConfigurationProperties(JdbcProperties.class) //启用属性读取类
//public class JdbcConfiguration {
//  //	@Value("${jdbc.url}")
//  //	String url;
//  //	@Value("${jdbc.driverClassName}")
//  //	String driverClassName;
//  //	@Value("${jdbc.username}")
//  //	String username;
//  //	@Value("${jdbc.password}")
//  //	String password;
//  @Autowired
//	private JdbcProperties jdbcProperties;
//
//  @Bean
//  public DataSource dataSource() {
//    DruidDataSource dataSource = new DruidDataSource();
////    dataSource.setUrl(url);
////    dataSource.setDriverClassName(driverClassName);
////    dataSource.setUsername(username);
////    dataSource.setPassword(password);
//		dataSource.setUrl(jdbcProperties.getUrl());
//		dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
//		dataSource.setUsername(jdbcProperties.getUsername());
//		dataSource.setPassword(jdbcProperties.getPassword());
//    return dataSource;
//  }
//
//
//
//}

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {

	@Bean
	// 声明要注入的属性前缀，SpringBoot会自动把相关属性通过set方法注入到DataSource中
	@ConfigurationProperties(prefix = "jdbc")
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		return dataSource;
	}
}
