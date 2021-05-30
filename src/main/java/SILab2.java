import java.util.ArrayList;
import java.util.List;

class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {

    public static List<Integer> function(List<Time> timesList) {
        List<Integer> result = new ArrayList<>();//1

        for (int i = 0; i < timesList.size(); i++) {//1
            int hr = timesList.get(i).getHours();//2
            int min = timesList.get(i).getMinutes();//2
            int sec = timesList.get(i).getSeconds();//2
            if (hr < 0 || hr > 24){//3
                if (hr < 0){//4
                    throw new RuntimeException("The hours are smaller than the minimum");//5
                }
                else {//6
                    throw new RuntimeException("The hours are grater than the maximum");//7
                }
            }
            else if (hr < 24) {//8
                if (min < 0 || min > 59)//9
                    throw new RuntimeException("The minutes are not valid!");//10
                else {//11
                    if (sec >= 0 && sec <= 59)//12
                        result.add(hr * 3600 + min * 60 + sec);//13
                    else//14
                        throw new RuntimeException("The seconds are not valid");//15
                }
            }
            else if (hr == 24 && min == 0 && sec == 0) {//16
                result.add(hr * 3600 + min * 60 + sec);//17
            }
            else {//18
                throw new RuntimeException("The time is greater than the maximum");//19
            }
        }//20
        return result;//21
    }//22
}