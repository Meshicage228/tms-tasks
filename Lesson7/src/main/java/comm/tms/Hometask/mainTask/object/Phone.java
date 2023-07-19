package comm.tms.Hometask.mainTask.object;

import comm.tms.Hometask.mainTask.service.ModelPhone;

public class Phone {
    private String number;
    private ModelPhone model;
    private float weight;

    public Phone() {
    }
    public Phone(String number, ModelPhone model, float weight) {
        this(number, model);
        this.weight = weight;
    }

    public Phone(String number, ModelPhone model) {
        this.number = number;
        this.model = model;
    }
    public void receiveCall(String name){
        System.out.println("Звонит " + name);
    }
    public void receiveCall(String name, String number){
        System.out.println(number + " звонит " + name);
    }
    public void sendMessage(String... number){
        for (String num : number) {
            System.out.println("To the number " + num + " was send message");
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "comm.tms.Hometask.object.Phone{" +
                "number='" + number + '\'' +
                ", model=" + model +
                ", weight=" + weight +
                '}';
    }
}
