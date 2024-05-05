package com.sergioramirezme.eldar.business;

import com.sergioramirezme.eldar.dtos.PaymentDTO;
import com.sergioramirezme.eldar.dtos.PaymentFeeInquiryReqDTO;
import com.sergioramirezme.eldar.dtos.PaymentFeeInquiryResDTO;
import com.sergioramirezme.eldar.entities.ArgumentExpression;
import com.sergioramirezme.eldar.entities.BrandCard;
import com.sergioramirezme.eldar.entities.Fee;
import com.sergioramirezme.eldar.exceptions.BusinessException;
import com.sergioramirezme.eldar.repositories.IBrandCardRepository;
import com.sergioramirezme.eldar.utils.NashornUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.ScriptException;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PaymentBO {

    private IBrandCardRepository brandCardRepository;

    @Autowired
    public PaymentBO(IBrandCardRepository brandCardRepository) {
        this.brandCardRepository = brandCardRepository;

    }

    public PaymentFeeInquiryResDTO inquiryFee(PaymentFeeInquiryReqDTO paymentFeeInquiryReqDTO) throws BusinessException {
        BrandCard brandCard = brandCardRepository.findByName(paymentFeeInquiryReqDTO.getBrand());

        if(brandCard == null)
            throw new BusinessException("Los datos ingresados no corresponden a una tarjeta en servicio.");

        double fee = calculateFee(brandCard.getFee(), paymentFeeInquiryReqDTO.getAmount());
        return PaymentFeeInquiryResDTO.builder()
                .fee(fee)
                .build();
    }

    public void processPayment(PaymentDTO paymentDTO) throws BusinessException {}

    public double calculateFee(Fee feeEntity, double amount) throws BusinessException {
        Map<String, Double> argname_value = feeEntity.getArguments().stream()
                .collect(Collectors.toMap(ArgumentExpression::getName,
                        arg -> switch (arg.getName()) {
                            case "day" -> (double) LocalDate.now().getDayOfMonth();
                            case "month" -> (double) LocalDate.now().getMonthValue();
                            case "year" -> Double.parseDouble(String.valueOf(LocalDate.now().getYear()).substring(2));
                            default -> arg.getDefaultValue();
                        }));

        try {
            double fee = NashornUtils.eval_expression(feeEntity.getExpression(), argname_value);
            return amount * (fee / 100);
        } catch (ScriptException e) {
            e.printStackTrace();
            throw new BusinessException("Ocurrió un error al evaluar la expresión de tasa.");
        }

    }

}
