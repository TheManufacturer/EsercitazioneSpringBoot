package com.example.interceptor01.configurations;

import com.example.interceptor01.interceptors.APILoggingInterceptor;
import com.example.interceptor01.interceptors.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringMVCConfiguration implements WebMvcConfigurer {

        @Autowired
        private APILoggingInterceptor apiLoggingInterceptor;

        @Autowired
        private LegacyInterceptor legacyInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(apiLoggingInterceptor);
            registry.addInterceptor(legacyInterceptor);
        }
}

