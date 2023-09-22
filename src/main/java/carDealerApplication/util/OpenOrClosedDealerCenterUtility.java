package carDealerApplication.util;

import carDealerApplication.dal.DealerCenterRepository;
import carDealerApplication.entity.DealerCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
@Data
@AllArgsConstructor
public class OpenOrClosedDealerCenterUtility {
    private final DealerCenterRepository dealerCenterRepository;

    public short currentHourPreparer() {
        return Short.parseShort(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance()
                .getTime()).split(":")[0]);
    }

    public short currentMinutePreparer() {
        return Short.parseShort(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance()
                .getTime()).split(":")[1]);
    }

    public void isOpenSetter() {
        for (DealerCenter dealerCenter : dealerCenterRepository.findAll()) {
            byte openHoursHour = Byte.parseByte(dealerCenter.getHours().split(" - ")[0].split(":")[0]);
            byte openHoursMinute = Byte.parseByte(dealerCenter.getHours().split(" - ")[0].split(":")[1]);

            byte closedHoursHour = Byte.parseByte(dealerCenter.getHours().split(" - ")[1].split(":")[0]);
            byte closedHoursMinute = Byte.parseByte(dealerCenter.getHours().split(" - ")[1].split(":")[1]);

            if (currentHourPreparer() > openHoursHour || currentHourPreparer() < closedHoursHour) {
                if (currentHourPreparer() == openHoursHour) {
                    if (currentMinutePreparer() > openHoursMinute) {
                        dealerCenter.setIsOpen(true);
                    } else {
                        dealerCenter.setIsOpen(false);
                        System.out.println("(minutes false) " + "open minutes of this dealer: " + openHoursMinute +
                                " now: " + currentHourPreparer() + " closing minutes: " + closedHoursMinute);
                    }
                } else if (currentHourPreparer() == closedHoursHour) {
                    if (currentMinutePreparer() < closedHoursMinute) {
                        dealerCenter.setIsOpen(true);
                    } else {
                        dealerCenter.setIsOpen(false);
                        System.out.println("(minutes false) " + "open minutes of this dealer: " + openHoursMinute +
                                " now: " + currentHourPreparer() + " closing minutes: " + closedHoursMinute);
                    }
                } else {
                    dealerCenter.setIsOpen(true);
                }
            } else {
                dealerCenter.setIsOpen(false);
                System.out.println("hours false " + "open hours of this dealer: " + openHoursHour +
                        " now: " + currentHourPreparer() + " closing hours: " + closedHoursHour);
            }
        }
    }
}