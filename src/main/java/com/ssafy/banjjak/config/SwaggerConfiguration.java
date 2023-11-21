package com.ssafy.banjjak.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.HashSet;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfiguration {

//	Swagger-UI 3.x 확인
//	//http://localhost/vue/swagger-ui/index.html
	
	private final ServerProperties serverProperties;
	
    @Bean
    public Docket allApi() {
        return new Docket(DocumentationType.OAS_30)
        	.consumes(getConsumeContentTypes())
        	.produces(getProduceContentTypes())
            .groupName("ALL-API")
            .apiInfo(allApiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.ssafy.banjjak"))
            .paths(PathSelectors.ant("/**"))
            .build()
            .useDefaultResponseMessages(false);
    }
    
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.OAS_30)
        	.consumes(getConsumeContentTypes())
            .produces(getProduceContentTypes())
            .groupName("USER-API")
            .apiInfo(userApiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.ssafy.banjjak.user.controller"))
            .paths(PathSelectors.ant("/user/**"))
            .build()
            .useDefaultResponseMessages(false);
    }
    
    @Bean
    public Docket shortApi() {
        return new Docket(DocumentationType.OAS_30)
        	.consumes(getConsumeContentTypes())
            .produces(getProduceContentTypes())
            .groupName("SHORT-API")
            .apiInfo(boardApiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.ssafy.banjjak.shorts.controller"))
            .paths(PathSelectors.ant("/short/**"))
            .build()
            .useDefaultResponseMessages(false);
    }
    
    private ApiInfo allApiInfo() {
        Integer port = serverProperties.getPort();
        return new ApiInfoBuilder()
            .title("BANJJAK Swagger Open API Docs")
            .description(
                "<h3>BANJJAK API Reference for Developers</h3>BANJJAK을 위한 API<br><img src=\"/assets/img/ssafy_logo.png\" width=\"150\">")
            .version("1.0")
            .license("SSAFY License")
            .licenseUrl("https://www.ssafy.com/ksp/jsp/swp/etc/swpPrivacy.jsp")
            .termsOfServiceUrl("http://edu.ssafy.com")
            .contact(new Contact("SSAFY", "https://www.ssafy.com", "ssafy@ssafy.com"))
            .build();
    }

    private ApiInfo userApiInfo() {
        return new ApiInfoBuilder()
            .title("사용자")
            .description("<h2>사용자 API</h2>")
            .version("1.0")
            .license("SSAFY License")
            .licenseUrl("https://www.ssafy.com/ksp/jsp/swp/etc/swpPrivacy.jsp")
            .termsOfServiceUrl("http://edu.ssafy.com")
            .contact(new Contact("SSAFY", "https://www.ssafy.com", "ssafy@ssafy.com"))
            .build();
    }
    
    private ApiInfo boardApiInfo() {
        return new ApiInfoBuilder()
            .title("Short")
            .description("<h2>Short API</h2>")
            .version("1.0")
            .license("SSAFY License")
            .licenseUrl("https://www.ssafy.com/ksp/jsp/swp/etc/swpPrivacy.jsp")
            .termsOfServiceUrl("http://edu.ssafy.com")
            .contact(new Contact("SSAFY", "https://www.ssafy.com", "ssafy@ssafy.com"))
            .build();
    }

	private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
//      consumes.add("application/xml;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }

}
