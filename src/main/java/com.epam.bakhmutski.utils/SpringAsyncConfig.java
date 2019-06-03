package com.epam.bakhmutski.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@ComponentScan("com.epam.bakhmutski.utils")
public class SpringAsyncConfig {
}