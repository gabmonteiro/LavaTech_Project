#!/usr/bin/env python3
"""
Script para adicionar logo em todas as telas do projeto LavaTech-Cliente
"""
import re
import os

def add_logo_to_file(filepath):
    """Adiciona logo a um arquivo Java de tela"""
    if not os.path.exists(filepath):
        print(f"Arquivo não encontrado: {filepath}")
        return False
    
    with open(filepath, 'r', encoding='utf-8') as f:
        content = f.read()
    
    # Verificar se já tem logo
    if 'jLblLogo' in content:
        print(f"  {filepath} já tem logo, pulando...")
        return False
    
    # 1. Adicionar declaração da variável jLblLogo após outras declarações de componentes
    pattern1 = r'(jTable\w+|jScrollPane\w+|jPanel\w+)\s*=\s*new\s+[^;]+;'
    match = re.search(pattern1, content)
    if match:
        insert_pos = match.end()
        # Encontrar o próximo ponto e vírgula
        next_semicolon = content.find(';', insert_pos) + 1
        if next_semicolon > 0:
            content = content[:next_semicolon] + '\n        jLblLogo = new javax.swing.JLabel();\n' + content[next_semicolon:]
    
    # 2. Adicionar código de carregamento da logo após setTitle
    pattern2 = r'setTitle\([^)]+\);'
    match = re.search(pattern2, content)
    if match:
        insert_pos = match.end()
        logo_code = '''
        
        // Carregar logo pequena no canto superior direito
        javax.swing.JLabel logoLabel = view.utils.LogoHelper.createLogoLabel(80, 70);
        if (logoLabel != null) {
            jLblLogo = logoLabel;
        }'''
        content = content[:insert_pos] + logo_code + content[insert_pos:]
    
    # 3. Adicionar logo no layout horizontal (antes do último .addComponent ou .addGroup)
    pattern3 = r'(\.addComponent\(jScrollPane\w+\)\s*$)'
    if re.search(pattern3, content, re.MULTILINE):
        content = re.sub(
            r'(\.addComponent\(jScrollPane\w+\)\s*$)',
            r'.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()\n                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)\n                .addComponent(jLblLogo)\n                .addContainerGap())\n            \1',
            content,
            flags=re.MULTILINE
        )
    
    # 4. Adicionar logo no layout vertical
    pattern4 = r'(\.addComponent\(jPanel\w+[^)]+\)\s*\n\s*\.addPreferredGap)'
    if re.search(pattern4, content):
        content = re.sub(
            pattern4,
            r'.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)\n                    .addComponent(\1\n                    .addGroup(layout.createSequentialGroup()\n                        .addContainerGap()\n                        .addComponent(jLblLogo)))',
            content
        )
    
    # 5. Adicionar variável jLblLogo na seção de variáveis
    pattern5 = r'(private javax\.swing\.JLabel jLblTitulo;)'
    if re.search(pattern5, content):
        content = re.sub(
            pattern5,
            r'private javax.swing.JLabel jLblLogo;\n    \1',
            content
        )
    
    with open(filepath, 'w', encoding='utf-8') as f:
        f.write(content)
    
    print(f"  ✓ {filepath} atualizado")
    return True

# Lista de telas para processar
telas = [
    "src/view/TelaListaFuncionarios.java",
    "src/view/TelaListaServicos.java",
    "src/view/TelaListaUsuarios.java",
    "src/view/TelaListaVeiculos.java",
    "src/view/TelaCriarAgendamento.java",
    "src/view/TelaCriarCliente.java",
    "src/view/TelaCriarFuncionario.java",
    "src/view/TelaCriarServico.java",
    "src/view/TelaCriarUsuario.java",
    "src/view/TelaCriarVeiculo.java"
]

print("Adicionando logo em todas as telas...")
for tela in telas:
    add_logo_to_file(tela)

print("\nConcluído!")

