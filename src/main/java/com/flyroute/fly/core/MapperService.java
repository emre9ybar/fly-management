package com.flyroute.fly.core;

import com.flyroute.fly.dto.response.userresponse.GetUsersListResponse;
import com.flyroute.fly.entity.User;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;

public interface MapperService {

  ModelMapper forRequest();
  ModelMapper forResponse();





}
