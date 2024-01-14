package com.learning.paymentservice.service.impl;

import com.learning.paymentservice.model.entity.Payment;
import com.learning.paymentservice.model.request.PaymentRequest;
import com.learning.paymentservice.repository.PaymentRepository;
import com.learning.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.learning.paymentservice.util.DateTimeUtils.getCurrentDateTimeUtc;

@Service
public class PaymentServiceImpl implements PaymentService {
    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        logger.info("Recording payment details: {}", paymentRequest);

        return paymentRepository.save(Payment.PaymentBuilder.builder()
                        .orderId(paymentRequest.orderId())
                        .referenceNumber(paymentRequest.referenceNumber())
                        .paymentDate(getCurrentDateTimeUtc())
                        .paymentStatus("SUCCESS")
                        .amount(paymentRequest.amount())
                        .paymentMode(paymentRequest.paymentMode())
                        .build())
                .getPaymentId();
    }
}
