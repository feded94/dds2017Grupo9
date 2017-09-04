package com.dds;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.dds.Cuentas.Cuenta;
import com.dds.Cuentas.CuentaRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dds"})
public class Grupo9Application implements CommandLineRunner {

	CuentaRepository cuentaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Grupo9Application.class, args);
		
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Cuenta cuenta1 = new Cuenta();
		cuenta1.set_nombre("face");
		cuenta1.set_tipo("tipo1");
		cuenta1.set_valor(200);
		cuentaRepository.save(cuenta1);
			
		
	}
}
