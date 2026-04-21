package com.ecommerce.order.clients;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.propagation.Propagator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ProductServiceClientConfig {
    @Autowired(required = false)
    private ObservationRegistry observationRegistry;

    @Autowired(required = false)
    private Tracer tracer;

    @Autowired(required = false)
    private Propagator propagator;

    @Bean
    public RestClient.Builder restClientBuilder() {
        RestClient.Builder builder = RestClient.builder();

        if (null != observationRegistry)
            builder.requestInterceptor(createTracingInterceptor());
        return builder;
    }

    private ClientHttpRequestInterceptor createTracingInterceptor() {
        return ((request, body, execution) -> {
            if (tracer != null && propagator != null && tracer.currentSpan() != null) {
                propagator.inject(tracer.currentTraceContext().context(),
                        request.getHeaders(),
                        (carrier, key, value) -> carrier.add(key, value));
            }
            return execution.execute(request, body);
        });
    }

    @Bean
    public ProductServiceClient restClientInterface(RestClient.Builder restClientBuilder) {
        RestClient restClient = restClientBuilder
                .baseUrl("http://product-service")
                .build();

        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(adapter)
                .build();
        return factory.createClient(ProductServiceClient.class);

    }
}
