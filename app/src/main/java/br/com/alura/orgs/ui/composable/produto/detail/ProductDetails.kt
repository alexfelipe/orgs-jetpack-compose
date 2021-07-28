package br.com.alura.orgs.ui.composable.produto.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.alura.orgs.R
import br.com.alura.orgs.extensions.formatToCurrency
import br.com.alura.orgs.model.Product
import br.com.alura.orgs.ui.viewmodel.ProductDetailsViewModel
import com.google.accompanist.coil.rememberCoilPainter
import java.math.BigDecimal

@Composable
fun ProductDetails(
    id: String,
    viewModel: ProductDetailsViewModel = viewModel(),
) {
    viewModel
        .findById(id)
        .collectAsState(initial = null).value?.let { product ->
            ProductDetails(product = product)
        }
}

@Composable
private fun ProductDetails(product: Product) {
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Box(Modifier
            .wrapContentHeight()
            .padding(bottom = 32.dp)) {
            Image(
                painter = rememberCoilPainter(
                    request = product.image ?: R.drawable.default_image,
                    requestBuilder = {
                        placeholder(R.drawable.placeholder)
                        error(R.drawable.error)
                    },
                    previewPlaceholder = R.drawable.default_image
                ),
                contentDescription = "Product Image",
                Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )
            Card(
                Modifier
                    .align(Alignment.BottomStart),
                elevation = 8.dp,
            ) {
                Text(
                    product.value.formatToCurrency(),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        Text(product.name)
        Text(product.description)
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview() {
    ProductDetails(
        Product(
            name = "test name",
            description = "test desc",
            value = BigDecimal("19.99")
        )
    )
}