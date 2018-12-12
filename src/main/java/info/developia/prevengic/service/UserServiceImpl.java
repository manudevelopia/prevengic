package info.developia.prevengic.service;

import info.developia.prevengic.exception.UserDoesNotExistException;
import info.developia.prevengic.mapper.UserMapper;
import info.developia.prevengic.model.User;
import info.developia.prevengic.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserBy(String email) {
        return userRepository.findByEmail(email)
                .map(UserMapper.MAPPER::entityToDomain)
                .orElseThrow(UserDoesNotExistException::new);
    }

}
