#!/bin/bash

# Script para iniciar o emulador Android LavaTech_AVD
# Uso: ./start-emulator.sh

# Configurar variáveis de ambiente
export ANDROID_HOME="$HOME/Android/Sdk"
export ANDROID_SDK_ROOT="$HOME/Android/Sdk"
export PATH="$PATH:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/emulator:$ANDROID_HOME/platform-tools"

# Verificar se o emulador está instalado
if [ ! -f "$ANDROID_HOME/emulator/emulator" ]; then
    echo "Erro: Emulador Android não encontrado em $ANDROID_HOME/emulator"
    exit 1
fi

# Verificar se o AVD existe
if [ ! -d "$HOME/.android/avd/LavaTech_AVD.avd" ]; then
    echo "Erro: AVD LavaTech_AVD não encontrado"
    echo "Execute: avdmanager create avd -n LavaTech_AVD -k \"system-images;android-30;google_apis;x86_64\""
    exit 1
fi

echo "Iniciando emulador Android LavaTech_AVD..."
echo "Aguarde alguns instantes para o emulador inicializar completamente."
echo ""

# Iniciar o emulador em background
$ANDROID_HOME/emulator/emulator -avd LavaTech_AVD -no-snapshot-load &

echo "Emulador iniciado! Verifique a janela do emulador."
echo "Para verificar se está pronto, execute: adb devices"
echo ""
echo "Para parar o emulador, feche a janela ou execute: adb emu kill"

