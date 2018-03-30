package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.dao.PaintingRepository;
import ua.com.owu.entity.Painting;
import ua.com.owu.sevice.PaintingService;

import java.util.Arrays;

/**
 * Created by дмитро on 29.03.2018.
 */
@Controller
public class MainController {
    @Autowired
    private PaintingService paintingService;

    @RequestMapping(value = "/")
    public String home(){
        return "index";
    }
    @RequestMapping(value = "/painting", method = RequestMethod.GET)
    public String listPaintings(Model model){
        model.addAttribute("painting",new Painting());
        model.addAttribute("listPaintings",this.paintingService.listPaintings());
        return "paintings";
    }
    @RequestMapping(value = "/paintings/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("painting") Painting painting){
        if(painting.getId() == 0){
            this.paintingService.addPainting(painting);
        }else {
            this.paintingService.updatePainting(painting);
        }

        return "redirect:/painting";
    }

    @RequestMapping("/remove/{id}")
    public String removePainting(@PathVariable("id") int id){
        this.paintingService.removePainting(id);

        return "redirect:/painting";
    }

    @RequestMapping("edit/{id}")
    public String editPainting(@PathVariable("id") int id, Model model){
        model.addAttribute("painting", this.paintingService.getPaintingById(id));
        model.addAttribute("listPaintings", this.paintingService.listPaintings());

        return "paintings";
    }

    @RequestMapping("paintingsdata/{id}")
    public String paintingData(@PathVariable("id") int id, Model model){
        model.addAttribute("painting", this.paintingService.getPaintingById(id));

        return "paintingsdata";
    }


}
