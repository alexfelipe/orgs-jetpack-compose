# Orgs

Projeto de simulação de um e-commerce de produtos naturais

## 🔨 Funcionalidades do projeto

O App lista e cadastra produtos com imagem, nome, descrição e valor:

![image](https://user-images.githubusercontent.com/8989346/125341595-268f7700-e32a-11eb-8063-0d4876cb3a4d.png)

## ✔️ Técnicas e tecnologias utilizadas

- `Kotlin`: linguagem padrão do projeto
- `Jetpack Compose`: framework de criação de telas com o padrão de UI declarativa
  - `Scaffold`: base para utilizar os componentes do material
    - `TopAppBar`: barra do topo do App
    - `FloatingActionButton`: botão para acessar formulário de produto
  - `Card`: container de cada item do produto
  - `Column`: ordenação dos composables em coluna
  - `Text`: apresentação de texto do nome, descrição e valor
  - `Image`: carregamento de imagens
  - `OutlinedTextField`: campo de texto para inserir as informações do produto
  - `Button`: botão para salvar produtos
  - `LazyColumn`: carregamento dos itens do produto dinacamente
  - `Coil`: biblioteca para carregar imagens a partir de URLs
- `Navigation`: configuração de nevagação de telas
- `DAO`: padrão para salvar e oferecer produtos em memória (as informações são perdidas ao reiniciar o App)
- `Extração de componentes`: criação e separação de componentes em arquivos distintos para isolar e reutilizar

## 📁 Acesso ao projeto

Você pode acessar o projeto a partir da branch [dev](https://github.com/alexfelipe/orgs-jetpack-compose/tree/dev). Se preferir, pode [baixá-la também como um zip](https://github.com/alexfelipe/orgs-jetpack-compose/archive/refs/heads/dev.zip).

 ## 🛠️ Abrir e rodar o projeto

Após baixar o projeto, você pode abrir com o Android Studio. Para isso, na tela de launcher clique em:

- **Open an Existing Project** (ou alguma opção similar)
- Procure o local onde o projeto está e o selecione (Caso o projeto seja baixado via zip, é necessário extraí-lo antes de procurá-lo)
- Por fim clique em OK

O Android Studio deve executar algumas tasks do Gradle para configurar o projeto, aguarde até finalizar. Ao finalizar as tasks, você pode executar o App 🏆
