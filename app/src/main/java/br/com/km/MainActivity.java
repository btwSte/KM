package br.com.km;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list_view;
    EditText valor_km;
    Spinner mes;
    Integer idMes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view = (ListView) findViewById(R.id.list_view);
        valor_km = (EditText) findViewById(R.id.valor_km);
        mes = (Spinner) findViewById(R.id.mes);

        ArrayAdapter mesAdapter = ArrayAdapter.createFromResource(this, R.array.mes,
                android.R.layout.simple_spinner_item
        );

        mes.setAdapter(mesAdapter);
    }

    public void inserirKM(View view) {
        String vl = valor_km.getText().toString();

        if (vl.isEmpty()){
            valor_km.setError("Informe o valor percorrido");
        }

        Integer posicao = mes.getSelectedItemPosition() +1;
        idMes = posicao;

        KM item = new KM (idMes, Float.parseFloat(vl));
        item.save();
        valor_km.setText(null);

        Toast.makeText(this,"A variavel foi salva"+item,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id ==  R.id.visualizar){
            startActivity(new Intent(this, Visualizar.class));
        }

        if(id == R.id.limpar_bd){
            KM.deleteAll(KM.class);

            Toast.makeText(this, "Banco limpo", Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.calculo){
            startActivity(new Intent(this, Calcular.class));
        }
        return true;
    }
}
