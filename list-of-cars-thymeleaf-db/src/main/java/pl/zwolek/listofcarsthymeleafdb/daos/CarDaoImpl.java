package pl.zwolek.listofcarsthymeleafdb.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.zwolek.listofcarsthymeleafdb.enums.Color;
import pl.zwolek.listofcarsthymeleafdb.models.Car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
class CarDaoImpl implements CarDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    CarDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void addCar(Car car) {
        long maxId = getMaxIdOfCars() + 1;
        String sql = "INSERT INTO cars VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, maxId, car.getModel(), car.getMark(), car.getColor().name(), car.getProductionDate());
    }

    @Override
    public List<Car> getCars() {
        List<Car> resultList = new ArrayList<>();
        String sql = "SELECT  * FROM cars";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> element : maps) {
            resultList.add(
                    new Car(Long.parseLong(String.valueOf(element.get("id"))),
                            String.valueOf(element.get("model")),
                            String.valueOf(element.get("mark")),
                            Color.valueOf(String.valueOf(element.get("color"))),
                            (Date) element.get("production_date"))

            );
        }
        return resultList;
    }

    @Override
    public List<Car> getCarsByProductionDateRange(Date from, Date to) {
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource("from", from);
        sqlParameterSource.addValue("to", to);
        List<Car> resultList = new ArrayList<>();
        String sql = "SELECT  * FROM cars WHERE production_date BETWEEN :from AND :to";
        resultList = namedParameterJdbcTemplate.query(sql,
                sqlParameterSource,
                (rs, rowNum) -> new Car(rs.getLong("id"),
                        rs.getString("model"),
                        rs.getString("mark"),
                        Color.valueOf(rs.getString("color")),
                        rs.getDate("production_date"))
        );

        return resultList;
    }

    long getMaxIdOfCars() {
        String sql = "SELECT MAX(id) FROM cars";
        Long numberOfCars = jdbcTemplate.queryForObject(sql, Long.class);
        return numberOfCars == null ? 0 : numberOfCars;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createTableCars() {
        String sql = "CREATE TABLE IF NOT EXISTS cars(id int, model varchar(255), mark varchar(255), color varchar(255),production_date DATE ,PRIMARY KEY (id))";
        jdbcTemplate.update(sql);
    }
}
