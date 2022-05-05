package by.andersen.laboratory.microservice.reports.model.dto;

import java.util.List;

public interface EntityDtoMapper <E, D> {

    D entityToDto(E entity);

    List<D> convertEntityListToDtoList(List<E> entityList);

    E dtoToEntity(D dto);
}
