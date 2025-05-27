# Documento de Especificação de Requisitos

## 1. Requisitos Funcionais (RF)

1. **RF01 – Cadastro de Usuário**
   O sistema deve permitir que o usuário crie uma conta com e-mail e senha (ou login anônimo) para salvar preferências e checklist.

2. **RF02 – Ingestão de Dados Climáticos**
   O sistema deve importar periodicamente (a cada 1h) dados de chuva e focos de calor de fonte pública (CSV/JSON) para análise de risco.

3. **RF03 – Geração de Alertas**
   Quando o volume de chuva em 24 h exceder o threshold definido (> 30 mm) ou houver detecção de foco de calor crítico, o sistema deve gerar um alerta.

4. **RF04 – Notificação por Áudio e Push**
   Ao gerar um alerta, o app deve emitir uma notificação push e reproduzir, via TTS, a mensagem “Risco de incêndio em sua região nas próximas 24 h”.

5. **RF05 – Exibição de Mapa 3D de Abrigos**
   O usuário deve visualizar, em um mapa WebGL (three.js), a localização de abrigos voluntários registrados no sistema.

6. **RF06 – Cálculo de Rota Otimizada**
   A partir da posição do usuário (manual ou GPS), o sistema deve calcular a rota mais curta até o abrigo mais próximo usando algoritmo Dijkstra/A\*.

7. **RF07 – Checklist de Preparação**
   O usuário deve ter acesso a um checklist editável (CRUD) de itens de emergência (máscara, água, documentos), com status “pendente/concluído”.

8. **RF08 – Sincronização Offline/Online**
   O app deve funcionar offline, armazenando localmente dados de checklist e abrigos, e sincronizar quando a conexão for restabelecida.

---

## 2. Requisitos Não-Funcionais (RNF)

1. **RNF01 – Performance de Carregamento**
   A tela principal (mapa + button alerta) deve carregar em ≤ 3 segundos em rede 3G.

2. **RNF02 – Disponibilidade**
   O backend deve ter disponibilidade mínima de 99% ao mês, considerando janelas de manutenção planejadas.

3. **RNF03 – Segurança de Dados**
   Todas as comunicações devem usar HTTPS/TLS 1.2+, e senhas devem ser armazenadas com hashing bcrypt (salt ≥ 12).

4. **RNF04 – Escalabilidade**
   A arquitetura deve permitir escalar horizontalmente o serviço de ingestão de dados e de geração de alertas.

5. **RNF05 – Usabilidade e Acessibilidade**
   O app deve seguir WCAG 2.1 AA, com contraste mínimo de 4.5:1 e suporte a leitor de tela.

6. **RNF06 – Confiabilidade Offline**
   Em modo offline, ≥ 90% das funções críticas (mapa básico, checklist, última carga de alertas) devem estar disponíveis.

7. **RNF07 – Manutenibilidade**
   O código deve ter cobertura mínima de testes unitários de 70% e seguir guia de estilo definido (ESLint, Prettier, Checkstyle).

8. **RNF08 – Portabilidade**
   A PWA deve rodar em Chrome, Firefox e Edge (desktop e mobile) sem componentes nativos adicionais.

---

## 3. Requisitos Técnicos (RT)

1. **RT01 – Frontend em React + PWA**
   Utilizar React 18, Service Workers e manifest.json para transformar o app em PWA.

2. **RT02 – Visualização 3D com three.js**
   Implementar o mapa de abrigos usando three.js, suportando renderização de até 200 pins sem queda perceptível de FPS.

3. **RT03 – Backend em Spring Boot / Node.js**
   Microserviço “Forecast” em Spring Boot (Java 17) e “Shelter” em Node.js (14+) expostos via REST.

4. **RT04 – Banco de Dados Geoespacial**
   Utilizar MongoDB Atlas com índice 2dsphere ou Oracle Spatial para consultas de proximidade geográfica.

5. **RT05 – Integração TTS e FCM**
   Chamar Web Speech API para TTS no frontend e Firebase Cloud Messaging para enviar notificações push.

6. **RT06 – Pipeline de Dados em Python**
   Script em Python (3.9+) que roda em container Docker, usa pandas para processar CSV de chuva e dispara alertas via API REST.

7. **RT07 – Autenticação JWT**
   Proteger endpoints com JWT, válido por 24 h, renovável via refresh token.

8. **RT08 – CI/CD Automatizado**
   Configurar pipeline no GitHub Actions para build, testes (unitários + lint) e deploy automatizado em AWS/GCP.

9. **RT09 – Infraestrutura em Docker e IaC**
   Definir Dockerfiles para cada serviço e usar Terraform para provisionar VPC, sub-redes e instâncias na cloud.

---

## 4. Regras de Negócio (RN)

1. **RN01 – Threshold de Alerta**
   O limite para disparo de alerta é chuva acumulada > 30 mm em 24 h **OU** foco de calor detectado acima de 45 °C.

2. **RN02 – Validar Localização**
   Se a geolocalização não estiver disponível ou for imprecisa (±> 100 m), o usuário deve poder informar manualmente latitude/longitude.

3. **RN03 – Prioridade de Rota**
   Abrigos com capacidade restante devem ser listados antes dos lotados;, lotados não aparecem como opção de rota.

4. **RN04 – Sincronização de Checklist**
   Itens marcados como “concluídos” offline só valem para o usuário se sincronizados em até 48 h após reconexão; depois disso, perdem validade.

5. **RN05 – Política de Retenção**
   Logs de alerta e uso do app devem ser mantidos por 90 dias; registros de checklist guardados por 1 ano.

6. **RN06 – Regras de Cancelamento**
   Usuário pode remover um abrigo do seu mapa apenas se não houver nenhum alerta ativo para aquela localização.

7. **RN07 – Conta Inativa**
   Se o usuário não fizer login por 6 meses, a conta é desativada, mas seus dados de checklist são arquivados (somente leitura).

8. **RN08 – Limite de Requisições**
   Cada usuário autenticado pode fazer no máximo 100 requisições de API por minuto; excessos retornam HTTP 429.
