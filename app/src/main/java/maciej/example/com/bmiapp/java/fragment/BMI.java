package maciej.example.com.bmiapp.java.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import maciej.example.com.bmiapp.R;
import maciej.example.com.bmiapp.java.model.BMI_DB;
import maciej.example.com.bmiapp.java.model.DB_Helper;

/**
 * Created by Maciej on 2017-08-09.
 */

public class BMI extends Fragment implements TextWatcher {


    @BindView(R.id.weight)
    EditText weight_input;
    @BindView(R.id.height)
    EditText height_input;
    @BindView(R.id.BMI_result)
    TextView bmi_result;
    @BindView(R.id.BMI_description)
    TextView bmi_description;
    @BindView(R.id.weight_range)
    TextView weight_range;
    @BindView(R.id.target_weigh)
    TextView target_weight;
    @BindView(R.id.btn)
    Button button;


    private Dao<BMI_DB, Long> bmiDbLongDao;


    public static BMI newInstance() {
        BMI fragment1 = new BMI();
        Bundle args = new Bundle();
        fragment1.setArguments(args);
        return fragment1;
    }

    public BMI() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        ButterKnife.bind(this, view);


        height_input.addTextChangedListener(this);
        weight_input.addTextChangedListener(this);

        DB_Helper db_helper = OpenHelperManager.getHelper(getActivity(), DB_Helper.class);
        bmiDbLongDao = db_helper.getBmiDao();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToDatabase();


            }

        });

        return view;
    }


    private void BMICalculate() {
        String result = "";

        try {
            String w = weight_input.getText().toString();
            String h = height_input.getText().toString();

            int i = Integer.parseInt(h);
            double metersFromCM = getMetersFromCM(i);
            double h_double = metersFromCM * metersFromCM;


            double value = (Integer.parseInt(w) / h_double);
            result = "" + value;
        } catch (Exception e) {


            result = " ";


        }

        bmi_result.setText(result);
    }

    private void BMIDescription() {
        String result = "";

        try {
            String s = bmi_result.getText().toString();
            double v = Double.parseDouble(s);
            result = "" + v;

            if (v < 16) {
                bmi_description.setText("Skrajan niedowaga");
                bmi_description.setTextColor(Color.BLUE);
            } else if (v >= 16 && v < 17) {
                bmi_description.setText("Duża niedowaga");
                bmi_description.setTextColor(Color.BLUE);
            } else if (v >= 17 && v <= 18.5) {
                bmi_description.setText("Niedowaga");
                bmi_description.setTextColor(Color.BLUE);
            } else if (v >= 18.5 && v < 25) {
                bmi_description.setText("Wartość prawidłowa");
                bmi_description.setTextColor(Color.GREEN);
            } else if (v >= 25 && v < 29.99) {
                bmi_description.setText("Nadwaga");
                bmi_description.setTextColor(Color.CYAN);
            } else if (v >= 20 && v < 35) {
                bmi_description.setText("I stopień otyłości");
                bmi_description.setTextColor(Color.RED);
            } else if (v >= 35 && v < 39.99) {
                bmi_description.setText("II stopień otyłości");
                bmi_description.setTextColor(Color.RED);
            } else {
                bmi_description.setText("Otyłość skrajna");
                bmi_description.setTextColor(Color.RED);
            }
        } catch (Exception e) {

        }

    }

    private void correctWeight() {
        try {
            String s = height_input.getText().toString();
            int i = Integer.parseInt(s);
            if (i >= 150 && i < 154) {
                weight_range.setText("Normalna waga 44 - 56 kg");
            } else if (i >= 154 && i < 156) {
                weight_range.setText("Normalna waga 44 - 58 kg");
            } else if (i >= 156 && i < 158) {
                weight_range.setText("Normalna waga 46 - 60 kg");
            } else if (i >= 158 && i < 160) {
                weight_range.setText("Normalna waga 48 - 62 kg");
            } else if (i >= 160 && i < 164) {
                weight_range.setText("Normalna waga 50 - 64 kg");
            } else if (i >= 164 && i < 166) {
                weight_range.setText("Normalna waga 50 - 66 kg");
            } else if (i >= 166 && i < 168) {
                weight_range.setText("Normalna waga 52 - 66 kg");
            } else if (i >= 168 && i < 170) {
                weight_range.setText("Normalna waga 54 - 70 kg");
            } else if (i >= 170 && i < 172) {
                weight_range.setText("Normalna waga 54 - 72 kg");
            } else if (i >= 172 && i < 174) {
                weight_range.setText("Normalna waga 56 - 72 kg");
            } else if (i >= 174 && i < 176) {
                weight_range.setText("Normalna waga 58 - 74 kg");
            } else if (i >= 176 && i < 178) {
                weight_range.setText("Normalna waga 58 - 74 kg");
            } else if (i >= 178 && i < 180) {
                weight_range.setText("Normalna waga 60 - 76 kg");
            } else if (i >= 180 && i < 182) {
                weight_range.setText("Normalna waga 60 - 76 kg");
            } else if (i >= 182 && i < 184) {
                weight_range.setText("Normalna waga 62 - 78 kg");
            } else if (i >= 184 && i < 186) {
                weight_range.setText("Normalna waga 64 - 80 kg");
            } else if (i >= 186 && i < 188) {
                weight_range.setText("Normalna waga 66 - 82 kg");
            } else if (i >= 188 && i < 190) {
                weight_range.setText("Normalna waga 68 - 84 kg");
            } else if (i >= 190 && i < 192) {
                weight_range.setText("Normalna waga 70 - 88 kg");
            } else if (i >= 192 && i < 194) {
                weight_range.setText("Normalna waga 72 - 90 kg");
            } else if (i >= 194 && i < 196) {
                weight_range.setText("Normalna waga 74 - 94 kg");
            } else if (i >= 196 && i <= 198) {
                weight_range.setText("Normalna waga 76 - 98 kg");
            } else {
                bmi_result.setText("");
                bmi_description.setText("Wskaźnik liczony jest dla wzrostu w zakresie 150 - 198 cm.");
                bmi_description.setTextColor(Color.RED);
                weight_range.setText("");
                target_weight.setText("");

            }

        } catch (Exception e) {

        }
    }

    private void targetWeight() {
        String result;
        try {
            String upper_range = weight_range.getText().toString();
            String substring = upper_range.substring(19, 21);
            String lower_range = weight_range.getText().toString();
            String substring1 = lower_range.substring(14, 16);

            String weight = weight_input.getText().toString();
            int weight_int = Integer.parseInt(weight);

            int i = Integer.parseInt(substring);
            int i1 = Integer.parseInt(substring1);

            if (weight_int <= i && weight_int >= i1) {
                target_weight.setText("OK");
                target_weight.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_sentiment_very_satisfied_black_24dp, 0, 0, 0);
            } else if (weight_int < i1) {
                int i2 = (i1 - weight_int) * -1;
                target_weight.setText(i2 + " kg");
                target_weight.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else if (weight_int > i) {
                int i2 = (i - weight_int) * -1;
                target_weight.setText("+" + i2 + " kg");
                target_weight.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

            } else {
                target_weight.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                target_weight.setText("");
            }


        } catch (Exception e) {
            result = "";
        }

    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        BMICalculate();
        BMIDescription();
        correctWeight();
        targetWeight();


    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        BMICalculate();
        BMIDescription();
        correctWeight();
        targetWeight();


    }

    @Override
    public void afterTextChanged(Editable editable) {
        BMICalculate();
        BMIDescription();
        correctWeight();
        targetWeight();


    }

    private double getMetersFromCM(int cm) {

        double meters = (double) cm / 100;

        return meters;

    }


    private void addToDatabase() {

        BMI_DB bmi_db = new BMI_DB();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(calendar.getTime());

        String s1 = bmi_result.getText().toString();
        String s = weight_input.getText().toString();


        if (s1.equals("") && s.equals("")) {

            Toast.makeText(getActivity(), "Wprowadź wzrost i wagę do odpowiednich pól", Toast.LENGTH_SHORT).show();
            return;

        } else {

            bmi_db.setWeight(s);
            bmi_db.setBmi_rate(s1);
            bmi_db.setDate(format);


            try {
                bmiDbLongDao.create(bmi_db);
                Toast.makeText(getActivity(), "Wynik został zapisany", Toast.LENGTH_SHORT).show();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }


}



