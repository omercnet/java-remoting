package net.omerc.javaremoting.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import net.omerc.javaremoting.api.ApiService;

import static java.lang.System.out;

@SpringBootApplication
public class Client {

    @Bean
    public HttpInvokerProxyFactoryBean http() {
        HttpInvokerProxyFactoryBean bean = new HttpInvokerProxyFactoryBean();
        bean.setServiceUrl("http://example.com/");
        bean.setServiceInterface(ApiService.class);
        return bean;
    }

    public static void main(String[] args) {
        ApiService service = SpringApplication.run(Client.class, args).getBean(ApiService.class);
        out.println(service.call("foo"));
    }

}
