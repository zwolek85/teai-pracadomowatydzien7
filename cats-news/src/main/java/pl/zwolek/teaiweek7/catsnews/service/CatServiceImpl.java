package pl.zwolek.teaiweek7.catsnews.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.zwolek.teaiweek7.catsnews.client.CatClient;
import pl.zwolek.teaiweek7.catsnews.client.dtos.AnimalFact;
import pl.zwolek.teaiweek7.catsnews.dao.CatNewsDao;
import pl.zwolek.teaiweek7.catsnews.dao.model.CatNews;

import java.util.List;

@Service
class CatServiceImpl implements CatService {

    private CatNewsDao catNewsDao;
    private CatClient catClient;

    public CatServiceImpl(CatNewsDao catNewsDao, CatClient catClient) {
        this.catNewsDao = catNewsDao;
        this.catClient = catClient;
    }

    @Override
    public List<CatNews> getCatNews() {
        return catNewsDao.getCatNews();
    }

    @Override
    public CatNews getCatNewsById(long id) {
        return catNewsDao.getCatNewsById(id);
    }

    @Override
    public void updateCatNews(CatNews catNews) {
        catNewsDao.updateCatNews(catNews);
    }


    @Override
    public void saveNewCatNews() {
        AnimalFact catFact = catClient.getCatFact();
        String news = catFact.getText();
        String image = catFact.getSrc();
        catNewsDao.saveCatNews(new CatNews(news, image));
    }

}
