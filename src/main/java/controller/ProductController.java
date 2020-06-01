package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService = new ProductServiceImpl();
    @GetMapping("/")
    public ModelAndView index(){
        List productlist = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products",productlist);
        return modelAndView;
    }

    @GetMapping("/product/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/product/save")
    public String save (Product product, RedirectAttributes redirect){
        product.setId(productService.findAll().size()+1);
        productService.save(product);
        redirect.addFlashAttribute("success", "Thêm Thành Công");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect){
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success","Sửa thành Công");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Xáo Thành Công");
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public ModelAndView view(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }
}