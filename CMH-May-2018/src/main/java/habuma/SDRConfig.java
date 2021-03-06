package habuma;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class SDRConfig {

	@Bean
	public RepositoryRestConfigurerAdapter sdrCustomizer() {
		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config
					.withEntityLookup()
					.forRepository(UserProfileRepository.class,
								   UserProfile::getUsername,
								   UserProfileRepository::findByUsername);
			}
		};
	}
	
}
