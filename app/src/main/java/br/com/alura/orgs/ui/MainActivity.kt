package br.com.alura.orgs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.alura.orgs.ui.composable.produto.formulario.ProductForm
import br.com.alura.orgs.ui.composable.produto.lista.ProductsList
import br.com.alura.orgs.ui.theme.OrgsTheme
import br.com.alura.orgs.ui.viewmodel.ProductFormViewModel
import br.com.alura.orgs.ui.viewmodel.ProductsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val productsListVM: ProductsListViewModel by viewModels()
    private val productFormVM: ProductFormViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "OrgsApp"
            ) {
                composable("OrgsApp") {
                    OrgsApp(
                        viewModel = productsListVM,
                        navController = navController
                    )
                }
                composable("productForm") {
                    ProductForm(
                        viewModel = productFormVM,
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
private fun OrgsApp(
    viewModel: ProductsListViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
) {

    OrgsTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Orgs") })
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    navController.navigate("productForm")
                }) {
                    Icon(
                        Icons.Filled.Add, "new product"
                    )
                }
            }
        ) {
            val products = viewModel.findAll().collectAsState(initial = emptyList())
            ProductsList(products = products.value)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    OrgsApp()
}