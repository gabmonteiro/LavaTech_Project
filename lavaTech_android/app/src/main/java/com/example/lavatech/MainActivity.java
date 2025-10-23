package MainActivity.java; // Use o mesmo nome do pacote!

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AgendamentosActivity extends AppCompatActivity {

    private EditText editTextDate;
    private EditText editTextTime;
    private Spinner spinnerServiceType;
    private Button buttonConfirmSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Garante que o layout correto está sendo usado
        setContentView(R.layout.tela_agendamentos);

        // 1. Encontrar todos os elementos de UI pelo ID
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        spinnerServiceType = findViewById(R.id.spinnerServiceType);
        buttonConfirmSchedule = findViewById(R.id.buttonConfirmSchedule);

        // 2. Configurar o Spinner (Seletor de Serviço)
        setupSpinner();

        // 3. Configurar os Eventos de Clique para Data e Hora
        editTextDate.setOnClickListener(v -> showDatePicker());
        editTextTime.setOnClickListener(v -> showTimePicker());

        // 4. Configurar o Botão de Confirmação
        buttonConfirmSchedule.setOnClickListener(v -> confirmSchedule());
    }

    // Método para configurar o Spinner (Seletor de Serviço)
    private void setupSpinner() {
        // Serviços de exemplo. Este array deve corresponder ao seu @array/car_wash_services no strings.xml
        String[] services = {"Lavagem Simples", "Lavagem Completa", "Polimento", "Higienização Interna"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item, // Layout padrão para o item
                services
        );
        // Define o layout para quando a lista é aberta
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerServiceType.setAdapter(adapter);
    }

    // Método para abrir o seletor de Data
    private void showDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    // Formata a data selecionada no EditText
                    String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    editTextDate.setText(date);
                }, year, month, day);

        // Garante que o usuário só pode selecionar datas a partir de hoje
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

        datePickerDialog.show();
    }

    // Método para abrir o seletor de Hora
    private void showTimePicker() {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minuteOfHour) -> {
                    // Formata a hora (adiciona um zero à esquerda se for menor que 10)
                    String time = String.format("%02d:%02d", hourOfDay, minuteOfHour);
                    editTextTime.setText(time);
                }, hour, minute, true); // O 'true' define o formato 24 horas
        timePickerDialog.show();
    }

    // Método chamado ao clicar no botão Confirmar
    private void confirmSchedule() {
        String data = editTextDate.getText().toString();
        String hora = editTextTime.getText().toString();
        String servico = spinnerServiceType.getSelectedItem().toString();

        // Lógica de validação básica
        if (data.isEmpty() || hora.isEmpty()) {
            Toast.makeText(this, "Por favor, selecione a data e a hora.", Toast.LENGTH_LONG).show();
            return;
        }

        // Simulação de confirmação e feedback para o usuário
        String msg = "Agendamento Confirmado para:\nData: " + data + "\nHora: " + hora + "\nServiço: " + servico;
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        // Aqui você faria a chamada a uma API ou salvaria no banco de dados.
    }
}