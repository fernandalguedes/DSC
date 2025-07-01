package cep.cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cep.cep.dto.Endereco;
import cep.cep.service.ViaCepService;

@Controller
@RequestMapping("/cep")
public class ViaCepController {

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping
    public String formBusca(Model model) {
        return "buscar-cep";
    }

    @PostMapping
    public String buscar(@RequestParam String cep, Model model) {
        Endereco endereco = viaCepService.buscarPorCep(cep);
        model.addAttribute("endereco", endereco);
        return "resultado-cep";
    }
}


