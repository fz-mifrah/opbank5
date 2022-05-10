package com.iga.opbank.service.mapper;

import com.iga.opbank.domain.PaimentFacture;
import com.iga.opbank.domain.ServiceClass;
import com.iga.opbank.service.dto.PaimentFactureDTO;
import com.iga.opbank.service.dto.ServiceClassDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaimentFacture} and its DTO {@link PaimentFactureDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaimentFactureMapper extends EntityMapper<PaimentFactureDTO, PaimentFacture> {
    @Mapping(target = "serviceClasses", source = "serviceClasses", qualifiedByName = "serviceClassNomServiceSet")
    PaimentFactureDTO toDto(PaimentFacture s);

    @Mapping(target = "removeServiceClass", ignore = true)
    PaimentFacture toEntity(PaimentFactureDTO paimentFactureDTO);

    @Named("serviceClassNomService")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomService", source = "nomService")
    ServiceClassDTO toDtoServiceClassNomService(ServiceClass serviceClass);

    @Named("serviceClassNomServiceSet")
    default Set<ServiceClassDTO> toDtoServiceClassNomServiceSet(Set<ServiceClass> serviceClass) {
        return serviceClass.stream().map(this::toDtoServiceClassNomService).collect(Collectors.toSet());
    }
}
