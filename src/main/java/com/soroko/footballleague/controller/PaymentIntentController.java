package com.soroko.footballleague.controller;


import com.soroko.footballleague.dto.HolderDTO;
import com.soroko.footballleague.entity.Request;
import com.soroko.footballleague.entity.Response;
import com.soroko.footballleague.service.kafka.KafkaProducer;
import com.soroko.footballleague.service.rabbit.RabbitProducer;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentIntentController {

    private final RabbitProducer rabbitProducer;

    @PostMapping("/create-payment-intent")
    public Response createPaymentIntent(@RequestBody Request request)
            throws StripeException {
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(request.getAmount() * 100L)
                        .putMetadata("teamName",
                                request.getTeamName())
                        .setCurrency("usd")
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams
                                        .AutomaticPaymentMethods
                                        .builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();

        PaymentIntent intent =
                PaymentIntent.create(params);

        return new Response(intent.getId(),
                intent.getClientSecret());
    }

    @PostMapping("/paymentapproved")
    public ResponseEntity<?> sendPaymentApproved(@RequestBody Request request) {
        HolderDTO holderDTO = new HolderDTO();
        holderDTO.setFullName("Ivan Ivanov");
        holderDTO.setEmail(request.getEmail());
        holderDTO.setTeamName(request.getTeamName());
        rabbitProducer.send(holderDTO);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
