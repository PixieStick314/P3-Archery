package P3.Archery.model.request;

public class RegisterReq {

    private String email;
    private String eventId;

    public RegisterReq(String email, String eventId) {
        this.email = email;
        this.eventId = eventId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

}
