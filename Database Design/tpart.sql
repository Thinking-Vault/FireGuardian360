------------------------------------------------------------------------
-- 1) Tabela: AÇÃO_COMBATE
-- Descrição: Registra as ações de combate executadas em focos de queimada.
------------------------------------------------------------------------
CREATE TABLE ACAO_COMBATE (
    QUEIMADA_QMD_ID    NUMBER            NOT NULL,
    ID_QMD             NUMBER            NOT NULL,
    DT_ACB_EXECUCAO    TIMESTAMP(6)      NOT NULL,
    TP_ACB_TIPO        VARCHAR2(20 CHAR) NOT NULL,
    DS_ACB_RESULTADO   VARCHAR2(4000 CHAR),
    CONSTRAINT PK_ACAO_COMBATE PRIMARY KEY (QUEIMADA_QMD_ID, ID_QMD)
);

COMMENT ON TABLE ACAO_COMBATE IS
    'Registra as ações de combate executadas para cada foco de queimada.';
COMMENT ON COLUMN ACAO_COMBATE.QUEIMADA_QMD_ID IS
    'FK para a tabela QUEIMADA, identifica o foco de queimada.';
COMMENT ON COLUMN ACAO_COMBATE.ID_QMD IS
    'Identificador único da ação de combate.';
COMMENT ON COLUMN ACAO_COMBATE.DT_ACB_EXECUCAO IS
    'Data e hora em que a ação de combate foi realizada.';
COMMENT ON COLUMN ACAO_COMBATE.TP_ACB_TIPO IS
    'Tipo de ação de combate (ex.: Pulverização, Resfriamento, Contenção).';
COMMENT ON COLUMN ACAO_COMBATE.DS_ACB_RESULTADO IS
    'Descrição do resultado observado após a ação de combate.';


------------------------------------------------------------------------
-- 2) Tabela: ALERT
-- Descrição: Armazena alertas gerados por sensores ou usuários.
------------------------------------------------------------------------
CREATE TABLE ALERT (
    SENSOR_DATA_SND_ID   NUMBER            NOT NULL,
    QUEIMADA_QMD_ID      NUMBER            NOT NULL,
    USER_USR_ID          NUMBER            NOT NULL,
    ID_USR               NUMBER            NOT NULL,
    ID_ALT_ALERT         NUMBER            NOT NULL,
    TP_ALT_TYPE          VARCHAR2(50 CHAR) NOT NULL,
    NR_ALT_LEVEL         NUMBER(1)         NOT NULL,
    DH_ALT_CREATED_AT    TIMESTAMP(6)      NOT NULL,
    NR_ALT_LNG           NUMBER(9,6)       NOT NULL,
    ID_ALT_ALERT_5       VARCHAR2(36 CHAR) NOT NULL,
    ID_QMD               NUMBER            NOT NULL,
    CONSTRAINT PK_ALERT      PRIMARY KEY (ID_ALT_ALERT)
    -- Você pode adicionar FKs para SENSOR_DATA, QUEIMADA, USUARIO aqui
);

COMMENT ON TABLE ALERT IS
    'Registra todos os alertas emitidos por sensores ou solicitados por usuários.';
COMMENT ON COLUMN ALERT.SENSOR_DATA_SND_ID IS
    'FK para SENSOR_DATA, identifica o sensor que gerou o alerta.';
COMMENT ON COLUMN ALERT.QUEIMADA_QMD_ID IS
    'FK para QUEIMADA, quando o alerta é relacionado a um foco identificado.';
COMMENT ON COLUMN ALERT.USER_USR_ID IS
    'FK para USUARIO, usuário que confirmou/acionou o alerta.';
COMMENT ON COLUMN ALERT.ID_USR IS
    'Identificador interno do usuário na sessão.';
COMMENT ON COLUMN ALERT.TP_ALT_TYPE IS
    'Tipo de alerta (ex.: Fumaça, Chama, Nível Crítico).';
COMMENT ON COLUMN ALERT.NR_ALT_LEVEL IS
    'Nível de severidade do alerta (0-9).';
COMMENT ON COLUMN ALERT.DH_ALT_CREATED_AT IS
    'Data e hora de criação do alerta.';
COMMENT ON COLUMN ALERT.NR_ALT_LNG IS
    'Longitude do ponto de alerta (graus decimais).';
COMMENT ON COLUMN ALERT.ID_ALT_ALERT_5 IS
    'UUID externo do alerta para integração com sistemas terceiros.';
