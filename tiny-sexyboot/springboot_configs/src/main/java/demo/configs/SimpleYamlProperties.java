package demo.configs;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import demo.factories.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;


@Configuration
@ConfigurationProperties(prefix = "map") // used to specify the prefix
/* used to specify the configuration location & the property bean factory */
@PropertySource(value = "classpath:external.yaml", factory = YamlPropertySourceFactory.class)
@Getter
@Setter
public class SimpleYamlProperties {
    private Map<String, Map<String, String>> entries;
    private List<String> list;
}
