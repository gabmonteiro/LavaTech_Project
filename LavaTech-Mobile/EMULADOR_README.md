# Guia de Uso do Emulador Android - LavaTech Mobile

## ✅ Instalação Concluída

O emulador Android foi instalado e configurado com sucesso!

### Componentes Instalados:
- ✅ Android SDK Command-line Tools
- ✅ Android Emulator
- ✅ Imagem de Sistema Android 30 (API 30) com Google APIs
- ✅ AVD (Android Virtual Device) nomeado: **LavaTech_AVD**

## 🚀 Como Usar

### 1. Iniciar o Emulador

Você tem duas opções:

#### Opção A: Usar o script fornecido (Recomendado)
```bash
cd /home/plano/Desktop/LavaTech_Project/LavaTech-Mobile
./start-emulator.sh
```

#### Opção B: Comando direto
```bash
export ANDROID_HOME=~/Android/Sdk
export ANDROID_SDK_ROOT=~/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/emulator:$ANDROID_HOME/platform-tools
~/Android/Sdk/emulator/emulator -avd LavaTech_AVD &
```

### 2. Verificar se o Emulador Está Rodando

Após iniciar o emulador, aguarde alguns segundos e verifique:

```bash
adb devices
```

Você deve ver algo como:
```
List of devices attached
emulator-5554   device
```

### 3. Compilar e Instalar o App no Emulador

No diretório do projeto Android:

```bash
cd /home/plano/Desktop/LavaTech_Project/LavaTech-Mobile
./gradlew installDebug
```

Ou se estiver usando Android Studio, simplesmente execute o projeto normalmente - o emulador será detectado automaticamente.

### 4. Parar o Emulador

- **Opção 1**: Feche a janela do emulador
- **Opção 2**: Use o comando:
```bash
adb emu kill
```

## 📋 Informações do AVD

- **Nome**: LavaTech_AVD
- **API Level**: 30 (Android 11)
- **ABI**: x86_64
- **Google APIs**: Incluídas
- **Dispositivo Base**: Pixel 4

## 🔧 Configuração das Variáveis de Ambiente

As variáveis de ambiente foram adicionadas ao seu `~/.bashrc`:

```bash
export ANDROID_HOME="$HOME/Android/Sdk"
export ANDROID_SDK_ROOT="$HOME/Android/Sdk"
export PATH="$PATH:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/emulator:$ANDROID_HOME/platform-tools"
```

**Importante**: Após adicionar essas variáveis, você precisa:
1. Fechar e reabrir o terminal, OU
2. Executar: `source ~/.bashrc`

## 🐛 Solução de Problemas

### Emulador não inicia
- Verifique se há processos do emulador rodando: `ps aux | grep emulator`
- Mate processos antigos: `pkill -9 emulator`
- Verifique se o AVD existe: `ls ~/.android/avd/`

### ADB não detecta o emulador
- Aguarde alguns segundos após iniciar o emulador
- Execute: `adb kill-server && adb start-server`
- Verifique: `adb devices`

### Erro de permissão
- Certifique-se de que os scripts têm permissão de execução: `chmod +x start-emulator.sh`

## 📝 Notas

- O emulador pode demorar alguns minutos para iniciar na primeira vez
- Certifique-se de que o servidor LavaTech-Servidor está rodando antes de testar o app mobile
- O emulador consome recursos do sistema - feche-o quando não estiver usando

## 🎯 Próximos Passos

1. Inicie o servidor LavaTech-Servidor
2. Inicie o emulador usando `./start-emulator.sh`
3. Aguarde o emulador inicializar completamente
4. Compile e instale o app no emulador
5. Teste a aplicação!

