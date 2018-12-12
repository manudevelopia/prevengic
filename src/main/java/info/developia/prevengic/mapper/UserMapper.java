package info.developia.prevengic.mapper;

import info.developia.prevengic.dao.UserDao;
import info.developia.prevengic.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User entityToDomain(UserDao entity);
    UserDao domainToEntity(User domain);

}