COMMENT ON COLUMN ALERT.ID_QMD IS
    'ID de queimada associado, sinônimo de QUEIMADA_QMD_ID.';


------------------------------------------------------------------------
-- 3) Tabela: CHAT_MESSAGE
-- Descrição: Mensagens trocadas em cada sessão de chat.
------------------------------------------------------------------------
CREATE TABLE CHAT_MESSAGE (
    CHAT_SESSION_CTS_ID   NUMBER            NOT NULL,
    ID_CTM_MESSAGE        NUMBER            NOT NULL,
    TX_CTM_CONTENT        CLOB              NOT NULL,
    ID_CTS_SESSION        VARCHAR2(36 CHAR) NOT NULL,
    TX_CTM_CONTENT_1      VARCHAR2(4000 CHAR) NOT NULL,
    CHAT_SESSION_ID_USR   NUMBER            NOT NULL,
    CONSTRAINT PK_CHAT_MESSAGE PRIMARY KEY (ID_CTM_MESSAGE)
    -- FKs: CHAT_SESSION_CTS_ID -> CHAT_SESSION.CTS_ID
);

COMMENT ON TABLE CHAT_MESSAGE IS
    'Guarda o histórico de mensagens em cada sessão de chat.';
COMMENT ON COLUMN CHAT_MESSAGE.CHAT_SESSION_CTS_ID IS
    'FK para CHAT_SESSION, identifica a sessão de chat.';
COMMENT ON COLUMN CHAT_MESSAGE.ID_CTM_MESSAGE IS
    'Identificador único da mensagem.';
COMMENT ON COLUMN CHAT_MESSAGE.TX_CTM_CONTENT IS
    'Conteúdo completo da mensagem (CLOB).';
COMMENT ON COLUMN CHAT_MESSAGE.ID_CTS_SESSION IS
    'UUID da sessão de chat para rastreamento externo.';
COMMENT ON COLUMN CHAT_MESSAGE.TX_CTM_CONTENT_1 IS
    'Pré-visualização ou resumo da mensagem (até 4000 chars).';
COMMENT ON COLUMN CHAT_MESSAGE.CHAT_SESSION_ID_USR IS
    'ID do usuário autor da mensagem naquele chat.';


------------------------------------------------------------------------
-- 4) Tabela: CHAT_SESSION
-- Descrição: Sessões ativas de chat entre usuários e o sistema.
------------------------------------------------------------------------
CREATE TABLE CHAT_SESSION (
    CTS_ID             NUMBER            NOT NULL,
    USER_USR_ID        NUMBER            NOT NULL,
    ID_USR             NUMBER            NOT NULL,
    ID_CTS_SESSION     VARCHAR2(36 CHAR) NOT NULL,
    ID_ALT_ALERT_1     VARCHAR2(36 CHAR) NOT NULL,
    CONSTRAINT PK_CHAT_SESSION PRIMARY KEY (CTS_ID)
    -- FKs: USER_USR_ID -> USUARIO.USR_ID, ID_ALT_ALERT_1 -> ALERT.ID_ALT_ALERT
);

COMMENT ON TABLE CHAT_SESSION IS
    'Registra cada sessão de chat iniciada pelo usuário.';
COMMENT ON COLUMN CHAT_SESSION.CTS_ID IS
    'Identificador sequencial da sessão de chat.';
COMMENT ON COLUMN CHAT_SESSION.USER_USR_ID IS
    'FK para USUARIO, usuário que iniciou a sessão.';
COMMENT ON COLUMN CHAT_SESSION.ID_USR IS
    'ID interno do usuário nesta sessão.';
COMMENT ON COLUMN CHAT_SESSION.ID_CTS_SESSION IS
    'UUID global da sessão de chat.';
COMMENT ON COLUMN CHAT_SESSION.ID_ALT_ALERT_1 IS
    'UUID do alerta associado, caso a sessão seja disparada por um alerta.';

------------------------------------------------------------------------
-- 5) Ajustes na tabela CHAT_SESSION
------------------------------------------------------------------------
ALTER TABLE CHAT_SESSION
  DROP CONSTRAINT PK_CHAT_SESSION;  -- remove PK anterior

ALTER TABLE CHAT_SESSION
  ADD CONSTRAINT CHAT_SESSION_PK PRIMARY KEY (ID_CTS_SESSION, ID_USR);

ALTER TABLE CHAT_SESSION
  ADD CONSTRAINT CHAT_SESSION_UQ_CTS_ID UNIQUE (CTS_ID);


