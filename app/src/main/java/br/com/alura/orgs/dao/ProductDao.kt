package br.com.alura.orgs.dao

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.orgs.model.Product
import java.math.BigDecimal
import javax.inject.Inject

class ProductDao @Inject constructor() {

    companion object {
        private val products = mutableListOf(
            Product(
                name = LoremIpsum().values.joinToString(),
                description = LoremIpsum().values.joinToString(),
                BigDecimal("19.99"),
                image = "https://images.pexels.com/photos/1132047/pexels-photo-1132047.jpeg"
            ),
            Product(
                name = LoremIpsum().values.joinToString(),
                description = LoremIpsum().values.joinToString(),
                BigDecimal("1999.99"),
                image = ""
            ),
            Product(
                name = LoremIpsum().values.joinToString(),
                description = LoremIpsum().values.joinToString(),
                BigDecimal("199.99"),
            ),
        )
    }

    fun all() = products.toList()

    fun save(vararg product: Product) {
        products.addAll(product)
    }

}