package info.developia.prevengic.service;

import info.developia.prevengic.dao.CompoundDao;
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
    public List<Compound> findBy(String nce, String cas, String name) {
        CompoundDao compoundExample = CompoundDao.builder()
                .ncas(cas)
                .nce(nce)
                .name(name)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withMatcher("nce", contains())
                .withMatcher("ncas", contains())
                .withMatcher("name", contains())
                .withIgnoreCase();

        Example<CompoundDao> example = Example.of(compoundExample, matcher);

        return compoundRepository.findAll(example).stream()
                .map(CompoundMapper.MAPPER::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Compound create(Compound compound) {
        CompoundDao compoundEntity = CompoundMapper.MAPPER.domainToEntity(compound);

        CompoundDao result = compoundRepository.save(compoundEntity);

        return CompoundMapper.MAPPER.entityToDomain(result);
    }

}