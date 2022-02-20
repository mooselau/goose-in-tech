package demo.factories;

import java.io.IOException;
import java.util.Properties;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;


public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(final String s, final EncodedResource encodedResource)
            throws IOException {
        String sourceName = encodedResource.getResource().getFilename();
        if (!encodedResource.getResource().exists()) {
            // if resource not found, return empty properties
            return new PropertiesPropertySource(sourceName, new Properties());
        } else {
            // only works on YAML, will error if not Yaml format
            YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
            factoryBean.setResources(encodedResource.getResource());
            Properties properties = factoryBean.getObject();
            return new PropertiesPropertySource(sourceName, properties);
        }
    }
}
