package com.probe.config;

import com.probe.model.Command;
import com.probe.model.Direction;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Command>() {
            @Override
            public Command convert(String source) {
                return Command.valueOf(source);
            }
        });
        registry.addConverter(new Converter<Command, String>() {
            @Override
            public String convert(Command source) {
                return source.name();
            }
        });
        registry.addConverter(new Converter<String, Direction>() {
            @Override
            public Direction convert(String source) {
                return Direction.valueOf(source);
            }
        });
        registry.addConverter(new Converter<Direction, String>() {
            @Override
            public String convert(Direction source) {
                return source.name();
            }
        });
    }
}