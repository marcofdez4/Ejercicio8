package aop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aop.aspectos.InformeFuncionAspect;

@Configuration
@EnableAspectJAutoProxy
//@ComponentScan("aop.funcionUsuarios")
public class ConfiguracionUsuarioAspecto {

	@Bean
	public InformeFuncionAspect informeFuncionAspect() {
		return new InformeFuncionAspect();
	}
}
