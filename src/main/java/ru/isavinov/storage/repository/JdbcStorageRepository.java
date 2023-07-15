package ru.isavinov.storage.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.isavinov.storage.model.Item;
import ru.isavinov.storage.model.Storage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Primary
public class JdbcStorageRepository implements StorageRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcStorageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Storage> getAllStorages() {
        return jdbcTemplate.query("select * from storage left join item on storage.id = item.storage_id", new StorageExtractor()).values();
    }

    @Override
    public Storage getById(Long id) {
        return jdbcTemplate.query("select * from storage left join item on storage.id = item.storage_id where storage.id=?", new StorageExtractor(), id).get(id);

    }

    @Override
    public void create(Storage storage) {
        jdbcTemplate.update("insert into storage(name, address, capacity) values (?, ?, ?)", storage.getName(), storage.getAddress(), storage.getCapacity());

    }

    public static class StorageExtractor implements ResultSetExtractor<Map<Long, Storage>>{

        @Override
        public Map<Long, Storage> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, Storage> result = new LinkedHashMap<>();

            while (rs.next()){
                Long storageId = rs.getLong(1);
                String storageName = rs.getString(2);
                String storageAddress = rs.getString(3);
                Long storageCapacity = rs.getLong(4);

                Storage storage = new Storage(storageId, storageName, storageAddress, storageCapacity);

                result.putIfAbsent(storageId, storage);

                Long itemId = rs.getLong(5);

                if (!rs.wasNull()){
                    String itemName = rs.getString(6);
                    String itemCode = rs.getString(7);
                    Double itemWeight = rs.getDouble(8);
                    Date itemDueTo = rs.getDate(9);

                    Item item = new Item(itemId, itemName, itemCode, itemWeight, itemDueTo);

                    result.get(storageId).addItem(item);
                }


            }

            return result;
        }
    }
}
