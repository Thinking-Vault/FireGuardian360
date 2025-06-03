# FireGuardian 360

FireGuardian 360 propõe um PWA multiplataforma para prevenir e mitigar desastres climáticos extremos, com ênfase em focos de incêndio.  
Ele ingere dados meteorológicos e de satélite, gera alertas automáticos por TTS e push, mostra num mapa 3D (three.js) abrigos voluntários próximos e calcula rotas de evacuação pela rota mais curta.  
Usuários mantêm um checklist de itens de emergência sincronizado offline/online e, em casos de estresse ou trauma, acessam o PsyHelp, um chat em tempo real com psicólogos voluntários e bot de primeiros socorros psicológicos.  
Tudo isso roda num backend Java/Spring Boot organizado em contextos (Forecast, Shelter, Checklist e PsyHelp), persiste em Oracle (índices geoespaciais) e escala via Docker + cloud. A MVP foca na geração de alertas, mapeamento de abrigos, checklist CRUD e chat, garantindo resiliência comunitária e suporte humano imediato.

## Diagrama de Classes

![Diagra de classes](./../../test.html/Class%20Diagram0.png)
