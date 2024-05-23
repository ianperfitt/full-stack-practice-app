package com.example.springcloudgateway.java.repository.feign.decoder.config;

import feign.codec.Decoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// used as a workaround for decoding OpenFeign response
@Configuration
public class FeignResponseDecoderConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignResponseDecoderConfig.class);

    @Bean
    public Decoder feignDecoder() {

        LOGGER.info(String.format("FeignResponseDecoderConfig -> Decoding FeignClient response"));

        ObjectFactory<HttpMessageConverters> messageConverters = () -> {
            HttpMessageConverters converters = new HttpMessageConverters();
            return converters;
        };
        return new SpringDecoder(messageConverters);
    }
}
