package com.natchamp.in.payment.web.rest.api;

import com.natchamp.in.payment.generateddomain.ApiUtil;
import com.natchamp.in.payment.generateddomain.service.dto.PaymentRequest;
import com.natchamp.in.payment.generateddomain.service.dto.PaymentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Optional;

public interface PaymentApi {

    /**
     * POST /payment/{bookId} :
     *
     * @param bookId  (required)
     * @param paymentRequest  (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "postPaymentBookId",
            summary = "",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/payment/{bookId}",
            produces = { "application/json" },
            consumes = { "application/json", "application/xml" }
    )
    default ResponseEntity<PaymentResponse> _postPaymentBookId(
            @Parameter(name = "bookId", description = "", required = true) @PathVariable("bookId") String bookId,
            @Parameter(name = "PaymentRequest", description = "") @Valid @RequestBody(required = false) PaymentRequest paymentRequest
    ) {
        return postPaymentBookId(bookId, paymentRequest);
    }

    // Override this method
    default  ResponseEntity<PaymentResponse> postPaymentBookId(String bookId, PaymentRequest paymentRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
