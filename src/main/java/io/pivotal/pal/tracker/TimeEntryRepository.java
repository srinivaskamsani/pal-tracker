package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.util.List;

public interface TimeEntryRepository {

    TimeEntry create(TimeEntry any);
    TimeEntry update(long eq, TimeEntry any);
    void delete(long l);
    List<TimeEntry> list();
    TimeEntry find(long l);

}
