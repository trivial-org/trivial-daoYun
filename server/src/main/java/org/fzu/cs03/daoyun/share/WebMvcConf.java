package org.fzu.cs03.daoyun.share;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConf implements WebMvcConfigurer {
    @Autowired
    private UserSecurityInterceptor securityInterceptor;

    private final Logger logger = LoggerFactory.getLogger(WebMvcConf.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(securityInterceptor).addPathPatterns("/**");//配置登录拦截器拦截路径
        registry.addInterceptor(securityInterceptor)
//                .excludePathPatterns("/**");
                .addPathPatterns("/**")
                .excludePathPatterns("/signin")
                .excludePathPatterns("/signup")
                .excludePathPatterns("/verification/mail")
                .excludePathPatterns("/verification/code")
                .excludePathPatterns("/signup/users")
                .excludePathPatterns("/device")
                .excludePathPatterns("/dataDictionary");


//        log.debug("跨域拦截器注册成功！");
    }

//    但是使用此方法配置之后再使用自定义拦截器时跨域相关配置就会失效。
//    原因是请求经过的先后顺序问题，当请求到来时会先进入拦截器中，而不是进入Mapping映射中，所以返回的头信息中并没有配置的跨域信息。浏览器就会报跨域异常。
//
//    正确的解决跨域问题的方法时使用CorsFilter过滤器。代码如下：

    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
        // registry.addMapping("/api/**")
                // .allowedOrigins("*")
                // .allowedMethods("GET", "POST", "OPTIONS","PUT","DELETE")
                // .allowedHeaders("*")
                // .allowCredentials(true)
                // .maxAge(3600);
    // }



    // 自己添加转化器，不加bufferImg，
    // 在AbstractMessageConverterMethodProcessor
    /*

            if (body != null) {
                Set<MediaType> producibleMediaTypes = (Set)inputMessage.getServletRequest().getAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE);
                if (!isContentTypePreset && CollectionUtils.isEmpty(producibleMediaTypes)) {
                    throw new HttpMediaTypeNotAcceptableException(this.allSupportedMediaTypes);
                }

                throw new HttpMessageNotWritableException("No converter for [" + valueType + "] with preset Content-Type '" + contentType + "'");
            }
             找不到转化器
    * */

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(new BufferedImageHttpMessageConverter());
//        super.configureMessageConverters(converters);
//        //创建fastjson消息转换器
//        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
//        //创建配置类
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        //修改配置返回内容的过滤
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteNullBooleanAsFalse);
//
//        fastJsonConverter.setFastJsonConfig(fastJsonConfig);
//
//        //添加StringHttpMessageConverter，解决中文乱码问题
//        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        List<MediaType> mediaTypes = Collections.singletonList(MediaType.APPLICATION_JSON_UTF8);
//        stringConverter.setSupportedMediaTypes(mediaTypes);
//
//        //讲fastJson添加到消息转换列表
//        converters.add(fastJsonConverter);
//        converters.add(stringConverter);
    }


}