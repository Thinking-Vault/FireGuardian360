-- Comentários de Tabelas
COMMENT ON TABLE USR IS    'Entidade USR: armazena os usuários do sistema.';
COMMENT ON TABLE ALT IS    'Entidade ALT: registra alertas gerados pelos usuários.';
COMMENT ON TABLE SHL IS    'Entidade SHL: armazena informações de abrigos disponíveis.';
COMMENT ON TABLE CLI IS    'Entidade CLI: itens de checklist de cada usuário.';
COMMENT ON TABLE CSS IS    'Entidade CSS: sessões de chat iniciadas pelos usuários.';
COMMENT ON TABLE CMT IS    'Entidade CMT: mensagens trocadas em cada sessão de chat.';

-- Comentários de Colunas USR
COMMENT ON COLUMN USR.ID_USR_USER          IS 'PK: identificador único do usuário.';
COMMENT ON COLUMN USR.CD_USR_EMAIL         IS 'E-mail do usuário (único, obrigatório).';
COMMENT ON COLUMN USR.TX_USR_PASSWORD_HASH IS 'Hash da senha do usuário.';
COMMENT ON COLUMN USR.DH_USR_CREATED_AT    IS 'Data e hora de criação do registro.';

-- Comentários de Colunas ALT
COMMENT ON COLUMN ALT.ID_ALT_ALERT         IS 'PK: identificador único do alerta.';
COMMENT ON COLUMN ALT.ID_USR_USER          IS 'FK → USR.ID_USR_USER: usuário que gerou o alerta.';
COMMENT ON COLUMN ALT.TP_ALT_TYPE          IS 'Tipo do alerta (ex.: CHUVA, FOGO).';
COMMENT ON COLUMN ALT.NR_ALT_LEVEL         IS 'Nível de gravidade do alerta.';
COMMENT ON COLUMN ALT.DH_ALT_CREATED_AT    IS 'Data e hora em que o alerta foi criado.';
COMMENT ON COLUMN ALT.MD_ALT_LAT           IS 'Latitude do ponto do alerta.';
COMMENT ON COLUMN ALT.MD_ALT_LNG           IS 'Longitude do ponto do alerta.';

-- Comentários de Colunas SHL
COMMENT ON COLUMN SHL.ID_SHL_SHELTER       IS 'PK: identificador único do abrigo.';
COMMENT ON COLUMN SHL.NM_SHL_NAME          IS 'Nome do abrigo.';
COMMENT ON COLUMN SHL.MD_SHL_LAT           IS 'Latitude do abrigo.';
COMMENT ON COLUMN SHL.MD_SHL_LNG           IS 'Longitude do abrigo.';
COMMENT ON COLUMN SHL.QT_SHL_CAPACITY      IS 'Capacidade total do abrigo.';
COMMENT ON COLUMN SHL.QT_SHL_AVAILABLE     IS 'Número de vagas disponíveis atualmente.';

-- Comentários de Colunas CLI
COMMENT ON COLUMN CLI.ID_CLI_ITEM          IS 'PK: identificador único do item de checklist.';
COMMENT ON COLUMN CLI.ID_USR_USER          IS 'FK → USR.ID_USR_USER: usuário dono do item.';
COMMENT ON COLUMN CLI.NM_CLI_LABEL         IS 'Descrição do item de checklist.';
COMMENT ON COLUMN CLI.ST_CLI_STATUS        IS 'Status do item (P=pendente, C=concluído).';
COMMENT ON COLUMN CLI.DH_CLI_UPDATED_AT    IS 'Data e hora da última atualização do status.';

-- Comentários de Colunas CSS
COMMENT ON COLUMN CSS.ID_CSS_SESSION       IS 'PK: identificador único da sessão de chat.';
COMMENT ON COLUMN CSS.ID_USR_USER          IS 'FK → USR.ID_USR_USER: usuário participante.';
COMMENT ON COLUMN CSS.DH_CSS_STARTED_AT    IS 'Data e hora de início da sessão.';
COMMENT ON COLUMN CSS.DH_CSS_ENDED_AT      IS 'Data e hora de término da sessão.';

-- Comentários de Colunas CMT
COMMENT ON COLUMN CMT.ID_CMT_MESSAGE       IS 'PK: identificador único da mensagem.';
COMMENT ON COLUMN CMT.ID_CSS_SESSION       IS 'FK → CSS.ID_CSS_SESSION: sessão a que a mensagem pertence.';
COMMENT ON COLUMN CMT.TP_CMT_SENDER        IS 'Origem da mensagem (USER, BOT, PSY).';
COMMENT ON COLUMN CMT.TX_CMT_TEXT          IS 'Conteúdo textual da mensagem.';
COMMENT ON COLUMN CMT.DH_CMT_SENT_AT       IS 'Data e hora em que a mensagem foi enviada.';
