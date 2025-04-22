package com.example.projetobd.controller;

import com.example.projetobd.dao.produtoDao;
import com.example.projetobd.model.produtoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoPageController {

    @Autowired
    private produtoDao pDao;

    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", pDao.getAll());
        model.addAttribute("produto", new produtoModel());
        return "produtos";
    }

    @PostMapping("/add")
    public String inserirProduto(@ModelAttribute produtoModel produto) {
        pDao.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/delete/{cod}")
    public String deletarProduto(@PathVariable int cod) {
        pDao.delete(cod);
        return "redirect:/produtos";
    }
}
