package br.com.alura.orgs.ui.composable.produto.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.orgs.R
import br.com.alura.orgs.extensions.formatToCurrency
import br.com.alura.orgs.model.Product
import br.com.alura.orgs.ui.theme.Green800
import com.google.accompanist.coil.rememberCoilPainter
import java.math.BigDecimal

@Composable
fun ProductDetailsScreen(product: Product) {
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {

        val contentHeight = remember {
            64
        }

        Box(
            Modifier
                .wrapContentHeight()
                .padding(bottom = (contentHeight / 2).dp)
        ) {
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
                    .align(Alignment.BottomStart)
                    .offset(y = (contentHeight / 2).dp)
                    .padding(start = 16.dp)
                    .height(contentHeight.dp),
                elevation = 8.dp,
                shape = RoundedCornerShape(28.dp)
            ) {
                Text(
                    product.value.formatToCurrency(),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Bold,
                    color = Green800
                )
            }
        }
        Text(
            product.name,
            Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp,
                    top = 16.dp
                ),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            product.description,
            Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview() {
    ProductDetailsScreen(
        Product(
            name = LoremIpsum(10).values.joinToString(),
            description = LoremIpsum(50).values.joinToString(),
            value = BigDecimal("19.99")
        )
    )
}