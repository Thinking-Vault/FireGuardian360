# FireGuardian360

## Descritivo do Projeto

O projeto visa estruturar um banco de dados relacional para apoiar o monitoramento e combate às queimadas no Brasil. O sistema integra dados de sensores de detecção de focos de incêndio, registros históricos de queimadas, informações meteorológicas, características da vegetação e ações das autoridades responsáveis. O objetivo é oferecer uma base sólida de dados que permita análises preditivas, emissão de alertas e suporte à tomada de decisão para ações emergenciais, fiscalização ambiental e planejamento estratégico.

## Entidades e Significados

| Entidade         | Sigla | Descrição                                                                                   |
|------------------|-------|--------------------------------------------------------------------------------------------|
| **QUEIMADA**     | QMD   | Registro de uma queimada detectada em uma determinada localidade.                           |
| **SENSOR**       | SNS   | Equipamento responsável por detectar focos de incêndio e coletar dados ambientais.          |
| **LOCALIZAÇÃO**  | LOC   | Informações geográficas da área onde a queimada foi detectada.                              |
| **VEGETAÇÃO**    | VGT   | Tipo predominante de vegetação na área afetada pela queimada.                               |
| **METEOROLOGIA** | MTR   | Dados climáticos coletados no momento ou próximos da ocorrência da queimada.                |
| **AÇÃO_COMBATE** | ACB   | Ação executada pelas autoridades para conter ou combater o foco de incêndio.                |

## **Atributos, Significados e Identificadores**

### `QUEIMADA (QMD)`

| Coluna               | Significado Real                        |
| -------------------- | --------------------------------------- |
| `ID_QMD`    | Identificador único do foco de queimada |
| `DT_QMD_OCORRENCIA`  | Data da ocorrência                      |
| `TP_QMD_INTENSIDADE` | Intensidade do foco (baixa/média/alta)  |
| `ID_LOC_LOCALIZACAO` | Localização onde ocorreu                |
| `ID_SNS_SENSOR`      | Sensor que detectou                     |
| `ID_VGT_VEGETACAO`   | Tipo de vegetação da área afetada       |

🔑 **Identificador:** `ID_QMD`

---

### `SENSOR (SNS)`

| Coluna          | Significado Real                      |
| --------------- | ------------------------------------- |
| `ID_SNS` | Identificador do sensor               |
| `NM_SNS_MODELO` | Modelo do sensor                      |
| `TP_SNS_TIPO`   | Tipo de sensor (térmico, óptico etc.) |
| `ST_SNS_STATUS` | Status (ativo/inativo)                |

🔑 **Identificador:** `ID_SNS`

---

### `LOCALIZACAO (LOC)`

| Coluna               | Significado Real             |
| -------------------- | ---------------------------- |
| `ID_LOC` | Identificador da localização |
| `NM_LOC_REGIAO`      | Nome da região               |
| `SG_LOC_UF`          | Sigla do estado              |
| `NR_LOC_LATITUDE`    | Latitude                     |
| `NR_LOC_LONGITUDE`   | Longitude                    |

🔑 **Identificador:** `ID_LOC`

---

### `VEGETACAO (VGT)`

| Coluna                  | Significado Real                      |
| ----------------------- | ------------------------------------- |
| `ID_VGT`      | Identificador do tipo de vegetação    |
| `NM_VGT_TIPO`           | Nome do tipo (cerrado, floresta etc.) |
| `DS_VGT_CARACTERISTICA` | Descrição geral do tipo de vegetação  |

🔑 **Identificador:** `ID_VGT`

---

### `METEOROLOGIA (MTR)`

| Coluna                | Significado Real                |
| --------------------- | ------------------------------- |
| `ID_MTR` | Identificador do dado climático |
| `DT_MTR_COLETA`       | Data da coleta                  |
| `MD_MTR_TEMPERATURA`  | Temperatura (°C)                |
| `PC_MTR_UMIDADE`      | Umidade relativa (%)            |
| `MD_MTR_VENTO`        | Velocidade do vento (km/h)      |
| `ID_LOC_LOCALIZACAO`  | Referência geográfica           |

🔑 **Identificador:** `ID_MTR`

---

### `ACAO_COMBATE (ACB)`

| Coluna             | Significado Real                     |
| ------------------ | ------------------------------------ |
| `ID_ACB`      | Identificador da ação                |
| `ID_QMD_QUEIMADA`  | Foco de queimada atendido            |
| `DT_ACB_EXECUCAO`  | Data da ação                         |
| `TP_ACB_TIPO`      | Tipo de ação (aérea, terrestre etc.) |
| `DS_ACB_RESULTADO` | Resultado da ação                    |

🔑 **Identificador:** `ID_ACB`

---

## **Relacionamentos e Cardinalidades**

### 📍 `QUEIMADA` → `LOCALIZACAO`

* **Significado:** Uma queimada ocorre em um local específico.
* **Cardinalidade:** Muitas queimadas podem ocorrer em uma mesma localização (N:1).
* **FK:** `FK_QMD_LOC`

---

### 🔍 `QUEIMADA` → `SENSOR`

* **Significado:** Cada foco de incêndio é detectado por um sensor.
* **Cardinalidade:** Muitos focos podem ser detectados por um mesmo sensor (N:1).
* **FK:** `FK_QMD_SNS`

---

### 🌿 `QUEIMADA` → `VEGETACAO`

* **Significado:** A vegetação define o tipo de cobertura onde a queimada ocorreu.
* **Cardinalidade:** Muitas queimadas podem afetar o mesmo tipo de vegetação (N:1).
* **FK:** `FK_QMD_VGT`

---

### 🌡️ `METEOROLOGIA` → `LOCALIZACAO`

* **Significado:** Os dados climáticos são vinculados a um local.
* **Cardinalidade:** Muitos registros de clima para um local (N:1).
* **FK:** `FK_MTR_LOC`

---

### 🧯 `ACAO_COMBATE` → `QUEIMADA`

* **Significado:** Representa a ação tomada para um foco de queimada específico.
* **Cardinalidade:** Uma queimada pode ter várias ações de combate (1\:N).
* **FK:** `FK_ACB_QMD`
