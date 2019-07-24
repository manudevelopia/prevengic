package info.developia.prevengic.service;

import info.developia.prevengic.dto.CompoundDto;
import info.developia.prevengic.model.Compound;

import java.util.List;

public interface CompoundService {

    List<Compound> findAll();

    List<CompoundDto> findBy(String nce, String ncas, String name);

    Compound create(Compound compound);

}
