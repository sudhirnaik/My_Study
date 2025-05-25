package practice;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Event {
    private Integer Id;
    private User host;
    private Group group;
    private List<User> attendees;
    private String info;
    private Date date;
    private TimeSlot timeSlot;
    private String location;

}
