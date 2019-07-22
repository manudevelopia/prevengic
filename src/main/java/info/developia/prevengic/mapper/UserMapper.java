package info.developia.prevengic.mapper;

import info.developia.prevengic.dao.UserDao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    info.developia.prevengic.model.User entityToDomain(UserDao entity);

}
