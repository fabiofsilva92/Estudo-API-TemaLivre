package estudo.apitemalivre.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("estudo.apitemalivre.controllers"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessage())
                .globalResponseMessage(RequestMethod.POST, responseMessage())
                .globalResponseMessage(RequestMethod.PUT, responseMessage())
                .globalResponseMessage(RequestMethod.DELETE, responseMessage())
                .securitySchemes(Arrays.asList(new ApiKey("apiKey", "Authorization", "header")))
                .securityContexts(Arrays.asList(securityContext()))
                .apiInfo(metadata());
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder()
                .securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("ADMIN", "accessEverything");
        AuthorizationScope [] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("apiKey", authorizationScopes));
    }

    public static ApiInfo metadata(){
        return new ApiInfoBuilder().title("API - TemaLivre - Jogos / Plataformas / Generos")
                .description("CRUD completo de todas entidades")
                .version("1.0")
                .license("")
                .licenseUrl("")
                .contact(new Contact("Fábio Fernandes da Silva", "https://git.gft.com/forv/estudo-api-temalivre", "fabio.fernandes@gft.com"))
                .build();
    }

    public static List<ResponseMessage> responseMessage(){
        return new ArrayList<ResponseMessage>(){
            {
                add(new ResponseMessageBuilder().code(200).message("Sucesso!").build());
                add(new ResponseMessageBuilder().code(201) .message("Criado!").build());
                add(new ResponseMessageBuilder().code(400) .message("Erro na requisição!").build());
                add(new ResponseMessageBuilder().code(401) .message("Não Autorizado!").build());
                add(new ResponseMessageBuilder().code(403) .message("Proibido!").build());
                add(new ResponseMessageBuilder().code(404) .message("Não Encontrado!").build());
                add(new ResponseMessageBuilder().code(500) .message("Erro!").build());
            }
        };
    }

}
