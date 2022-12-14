package com.example.demo.user;

import com.example.demo.generic.IEntityMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper extends IEntityMapper<User> {
  @Mapping(target = "id", ignore = true)
  @BeanMapping(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
  )
  void updateUser(User entityDto, @MappingTarget User entity);
}
