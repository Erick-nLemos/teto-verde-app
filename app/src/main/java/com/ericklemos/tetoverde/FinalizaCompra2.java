package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ericklemos.tetoverde.controllers.QtdPrdt;
import com.ericklemos.tetoverde.controllers.UserSession;

public class FinalizaCompra2 extends AppCompatActivity {

    private UserSession session = UserSession.getInstance();
    QtdPrdt calcQtd = QtdPrdt.getInstance();
    TextView txtNomeComp, txtNotaF, txtValorTotal;
    String nf = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaliza_compra2);

        txtNomeComp = findViewById(R.id.txtNome);
        txtValorTotal = findViewById(R.id.txtValorTotal);
        txtNotaF = findViewById(R.id.txtNF);

        txtNomeComp.setText(session.getUserName());
        gerarNF();
        calcValTotal(txtValorTotal);
    }

    public void gerarNF(){
        if(calcQtd.qtdRuc > 0){
            nf = nf +"Produto: Rúcula\t Qtd: "+ calcQtd.qtdRuc +"  Val: R$4,99\n";
        }
        if(calcQtd.qtdAlfL > 0){
            nf = nf +"Produto: Alface Lisa\t Qtd: "+ calcQtd.qtdAlfL +"  Val: R$1,49\n";
        }
        if(calcQtd.qtdAlfC > 0){
            nf = nf +"Produto: Alface Crespa\t Qtd: "+ calcQtd.qtdAlfC +"  Val: R$1,99\n";
        }
        if(calcQtd.qtdAlfL > 0){
            nf = nf +"Produto: Repolho Verde\t Qtd: "+ calcQtd.qtdRepV +"  Val: R$4,99\n";
        }

        txtNotaF.setText(nf);
    }

    public void calcValTotal(TextView textView){
        double valTotal;
        valTotal = (calcQtd.qtdAlfL*1.49) + (calcQtd.qtdRepV*4.99) + (calcQtd.qtdAlfC*1.99) + (calcQtd.qtdRuc*4.99);

        String valTotalFormatado = String.format("%.2f", valTotal);
        textView.setText("R$ "+ valTotalFormatado);
    }

    public void clickHome(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Market.class);
        startActivity(tela);
    }

    public void clickCarrinho(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Carrinho.class);
        startActivity(tela);
    }

    public void clickPerfil(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Perfil.class);
        startActivity(tela);
    }
}