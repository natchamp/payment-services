package com.natchamp.in.payment.web.rest;

import com.natchamp.in.payment.generateddomain.service.dto.PaymentRequest;
import com.natchamp.in.payment.generateddomain.service.dto.PaymentResponse;
import com.natchamp.in.payment.web.rest.api.PaymentApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController implements PaymentApi {
    Logger log = LoggerFactory.getLogger(PaymentController.class);
    public ResponseEntity<PaymentResponse> postPaymentBookId(String bookId, PaymentRequest paymentRequest) {
        log.info("Request received for purchase Book with ID : {}", bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
