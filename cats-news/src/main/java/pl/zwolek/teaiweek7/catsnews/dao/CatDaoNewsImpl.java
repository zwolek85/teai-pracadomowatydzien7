package pl.zwolek.teaiweek7.catsnews.dao;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.zwolek.teaiweek7.catsnews.dao.model.CatNews;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
class CatDaoNewsImpl implements CatNewsDao {

    private JdbcTemplate jdbcTemplate;

    public CatDaoNewsImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveCatNews(CatNews newCatNews) {
        long maxId = getMaxIdOfCat() + 1;
        String sql = "INSERT INTO cat_news VALUES (?,?,?)";
        jdbcTemplate.update(sql, maxId, newCatNews.getNews(), newCatNews.getImageSrc());
    }

    @Override
    public void updateCatNews(CatNews catNews) {
        jdbcTemplate.update("UPDATE cat_news SET news=? , image_src=? WHERE id=?", catNews.getNews(), catNews.getImageSrc(), catNews.getId());
    }

    @Override
    public List<CatNews> getCatNews() {
        List<CatNews> resultList = new ArrayList<>();
        String sql = "SELECT * FROM cat_news";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> element : maps) {
            resultList.add(
                    new CatNews(Long.parseLong(String.valueOf(element.get("id"))),
                            String.valueOf(element.get("news")),
                            String.valueOf(element.get("image_src")))

            );
        }

        return resultList;
    }

    @Override
    public CatNews getCatNewsById(long id) {
        String sql = "SELECT * FROM cat_news WHERE id=?";
        return jdbcTemplate.queryForObject(sql,
                ( rs,rowNum) -> new CatNews(rs.getLong("id"), rs.getString("news"),rs.getString("image_src")),
                        id);

    }

    private long getMaxIdOfCat() {
        String sql = "SELECT MAX(id) FROM cat_news";
        Long numberOfCars = jdbcTemplate.queryForObject(sql, Long.class);
        return numberOfCars == null ? 0 : numberOfCars;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createTableCars() {
        String sql = "CREATE TABLE IF NOT EXISTS cat_news(id int, news varchar(255), image_src varchar(255) ,PRIMARY KEY (id))";
        jdbcTemplate.update(sql);
    }
}
