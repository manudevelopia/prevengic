package info.developia.prevengic.service;

import info.developia.prevengic.exception.CompoundDoesNotExistException;
import info.developia.prevengic.mapper.CompoundMapper;
import info.developia.prevengic.model.Compound;
import info.developia.prevengic.repository.CompoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class CompoundServiceImpl implements CompoundService {

    private final CompoundRepository compoundRepository;

    @Autowired
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

    @Override
    public List<Compound> findBy(String nce, String cas, String name) {
        info.developia.prevengic.dao.Compound compoundExample = info.developia.prevengic.dao.Compound.builder()
                .cas(cas)
                .nce(nce)
                .name(name)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("nce", contains())
                .withMatcher("cas", contains())
                .withMatcher("name", contains())
                .withIgnoreCase();

        Example<info.developia.prevengic.dao.Compound> example = Example.of(compoundExample, matcher);

        return compoundRepository.findAll(example).stream()
                .map(CompoundMapper.MAPPER::entityToDomain)
                .collect(Collectors.toList());
    }

}