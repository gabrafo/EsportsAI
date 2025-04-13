# Know Your Fan + Document Validator = Esports AI

Um sistema integrado para **validação de documentos** e **análise de engajamento em e-sports**, combinando técnicas de IA, visão computacional e processamento de dados.  
*(Projeto em desenvolvimento e que poderá passar por grandes mudanças)*

---

## 🎯 Objetivo
Desenvolver uma solução que:
1. **Valide documentos**:
   - Confirme a autenticidade do CPF usando o algoritmo oficial (Spring `@CPF`).
   - Compare a foto do documento com uma selfie do usuário usando IA (OpenCV/Face Recognition).
   - Verifique se o CPF extraído do documento (OCR) coincide com o informado.
2. **Analise engajamento em e-sports**:
   - Conecte-se ao Twitter via OAuth2 para coletar os últimos 100-200 tweets.
   - Use um modelo de regressão (Python) para pontuar o usuário de 1 a 100 com base nos tweets.

---

## 🛠️ Funcionalidades Implementadas/Previstas

### ✅ Backend (Spring/Java)
- Validação de CPF usando `@CPF` do Spring.
- Autenticação OAuth2 com Twitter.
- Comunicação com RabbitMQ para envio de dados ao Python.

### 🐍 Processamento em Python (MVP)
- **Validação de documentos**:
  - OCR com Tesseract para extrair CPF de imagens/PDFs.
  - Comparação facial básica (ex: OpenCV + Face Recognition).
- **Análise de tweets**:
  - Modelo de regressão simples para pontuação de engajamento.

### 🔮 Futuro/Em Estudo
- **Separação em dois sistemas**:
  - `Document Validator`: Foco em validação de documentos com IA.
  - `Know Your Fan`: Análise de engajamento em e-sports.
- Landing pages dedicadas para cada sistema.
- Uso de LLMs (ex: BERT) para análise semântica de tweets.
- Integração com outras redes (Instagram, Twitch).

---

## 🛠️ Foco Atual do Projeto (Aprendizado)
Este projeto **não replica práticas enterprise**, mas explora conceitos fundamentais:
- **Comunicação assíncrona** entre sistemas heterogêneos (Java/Python).
- **Serialização de dados** (JSON via RabbitMQ).
- **Gestão básica de dependências** (Docker para PostgreSQL/RabbitMQ).
- **Validação de hipóteses** com IA (ex: "Como comparar rostos via OpenCV?").
