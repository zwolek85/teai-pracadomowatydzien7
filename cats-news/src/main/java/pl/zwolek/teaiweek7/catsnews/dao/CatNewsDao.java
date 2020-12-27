package pl.zwolek.teaiweek7.catsnews.dao;

import pl.zwolek.teaiweek7.catsnews.dao.model.CatNews;

import java.util.List;

public interface CatNewsDao {

    void saveCatNews(CatNews newCatNews);

    void updateCatNews(CatNews catNews);

    List<CatNews> getCatNews();

    CatNews getCatNewsById(long id);
}
