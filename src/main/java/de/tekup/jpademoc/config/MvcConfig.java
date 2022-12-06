package de.tekup.jpademoc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
 
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("voitures-photos", registry);
    }
     
    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path dirPath = Path.of(dirName);
        Path uploadDir = dirPath.toAbsolutePath().normalize();

         
        registry.addResourceHandler("/" + dirPath.normalize() + "/**").addResourceLocations("file:/"+ uploadDir + "/");
    }
}