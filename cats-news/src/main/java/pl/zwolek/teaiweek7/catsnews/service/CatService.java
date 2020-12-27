package pl.zwolek.teaiweek7.catsnews.service;

import pl.zwolek.teaiweek7.catsnews.dao.model.CatNews;

import java.util.List;

public interface CatService {

    List<CatNews> getCatNews();

    void updateCatNews(CatNews catNews);

    CatNews getCatNewsById(long id);

    void saveNewCatNews();

}
