package com.example.practica_6_conversion;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practica_6_conversion.model.Celsius;
import com.example.practica_6_conversion.model.Farenheit;
import com.example.practica_6_conversion.model.Grado;
import com.example.practica_6_conversion.model.Kelvin;

public class MainActivity2 extends AppCompatActivity {

    Spinner spinner;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner = findViewById(R.id.spi);
        editText = findViewById(R.id.editxt);
        button = findViewById(R.id.btn);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.conversion_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                convertir();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Aquí puedes manejar la falta de selección
            }
        });
    }

    private void convertir() {
        String valorStr = editText.getText().toString();

        if (!valorStr.isEmpty()) {
            double valor = Double.parseDouble(valorStr);

            // Obtiene la opción seleccionada en el Spinner
            String opcion = spinner.getSelectedItem().toString();

            // Realiza la conversión según la opción seleccionada
            Grado resultado = null;

            if (opcion.equals("Celsius a Fahrenheit")) {
                resultado = new Farenheit(valor).parse(new Celsius(valor));
            } else if (opcion.equals("Celsius a Kelvin")) {
                resultado = new Kelvin(valor).parse(new Celsius(valor));
            } else if (opcion.equals("Fahrenheit a Celsius")) {
                resultado = new Celsius(valor).parse(new Farenheit(valor));
            } else if (opcion.equals("Fahrenheit a Kelvin")) {
                resultado = new Kelvin(valor).parse(new Farenheit(valor));
            } else if (opcion.equals("Kelvin a Celsius")) {
                resultado = new Celsius(valor).parse(new Kelvin(valor));
            } else if (opcion.equals("Kelvin a Fahrenheit")) {
                resultado = new Farenheit(valor).parse(new Kelvin(valor));
            }

            if (resultado != null) {
                TextView resultadoTextView = findViewById(R.id.textResultado);
                resultadoTextView.setText("Resultado: " + resultado.getValor() + " " + resultado.getUnidad());
            }
        } else {
            mostrarMensaje("Por favor, ingresa un valor.");
        }
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

}
