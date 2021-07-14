package br.com.alura.orgs.ui.composable.produto.lista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.orgs.R
import br.com.alura.orgs.extensions.formatToCurrency
import br.com.alura.orgs.model.Product
import br.com.alura.orgs.ui.theme.Green800
import com.google.accompanist.coil.rememberCoilPainter
import java.math.BigDecimal

@Composable
fun ProductsList(products: List<Product>) {
    LazyColumn {
        items(products) { product ->
            ProductItem(
                product = product,
            )
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    val image = rememberCoilPainter(
        product.image ?: R.drawable.default_image,
        requestBuilder = {
            placeholder(R.drawable.placeholder)
            error(R.drawable.error)
        },
        previewPlaceholder = R.drawable.default_image
    )
    ProductItem(product = product, image)
}

@Composable
private fun ProductItem(
    product: Product,
    image: Painter = rememberCoilPainter(
        R.drawable.default_image,
        previewPlaceholder = R.drawable.default_image,
        requestBuilder = {
            placeholder(R.drawable.placeholder)
            error(R.drawable.error)
        }
    )
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(16.dp),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {

            Image(
                painter = image,
                contentDescription = "product image",
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = product.name,
                maxLines = 2,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = product.description,
                fontSize = 14.sp,
                maxLines = 1,
                modifier = Modifier.padding(top = 8.dp),
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = product.value.formatToCurrency(),
                modifier = Modifier.padding(top = 8.dp),
                fontWeight = FontWeight.Bold,
                color = Green800,
                fontSize = 18.sp
            )
        }
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    ProductItem(
        product = Product(
            name = "test name",
            description = "test description",
            value = BigDecimal("19.99")
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun ProductsListPreview() {
    ProductsList(
        listOf(
            Product(
                name = "test name 1",
                description = "test description 1",
                value = BigDecimal("9.99")
            ),
            Product(
                name = "test name 2",
                description = "test description 2",
                value = BigDecimal("19.99")
            ),
        )
    )
}