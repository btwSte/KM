package br.com.km;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import java.util.List;

public class Calcular extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.calcular);
    }

    public class CalcularAdapter extends ArrayAdapter<KM> {

        public CalcularAdapter(Context context, List<KM> list){
            super(context, 0, list);
        }


    }
}

