package corbos.crackcodeapi.controllers;

import corbos.crackcodeapi.data.GamesDao;
import corbos.crackcodeapi.data.RoundsDao;
import corbos.crackcodeapi.models.Games;
import corbos.crackcodeapi.models.Rounds;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crackCode")
public class CrackCodeController {

    private final RoundsDao dao;
    private final GamesDao gDao;

    public CrackCodeController(RoundsDao dao, GamesDao gDao) {
        this.dao = dao;
        this.gDao = gDao;
    }

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public Games create() {
        return gDao.newGame();
    }

    @GetMapping("/rounds/{id}")
    public ResponseEntity<Rounds> findRById(@PathVariable int id) {
        Rounds result = dao.findRById(id);
        if (result == null) {
            return (ResponseEntity<Rounds>) new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/rounds")
    public List<Rounds> all() {
        return dao.getAll();
    }


    @PostMapping("/guess")
    @ResponseStatus(HttpStatus.CREATED)
    public Rounds create(@RequestBody Rounds rounds) {

        return dao.add(rounds, gDao);
    }


    @GetMapping("/game")
    public List<Games> allGames() {return gDao.getAllGames(); }

    @GetMapping("/game/{id}")
    public ResponseEntity<Games> findById(@PathVariable int id) {
        Games result = gDao.findById(id);
        if (result == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

}