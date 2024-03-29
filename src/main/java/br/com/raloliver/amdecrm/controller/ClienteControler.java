package br.com.raloliver.amdecrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        ModelAndView modelAndView = new ModelAndView("cliente/listar");

        List<Cliente> clientes = clienteRepository.findAll();
        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("cliente/detalhar");

        Cliente cliente = clienteRepository.getOne(id);
        modelAndView.addObject("cliente", cliente);

        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        // #TODO: adicionar página para confirmar exclusão. No cenário atual, o cliente
        // é excluído sem confirmar e após isso é redirecionado pra lista
        ModelAndView modelAndView = new ModelAndView("redirect:/clientes");

        clienteRepository.deleteById(id);

        return modelAndView;
    }

    /**
     * Action responsável apenas por exibir a página que vai cadastrar
     */
    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("cliente/cadastrar");

        modelAndView.addObject("cliente", new Cliente());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(Cliente cliente) {
        ModelAndView modelAndView = new ModelAndView("redirect:/clientes");

        clienteRepository.save(cliente);

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("cliente/editar");

        Cliente cliente = clienteRepository.getOne(id);
        modelAndView.addObject("cliente", cliente);

        return modelAndView;
    }

    /**
     * O SB sabe a diferença ao criar ou editar (PostMapping) quando existe o ID
     */
    @PostMapping("/{id}/editar")
    public ModelAndView editar(Cliente cliente) {
        ModelAndView modelAndView = new ModelAndView("redirect:/clientes");

        clienteRepository.save(cliente);

        return modelAndView;
    }
}
