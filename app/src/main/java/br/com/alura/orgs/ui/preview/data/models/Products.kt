package br.com.alura.orgs.ui.preview.data.models

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.orgs.model.Product
import java.math.BigDecimal

val products = listOf(
    Product(
        name = LoremIpsum(20).values.joinToString(),
        description = LoremIpsum(30).values.joinToString(),
        value = BigDecimal("19.99")
    ),
    Product(
        name = LoremIpsum(20).values.joinToString(),
        description = LoremIpsum(30).values.joinToString(),
        value = BigDecimal("19.99")
    ),
)