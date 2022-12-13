package de.tekup.jpademoc;

import de.tekup.jpademoc.ctrls.ClientCtrl;
import de.tekup.jpademoc.security.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class JpaDemoCApplication {

    public static void main(String[] args) {
       ApplicationContext ctx =  SpringApplication.run(JpaDemoCApplication.class, args);
        //System.err.println(Arrays.toString(ctx.getBeanDefinitionNames()));
        //ClientCtrl client =  ctx.getBean(ClientCtrl.class);
        //client.hello();
    }

}
