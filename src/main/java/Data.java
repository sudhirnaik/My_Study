

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.ExecutorService;


public class Data {

    private Integer value;
    private Timestamp updateTime;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}

/*class Test{
    public static void main(String[] args) {
        MyCollection collection = new MyCollection();
        Data d1 = new Data();
        d1.setValue(1);
        collection.addData(d1);
        new ExecutorService.Scheduled(delay, )
                service.submit(() -> collection.removeExpired());
    }
}*/


/*class MyCollection{
    private List<Data> list;
    private final Integer expTime = 60;
    public Data addData(Data data) {
        data.setUpdateTime(now);
        list.add(data);
        return data;
    }

    public Data getData(Data data) {
        if (list.contains(data)){
            for(Data dataFromList: list){
                if (dataFromList.getValue().equals(data.getValue())){
                    data.setUpdateTime(now);
                    return data;
                }
            }

        }
        return null;

    }

    public void removeExpired() {
            for(int i = 0; i< list.size(); i++){
                if (now - list.get(i).getUpdateTime() > expTime*1000){
                    list.remove(i);
                }
            }
    }


}*/
