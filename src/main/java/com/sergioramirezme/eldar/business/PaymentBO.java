package com.sergioramirezme.eldar.business;

import com.sergioramirezme.eldar.dtos.CardDTO;
import com.sergioramirezme.eldar.dtos.PaymentFeeInquiryReqDTO;
import com.sergioramirezme.eldar.dtos.PaymentFeeInquiryResDTO;
import com.sergioramirezme.eldar.exceptions.BusinessException;
import com.sergioramirezme.eldar.exceptions.PersistenceException;
import com.sergioramirezme.eldar.repositories.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentBO {

    private IPaymentRepository paymentDAO;

    @Autowired
    public PaymentBO(IPaymentRepository paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    //Metodo utilizado por la api y manual para obtener el fee de un pago
    public PaymentFeeInquiryResDTO inquiryFee(PaymentFeeInquiryReqDTO paymentFeeInquiryReqDTO) throws BusinessException {
        //Obtener fee de la marca y ejecutar logica de calculo de tarifa utilizando el amount
        PaymentFeeInquiryResDTO paymentFeeInquiryResDTO = new PaymentFeeInquiryResDTO();
        return paymentFeeInquiryResDTO;
    }

    public void processPayment(CardDTO cardDTO) throws BusinessException {
        try {
            throw new PersistenceException();
        } catch (PersistenceException e) {
            throw new BusinessException(e);
        }
    }

}
