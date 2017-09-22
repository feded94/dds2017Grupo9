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
import org.springframework.context.annotation.Configuration;

import com.dds.persistence.Cuenta;
import com.dds.persistence.CuentaRepository;
import com.dds.persistence.Empresa;
import com.dds.persistence.EmpresaRepository;
import com.dds.persistence.Periodo;
import com.dds.persistence.PeriodoRepository;
import com.dds.persistence.Condicion;
import com.dds.persistence.CondicionRepository;
import com.dds.persistence.Metodologia;
import com.dds.persistence.MetodologiaRepository;
import com.dds.persistence.Indicador;
import com.dds.persistence.Numero;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dds"})
@EnableAutoConfiguration
@EnableJpaRepositories
@Configuration
@EntityScan(basePackages =  {"com.dds.persistence","com.dds.model"})
public class Grupo9Application implements CommandLineRunner {

    final
	CuentaRepository cuentaRepository;
    final
	EmpresaRepository empRepo;
	final
	CondicionRepository condRepo;
	final
	MetodologiaRepository metRepo;
	final
	PeriodoRepository periodoRepo;

	@Autowired
	public Grupo9Application(CuentaRepository cuentaRepository, EmpresaRepository empRepo, CondicionRepository condRepo, MetodologiaRepository metRepo, PeriodoRepository periodoRepo) {
		this.cuentaRepository = cuentaRepository;
		this.empRepo = empRepo;
		this.condRepo = condRepo;
		this.metRepo = metRepo;
		this.periodoRepo = periodoRepo;
	}

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
		met1.addCondicion(cond1);
//		metRepo.save(met1);
	}
}