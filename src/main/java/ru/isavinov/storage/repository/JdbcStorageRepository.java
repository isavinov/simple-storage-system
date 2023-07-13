package ru.isavinov.storage.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.isavinov.storage.model.Item;
import ru.isavinov.storage.model.Storage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Primary
public class JdbcStorageRepository implements StorageRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcStorageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Storage> getAllStorages() {
        Map<Long, Storage> storageMap = jdbcTemplate.query("SELECT * FROM storage s LEFT JOIN item i on s.id = i.storage_id", new StorageExtractor());
        return storageMap.values();
    }

    @Override
    public Storage getById(Long id) {
        Map<Long, Storage> storageMap = jdbcTemplate.query("SELECT * FROM storage s LEFT JOIN item i on s.id = i.storage_id WHERE s.id = ?", new StorageExtractor(), id);
        return storageMap.get(id);
    }

    @Override
    public void create(Storage storage) {
        jdbcTemplate.update("INSERT INTO storage(name, address, capacity) VALUES (?, ?, ?)", storage.getName(), storage.getAddress(), storage.getCapacity());
    }

    public static class StorageExtractor implements ResultSetExtractor<Map<Long, Storage>> {

        @Override
        public Map<Long, Storage> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, Storage> data = new LinkedHashMap<>();
            while (rs.next()) {
                Storage storage = new Storage();
                storage.setId(rs.getLong(1));
                storage.setName(rs.getString(2));
                storage.setAddress(rs.getString(3));
                storage.setCapacity(rs.getLong(4));
                data.putIfAbsent(storage.getId(), storage);

                Long itemId = rs.getLong(5);
                if (!rs.wasNull()){
                    Item item = new Item();
                    item.setId(itemId);
                    item.setName(rs.getString(6));
                    item.setCode(rs.getString(7));
                    item.setWeight(rs.getDouble(8));
                    item.setDueTo(rs.getDate(9));

                    data.get(storage.getId()).getItems().add(item);
                }


            }
            return data;
        }
    }
}
