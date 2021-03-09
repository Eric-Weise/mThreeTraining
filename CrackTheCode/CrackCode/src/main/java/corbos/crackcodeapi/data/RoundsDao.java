package corbos.crackcodeapi.data;

import corbos.crackcodeapi.models.Rounds;
import java.util.List;

public interface RoundsDao {

    Rounds add(Rounds rounds, GamesDao gDao);

    List<Rounds> getAll();

    Rounds findRById(int id);

}