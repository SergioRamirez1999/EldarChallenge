package com.sergioramirezme.eldar;

import com.sergioramirezme.eldar.business.PaymentBO;
import com.sergioramirezme.eldar.dtos.PaymentFeeInquiryReqDTO;
import com.sergioramirezme.eldar.dtos.PaymentFeeInquiryResDTO;
import com.sergioramirezme.eldar.entities.Card;
import com.sergioramirezme.eldar.repositories.ICardRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.TimeZone;

@SpringBootApplication
public class EldarApplication {

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Argentina/Buenos_Aires"));
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(EldarApplication.class, args);

		ICardRepository paymentRepository = context.getBean(ICardRepository.class);
		PaymentBO paymentBO = context.getBean(PaymentBO.class);

		Card visa = paymentRepository.findByNumberAndDueDateAndBrandName("1111 1111 1111 1111", LocalDate.of(2022, 9, 11), "VISA");
		Card nara = paymentRepository.findByNumberAndDueDateAndBrandName("2222 2222 2222 2222", LocalDate.of(2026, 9, 11), "NARA");
		Card amex = paymentRepository.findByNumberAndDueDateAndBrandName("3333 3333 3333 3333", LocalDate.of(2026, 9, 11), "AMEX");

		showCardInfo(visa, visa, paymentBO, 850);
		showCardInfo(nara, visa, paymentBO, 1024);
		showCardInfo(amex, nara, paymentBO, 1000);


	}

	private static void showCardInfo(Card card, Card c2, PaymentBO paymentBO, double amount) {
		System.out.println(card);
		System.out.println(MessageFormat.format("Pago de {0}: ", amount).concat(card.isValidPayment(amount) ? "válido" : "no válido"));
		System.out.println("Estado de expiración: " + (card.isValid() ? "no expirada" : "expirada"));
		System.out.println("Tarjetas iguales: " + card.isSameCard(c2));

		try {
			String brand = card.getBrand().getName();

			PaymentFeeInquiryResDTO paymentFeeInquiryResDTO = paymentBO.inquiryFee(
					PaymentFeeInquiryReqDTO.builder()
							.brand(brand)
							.amount(amount)
							.build());

			System.out.println(
					MessageFormat.format("Tasa de operacion con tarjeta {0} y monto {1}: ", brand, amount)
							+ paymentFeeInquiryResDTO.getFee());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
