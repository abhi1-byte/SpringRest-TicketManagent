package com.abhi.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Tourist REST API",
                version = "1.0",
                description = "CRUD API for tourists"
        )
)
public class OpenApiConfig {

}
// http://localhost:9999/RestMiniProject/swagger-ui/index.html -> shows a visual interface built from that spec
// http://localhost:9999/RestMiniProject/v3/api-docs → gives the raw spec (machine-readable JSON)