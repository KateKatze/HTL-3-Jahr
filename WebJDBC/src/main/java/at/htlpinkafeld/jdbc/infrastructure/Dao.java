package at.htlpinkafeld.jdbc.infrastructure;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    List<T> list() throws SQLException;
}
