package rest.controllers;

import org.chiclepad.backend.Dao.DaoFactory;
import org.chiclepad.backend.Dao.DiaryPageDao;
import org.chiclepad.backend.entity.DiaryPage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiaryPageController {

    private DiaryPageDao diaryPageDao = DaoFactory.INSTANCE.getDiaryPageDao();

    @RequestMapping("/loggedInUserId/{userId}/diaryPages")
    public List<DiaryPage> getAllDiaryPagesByUserId(@PathVariable int userId) {
        return diaryPageDao.getAll(userId);
    }

    @RequestMapping("/loggedInUserId/{userId}/diaryPages/{id}")
    public DiaryPage getDiaryPageById(@PathVariable int id) {
        return diaryPageDao.get(id);
    }
}
