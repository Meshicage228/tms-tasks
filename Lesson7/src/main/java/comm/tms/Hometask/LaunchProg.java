package comm.tms.Hometask;

import comm.tms.Hometask.mainTask.object.*;
import comm.tms.Hometask.mainTask.service.*;

public class LaunchProg {
    public static void main(String[] args) {

        Phone phone1 = new Phone("+375 29 444 44 44", ModelPhone.HUAWEI, 180.3f);
        Phone phone2 = new Phone("+375 29 111 11 11", ModelPhone.XIAOMI);
        Phone phone3 = new Phone("+375 29 123 52 12", ModelPhone.NOKIA,182.54f );

        phone2.receiveCall("Dad");
        phone3.receiveCall("Grandad", "+375 29 234 24 11");

        Phone[] phones = new Phone[] { phone1, phone2, phone3 };


        PhoneService.getInfoPhones(phones);
        PhoneService.showNumbers(phones);
        phone3.sendMessage("+375 29 111 11 11", "+375 29 123 52 12", "+375 29 999 99 99");

    }

}
