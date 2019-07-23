package info.developia.prevengic.mapper;

import info.developia.prevengic.dao.CompoundDao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompoundMapper {

    CompoundMapper MAPPER = Mappers.getMapper(CompoundMapper.class);

    info.developia.prevengic.model.Compound entityToDomain(CompoundDao entity);

    List<info.developia.prevengic.model.Compound> entityToDomain(List<CompoundDao> entity);

    CompoundDao domainToEntity(info.developia.prevengic.model.Compound entity);

}
