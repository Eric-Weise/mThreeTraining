package corbos.crackcodeapi.models;

import corbos.crackcodeapi.data.GamesDatabaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class Games {
    private int gameId;
    // private String gamesResult;
    private static String answer = "";
    private boolean finished;
    //private ArrayList<Integer> numbers = new ArrayList<Integer>();

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

//    public String getGamesResult() {
//        return gamesResult;
//    }

//    public void setGamesResult(String gamesResult) {
//        this.gamesResult = gamesResult;
//    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean getFinished() {
        return finished;
    }

    public static String getAnswer() {
        return answer;
    }

    public void setAnswer() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        Random random = new Random();

        for(int i=0; i<4; i++)
        {
            int x = random.nextInt(numbers.size());
            answer = answer + numbers.get(x).toString();
            numbers.remove(x);
        }
        finished = false;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }
}
