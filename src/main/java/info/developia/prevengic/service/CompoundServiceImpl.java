package info.developia.prevengic.service;

import info.developia.prevengic.exception.CompoundDoesNotExistException;
import info.developia.prevengic.mapper.CompoundMapper;
import info.developia.prevengic.model.Compound;
import info.developia.prevengic.repository.CompoundRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompoundServiceImpl implements CompoundService {

    private final CompoundRepository compoundRepository;

    public CompoundServiceImpl(CompoundRepository compoundRepository) {
        this.compoundRepository = compoundRepository;
    }

    @Override
    public List<Compound> findAll() {
        return CompoundMapper.MAPPER.entityToDomain(compoundRepository.findAll());
    }

    @Override
    public List<Compound> findByName(String name) {
        return compoundRepository.findByNameIgnoreCaseContaining(name)
                .map(CompoundMapper.MAPPER::entityToDomain)
                .orElseThrow(CompoundDoesNotExistException::new);
    }

    @Override
    public List<Compound> findByNce(String nce) {
        return compoundRepository.findByNceIgnoreCaseContaining(nce)
                .map(CompoundMapper.MAPPER::entityToDomain)
                .orElseThrow(CompoundDoesNotExistException::new);
    }

    @Override
    public List<Compound> findByCas(String cas) {
        return compoundRepository.findByCasIgnoreCaseContaining(cas)
                .map(CompoundMapper.MAPPER::entityToDomain)
                .orElseThrow(CompoundDoesNotExistException::new);
    }

}