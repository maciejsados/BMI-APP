package maciej.example.com.bmiapp.java.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Maciej on 2017-08-11.
 */
@DatabaseTable(tableName = "BMI_results")

public class BMI_DB {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String date;

    @DatabaseField
    private String weight;

    @DatabaseField
    private String bmi_rate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setBmi_rate(String bmi_rate) {
        this.bmi_rate = bmi_rate;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getWeight() {
        return weight;
    }

    public String getBmi_rate() {
        return bmi_rate;
    }

    @Override
    public String toString() {
        return
                date + "        " +
                weight + " kg" +
                "        BMI: " + bmi_rate;
    }


}
