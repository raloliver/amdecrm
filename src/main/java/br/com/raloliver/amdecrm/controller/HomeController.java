package br.com.raloliver.amdecrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    // @GetMapping("/mensagem")
    // public String mensagem(ModelMap modelMap) {
    // modelMap.addAttribute("mensagem", "Carregando...");
    // return "mensagem";
    // }

    /**
     * ModelAndView: além do Model, informa-se a View que será utilizada. Bom pelo
     * fato de diminuir a quantidade de parametros recebidos pelo método.
     */
    @GetMapping("/mensagem")
    public ModelAndView mensagem() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("mensagem");
        modelAndView.addObject("mensagem", "Carregando...");

        return modelAndView;
    }

    /**
     * PathVariable: exibe dados a partir de um caminho na url
     * (@GetMapping("/saudacao/{nome}") | @PathVariable String nome). RequestParam:
     * exibe dados a partir de um query na url
     */
    @GetMapping("/saudacao")
    public ModelAndView saudacao(@RequestParam(required = false, defaultValue = "João") String nome) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("saudacao");
        modelAndView.addObject("nome", nome);

        return modelAndView;
    }

}