------------------------------------------------------------------------
-- 6) Tabela: CHECKLIST_ITEM
-- Descrição: Itens de checklist vinculados a alertas e usuários.
------------------------------------------------------------------------
CREATE TABLE CHECKLIST_ITEM (
  USER_USR_ID     NUMBER            NOT NULL,
  ID_USR          NUMBER            NOT NULL,
  ID_CKI_ITEM     VARCHAR2(36 CHAR) NOT NULL,
  NM_CKI_LABEL    VARCHAR2(200 CHAR) NOT NULL,
  TP_CKI_STATUS   VARCHAR2(20 CHAR)  NOT NULL,
  ID_ALT_ALERT_3  VARCHAR2(36 CHAR)  NOT NULL,
  CONSTRAINT PK_CHECKLIST_ITEM PRIMARY KEY (ID_CKI_ITEM)
  -- FK(USER_USR_ID, ID_USR) -> USUARIO, FK(ID_ALT_ALERT_3) -> ALERT
);

COMMENT ON TABLE CHECKLIST_ITEM IS
  'Itens de ações pendentes ou concluídas associados a um alerta e usuário.';
COMMENT ON COLUMN CHECKLIST_ITEM.USER_USR_ID IS
  'FK para USUARIO, dono do item de checklist.';
COMMENT ON COLUMN CHECKLIST_ITEM.ID_USR IS
  'ID interno do usuário na sessão.';
COMMENT ON COLUMN CHECKLIST_ITEM.NM_CKI_LABEL IS
  'Texto descritivo do item de checklist.';
COMMENT ON COLUMN CHECKLIST_ITEM.TP_CKI_STATUS IS
  'Status do item (ex.: PENDENTE, CONCLUÍDO).';
COMMENT ON COLUMN CHECKLIST_ITEM.ID_ALT_ALERT_3 IS
  'UUID do alerta associado ao checklist.';


------------------------------------------------------------------------
-- 7) Tabela: FIRE_HISTORY
-- Descrição: Histórico de queimadas, liga focos, vegetação e medidas.
------------------------------------------------------------------------
CREATE TABLE FIRE_HISTORY (
  QUEIMADA_QMD_ID     NUMBER            NOT NULL,
  VEGETATION_VGT_ID   NUMBER            NOT NULL,
  ID_FIH_FIRE         VARCHAR2(36 CHAR) NOT NULL,
  DT_FIH_START        DATE              NOT NULL,
  DT_FIH_END          DATE              NOT NULL,
  VL_FIH_AREA_BURNED  NUMBER(12,2)      NOT NULL,
  DS_FIH_RESOURCES    VARCHAR2(4000 CHAR) NOT NULL,
  ID_VGT_VEGETATION   VARCHAR2(36 CHAR) NOT NULL,
  ID_QMD              NUMBER            NOT NULL,
  CONSTRAINT PK_FIRE_HISTORY PRIMARY KEY (ID_FIH_FIRE)
  -- FK(QUEIMADA_QMD_ID) -> QUEIMADA, FK(VEGETATION_VGT_ID) -> VEGETATION
);

COMMENT ON TABLE FIRE_HISTORY IS
  'Armazena o histórico detalhado de cada evento de queimada.';
COMMENT ON COLUMN FIRE_HISTORY.DT_FIH_START IS
  'Data de início da queimada.';
COMMENT ON COLUMN FIRE_HISTORY.DT_FIH_END IS
  'Data de extinção ou controle da queimada.';
COMMENT ON COLUMN FIRE_HISTORY.VL_FIH_AREA_BURNED IS
  'Área afetada pela queimada em hectares.';
COMMENT ON COLUMN FIRE_HISTORY.DS_FIH_RESOURCES IS
  'Recursos utilizados no combate (e.g., água, retardantes).';


------------------------------------------------------------------------
-- 8) Tabela: LOCALIZACAO
-- Descrição: Pontos geográficos de interesse (sensores, focos, bases).
------------------------------------------------------------------------
CREATE TABLE LOCALIZACAO (
  LOC_ID           NUMBER            NOT NULL,
  ID_LOC           NUMBER            NOT NULL,
  NM_LOC_REGIAO    VARCHAR2(100 CHAR) NOT NULL,
  SG_LOC_UF        CHAR(2 CHAR)      NOT NULL,
  NR_LOC_LATITUDE  NUMBER(9,6)       NOT NULL,
  NR_LOC_LONGITUDE NUMBER(9,6)       NOT NULL,
  SENSOR_DATA_SND_ID NUMBER          NOT NULL,
  CONSTRAINT PK_LOCALIZACAO PRIMARY KEY (ID_LOC),
  CONSTRAINT UQ_LOCALIZACAO_LOC_ID UNIQUE (LOC_ID)
  -- FK(SENSOR_DATA_SND_ID) -> SENSOR_DATA
);

