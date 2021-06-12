package br.com.raloliver.amdecrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    // @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String home() {
        return "home";
    }

    /**
     * Para passar dados da controler para view, podemos utilizar a interface model
     * e a classe model mapping Model X ModelMap: Model é a interface, e o ModelMap
     * é a implementação da interface Model.
     */
    @GetMapping("/mensagem")
    public String mensagem(ModelMap modelMap) {
        modelMap.addAttribute("mensagem", "Carregando...");
        return "mensagem";
    }

}
