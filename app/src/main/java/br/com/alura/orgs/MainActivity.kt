package br.com.alura.orgs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.alura.orgs.dao.ProdutoDao
import br.com.alura.orgs.ui.composable.produto.formulario.FormularioProduto
import br.com.alura.orgs.ui.composable.produto.lista.ListaProdutos
import br.com.alura.orgs.ui.theme.OrgsTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "OrgsApp") {
                composable("OrgsApp") {
                    OrgsApp(navController = navController)
                }
                composable("formularioProduto") {
                    FormularioProduto(navController = navController)
                }
            }
        }
    }
}

@Composable
private fun OrgsApp(
    dao: ProdutoDao = ProdutoDao(),
    navController: NavHostController = rememberNavController()
) {

    OrgsTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Orgs") })
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    navController.navigate("formularioProduto")
                }) {
                    Icon(
                        Icons.Filled.Add, "Novo produto"
                    )
                }
            }
        ) {
            val produtos = remember {
                dao.todos()
            }
            ListaProdutos(produtos)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    OrgsApp()
}