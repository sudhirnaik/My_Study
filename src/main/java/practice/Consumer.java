package practice;

import java.util.List;


public class Consumer {

        private Integer id;
        private List<String> phoneNumber;

    public Consumer() {
    }

    public Consumer(Integer id, List<String> phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
