package parserDB;

import lombok.Data;

import java.util.Date;

/**
 * Created by patryk on 12.03.16.
 */
@Data
public class File {

    private String name;
    private Date date;
    private double startValue;
    private double maxValue;
    private double minValue;
    private double endValue;
    private float volume;

    public File(String name, Date date, double startValue, double minValue, double maxValue, double endValue, float volume) {
        this.name = name;
        this.date = date;
        this.startValue = startValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.endValue = endValue;
        this.volume = volume;
    }


}
