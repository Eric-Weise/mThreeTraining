package corbos.crackcodeapi.data;

import corbos.crackcodeapi.models.Games;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@Profile("database")
public class GamesDatabaseDao implements GamesDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GamesDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Games add(Games games) {
        return null;
    }

    @Override
    public List<Games> getAllGames() {
        final String sql = "SELECT gameId, answer, finished FROM games WHERE finished = false;";
        return jdbcTemplate.query(sql, new GamesDatabaseDao.GamesMapper());
    }

    @Override
    public Games findById(int id) {
        final String sql = "SELECT gameId, answer, finished"
                + " FROM games WHERE gameId = ?;";

        return jdbcTemplate.queryForObject(sql, new GamesDatabaseDao.GamesMapper(), id);
    }

    @Override
    public List<Games> update(int id) {
        final String sql = "UPDATE games SET finished = true WHERE gameId = ? ;";
        return jdbcTemplate.query(sql, new GamesDatabaseDao.GamesMapper());
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public Games newGame() {
        Games game = new Games();
        final String sql = "INSERT INTO games(answer, finished) VALUES (?, ?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        game.setAnswer();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, game.getAnswer());
            statement.setBoolean(2, game.getFinished());
            //statement.setInt(3, game.getGameId());
            return statement;

        }, keyHolder);

        game.setGameId(keyHolder.getKey().intValue());

        return game;

    }

    private static final class GamesMapper implements RowMapper<Games> {

        @Override
        public Games mapRow(ResultSet rs, int index) throws SQLException {
            Games cc = new Games();
            cc.setGameId(rs.getInt("gameId"));
            cc.setAnswer(rs.getString("answer"));
            cc.setFinished(rs.getBoolean("finished"));
            return cc;
        }
    }
}