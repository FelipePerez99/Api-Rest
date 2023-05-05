package com.alura.api.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alura.api.Entity.Topico;
import com.alura.api.Service.TopicoInt;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/topicos")
public class TopicoController {
    
    @Autowired
    private TopicoInt topicoInt;

    @PostMapping("/registrar")
    @ResponseBody
    public Topico registrarTopicos(@RequestBody Topico topicos){
        return topicoInt.registrar(topicos);
    }

    @GetMapping("/listar") 
    @ResponseBody
    public List<Topico> listarTopicos(){
        return topicoInt.listarTopicos();
    }

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Optional<Topico> busquedaTopico(@PathVariable Long id){
        return topicoInt.buscarTopico(id);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public void eliminarTopico(@PathVariable Long id){
        topicoInt.eliminarTopico(id);
    }

    @PutMapping("/actualizar/{id}")
    @Transactional
    @ResponseBody
    public void actualizarTop(@PathVariable Long id, @RequestBody Topico topicos){
        topicoInt.actualizarTopico(id, topicos);
    }
}
