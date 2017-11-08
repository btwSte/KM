package br.com.km;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class Visualizar extends AppCompatActivity{
    VisualizarAdapter adapter;
    ListView list_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.visualizar);

        list_view = (ListView) findViewById(R.id.list_view);

        //fazer select no banco de dados
        List<KM> listaKM = KM.listAll(KM.class);

        //inicializar adapter
        adapter = new VisualizarAdapter(this, listaKM);

        list_view.setAdapter(adapter);
    }



    public class VisualizarAdapter extends ArrayAdapter<KM>{

        public VisualizarAdapter(Context context, List<KM> list){
            super(context, 0, list);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            View v = convertView;

            if(v == null){
                v = LayoutInflater.from(getContext()).inflate(R.layout.item_lista, null);
            }


            KM km = getItem(position);

            TextView txtItem = (TextView) v.findViewById(R.id.txtItem);
            TextView valor_item = (TextView) v.findViewById(R.id.valor_item);

            String nomeMes;

           switch (km.getIdMes()){
                case 1:
                    nomeMes = "JANEIRO";
                    break;
                case 2:
                    nomeMes = "FEVEREIRO";
                    break;
                case 3:
                   nomeMes = "MARÇO";
                   break;
                case 4:
                  nomeMes = "ABRIL";
                  break;
                case 5:
                   nomeMes = "MAIO";
                   break;
                case 6:
                   nomeMes = "JUNHO";
                   break;
                case 7:
                   nomeMes = "JULHO";
                    break;
                case 8:
                   nomeMes = "AGOSTO";
                    break;
                case 9:
                   nomeMes = "SETEMBRO";
                   break;
                case 10:
                   nomeMes = "OUTUBRO";
                   break;
                case 11:
                   nomeMes = "NOVEMBRO";
                   break;
                case 12:
                   nomeMes = "DEZEMBRO";
                   break;
                default:
                    nomeMes = "";
                    break;
            }



            txtItem.setText(nomeMes);

            valor_item.setText( km.getValor_item() +"");
            
            return v;
        }
    }
}