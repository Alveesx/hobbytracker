# 🎯 Gestor de Passatempos (Hobby Tracker)

Aplicação desenvolvida em Java para gestão pessoal de hobbies, atividades de lazer e acompanhamento de progresso (KPIs). O projeto foca-se na aplicação de conceitos de Programação Orientada a Objetos (POO), persistência de dados e interface gráfica.

## 📋 Funcionalidades Principais

### 1. Gestão de Atividades (Core)
* **Registo de Hobbies:** Suporte para diferentes tipos de atividades (Leitura, Gaming, Desporto, etc.) utilizando **Polimorfismo**.
* **Diário de Sessões:** Registo detalhado de sessões realizadas (data, duração, observações) com ordenação cronológica automática.

### 2. Análise e Estatística (Inteligência)
* **Metas vs. Realidade:** Definição de objetivos anuais (ex: "Ler 50 horas este ano") e cálculo automático da percentagem de conclusão.
* **Streaks e Consistência:** Algoritmo que identifica se o utilizador está ativo recentemente ou se abandonou o hobby.
* **Gestão Financeira:** Implementação da interface `Monetizavel` para calcular custos acumulados em hobbies que envolvem despesa (ex: compra de livros, subscrições).

### 3. Interface Gráfica
* Desenvolvida em **JavaFX** com layout desenhado via **Scene Builder**.
* Visualização de dados em tabelas dinâmicas.

---

## 🛠️ Arquitetura e Decisões Técnicas

O projeto segue uma separação clara entre a lógica de negócio e a interface visual.

### Backend (`package backend`)
* **`Passatempo` (Abstract Class):** Classe base que define o comportamento comum e implementa `Serializable` e `Comparable`.
* **`Monetizavel` (Interface):
