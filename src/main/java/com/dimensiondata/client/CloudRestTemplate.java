package com.dimensiondata.client;

import com.dimensiondata.client.exception.CloudServerClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
public class CloudRestTemplate {

    private static final String USER_AGENT = "User-Agent";

    @Value("${rest.user.agent}")
    private String userAgent;

    @Value("${rest.media.type}")
    private String mediaTypeValue;

    @Value("${rest.media.subtype}")
    private String mediaSubtypeValue;

    private MediaType mediaType;

    @Autowired
    protected RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        mediaType = new MediaType(mediaTypeValue, mediaSubtypeValue);
    }

    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, T body, Class<T> clazz) {
        return exchange(url,method,body,clazz,null);
    }

    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, T body, Class<T> clazz, Map<String,List<String>> headers) {
        try {
            HttpEntity entity = createRequestEntity(body, headers);
            return restTemplate.exchange(url, method, entity, clazz);
        } catch (RestClientException e ) {
            throw createClientException(e);
        }
    }

    private <T> HttpEntity createRequestEntity(T requestBody, Map<String,List<String>> headers ) {

        HttpHeaders httpHeaders = buildHeaders(headers);
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(mediaType);

        httpHeaders.setAccept(supportedMediaTypes);
        httpHeaders.set(USER_AGENT, userAgent);
        if (requestBody != null)
            httpHeaders.setContentType(mediaType);

        return new HttpEntity<T>(requestBody, httpHeaders);
    }

    private static HttpHeaders buildHeaders( Map<String,List<String>> headers ) {
        if ( headers == null )
            return new HttpHeaders();

        HttpHeaders httpHeaders = new HttpHeaders();
        Iterator<String> keys = headers.keySet().iterator();
        while ( keys.hasNext() ) {
            String headerKey = keys.next();
            httpHeaders.put(headerKey, headers.get(headerKey));
        }

        return httpHeaders;
    }

    private CloudServerClientException createClientException( RestClientException exception ) {
        if ( exception instanceof HttpClientErrorException) {
            HttpClientErrorException httpEx = (HttpClientErrorException) exception;
            return new CloudServerClientException(httpEx.getResponseBodyAsString(), httpEx, httpEx.getStatusCode().value());
        } else {
            return new CloudServerClientException(exception.getMessage(), exception, HttpStatus.SERVICE_UNAVAILABLE.value());
        }
    }

}
