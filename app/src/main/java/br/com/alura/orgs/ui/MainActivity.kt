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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.alura.orgs.model.Product
import br.com.alura.orgs.ui.composable.produto.detail.ProductDetailsScreen
import br.com.alura.orgs.ui.composable.produto.formulario.ProductFormScreen
import br.com.alura.orgs.ui.composable.produto.lista.ProductsList
import br.com.alura.orgs.ui.preview.data.models.products
import br.com.alura.orgs.ui.theme.OrgsTheme
import br.com.alura.orgs.ui.viewmodel.ProductDetailsViewModel
import br.com.alura.orgs.ui.viewmodel.ProductFormViewModel
import br.com.alura.orgs.ui.viewmodel.ProductsListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val productsListVM: ProductsListViewModel by viewModels()
    private val productFormVM: ProductFormViewModel by viewModels()
    private val productDetailsVM: ProductDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "OrgsApp"
            ) {

                composable("OrgsApp") {
                    productsListVM.findAll()
                        .collectAsState(initial = null)
                        .value?.let { products ->
                            OrgsAppScreen(
                                onFabClick = {
                                    navController.navigate("productForm")
                                },
                                products = products,
                                onItemClick = {
                                    navController
                                        .navigate("productDetails/${it.id}")
                                }
                            )
                        }
                }
                composable("productForm") {
                    productFormVM //work around to resolve the save feature
                    ProductFormScreen(
                        onClickSave = { product ->
                            navController.popBackStack()
                            lifecycleScope.launch(Dispatchers.IO) {
                                productFormVM.save(product = product)
                            }
                        }
                    )
                }
                composable("productDetails/{id}") {
                    it.arguments?.getString("id")?.let { id ->
                        productDetailsVM.findById(id)
                            .collectAsState(initial = null)
                            .value?.let { product ->
                                ProductDetailsScreen(
                                    product
                                )
                            }
                    }
                }
            }
        }
    }

}

@Composable
private fun OrgsAppScreen(
    onFabClick: () -> Unit = {},
    products: List<Product>,
    onItemClick: (product: Product) -> Unit = {}
) {
    OrgsTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Orgs") })
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    onFabClick()
                }) {
                    Icon(
                        Icons.Filled.Add, "new product"
                    )
                }
            }
        ) {
            ProductsList(
                products = products,
                onItemClick = {
                    onItemClick(it)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    OrgsAppScreen(
        products = products
    )
}