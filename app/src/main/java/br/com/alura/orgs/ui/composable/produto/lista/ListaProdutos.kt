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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.orgs.R
import br.com.alura.orgs.extensions.formataParaMoeda
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.theme.Green800
import com.google.accompanist.coil.rememberCoilPainter
import java.math.BigDecimal

@Composable
fun ListaProdutos(produtos: List<Produto>) {
    LazyColumn {
        items(produtos) { produto ->
            ProdutoItem(
                produto = produto,
            )
        }
    }
}

@Composable
fun ProdutoItem(produto: Produto) {
    val imagem = produto.image?.let {
        rememberCoilPainter(it, requestBuilder = {
            placeholder(R.drawable.placeholder)
        })
    } ?: painterResource(id = R.drawable.imagem_padrao)
    ProdutoItem(produto = produto, imagem)
}

@Composable
private fun ProdutoItem(
    produto: Produto,
    imagem: Painter = painterResource(id = R.drawable.imagem_padrao)
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(16.dp),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {

            Image(
                painter = imagem,
                contentDescription = "Imagem do produto",
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = produto.nome,
                maxLines = 2,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = produto.descricao,
                fontSize = 14.sp,
                maxLines = 1,
                modifier = Modifier.padding(top = 8.dp),
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = produto.valor.formataParaMoeda(),
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
fun ProdutoItemPreview() {
    ProdutoItem(
        produto = Produto(
            nome = "teste nome",
            descricao = "teste descrição",
            valor = BigDecimal("19.99")
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun ListaProdutoPreview() {
    ListaProdutos(
        listOf(
            Produto(
                nome = "teste nome 1",
                descricao = "teste descrição 1",
                valor = BigDecimal("9.99")
            ),
            Produto(
                nome = "teste nome 2",
                descricao = "teste descrição 2",
                valor = BigDecimal("19.99")
            ),
        )
    )
}