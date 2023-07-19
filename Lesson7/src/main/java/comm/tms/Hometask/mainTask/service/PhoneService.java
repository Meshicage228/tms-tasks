package comm.tms.Hometask.mainTask.service;

import comm.tms.Hometask.mainTask.object.Phone;

public class PhoneService {
    public static void getInfoPhones(Phone... phones){
        if(phones.length == 0) return;
        System.out.println("Info about telephones : ");
        for (Phone teleph : phones) {
            System.out.println(teleph.toString());
        }
    }
    public static void showNumbers(Phone... phones){
        if(phones.length == 0) return;
        System.out.println("Numbers of telephones");
        for (Phone tel : phones) {
            System.out.println(tel.getNumber());
        }
    }
}
