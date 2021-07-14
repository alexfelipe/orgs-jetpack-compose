package br.com.alura.orgs.ui.composable.produto.formulario

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProductDao
import br.com.alura.orgs.model.Product
import com.google.accompanist.coil.rememberCoilPainter
import java.math.BigDecimal

@Composable
fun ProductForm(
    navController: NavHostController = rememberNavController()
) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    var image: String? by remember {
        mutableStateOf(null)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {

        if (showDialog) {
            ImageFormDialog(
                image,
                onDismiss = {
                    showDialog = false
                }
            ) { loadedImage ->
                showDialog = false
                image = loadedImage
            }
        }

        Image(
            painter = rememberCoilPainter(
                image ?: R.drawable.default_image,
                previewPlaceholder = R.drawable.default_image
            ),
            contentDescription = "product image",
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    showDialog = true
                },
            contentScale = ContentScale.Crop
        )

        var name by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text(text = "Name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
        )
        var description by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
            },
            label = {
                Text(text = "Description")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 8.dp,
                    end = 16.dp
                )
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
                Text(text = "Value")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 16.dp
                ),
            keyboardOptions = KeyboardOptions.Default
                .copy(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = {
                val newProduct = Product(
                    name = name,
                    description = description,
                    value = BigDecimal(valor),
                    image = image
                )
                ProductDao().save(newProduct)
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 16.dp
                )
        ) {
            Text(text = "Save")
        }
    }
}

@Composable
private fun ImageFormDialog(
    defaultImage: String?,
    onDismiss: () -> Unit,
    onConfirm: (url: String?) -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
    ) {
        ImageForm(
            defaultImage = defaultImage,
            onCancel = onDismiss,
            onConfirm = { loadedImage ->
                onDismiss()
                onConfirm(loadedImage)
            }
        )
    }
}

@Composable
private fun ImageForm(
    defaultImage: String? = null,
    onCancel: () -> Unit = {},
    onConfirm: (image: String?) -> Unit = {}
) {

    var imageUrl by remember {
        mutableStateOf(defaultImage)
    }

    var urlField by remember {
        mutableStateOf(imageUrl ?: "")
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(Modifier.wrapContentHeight()) {
            Box(Modifier.wrapContentHeight()) {
                Image(
                    painter = rememberCoilPainter(
                        imageUrl ?: R.drawable.default_image,
                        requestBuilder = {
                            placeholder(R.drawable.placeholder)
                            error(R.drawable.error)
                        },
                        previewPlaceholder = R.drawable.default_image
                    ),
                    contentDescription = "product image",
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(16.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Button(
                    onClick = {
                        if (urlField.isEmpty()) {
                            imageUrl = null
                            return@Button
                        }
                        imageUrl = urlField
                    },
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Text("Load")
                }

            }

            OutlinedTextField(
                value = urlField,
                onValueChange = {
                    urlField = it
                },
                Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 16.dp)
                    .fillMaxWidth(),
                label = {
                    Text("Image URL")
                }
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 8.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    ),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = onCancel) {
                    Text(text = "Cancel")
                }
                TextButton(onClick = {
                    onConfirm(urlField)
                }) {
                    Text(text = "Confirm")
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun ProductFormPreview() {
    ProductForm()
}

@Preview
@Composable
private fun ImageFormPreview() {
    ImageForm()
}

