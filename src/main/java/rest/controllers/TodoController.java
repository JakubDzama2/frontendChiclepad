package rest.controllers;

import org.chiclepad.backend.Dao.DaoFactory;
import org.chiclepad.backend.Dao.TodoDao;
import org.chiclepad.backend.entity.Todo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private TodoDao todoDao = DaoFactory.INSTANCE.getTodoDao();

    @RequestMapping("/loggedInUserId/{userId}/todos")
    public List<Todo> getAllTodosByUserId(@PathVariable int userId) {
        return todoDao.getAll(userId);
    }

    @RequestMapping("/loggedInUserId/{userId}/todos/{id}")
    public Todo getTodoById(@PathVariable int id) {
        return todoDao.get(id);
    }
}
