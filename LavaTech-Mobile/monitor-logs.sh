#!/bin/bash

# Script para monitorar logs do app LavaTech Mobile em tempo real
# Uso: ./monitor-logs.sh

echo "=========================================="
echo "Monitor de Logs - LavaTech Mobile"
echo "=========================================="
echo ""
echo "Pressione Ctrl+C para parar"
echo ""

# Configurar variáveis de ambiente
export ANDROID_HOME="$HOME/Android/Sdk"
export ANDROID_SDK_ROOT="$HOME/Android/Sdk"
export PATH="$PATH:$ANDROID_HOME/platform-tools"

# Verificar se o dispositivo está conectado
if ! adb devices | grep -q "device$"; then
    echo "ERRO: Nenhum dispositivo Android conectado!"
    echo "Conecte seu celular via USB e autorize a depuração USB."
    exit 1
fi

echo "Dispositivo conectado:"
adb devices -l
echo ""

# Limpar logs antigos (opcional)
read -p "Deseja limpar os logs antigos antes de começar? (s/n): " limpar
if [ "$limpar" = "s" ] || [ "$limpar" = "S" ]; then
    echo "Limpando logs..."
    adb logcat -c
    echo "Logs limpos!"
    echo ""
fi

echo "Iniciando monitoramento de logs..."
echo "Filtrando por: ProjetoLavaTech, AndroidRuntime, System.err"
echo ""

# Monitorar logs do app com filtros úteis
adb logcat -v time | grep -E "projetolavatech|AndroidRuntime|System.err|ConexaoController|Socket|IOException|Exception" --color=always

