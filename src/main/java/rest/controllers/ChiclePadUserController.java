package rest.controllers;

import org.chiclepad.backend.Dao.ChiclePadUserDao;
import org.chiclepad.backend.Dao.DaoFactory;
import org.chiclepad.backend.entity.ChiclePadUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChiclePadUserController {

    private ChiclePadUserDao chiclePadUserDao = DaoFactory.INSTANCE.getChiclePadUserDao();

    @RequestMapping("/users/{id}")
    public ChiclePadUser getUserById(@PathVariable int id) {
        return chiclePadUserDao.get(id);
    }

    @RequestMapping("/loggedInUser")
    public ChiclePadUser getLoggedIndUser() {
        return null;
    }
}
