package ru.skypro.homework.mapping.ads;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.skypro.homework.dto.ads.CreateAdsDto;
import ru.skypro.homework.entity.AdsEntity;
import ru.skypro.homework.entity.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CreateAdsDtoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "image", source = "image")
    AdsEntity toModel(CreateAdsDto dto, UserEntity user, String image);

    CreateAdsDto toDto(AdsEntity entity);
}
