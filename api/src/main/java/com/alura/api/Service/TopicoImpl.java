package com.alura.api.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.api.Entity.Topico;
import com.alura.api.Repository.TopicoRep;

@Service
public class TopicoImpl implements TopicoInt {

    @Autowired
    private TopicoRep topicoRepository;

    @Override
    public Topico registrar(Topico topicos) {
        List<Topico> topicoExistentes = topicoRepository.findAll();
        for (Topico topico : topicoExistentes) {
            if(topico.getTitulo().equals(topicos.getTitulo()) && topico.getMensaje().equals(topicos.getMensaje())){
                throw new IllegalArgumentException("El tópico ya está registrado");
            }
        }
        return topicoRepository.save(topicos);
    }

    @Override
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    @Override
    public Optional<Topico> buscarTopico(Long id) {
        return topicoRepository.findById(id);
    }

    @Override
    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }

    @Override
    public void actualizarTopico(Long id, Topico actualizacionTopico) {
        Optional<Topico> topico = buscarTopico(id);
        if (topico.isPresent()) {
            Topico topicoExiste = topico.get();
            topicoExiste.setTitulo(actualizacionTopico.getTitulo());
            topicoExiste.setMensaje(actualizacionTopico.getMensaje());
            topicoRepository.save(topicoExiste);
        }
    }

    
}
