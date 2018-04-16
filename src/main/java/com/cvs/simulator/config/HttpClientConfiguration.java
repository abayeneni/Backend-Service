package com.cvs.simulator.config;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * To make http/https requests
 *
 */
@Configuration
public class HttpClientConfiguration {

    /**
     * Logger initialization for HttpClientConfiguration.
     */
    private static final Logger LOG = Logger.getLogger(HttpClientConfiguration.class);

    /**
     * POOLMAX Value
     */
    private static final int POOLMAX = 20;

    /**
     * POOLMAXPERROUTE
     */
    private static final int MAXPERROUTE = 200;

    /**
     * @return returns ClientHttpRequestFactory
     */
    @Bean
    public ClientHttpRequestFactory httpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }

    /**
     * @return restTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory());
        // Create a list for the message converters
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        // Add the String Message converter
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        // Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    /**
     * Apache HttpClient which works for Http & Https.
     *
     * @return HttpClient
     */
    public HttpClient httpClient() {
        SSLConnectionSocketFactory sf = null;
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.create();
        try {
            SSLContext sslcontext = new SSLContextBuilder()
                    .loadTrustMaterial(null, (certificate, authType) -> true)
                    .build();
            sf = new SSLConnectionSocketFactory(sslcontext, new NoopHostnameVerifier());
            registryBuilder.register("https", sf);
        } catch (Exception e) {
            LOG.error("unable to establish SSL Context layer ", e);
        }
        Registry<ConnectionSocketFactory> socketFactoryRegistry = registryBuilder
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
                socketFactoryRegistry);
        connectionManager.setMaxTotal(POOLMAX);
        connectionManager.setDefaultMaxPerRoute(MAXPERROUTE);
        HttpClientBuilder builder = HttpClientBuilder
                .create()
                .setConnectionManager(connectionManager);
        return builder.build();
    }
}