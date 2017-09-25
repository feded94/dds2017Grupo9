package com.dds;

import com.dds.persistence.services.CuentaService;
import com.dds.persistence.services.EmpresaService;
import com.dds.persistence.services.IndicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.dds.persistence.repositories"})
@ComponentScan(basePackages = {"com.dds"})
@EntityScan(basePackages =  {"com.dds.model", "com.dds.persistence"})
public class Grupo9Application implements CommandLineRunner {
    private final CuentaService cuentaService;
	private final IndicadorService indicadorService;
	private final EmpresaService empresaService;

    public Grupo9Application(CuentaService cuentaService, IndicadorService indicadorService, EmpresaService empresaService) {
        this.cuentaService = CuentaService.getService();
        this.indicadorService = IndicadorService.getService();
        this.empresaService = EmpresaService.getService();
    }

	public static void main(String[] args) {
		SpringApplication.run(Grupo9Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*
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
		//IndicadorBusiness indicadorB1 = new IndicadorBusiness();
		Indicador indicadorprueba = new Numero(4.00);
		cond1.setNumero(" 44");
		cond1.setTipo(" tipo 4");
		cond1.setIndicador(indicadorprueba);

		Periodo periodo1 = new Periodo();
		periodo1.setfechaFin(date);
		periodo1.setfechaInicio(date);
		periodoRepo.save(periodo1);

		Metodologia met1 = new Metodologia();
		met1.setNombreMetodologia("metodologia");
		//met1.addCondicion(cond1);
//		metRepo.save(met1);
*/
	}
}