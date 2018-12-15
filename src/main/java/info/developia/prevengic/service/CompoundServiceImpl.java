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
    public Compound findByName(String name) {
        return compoundRepository.findByName(name)
                .map(CompoundMapper.MAPPER::entityToDomain)
                .orElseThrow(CompoundDoesNotExistException::new);
    }

    @Override
    public Compound findByNce(String nce) {
        return compoundRepository.findByNce(nce)
                .map(CompoundMapper.MAPPER::entityToDomain)
                .orElseThrow(CompoundDoesNotExistException::new);
    }

    @Override
    public Compound findByCas(String cas) {
        return compoundRepository.findByCas(cas)
                .map(CompoundMapper.MAPPER::entityToDomain)
                .orElseThrow(CompoundDoesNotExistException::new);
    }

}