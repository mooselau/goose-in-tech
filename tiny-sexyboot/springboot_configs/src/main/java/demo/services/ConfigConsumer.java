package demo.services;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import demo.configs.SimpleYamlProperties;


@Component
public class ConfigConsumer {
    @Autowired
    private SimpleYamlProperties yamlProperties;

    @PostConstruct
    public void init() {
        p("===> Reading Properties from YAML <===");
        Map<String, Map<String, String>> map = yamlProperties.getEntries();
        for (Map.Entry<String, Map<String, String>> entry: map.entrySet()) {
            p("entry: " + entry.getKey());
            entry.getValue().forEach((o, o2) -> p("key: " + o + ", value: " + o2));
        }

        List<String> list = yamlProperties.getList();
        list.forEach(s -> p("List Element: " + s));
        p("===> Reading Properties Over <===");
    }

    private void p(String msg) {
        System.out.println(msg);
    }

}
