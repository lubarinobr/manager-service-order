package br.com.managerorders.configurations.thymeleaf

import nz.net.ultraq.thymeleaf.LayoutDialect
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.thymeleaf.spring5.SpringTemplateEngine

@Configuration
class ThymeleafConfiguration {

    /*@Bean
    fun thymeleafLayoutDialect(): SpringTemplateEngine {
        val layoutDialect = SpringTemplateEngine()
        layoutDialect.addDialect(LayoutDialect())
        return layoutDialect
    }*/
}