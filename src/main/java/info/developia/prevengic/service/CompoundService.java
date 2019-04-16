package info.developia.prevengic.service;

import info.developia.prevengic.model.Compound;

import java.util.List;

public interface CompoundService {

    List<Compound> findAll();

    List<Compound> findByName(String name);

    List<Compound> findByNce(String nce);

    List<Compound> findByCas(String cas);

    List<Compound> findBy(String nce, String cas, String name);

    Compound findById(Long id);

}
