package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry newTimeEntry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(newTimeEntry, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> newTimeEntry = timeEntryRepository.list();

        return new ResponseEntity<>(newTimeEntry, HttpStatus.OK);

    }

    @PutMapping("{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable long id, @RequestBody TimeEntry expected) {
        TimeEntry newTimeEntry = timeEntryRepository.update(id, expected);
        if(newTimeEntry!= null){
        return new ResponseEntity<>(newTimeEntry, HttpStatus.OK);}
        else {
            return new ResponseEntity<>(newTimeEntry,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id) {
        timeEntryRepository.delete(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {

        TimeEntry newTimeEntry = timeEntryRepository.find(id);
        if(newTimeEntry != null){
            return new ResponseEntity<>(newTimeEntry, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(newTimeEntry, HttpStatus.NOT_FOUND);
        }


    }
}
