package com.dds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.dds.Cuentas.Cuenta;
import com.dds.Cuentas.CuentaRepository;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dds"})
@EnableAutoConfiguration
@EnableJpaRepositories
@Configuration
@EntityScan(basePackages = {"com.dds.Cuentas"})
public class Grupo9Application implements CommandLineRunner {

    @Autowired
	CuentaRepository cuentaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Grupo9Application.class, args);
		
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		Cuenta cuenta1 = new Cuenta();
		cuenta1.set_nombre("face");
		cuenta1.set_tipo("tipo1");
		cuenta1.set_valor(200);
		cuentaRepository.save(cuenta1);
	}
}