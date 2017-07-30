package cn.wcj.springboot.quickstart;


import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@SpringBootApplication(exclude={RedisAutoConfiguration.class})
//@Configuration
@SpringBootConfiguration
public class HelloApplication {

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello SpringBoot!!!微架构时代来临";
    }
    
//    @Bean
//    public StringHttpMessageConverter stringHttpMessageConverter(){
//        StringHttpMessageConverter converter  = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        return converter;
//    }

    
    public static void main(String[] args) {
        //SpringApplication.run(HelloApplication.class, args);
    	SpringApplication application = new SpringApplication(HelloApplication.class);
    	application.setBannerMode(Mode.OFF);
    	application.run(args)   ;
    }

	
}
