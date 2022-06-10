package es.grupo2.proyectospring.service;


import es.grupo2.proyectospring.dto.AnalistaDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;
import es.grupo2.proyectospring.entity.Analista;
import es.grupo2.proyectospring.repository.AnalistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalistaService {
    private AnalistaRepository analistaRepository;
    private UsuarioService usuarioService;

    @Autowired
    public void setAnalistaRepository(AnalistaRepository analistaRepository){
        this.analistaRepository = analistaRepository;
    }

    public List<UsuarioDTO> listarAnalistas () {
        List<Analista> clientes = analistaRepository.findAll();
        List<UsuarioDTO> us = new ArrayList<>();
        for(Analista an : clientes){
            UsuarioDTO u = usuarioService.buscarUsuario(an.getUsuarioId());
            us.add(u);}
        return us;
    }

    public List<UsuarioDTO> listarNOAnalistas(){
        List<UsuarioDTO> usuarios = usuarioService.listarListas();
        List<UsuarioDTO> analistas = this.listarAnalistas();
        List<UsuarioDTO> aux = new ArrayList<>();
        for(UsuarioDTO us : usuarios){
            boolean encontrado = false;
            for(UsuarioDTO an : analistas){
                if(an.getId() == us.getId()){
                    encontrado = true;
                }
            }
            if(!encontrado){
                aux.add(us);
            }
        }
        return aux;
    }

    public AnalistaDTO buscarAnalista (int id) {
        Analista m = this.analistaRepository.findById(id).orElse(null);
        return m.toDTO();
    }

    public void borrarAnalista (int id) {
        Analista m= this.analistaRepository.findById(id).orElse(null);
        this.analistaRepository.delete(m);
    }

    //TODO
}
