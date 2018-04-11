package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    HashMap<Long,TimeEntry> hm = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry any) {

        int size = hm.size();
        Long counter = size + 1L;
        any.setId(counter);
        hm.put(counter,any);
        return any;
    }

    @Override
    public TimeEntry update(long eq, TimeEntry any) {
        if(hm.get(eq)!= null) {
            any.setId(eq);
            hm.put(eq,any);
            return any;
        }else {
            return null;
        }

    }

    @Override
    public void delete(long l) {
        hm.remove(l);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(hm.values());
    }

    @Override
    public TimeEntry find(long l) {
        TimeEntry foundTimeEntry = hm.get(l);
        return foundTimeEntry;
    }
}
