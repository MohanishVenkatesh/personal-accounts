package com.mohanish.personalaccounts.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Mohanish Venkatesh",
                        email = "vmohanish2000@hotmail.com",
                        url = "https://www.linkedin.com/in/mohanish-venkatesh-448466152/"
                ),
                description = " This is a project created to manage personal finances",
                title = "Personal Accounts Software",
                version = "1.0",
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/license/mit/"
                ),
                termsOfService = "Terms of Service"
        ),
        servers = {
                    @Server(
                            description = "Local ENV",
                            url = "http://localhost:8080"
                    ),
                    @Server(
                            description = "PROD ENV",
                            url = "https://localhost:8080"
                    )
        }

)
public class OpenApiConfig {
}
