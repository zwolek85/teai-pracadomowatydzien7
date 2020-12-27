package pl.zwolek.teaiweek7.catsnews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zwolek.teaiweek7.catsnews.dao.model.CatNews;
import pl.zwolek.teaiweek7.catsnews.service.CatService;

import java.util.List;

@Controller
@RequestMapping(path = {"/", "cat-news"})
class CatNewsController {

    private CatService catService;

    public CatNewsController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    String getCatNews(Model model) {
        List<CatNews> catNewsList = catService.getCatNews();
        model.addAttribute("catNewsList", catNewsList);
        return "cat-news";

    }

    @GetMapping("update-cat-news/{id}")
    String getUpdateCatNews(@PathVariable long id, Model model) {
        CatNews catNews = catService.getCatNewsById(id);
        model.addAttribute("catNews", catNews);
        return "edit-cat-news";

    }

    @PostMapping("update-cat-news/{id}")
    String postUpdateCatNews(@PathVariable long id, @ModelAttribute CatNews catNews) {
        catNews.setId(id);
        catService.updateCatNews(catNews);
        return "redirect:/cat-news";

    }

    @GetMapping("get-new-cat-news")
    String getNewCatNews() {
        catService.saveNewCatNews();
        return "redirect:/cat-news";

    }


}
