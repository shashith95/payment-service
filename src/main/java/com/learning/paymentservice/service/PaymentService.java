package com.learning.paymentservice.service;

import com.learning.paymentservice.model.request.PaymentRequest;

public interface PaymentService {

    Long doPayment(PaymentRequest paymentRequest);
}
