package rest.controllers;

import org.chiclepad.backend.Dao.DaoFactory;
import org.chiclepad.backend.Dao.NoteDao;
import org.chiclepad.backend.entity.Note;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import rest.exceptions.NoteNotFoundException;

@RestController
public class NoteController {

    private NoteDao noteDao = DaoFactory.INSTANCE.getNoteDao();
/*
    @RequestMapping("/notes/userId/{id}")
    public List<Note> getAllNotesByUserId(@PathVariable int id) {
        List<Note> notes = null;
        try {
            notes = noteDao.getAll(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoteNotFoundException();
        }
        return notes;
    }

        @RequestMapping("/notes/{id}")
        public Note getNoteById(@PathVariable int id) throws NoteNotFoundException {
            Note note = null;
            try {
                note = noteDao.get(id);
            } catch (EmptyResultDataAccessException erdae) {
                throw new NoteNotFoundException();
            }
            return note;
        }
    */

    @RequestMapping("/notes/userId/{id}")
    public List<Note> getAllNotesByUserId(@PathVariable int userId) {
        return noteDao.getAll(userId);
    }

    @RequestMapping("/notes/{id}")
    public Note getNoteById(@PathVariable int id) {
        return noteDao.get(id);
    }
}