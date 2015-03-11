package com.dimensiondata.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConfig {

    @Value("${http.client.maxConnections}")
    private int maxConnections;

    @Value("${http.client.soTimeout}")
    private int soTimeOut;

    @Bean
    public HttpClient httpClient() {
        RequestConfig.Builder builder = RequestConfig.custom();
        builder.setSocketTimeout(soTimeOut);

        RequestConfig requestConfig = builder.build();

        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        clientBuilder.setDefaultRequestConfig(requestConfig);
        clientBuilder.setMaxConnTotal(maxConnections);

        return clientBuilder.build();
    }

    @Bean
    @Autowired
    public RestTemplate restTemplate( HttpClient httpClient) {

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(factory);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(1);
        messageConverters.add( new MappingJackson2HttpMessageConverter()) ;
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.dimensiondata.model");
        return marshaller;
    }

}



