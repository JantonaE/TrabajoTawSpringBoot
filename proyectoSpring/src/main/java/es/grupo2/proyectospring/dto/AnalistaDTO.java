/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.grupo2.proyectospring.dto;

import es.grupo2.proyectospring.entity.Analisis;

import java.util.List;

/**
 *
 * @author ruben
 */
public class AnalistaDTO {
    private Long usuarioId;
    private UsuarioDTO usuario;
    private List<Analisis> analisisList;
    
    public AnalistaDTO() {
    }

    public AnalistaDTO(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public List<Analisis> getAnalisisList(){ return this.analisisList;}

    public void setAnalisisList(List<Analisis> analisisList) {this.analisisList = analisisList;}
}
