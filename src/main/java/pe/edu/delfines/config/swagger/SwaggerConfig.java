package pe.edu.delfines.config.swagger;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
	public static final Contact DEFAULT_CONTACT = new Contact("Fabrizzio Aranda", 
			"https://github.com/Infatzmut/", "fabrizzio1996@gmail.com");
	
	@SuppressWarnings("rawtypes")
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Delfines", "Hotel App", 
			"1.0", "PREMIUN", DEFAULT_CONTACT, "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0", 
			new ArrayList<VendorExtension>());
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
	}
}
