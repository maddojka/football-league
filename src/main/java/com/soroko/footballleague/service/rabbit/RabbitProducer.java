package com.soroko.footballleague.service.rabbit;
import com.soroko.footballleague.configuration.ScheduledTasks;
import com.soroko.footballleague.dto.HolderDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
/**
 * @author yuriy.soroko
 */
@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RabbitProducer {

    final AmqpTemplate amqpTemplate;

    public void send(HolderDTO holderDTO) {
        log.info(String.format("Json message sent -> %s", holderDTO.toString()));
        amqpTemplate.convertAndSend("payment_routing_exchange","payment_routing_key", holderDTO);
    }
}
