package com.shilin.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * mybatis plus逻辑删除
 * 1、配置全局的逻辑删除规则（可省略）
 * 2、配置逻辑删除组件（3.1.1开始不需要配置）
 * 3、实体类字段加上 @TableLogic 注解
 *
 * JSR303
 * 1、给Bean添加校验注解：javax.validation.constraints，并定义自己的message提示
 * 2、开启校验功能@Valid
 * 		效果：校验错误后会有默认的响应；
 * 3、给校验的bean后紧跟一个BingingResult，就可以获取到校验的结果
 * 4、分组校验
 * 		1)、@NotBlank(message = "品牌名不能为空",groups = {AddGroup.class,UpdateGroup.class})
 * 			给校验注解标注什么情况需要进行校验
 * 		2)、@Validated({AddGroup.class})
 * 		3)、默认没有指定分组的校验注解，在分组校验情况下不生效，只会在没有标注分组的@Validated才会生效
 * 5、自定义校验
 * 		1）、编写一个自定义校验注解
 * 		2）、编写一个自定义校验器
 * 		3）、关联自定义的校验器和自定义的校验注解
 *      @Documented
 * 		@Constraint(validatedBy = {ListValueConstraintValidator.class【可以指定多个不同的校验器，适配不同类型的校验】})
 * 		@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
 * 		@Retention(RetentionPolicy.RUNTIME)
 * 		public @interface ListValue
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.shilin.gulimall.product.feign")
@MapperScan("com.shilin.gulimall.product.dao")
public class GulimallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallProductApplication.class, args);
	}

}