COMMENT ON TABLE LOCALIZACAO IS
  'Registro de regiões, estações e sensores com coordenadas geográficas.';
COMMENT ON COLUMN LOCALIZACAO.NM_LOC_REGIAO IS
  'Nome da região ou localidade.';
COMMENT ON COLUMN LOCALIZACAO.SG_LOC_UF IS
  'Sigla da Unidade Federativa (ex.: SP, MG).';
COMMENT ON COLUMN LOCALIZACAO.NR_LOC_LATITUDE IS
  'Latitude em graus decimais.';
COMMENT ON COLUMN LOCALIZACAO.NR_LOC_LONGITUDE IS
  'Longitude em graus decimais.';


------------------------------------------------------------------------
-- 9) Tabela: METEOROLOGIA
-- Descrição: Coletas de dados meteorológicos por local.
------------------------------------------------------------------------
CREATE TABLE METEOROLOGIA (
  LOCALIZACAO_LOC_ID  NUMBER         NOT NULL,
  ID_LOC              NUMBER         NOT NULL,
  ID_MTR              NUMBER         NOT NULL,
  DT_MTR_COLETA       TIMESTAMP(6)   NOT NULL,
  MD_MTR_TEMPERATURA  NUMBER(5,2)    NOT NULL,
  PC_MTR_UMIDADE      NUMBER(5,2)    NOT NULL,
  MD_MTR_VENTO        NUMBER(5,2)    NOT NULL,
  CONSTRAINT PK_METEOROLOGIA PRIMARY KEY (ID_MTR)
  -- FK(LOCALIZACAO_LOC_ID, ID_LOC) -> LOCALIZACAO
);

COMMENT ON TABLE METEOROLOGIA IS
  'Dados de temperatura, umidade e vento coletados por sensor.';
COMMENT ON COLUMN METEOROLOGIA.MD_MTR_TEMPERATURA IS
  'Temperatura em °C com precisão de duas casas decimais.';
COMMENT ON COLUMN METEOROLOGIA.PC_MTR_UMIDADE IS
  'Umidade relativa do ar em % com duas casas decimais.';
COMMENT ON COLUMN METEOROLOGIA.MD_MTR_VENTO IS
  'Velocidade do vento em m/s com duas casas decimais.';


------------------------------------------------------------------------
-- 10) Tabela: QUEIMADA
-- Descrição: Registro dos focos de incêndio detectados.
------------------------------------------------------------------------
CREATE TABLE QUEIMADA (
  QMD_ID               NUMBER            NOT NULL,
  LOCALIZACAO_LOC_ID   NUMBER            NOT NULL,
  SENSOR_SNS_ID        NUMBER            NOT NULL,
  VEGETATION_VGT_ID    NUMBER            NOT NULL,
  ID_VGT_VEGETATION    VARCHAR2(36 CHAR) NOT NULL,
  ID_LOC               NUMBER            NOT NULL,
  ID_SNS_SENSOR        NUMBER            NOT NULL,
  ID_QMD               NUMBER            NOT NULL,
  DT_QMD_OCORRENCIA    TIMESTAMP(6)      NOT NULL,
  TP_QMD_INTENSIDADE   VARCHAR2(20 CHAR) NOT NULL,
  CONSTRAINT PK_QUEIMADA          PRIMARY KEY (ID_QMD),
  CONSTRAINT UQ_QUEIMADA_QMD_ID   UNIQUE     (QMD_ID)
  -- FK(LOCALIZACAO_LOC_ID) -> LOCALIZACAO
  -- FK(SENSOR_SNS_ID)        -> SENSOR
  -- FK(VEGETATION_VGT_ID)    -> VEGETATION
);

COMMENT ON TABLE QUEIMADA IS
  'Armazena cada foco de queimada detectado por sensores e satélite.';
COMMENT ON COLUMN QUEIMADA.DT_QMD_OCORRENCIA IS
  'Data e hora da ocorrência do foco de queimada.';
COMMENT ON COLUMN QUEIMADA.TP_QMD_INTENSIDADE IS
  'Intensidade do fogo (ex.: BAIXA, MÉDIA, ALTA).';
