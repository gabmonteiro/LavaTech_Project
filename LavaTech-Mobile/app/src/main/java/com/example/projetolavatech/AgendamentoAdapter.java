package com.example.projetolavatech;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelDominio.Agendamento;

public class AgendamentoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Agendamento> agendamentos;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private OnStatusChangeListener statusChangeListener;

    public interface OnStatusChangeListener {
        void onStatusChange(Agendamento agendamento, String novoStatus);
    }

    public AgendamentoAdapter(Context context, ArrayList<Agendamento> agendamentos) {
        this.context = context;
        this.agendamentos = agendamentos != null ? agendamentos : new ArrayList<>();
    }

    public void setOnStatusChangeListener(OnStatusChangeListener listener) {
        this.statusChangeListener = listener;
    }

    @Override
    public int getCount() {
        return agendamentos.size();
    }

    @Override
    public Object getItem(int position) {
        return agendamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return agendamentos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_agendamento, parent, false);
            holder = new ViewHolder();
            holder.textViewId = convertView.findViewById(R.id.textViewId);
            holder.textViewStatus = convertView.findViewById(R.id.textViewStatus);
            holder.textViewDataHora = convertView.findViewById(R.id.textViewDataHora);
            holder.textViewCliente = convertView.findViewById(R.id.textViewCliente);
            holder.textViewVeiculo = convertView.findViewById(R.id.textViewVeiculo);
            holder.textViewFuncionario = convertView.findViewById(R.id.textViewFuncionario);
            holder.textViewServico = convertView.findViewById(R.id.textViewServico);
            holder.buttonAlterarStatus = convertView.findViewById(R.id.buttonAlterarStatus);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Agendamento agendamento = agendamentos.get(position);

        // ID
        holder.textViewId.setText("ID: #" + agendamento.getId());

        // Status com cor
        String status = agendamento.getStatus() != null ? agendamento.getStatus() : "Desconhecido";
        holder.textViewStatus.setText(status);
        
        // Definir cor do status
        int statusColor;
        if ("Agendado".equals(status)) {
            statusColor = Color.parseColor("#2196F3"); // Azul
        } else if ("Em Andamento".equals(status)) {
            statusColor = Color.parseColor("#FF9800"); // Laranja
        } else if ("Concluído".equals(status)) {
            statusColor = Color.parseColor("#4CAF50"); // Verde
        } else if ("Cancelado".equals(status)) {
            statusColor = Color.parseColor("#F44336"); // Vermelho
        } else {
            statusColor = Color.parseColor("#757575"); // Cinza
        }
        holder.textViewStatus.setBackgroundColor(statusColor);

        // Data/Hora
        if (agendamento.getDataHora() != null) {
            holder.textViewDataHora.setText(agendamento.getDataHora().format(formatter));
        } else {
            holder.textViewDataHora.setText("Data não informada");
        }

        // Cliente
        String clienteNome = agendamento.getCliente() != null ? agendamento.getCliente().getNome() : "—";
        holder.textViewCliente.setText(clienteNome);

        // Veículo
        String veiculoModelo = agendamento.getVeiculo() != null ? agendamento.getVeiculo().getModelo() : "—";
        holder.textViewVeiculo.setText(veiculoModelo);

        // Funcionário
        String funcionarioNome = agendamento.getFuncionario() != null ? agendamento.getFuncionario().getNome() : "—";
        holder.textViewFuncionario.setText(funcionarioNome);

        // Serviço
        String servicoNome = agendamento.getServico() != null ? agendamento.getServico().getNome() : "—";
        holder.textViewServico.setText(servicoNome);

        // Botão Alterar Status
        holder.buttonAlterarStatus.setOnClickListener(v -> {
            if (statusChangeListener != null) {
                statusChangeListener.onStatusChange(agendamento, status);
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        TextView textViewId;
        TextView textViewStatus;
        TextView textViewDataHora;
        TextView textViewCliente;
        TextView textViewVeiculo;
        TextView textViewFuncionario;
        TextView textViewServico;
        Button buttonAlterarStatus;
    }

    public void updateData(ArrayList<Agendamento> newAgendamentos) {
        this.agendamentos = newAgendamentos != null ? newAgendamentos : new ArrayList<>();
        notifyDataSetChanged();
    }
}

