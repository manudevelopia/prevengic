package info.developia.prevengic.mapper;

import info.developia.prevengic.dao.Compound;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompoundMapper {

    CompoundMapper MAPPER = Mappers.getMapper(CompoundMapper.class);

    info.developia.prevengic.model.Compound entityToDomain(Compound entity);
    List<info.developia.prevengic.model.Compound> entityToDomain(List<Compound> entity);

}
