package com.sirzhangs.commonserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

import com.github.tobato.fastdfs.FdfsClientConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Import(FdfsClientConfig.class)
@EnableEurekaClient
@SpringBootApplication
@MapperScan(value = "com.sirzhangs.commonserver.mapper")
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@EnableSwagger2
public class EurekaCommonServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCommonServerApplication.class, args);
	}

}
