#!/bin/bash

# Script simples para ver logs do app LavaTech Mobile
# Uso: ./ver-logs.sh

source ~/.bashrc

echo "=========================================="
echo "Monitor de Logs - LavaTech Mobile"
echo "=========================================="
echo ""
echo "Pressione Ctrl+C para parar"
echo ""

# Limpar logs antigos
adb logcat -c

echo "Logs limpos! Agora execute o app no celular."
echo "Os logs aparecerão abaixo em tempo real:"
echo ""

# Monitorar logs do app (ConexaoController, LoginActivityApp, ListaAgendamentosActivityApp) e erros
adb logcat -v time ConexaoController:* LoginActivityApp:* ListaAgendamentos:* AndroidRuntime:E *:S

