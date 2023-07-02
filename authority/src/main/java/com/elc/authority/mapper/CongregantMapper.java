package com.elc.authority.mapper;

import com.elc.authority.entity.Congregant;
import com.elc.authority.model.RegisterRequest;
import org.mapstruct.Mapper;

@Mapper
public interface CongregantMapper {
    Congregant toCongregant(RegisterRequest registerRequest);
}
