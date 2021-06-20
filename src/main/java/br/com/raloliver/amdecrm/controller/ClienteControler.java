package br.com.raloliver.amdecrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.raloliver.amdecrm.model.Cliente;
import br.com.raloliver.amdecrm.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteControler {

    /**
     * @Autowired dá controle ao Spring sobre determinada propriedade da classe
     *            (Dependency Injection)
     */
    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Não é necessário passar nenhum argumento, pois ao acessar a rota será
     * retornada a lista com todos os clientes
     */
    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("cliente/listar.html");

        List<Cliente> clientes = clienteRepository.findAll();
        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }
}
