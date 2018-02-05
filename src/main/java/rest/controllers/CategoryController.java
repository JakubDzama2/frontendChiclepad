package rest.controllers;

import org.chiclepad.backend.Dao.CategoryDao;
import org.chiclepad.backend.Dao.DaoFactory;
import org.chiclepad.backend.entity.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryDao categoryDao = DaoFactory.INSTANCE.getCategoryDao();

    @RequestMapping("/loggedInUserId/{userId}/categories")
    public List<Category> getAllCategoriesByUserId(@PathVariable int userId) {
        return categoryDao.getAll(userId);
    }

    @RequestMapping("/loggedInUserId/{userId}/categories/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryDao.get(id);
    }
}
