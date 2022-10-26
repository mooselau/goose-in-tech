package demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import demo.pojo.User;
import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
@ComponentScan
public class Application {
    public static void main(String[] args) {
        // 1. Use default SpringApplication to run
        ApplicationContext context = SpringApplication.run(Application.class, args);
        // 2. use ApplicationContext to run Spring IoC
        // ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = context.getBean(User.class);
        LOGGER.info("==> " + user.getUserName());
        // below simply want ApplicationContext could read application.properties
        //        Application app = new Application();
        //        app.loadProperty();
    }

    private void loadProperty() {
        Properties properties = new Properties();
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
