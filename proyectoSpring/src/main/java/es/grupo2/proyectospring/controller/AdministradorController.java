package es.grupo2.proyectospring.controller;


import es.grupo2.proyectospring.dto.CategoriaDTO;
import es.grupo2.proyectospring.dto.ProductoDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;
import es.grupo2.proyectospring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
    private UsuarioService usuarioService;
    private ProductoService productoService;
    private CategoriaService categoriaService;
    private MarketingService marketingService;
    private AnalistaService analistaService;

    public UsuarioService getUsuarioService(){return usuarioService;}
    @Autowired
    public void setUsuarioService(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public ProductoService getProductoService(){return productoService;}
    @Autowired
    public void setProductoService(ProductoService productoService){
        this.productoService = productoService;
    }

    public CategoriaService getCategoriaService(){return categoriaService;}
    @Autowired
    public void setCategoriaService(CategoriaService categoriaService){
        this.categoriaService=categoriaService;
    }

    public MarketingService getMarketingService(){return marketingService;}
    @Autowired
    public void setMarketingService(MarketingService marketingService){
        this.marketingService=marketingService;
    }

    public AnalistaService getAnalistaService(){return analistaService;}
    @Autowired
    public void setAnalistaService(AnalistaService analistaService){
        this.analistaService = analistaService;
    }

    @GetMapping("")
    public String getInfo(Model model){
        List<UsuarioDTO> listaUs = this.usuarioService.listarListas();
        List<ProductoDTO> listaPr = this.productoService.listarProductos();
        List<CategoriaDTO> listaCa = this.categoriaService.listarCategorias();
        //List<UsuarioDTO> listaMa = this.marketingService.listarMarketing();
        //List<UsuarioDTO> listaAn = this.analistaService.listarAnalistas();
        model.addAttribute("productos",listaPr);
        model.addAttribute("usuarios",listaUs);
        model.addAttribute("categorias",listaCa);
        //model.addAttribute("marketing",listaMa);
        //model.addAttribute("analistas",listaAn);
        return "administrador";
    }

    @PostMapping("")
    public String getFiltros(Model model, @RequestParam("filtroUs") String filtroUs, @RequestParam("filtroCategoria") String filtroCa,
                             @RequestParam("filtroProducto") String filtroPr){
        List<UsuarioDTO> listaUs = this.usuarioService.findByNombre(filtroUs);
        List<ProductoDTO> listaPr = this.productoService.listarProductos(filtroPr);
        List<CategoriaDTO> listaCa = this.categoriaService.listarCategorias(filtroCa);
        List<UsuarioDTO> listaMa = this.marketingService.listarMarketing();
        List<UsuarioDTO> listaAn = this.analistaService.listarAnalistas();
        model.addAttribute("productos",listaPr);
        model.addAttribute("usuarios",listaUs);
        model.addAttribute("categorias",listaCa);
        model.addAttribute("marketing",listaMa);
        model.addAttribute("analistas",listaAn);
        return "administrador";
    }
}
