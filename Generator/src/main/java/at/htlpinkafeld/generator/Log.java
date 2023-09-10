package at.htlpinkafeld.generator;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Log {
    private int randomNumber;
    private String timestamp;
    private String ip;

    public Log(String ip, int randomNumber) {
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.ip = ip;
        this.randomNumber = randomNumber;
    }

    @Override
    public String toString() {
        return "<li>" + timestamp + "-" + ip + "-" + randomNumber + "</li><br>";
    }
}
