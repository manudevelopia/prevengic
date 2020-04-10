package info.developia.prevengic.mapper;

import info.developia.prevengic.dao.CompoundDao;
import info.developia.prevengic.dto.CompoundDto;
import info.developia.prevengic.model.Compound;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompoundMapper {

    CompoundMapper MAPPER = Mappers.getMapper(CompoundMapper.class);

    Compound entityToDomain(CompoundDao dao);

    @Mapping(source = "chemicalProfile.vlaEdPpm", target = "vlaEdPpm")
    @Mapping(source = "chemicalProfile.vlaEdMgm", target = "vlaEdMgm")
    @Mapping(source = "chemicalProfile.vlaEcPpm", target = "vlaEcPpm")
    @Mapping(source = "chemicalProfile.vlaEcMgm", target = "vlaEcMgm")
    CompoundDto entityToDto(CompoundDao dao);

    List<info.developia.prevengic.model.Compound> entityToDomain(List<CompoundDao> entity);

    CompoundDao domainToEntity(info.developia.prevengic.model.Compound entity);

}
