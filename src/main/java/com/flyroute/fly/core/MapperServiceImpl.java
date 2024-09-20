package com.flyroute.fly.core;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MapperServiceImpl implements MapperService{

    private ModelMapper modelMapper;
    @Override
    public ModelMapper forRequest() {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD)  // Use loose matching for flexibility
                .setAmbiguityIgnored(true);  // Ignore ambiguity
        return modelMapper;    }

    @Override
    public ModelMapper forResponse() {
        modelMapper.getConfiguration().
                setMatchingStrategy(MatchingStrategies.LOOSE).
                setAmbiguityIgnored(true);
        return modelMapper;
    }
}
