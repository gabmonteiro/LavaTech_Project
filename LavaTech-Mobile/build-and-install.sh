#!/bin/bash

# Script para compilar e instalar o app LavaTech no dispositivo Android via ADB
# Uso: ./build-and-install.sh

set -e  # Para o script se houver erro

echo "=========================================="
echo "  LavaTech - Build e Instalação"
echo "=========================================="
echo ""

# Cores para output
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
NC='\033[0m' # No Color

# Verificar se o ADB está disponível
if ! command -v adb &> /dev/null; then
    echo -e "${RED}Erro: ADB não encontrado!${NC}"
    echo "Por favor, instale o Android SDK Platform Tools."
    exit 1
fi

# Verificar se há dispositivos conectados
echo "Verificando dispositivos conectados..."
DEVICES=$(adb devices | grep -v "List" | grep "device$" | wc -l)

if [ "$DEVICES" -eq 0 ]; then
    echo -e "${RED}Erro: Nenhum dispositivo Android conectado!${NC}"
    echo "Por favor:"
    echo "  1. Conecte seu celular via USB"
    echo "  2. Ative a depuração USB nas opções de desenvolvedor"
    echo "  3. Aceite a autorização de depuração USB no celular"
    exit 1
fi

echo -e "${GREEN}✓ Dispositivo encontrado!${NC}"
adb devices -l
echo ""

# Navegar para o diretório do projeto
cd "$(dirname "$0")"

# Limpar builds anteriores (opcional, mas recomendado)
echo "Limpando builds anteriores..."
./gradlew clean
echo ""

# Compilar o APK de debug
echo "Compilando o APK de debug..."
./gradlew assembleDebug

if [ $? -ne 0 ]; then
    echo -e "${RED}Erro na compilação!${NC}"
    exit 1
fi

echo -e "${GREEN}✓ Compilação concluída!${NC}"
echo ""

# Localizar o APK gerado
APK_PATH="app/build/outputs/apk/debug/app-debug.apk"

if [ ! -f "$APK_PATH" ]; then
    echo -e "${RED}Erro: APK não encontrado em $APK_PATH${NC}"
    exit 1
fi

echo "APK encontrado: $APK_PATH"
echo "Tamanho: $(du -h "$APK_PATH" | cut -f1)"
echo ""

# Desinstalar versão anterior (se existir)
echo "Verificando instalação anterior..."
if adb shell pm list packages | grep -q "com.example.projetolavatech"; then
    echo -e "${YELLOW}Desinstalando versão anterior...${NC}"
    adb uninstall com.example.projetolavatech || true
    echo ""
fi

# Instalar o APK
echo "Instalando o APK no dispositivo..."
adb install -r "$APK_PATH"

if [ $? -eq 0 ]; then
    echo ""
    echo -e "${GREEN}=========================================="
    echo "  ✓ Instalação concluída com sucesso!"
    echo "==========================================${NC}"
    echo ""
    echo "O app LavaTech foi instalado no seu dispositivo."
    echo ""
    echo "Para iniciar o app, execute:"
    echo "  adb shell am start -n com.example.projetolavatech/.MainActivity"
    echo ""
    echo "Ou simplesmente abra o app no seu celular!"
else
    echo -e "${RED}Erro na instalação!${NC}"
    exit 1
fi


