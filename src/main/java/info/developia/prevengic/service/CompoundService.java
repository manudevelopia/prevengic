package info.developia.prevengic.service;

import info.developia.prevengic.model.Compound;

import java.util.List;

public interface CompoundService {

    List<Compound> findAll();

    Compound findByName(String name);

    Compound findByNce(String nce);

    Compound findByCas(String cas);

}
