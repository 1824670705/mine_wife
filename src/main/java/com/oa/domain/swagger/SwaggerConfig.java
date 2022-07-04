package com.oa.domain.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

//@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        ParameterBuilder builder = new ParameterBuilder();
        List<Parameter> strList = new ArrayList<>();
//        builder.name("token").description("令牌")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(true).build();
        strList.add(builder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.oa.application.*.controller"))
                .paths(PathSelectors.any()).build().globalOperationParameters(strList);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Lei")
                .contact(new Contact("L", "http://baidu.com", "1824670705@qq.com"))
                .description("L's description document!")
                .version("1.0.0").build();
    }
}
