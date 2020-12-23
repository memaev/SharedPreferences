package mik.maev.sharedprefspractic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button up_btn;
    private TextView text;
    private SharedPreferences score_prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up_btn = findViewById(R.id.up_btn);
        text = findViewById(R.id.score);
        score_prefs = getSharedPreferences("Score", Context.MODE_PRIVATE); //создаем экземпляп класса SharedPreferences
        text.setText(Integer.toString(score_prefs.getInt("score", 0))); //отображаем текущий счет
        up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = score_prefs.getInt("score", 0); //записываем в переменную данные о счете, которые мы будем изменять
                score++;
                SharedPreferences.Editor edit = score_prefs.edit(); //создаем экземпляр класса Editor и задаем то, какие настройки мы будем редактировать
                edit.putInt("score", score); //Записываем в ячейку "score" значение
                edit.apply(); //Чтобы настройки сохранились, коммитим их. Без этого настройки остануться прежними
                text.setText(Integer.toString(score));
            }
        });
    }
}