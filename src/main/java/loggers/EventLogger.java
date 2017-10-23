package loggers;

import event.Event;
import event.EventType;

public interface EventLogger {
    void logEvent(Event msg);
}
