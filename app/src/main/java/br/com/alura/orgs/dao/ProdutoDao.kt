package br.com.alura.orgs.dao

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class ProdutoDao {

    companion object {
        private val produtos = mutableListOf(
            Produto(
                nome = LoremIpsum().values.joinToString(),
                descricao = LoremIpsum().values.joinToString(),
                BigDecimal("19.99"),
                image = "https://images.pexels.com/photos/1132047/pexels-photo-1132047.jpeg"
            ),
            Produto(
                nome = LoremIpsum().values.joinToString(),
                descricao = LoremIpsum().values.joinToString(),
                BigDecimal("19.99"),
                image = "https://images.pexels.com/photos/46174/strawberries-berries-fruit-freshness-46174.jpeg"
            )
        )
    }

    fun todos() = produtos.toList()

    fun salva(vararg produto: Produto) {
        produtos.addAll(produto)
    }

}