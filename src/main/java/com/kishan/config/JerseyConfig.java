package com.kishan.config;

import com.kishan.resource.NoteResource;
import com.sun.media.jfxmedia.logging.Logger;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {

        register(NoteResource.class);

        register(LoggingFeature.class);
        EncodingFilter.enableFor(this, GZipEncoder.class);


    }
}