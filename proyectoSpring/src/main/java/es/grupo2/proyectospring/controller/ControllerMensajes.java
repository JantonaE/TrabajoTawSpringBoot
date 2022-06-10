package es.grupo2.proyectospring.controller;

import es.grupo2.proyectospring.entity.Mensaje;
import es.grupo2.proyectospring.entity.VistaMensaje;
import es.grupo2.proyectospring.repository.MensajeRepository;
import es.grupo2.proyectospring.repository.VistaMensajeRepository;
import es.grupo2.proyectospring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ControllerMensajes {
    private UsuarioService usuarioService;
    private VistaMensajeRepository vistaMensajeRepository;
    private MensajeRepository mensajeRepository;

    @Autowired
    public void setMensajeRepository(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @Autowired
    public void setVistaMensajeRepository(VistaMensajeRepository vistaMensajeRepository) {
        this.vistaMensajeRepository = vistaMensajeRepository;
    }

    @RequestMapping ("/bandeja/{id}")
    public String showBandeja(@PathVariable("id") int idUsuario, Model model){
        //UsuarioDTO usuarioDTO = this.usuarioService.buscarUsuario(idUsuario);
        List<Mensaje> vistaMensajeList = this.mensajeRepository.findByUsuarioId(idUsuario);
        model.addAttribute("mensajes",vistaMensajeList);
        return "BandejaMensajes";
    }

}
