package in.kra3.energy;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by kra3 on 1/14/17.
 */

@Configuration
@EnableJpaRepositories(basePackages = "in.kra3.energy.repositories")
public class ApplicationConfiguration {
}
