package com.example.springfullstructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ImageAccessConfig implements WebMvcConfigurer {
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    //this method is map URL to file system folder
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //URL /images/ will access file in folder
        registry.addResourceHandler("/uploads/**")

                //Folder path Spring show at this
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/" + uploadDir + "/");

    }

}
