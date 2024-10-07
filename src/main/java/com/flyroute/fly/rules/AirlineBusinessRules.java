package com.flyroute.fly.rules;

import com.flyroute.fly.entity.Airline;
import com.flyroute.fly.exception.airlineexception.AirlineExceptionNotCreated;
import com.flyroute.fly.message.AirlineMessage;
import com.flyroute.fly.repository.AirlineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AirlineBusinessRules {

    private AirlineRepository airlineRepository;

    public void checkIfCodeExists(String code) {

        Optional<Airline> airline = airlineRepository.findByCode(code);

        if (airline.isPresent()) {
            throw new AirlineExceptionNotCreated(AirlineMessage.CODE_ALREADY_EXISTS);
        }

    }

}
