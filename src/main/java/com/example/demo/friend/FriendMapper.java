package com.example.demo.friend;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.demo.generic.IEntityMapper;

@Mapper(componentModel = "spring")
public interface FriendMapper extends IEntityMapper<Friend> {

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(Friend entityDto, @MappingTarget() Friend entity);
}
