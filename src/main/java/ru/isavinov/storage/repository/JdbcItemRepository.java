package ru.isavinov.storage.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.isavinov.storage.model.Item;

@Repository
public class JdbcItemRepository implements ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createItem(Long storageId, Item item) {
        jdbcTemplate.update("INSERT INTO item(name, code, weight, dueto, storage_id) values(?,?,?,?,?)"
                , item.getName(), item.getCode(), item.getWeight(), item.getDueTo(), storageId);
    }
}
