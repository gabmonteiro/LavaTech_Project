# Guia de Monitoramento de Logs - LavaTech Mobile

## 📱 Como Monitorar Logs do App no Celular

### Opção 1: Script Automatizado (Recomendado)

```bash
cd /home/plano/Desktop/LavaTech_Project/LavaTech-Mobile
./monitor-logs.sh
```

Este script:
- Verifica se o celular está conectado
- Limpa logs antigos (opcional)
- Filtra logs relevantes do app
- Mostra erros e exceções em destaque

### Opção 2: Comandos Diretos

#### Ver todos os logs do app:
```bash
adb logcat | grep -i "projetolavatech"
```

#### Ver apenas erros e exceções:
```bash
adb logcat *:E | grep -i "projetolavatech\|exception\|error"
```

#### Ver logs com timestamp:
```bash
adb logcat -v time | grep -i "projetolavatech"
```

#### Ver logs relacionados à conexão:
```bash
adb logcat | grep -i "conexao\|socket\|ioexception\|network"
```

#### Ver logs do Android Runtime (crashes):
```bash
adb logcat AndroidRuntime:E *:S
```

### Opção 3: Logs Específicos por Tag

#### Ver logs de uma tag específica:
```bash
adb logcat -s TAG_NAME
```

#### Ver múltiplas tags:
```bash
adb logcat -s Tag1 Tag2 Tag3
```

### Opção 4: Salvar Logs em Arquivo

```bash
# Salvar todos os logs
adb logcat > logs_completos.txt

# Salvar apenas logs do app
adb logcat | grep -i "projetolavatech" > logs_app.txt

# Salvar apenas erros
adb logcat *:E > logs_erros.txt
```

### Comandos Úteis

#### Limpar logs antes de testar:
```bash
adb logcat -c
```

#### Ver logs em tempo real com cores:
```bash
adb logcat -v time | grep --color=always -E "ERROR|Exception|projetolavatech"
```

#### Ver apenas o nível de erro:
```bash
adb logcat *:E
```

#### Ver logs de uma aplicação específica (por PID):
```bash
# Primeiro, encontre o PID do app
adb shell pidof com.example.projetolavatech

# Depois, filtre por PID
adb logcat --pid=<PID>
```

## 🔍 Análise do Problema Atual

Baseado nos logs do servidor, vejo que:
- ✅ Conexão estabelecida: `Socket[addr=/192.168.1.10,port=41530,localport=12345]`
- ❌ Cliente desconectou imediatamente

Possíveis causas:
1. **Exceção no app** durante o login/envio de dados
2. **Timeout** na comunicação
3. **Erro de serialização** dos objetos
4. **Problema de thread** no Android

## 🛠️ Debugging Passo a Passo

1. **Limpe os logs:**
   ```bash
   adb logcat -c
   ```

2. **Inicie o monitoramento:**
   ```bash
   ./monitor-logs.sh
   ```

3. **No celular, abra o app e tente fazer login**

4. **Observe os logs** para identificar:
   - Exceções (Exception, Error)
   - Problemas de rede (SocketException, IOException)
   - Problemas de thread (NetworkOnMainThreadException)
   - Problemas de serialização

## 📋 Tags Úteis para Filtrar

- `AndroidRuntime` - Crashes e erros fatais
- `System.err` - Erros do sistema
- `projetolavatech` - Logs do seu app (se você adicionar Log.d)
- `Socket` - Problemas de conexão
- `IOException` - Erros de I/O

## 💡 Dica: Adicionar Logs no Código

Para facilitar o debug, você pode adicionar logs no código Java:

```java
import android.util.Log;

// No ConexaoController.java
Log.d("ConexaoController", "Tentando conectar ao servidor...");
Log.e("ConexaoController", "Erro na conexão: " + e.getMessage());
```

Depois, monitore com:
```bash
adb logcat -s ConexaoController
```

