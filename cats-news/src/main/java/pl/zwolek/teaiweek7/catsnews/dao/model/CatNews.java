package pl.zwolek.teaiweek7.catsnews.dao.model;

import java.util.Objects;

public class CatNews {

    public long id;
    public String news;
    public String imageSrc;

    public CatNews(){}

    public CatNews(long id, String news, String imageSrc) {
        this.id = id;
        this.news = news;
        this.imageSrc = imageSrc;
    }

    public CatNews(String news, String imageSrc) {
        this.news = news;
        this.imageSrc = imageSrc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatNews catNews = (CatNews) o;
        return id == catNews.id
                && Objects.equals(news, catNews.news)
                && Objects.equals(imageSrc, catNews.imageSrc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                news,
                imageSrc);
    }

    @Override
    public String toString() {
        return "CatNews{" +
                "id=" + id +
                ", news='" + news + '\'' +
                ", imageSrc='" + imageSrc + '\'' +
                '}';
    }
}
