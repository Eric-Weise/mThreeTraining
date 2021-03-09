package corbos.crackcodeapi.data;

import corbos.crackcodeapi.models.Games;
import corbos.crackcodeapi.models.Rounds;
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
public class RoundsDatabaseDao implements RoundsDao {

    private final JdbcTemplate jdbcTemplate;
    private final JdbcTemplate GjdbcTemplate;

    @Autowired
    public RoundsDatabaseDao(JdbcTemplate jdbcTemplate, JdbcTemplate gjdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        GjdbcTemplate = gjdbcTemplate;
    }

    @Override
    public Rounds add(Rounds rounds, GamesDao gDao) {

        Games game = gDao.findById(rounds.getGameId());
        //Games currentGame = gDao.update(game.);
        String answer = game.getAnswer();
        boolean e = false;
        boolean p = false;
        boolean miss = false;
        final String sql = "INSERT INTO rounds(gameId, guess, result, time) VALUES (?, ?, ?, ?);";
        final String eSql = "UPDATE games SET finished = true WHERE gameId = ? ;";

        String guessed = rounds.getGuess(); //.toString();
        if (rounds.getGuess().equals(answer))//e
        {
            rounds.setResult("e");
            game.setFinished(true);

            final String sql2 = "UPDATE games SET finished = true WHERE gameId = ? ;";
            jdbcTemplate.update(sql2, game.getGameId());
        }
        else if (guessed.charAt(0) == answer.charAt(0) || guessed.charAt(1) == answer.charAt(1) || guessed.charAt(2) == answer.charAt(2) || guessed.charAt(3) == answer.charAt(3))//p
        {
            rounds.setResult("p");
        }

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();


        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, rounds.getGameId());
            statement.setString(2, rounds.getGuess());
            statement.setString(3, rounds.getResult());
            statement.setTimestamp(4, rounds.getTiming());
            return statement;

        }, keyHolder);

        rounds.setId(keyHolder.getKey().intValue());

        return rounds;
    }

    @Override
    public List<Rounds> getAll() {
        final String sql = "SELECT roundId, guess, result, gameId FROM rounds;";
        return jdbcTemplate.query(sql, new RoundsMapper());
    }

    @Override
    public Rounds findRById(int id) {

        final String sql = "SELECT roundId, guess, result, time, gameId "
                + "FROM rounds WHERE roundId = ? ORDER BY time ASC;";

        return jdbcTemplate.queryForObject(sql, new RoundsMapper(), id);
    }

    private static final class RoundsMapper implements RowMapper<Rounds> {

        @Override
        public Rounds mapRow(ResultSet rs, int index) throws SQLException {
            Rounds cc = new Rounds();
            cc.setId(rs.getInt("roundId"));
            cc.setResult(rs.getString("guess"));
            cc.setGuess(rs.getString("result"));
            cc.setTiming(rs.getTimestamp("time"));
            cc.setFinished(rs.getBoolean("gameId"));
            return cc;
        }
    }
}