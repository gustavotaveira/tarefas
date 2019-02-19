package br.com.home.controller;

import br.com.home.dao.UsuarioDao;
import br.com.home.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.POST)
    public String autentique(@Valid Usuario usuario, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return login();
        }
        if (new UsuarioDao().existeUsuario(usuario)) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:login/menu";
        }
        return "redirect:login";
    }

    @RequestMapping("/menu")
    public String menu() {
        return "tarefa/menu";
    }

    @RequestMapping
    public String login() {
        return "tarefa/login";
    }

    @RequestMapping("/cadastreUsuario")
    public String cadastreUsuario() {
        return "tarefa/cadastreUsuario";
    }


    @RequestMapping(value = "/cadastre", method = RequestMethod.POST)
    public String novo(Usuario usuario, Model model) {
        new UsuarioDao().cadastreNovo(usuario);
        model.addAttribute("sucesso", true);
        return login();
    }
}