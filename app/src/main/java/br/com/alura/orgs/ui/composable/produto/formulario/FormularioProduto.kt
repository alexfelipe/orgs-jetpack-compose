package br.com.alura.orgs.ui.composable.produto.formulario

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.alura.orgs.dao.ProdutoDao
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

@Composable
fun FormularioProduto(
    navController: NavHostController = rememberNavController()
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        var nome by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = nome,
            onValueChange = {
                nome = it
            },
            label = {
                Text(text = "Nome")
            },
            modifier = Modifier.fillMaxWidth()
        )
        var descricao by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = descricao,
            onValueChange = {
                descricao = it
            },
            label = {
                Text(text = "Descrição")
            },
            modifier = Modifier.fillMaxWidth()
        )
        var valor by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = valor,
            onValueChange = {
                valor = it
            },
            label = {
                Text(text = "Valor")
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default
                .copy(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = {
                val produtoNovo = Produto(
                    nome = nome,
                    descricao = descricao,
                    valor = BigDecimal(valor)
                )
                ProdutoDao().salva(produtoNovo)
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 8.dp,
                    bottom = 8.dp
                )
        ) {
            Text(text = "Salvar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormularioProdutoPreview() {
    FormularioProduto()
}