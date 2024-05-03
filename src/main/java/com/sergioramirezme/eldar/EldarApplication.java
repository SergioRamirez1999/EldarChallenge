package com.sergioramirezme.eldar;

import com.sergioramirezme.eldar.entities.Card;
import com.sergioramirezme.eldar.repositories.IPaymentRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.TimeZone;

@SpringBootApplication
@Data
public class EldarApplication {

	private IPaymentRepository paymentRepository;

	@Autowired
	public EldarApplication(IPaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Argentina/Buenos_Aires"));
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(EldarApplication.class, args);

		IPaymentRepository paymentRepository = context.getBean(IPaymentRepository.class);
		Card visa = paymentRepository.findByBrandName("VISA");
		Card nara = paymentRepository.findByBrandName("NARA");
		Card amex = paymentRepository.findByBrandName("AMEX");

	}

}
