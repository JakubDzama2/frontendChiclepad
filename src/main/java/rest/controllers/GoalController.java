package rest.controllers;

import org.chiclepad.backend.Dao.DaoFactory;
import org.chiclepad.backend.Dao.GoalDao;
import org.chiclepad.backend.entity.Goal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoalController {

    private GoalDao goalDao = DaoFactory.INSTANCE.getGoalDao();

    @RequestMapping("/loggedInUserId/{userId}/goals")
    public List<Goal> getAllGoalsByUserId(@PathVariable int userId) {
        return goalDao.getAll(userId);
    }

    @RequestMapping("/loggedInUserId/{userId}/goals/{id}")
    public Goal getGoalById(@PathVariable int id) {
        return goalDao.get(id);
    }
}
