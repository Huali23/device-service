package com.hc.device.config;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2配置类
 */
@Configuration
public class SwaggerConfig {

    @Value("${swagger.show:true}")
    private boolean swaggerShow;
    @Value("${swagger.base_url:http://collect.cloud.hchliot.com:7777/}")
    private String base_url;

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
        .host(base_url)
        .apiInfo(apiInfo())
        // 设置正式环境不显示Swagger2
        .enable(swaggerShow)
        .select()
        // 配置多个扫描路径
        .apis(
            Predicates.or(
            RequestHandlerSelectors.basePackage("com.hc")
            )
        )
        .paths(PathSelectors.any())
        .build();
    }

    private ApiInfo apiInfo() {
        // name：作者，url：通常项目地址，email：邮箱
        Contact contact=new Contact("柳士伟",
        ""," ");
        return new ApiInfoBuilder()
        //标题
        .title("山西税务")
        // 描述
        .description("山西税务相关接口文档")
        .contact(contact)
        //版本
        .version("1.0")
        .build();
    }
}