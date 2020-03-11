package cn.netinnet.workflow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(scanBasePackages={"cn.netinnet.workflow"})
@MapperScan({"cn.netinnet.workflow.user.dao", "cn.netinnet.workflow.activiti.dao"})
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class NinWorkflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(NinWorkflowApplication.class, args);
    }

}
