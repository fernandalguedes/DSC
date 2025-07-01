package json.json.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import json.json.service.JsonPlaceService;

@Controller
@RequestMapping("/posts")
public class JsonPlaceController {

    @Autowired
    private JsonPlaceService jsonPlaceService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("posts", jsonPlaceService.listarPosts());
        return "posts";
    }

    @GetMapping("/{id}")
    public String detalhe(@PathVariable Long id, Model model) {
        model.addAttribute("post", jsonPlaceService.buscarPorID(id));
        return "post-detalhe";
    }
}

