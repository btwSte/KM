package br.com.km;

import com.orm.SugarRecord;

public class KM extends SugarRecord{
    private Integer idMes;
    private Float valor_item;

    //Construtor obrigatorio por causa do ORM
    public KM(){}

    public KM (Integer idMes, Float valor_item){
        this.idMes = idMes;
        this.valor_item = valor_item;
    }

    public Integer getIdMes() {
        return idMes;
    }

    public void setIdMes(Integer idMes) {
        this.idMes = idMes;
    }

    public Float getValor_item() {
        return valor_item;
    }

    public void setValor_item(Float valor_item) {
        this.valor_item = valor_item;
    }





}
