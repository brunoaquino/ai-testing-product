# 📌 PoC: Uso de IA no Desenvolvimento de Software

## 📂 Descrição
Este repositório tem como objetivo testar diferentes IAs para otimizar o desenvolvimento de software, incluindo geração de código, revisão automática e refatoração.

## 🛠️ Tecnologias Utilizadas
- **GitHub Copilot**
- **Codeium**
- **Amazon CodeWhisperer**
- **Google Gemini**
- **OpenAI ChatGPT**
- **Codium AI, SonarQube, DeepCode** (para análise de código)
- **GitHub Actions** (para automação de testes)

## 📌 Estrutura do Repositório
```bash
📂 PoC-IA-Dev
 ├── 📂 generated_code  # Códigos gerados por IA
 │   ├── copilot/       # Código gerado pelo GitHub Copilot
 │   ├── codeium/       # Código gerado pelo Codeium
 │   ├── codewhisperer/ # Código gerado pelo Amazon CodeWhisperer
 │   ├── gemini/        # Código gerado pelo Google Gemini
 │   ├── chatgpt/       # Código gerado pelo OpenAI ChatGPT
 ├── 📂 code_review     # Resultados de análise de código
 │   ├── sonarqube/     # Relatórios do SonarQube
 │   ├── deepcode/      # Relatórios do DeepCode
 │   ├── codium/        # Análises do Codium AI
 ├── 📂 refactored_code # Código refatorado com IA
 ├── 📂 docs            # Documentação dos testes e comparações
 ├── .github/workflows  # Automação CI/CD com GitHub Actions
 ├── README.md          # Documentação principal
```

## 🚀 Como Iniciar
1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/PoC-IA-Dev.git
   cd PoC-IA-Dev
   ```
2. **Criação das Branches**
   ```bash
   git branch copilot
   git branch codeium
   git branch codewhisperer
   git branch gemini
   git branch chatgpt
   ```
3. **Configurar SonarQube e DeepCode**
   - Criar um arquivo `sonar-project.properties`
   - Configurar GitHub Actions para rodar análise de código

4. **Executar Testes**
   ```bash
   # Rodar análise do SonarQube
   sonar-scanner
   ```

## 📊 Métricas Avaliadas
✅ **Facilidade de Uso** das IAs
✅ **Qualidade do Código** (avaliada com SonarQube e DeepCode)
✅ **Tempo Economizado** com cada IA
✅ **Sugestões de Refatoração**
