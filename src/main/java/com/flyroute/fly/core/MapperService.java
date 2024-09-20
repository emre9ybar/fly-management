package com.flyroute.fly.core;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;

public interface MapperService {

  ModelMapper forRequest();
  ModelMapper forResponse();



}
