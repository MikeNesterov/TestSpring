package loggers;

import event.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private int cachSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cachSize) {
        super(fileName);
        this.cachSize = cachSize;
        cache = new ArrayList<Event>();
    }

    @Override
    public void logEvent(Event msg) {
        cache.add(msg);

        if(cache.size() == cachSize){
            writeEventFromCahe();
            cache.clear();
        }
    }

    private void writeEventFromCahe() {
        for(Event event : cache){
            super.logEvent(event);
        }
    }

    public void destroy(){
        if(!cache.isEmpty()){
            writeEventFromCahe();
        }
    }
}
