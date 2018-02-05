package rest.controllers;

import org.chiclepad.backend.Dao.DaoFactory;
import org.chiclepad.backend.Dao.NoteDao;
import org.chiclepad.backend.entity.Note;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/loggedInUserId/{userId}/notes")
    public List<Note> getAllNotesByUserId(@PathVariable int userId) {
        return noteDao.getAll(userId);
    }

    @RequestMapping("/loggedInUserId/{userId}/notes/{id}")
    public Note getNoteById(@PathVariable int id) {
        return noteDao.get(id);
    }

    @RequestMapping(value = "/loggedInUserId/{userId}/notes", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createNote(@PathVariable int userId, @RequestBody Note note) {
        if (note.getReminderTime() == null) {
            noteDao.create(userId, note.getContent());
        } else {
            noteDao.create(userId, note.getContent(), note.getReminderTime().get());
        }
    }
}