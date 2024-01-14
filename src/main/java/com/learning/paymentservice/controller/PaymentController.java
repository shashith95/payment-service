package com.learning.paymentservice.controller;

import com.learning.paymentservice.model.common.ApiResponse;
import com.learning.paymentservice.model.request.PaymentRequest;
import com.learning.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.learning.paymentservice.util.ResponseHandler.generateResponse;


@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> doPayment(@RequestBody PaymentRequest paymentRequest) {
        logger.info("Do payment API triggered with request body: {}", paymentRequest);

        return generateResponse(HttpStatus.OK, "Payment Processed Successfully", "100",
                paymentService.doPayment(paymentRequest));
    }
}
