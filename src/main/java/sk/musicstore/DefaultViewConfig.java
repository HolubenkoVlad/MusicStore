package sk.musicstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
/**
 * The class overrides the boot page.
 * */
public class DefaultViewConfig implements WebMvcConfigurer {
    @Override
    /**
     * The method adds the new controller that redirects to the catalog.jsp
     * @param ViewControllerRegistry allows to create simple automated controllers pre-configured with status code and/or a view.
     * @see org.springframework.web.servlet.config.annotation.ViewControllerRegistry
     * */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/products.do").setViewName("catalog");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
