# Orgs

Projeto de simulação de um e-commerce de produtos naturais

## 🔨 Funcionalidades do projeto

O App lista e cadastra produtos com imagem, nome, descrição e valor:

![orgs-compose-with-dialog](https://user-images.githubusercontent.com/8989346/125638297-56bf1082-2898-40ad-bc8b-ee09f8c2d01e.gif)

## ✔️ Técnicas e tecnologias utilizadas

- `Kotlin`: linguagem padrão do projeto
- `Jetpack Compose`: framework de criação de telas com o padrão de UI declarativa
  - `Scaffold`: base para utilizar os componentes do material
    - `TopAppBar`: barra do topo do App
    - `FloatingActionButton`: botão para acessar formulário de produto
  - `Card`: container de cada item do produto
  - `Column`: ordenação dos composables em coluna
  - `Box`: container para alinhar composables sobre o outro
  - `Text`: apresentação de texto do nome, descrição e valor
  - `Image`: carregamento de imagens
  - `OutlinedTextField`: campo de texto para inserir as informações do produto
  - `Button`: botão para salvar produtos
  - `LazyColumn`: carregamento dos itens do produto dinacamente
  - `Coil`: biblioteca para carregar imagens a partir de URLs
  - `Dialog`: caixa de diálogo para inserir imagens
  - `TextButton`: botões para a caixa de diálogo
- `Navigation`: configuração de nevagação de telas
- `Hilt`: lib para [injeção de dependência](https://www.alura.com.br/artigos/injecao-de-dependencia-do-android-com-o-hilt).
- `ViewModel`: componente para lidar com os dados de cada tela (Composable)
- `Room`: lib para facilitar a comunicação com o banco de dados utilizando o SQLite
  - `DAO`: padrão para salvar e oferecer produtos.
  - `Entity`: definição de campos que devem ser salvos no banco de dados
- `Extração de componentes`: criação e separação de componentes em arquivos distintos para isolar e reutilizar

## 📁 Acesso ao projeto

Você pode acessar o projeto a partir da branch [dev](https://github.com/alexfelipe/orgs-jetpack-compose/tree/dev). Se preferir, pode [baixá-la também como um zip](https://github.com/alexfelipe/orgs-jetpack-compose/archive/refs/heads/dev.zip).

 ## 🛠️ Abrir e rodar o projeto

Após baixar o projeto, você pode abrir com o Android Studio. o Jetpack Compose etá em beta ainda, portanto, você deve usar a versão [Arctic Fox | 2020.3.1 Beta 5 do AS](https://developer.android.com/studio/preview) para abrir o projeto. Após instalar esta versão e abrir a tela de launcher clique em:

- **Open** (ou uma opção similar para abrir projetos) (ou alguma opção similar)
- Procure o local onde o projeto está e o selecione (Caso o projeto seja baixado via zip, é necessário extraí-lo antes de procurá-lo)
- Por fim clique em OK

O Android Studio deve executar algumas tasks do Gradle para configurar o projeto, aguarde até finalizar. Ao finalizar as tasks, você pode executar o App 🏆
