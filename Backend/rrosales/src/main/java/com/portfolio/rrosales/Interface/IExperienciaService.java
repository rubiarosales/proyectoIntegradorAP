package com.portfolio.rrosales.Interface;

import com.portfolio.rrosales.Entity.Experiencia;
import java.util.List;

public interface IExperienciaService {

    public List<Experiencia> getExperiencia();

    public void saveExperiencia(Experiencia experiencia);

    public void deleteExperiencia(long id);

    public Experiencia findExperiencia(long id);
}
