package org.example.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImgurConfig {

    @Bean
    public ImgurUploader imgurUploader() {
        return new ImgurUploader();
    }
}
