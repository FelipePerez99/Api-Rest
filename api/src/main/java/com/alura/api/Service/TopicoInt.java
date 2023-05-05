package com.alura.api.Service;

import java.util.List;
import java.util.Optional;

import com.alura.api.Entity.Topico;

public interface TopicoInt {
    
    public Topico registrar(Topico topicos);
    public List<Topico> listarTopicos();
    public Optional<Topico> buscarTopico(Long id);
    public void eliminarTopico(Long id);
    public void actualizarTopico(Long id, Topico actualizacionTopico);
}
