package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan({"controller"})
public class ScanControl {
		@Bean
		public InternalResourceViewResolver viewResolve() {
			InternalResourceViewResolver view=new InternalResourceViewResolver();
			view.setPrefix("/WEB-INF/");
			view.setSuffix(".jsp");
			return view;
		}
		
		
		}


