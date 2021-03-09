package corbos.crackcodeapi.data;

import corbos.crackcodeapi.models.Games;

import java.util.List;

public interface GamesDao {
    Games add(Games games);

    List<Games> getAllGames();

    Games findById(int id);

    // true if item exists and is updated
    List<Games> update(int id);

    // true if item exists and is deleted
    boolean deleteById(int id);

    Games newGame();
}
