package com.example.examen_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2, et3, et4;
    private TextView tv1, tv2, tv3;
    private Spinner spinner;
    private String[] opciones = {"Suma", "Resta", "Multiplicación", "División"};
    private String[] signos = {"+", "-", "x", "÷"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.num1);
        et2 = (EditText) findViewById(R.id.num2);
        et3 = (EditText) findViewById(R.id.num3);
        et4 = (EditText) findViewById(R.id.num4);

        tv1 = (TextView) findViewById(R.id.signo);
        tv2 = (TextView) findViewById(R.id.resultado1);
        tv3 = (TextView) findViewById(R.id.resultado2);
        spinner = (Spinner) findViewById(R.id.sp);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item_manu ,opciones);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv1.setText(signos[i]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void operaciones(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        String valor3 = et3.getText().toString();
        String valor4 = et4.getText().toString();
        String operacion = spinner.getSelectedItem().toString();
        if (valor1.equals("")) {
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
            et1.requestFocus();
         }else if(valor2.equals("")){
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
            et2.requestFocus();
         } else if(valor3.equals("")){
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
            et3.requestFocus();
         } else if (valor4.equals("")){
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
            et4.requestFocus();
        }else{
            int numero1 = Integer.parseInt(valor1);
            int numero2 = Integer.parseInt(valor2);
            int numero3 = Integer.parseInt(valor3);
            int numero4 = Integer.parseInt(valor4);

            if(operacion.equals("Suma")){
                int arriba = numero1 * numero4;
                int arriba2 = numero2 * numero3;
                int abajo = numero2 * numero4;
                int arribat = arriba + arriba2;
                String arribar = String.valueOf(arribat);
                String abajor = String.valueOf(abajo);
                tv2.setText(arribar);
                tv3.setText(abajor);
                /*Limpiar campos
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                */
            } else if(operacion.equals("Resta")){
                int arriba = numero1 * numero4;
                int arriba2 = numero2 * numero3;
                int abajo = numero2 * numero4;
                int arribat = arriba - arriba2;
                String arribar = String.valueOf(arribat);
                String abajor = String.valueOf(abajo);
                tv2.setText(arribar);
                tv3.setText(abajor);
            } else if(operacion.equals("Multiplicación")){
                int arriba = numero1 * numero3;
                int abajo = numero2 * numero4;
                String arribar = String.valueOf(arriba);
                String abajor = String.valueOf(abajo);
                tv2.setText(arribar);
                tv3.setText(abajor);
            } else if(operacion.equals("División")){
                int arriba = numero1 * numero4;
                int abajo = numero2 * numero3;
                String arribar = String.valueOf(arriba);
                String abajor = String.valueOf(abajo);
                tv2.setText(arribar);
                tv3.setText(abajor);
            }
        }
    }
                //Para limpiar los todos los campos
    public void limpiar(View view){
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                tv2.setText("");
                tv3.setText("");
    }
    //Para salir de la aplicación
    public void salir(View view){
        System.exit(0);
    }
}