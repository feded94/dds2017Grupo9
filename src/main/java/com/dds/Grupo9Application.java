package com.dds;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.dds.Cuentas.Cuenta;
//import com.dds.Cuentas.CuentaRepository;
import com.dds.Empresas.Empresa;
import com.dds.Empresas.EmpresaRepository;
import com.dds.Metodologias.Condicion;
import com.dds.Metodologias.CondicionRepository;
import com.dds.Indicadores.*;

import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dds"})
@EnableAutoConfiguration
@EnableJpaRepositories
@Configuration
@EntityScan(basePackages =  {"com.dds.Cuentas", "com.dds.Empresas","com.dds.Metodologias","com.dds.Indicadores"})
public class Grupo9Application implements CommandLineRunner {

    @Autowired
	//CuentaRepository cuentaRepository;
	EmpresaRepository empRepo;
    CondicionRepository condRepo;
    
	public static void main(String[] args) {
		SpringApplication.run(Grupo9Application.class, args);
		
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		Date date = new Date();
		Cuenta cuenta1 = new Cuenta();
		cuenta1.setNombre("face");
		cuenta1.setTipo("tipo1");
		cuenta1.setValor(200);
		cuenta1.setPeriodo(date);
		Empresa emp1 = new Empresa();
		emp1.setNombre("mark"); 
		emp1.addCuenta(cuenta1);
		empRepo.save(emp1);
		Condicion cond1 = new Condicion();
		/*IndicadorBusiness indicadorB1 = new IndicadorBusiness();
		indicadorB1.set_expresion(" a+b");
		indicadorB1.set_nombre(" indicador de prueba");
		indicadorB1.set_valor(40.00);*/
		cond1.setNumero(" 44");
		cond1.setTipo(" tipo 4");
		cond1.setIndicador(null);
		condRepo.save(cond1);
	}
}