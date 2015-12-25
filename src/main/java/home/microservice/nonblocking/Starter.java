package home.microservice.nonblocking;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({VertxConfig.class, JOOQConfiguration.class, DataSourceConfiguration.class})
@ComponentScan("home.microservice.nonblocking.contact")
@PropertySource("classpath:/application.properties")
public class Starter {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) throws Exception {
       SpringApplication.run(Starter.class);
    }
}
