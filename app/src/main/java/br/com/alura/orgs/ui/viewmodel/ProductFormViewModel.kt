package br.com.alura.orgs.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.orgs.database.dao.ProductDao
import br.com.alura.orgs.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductFormViewModel @Inject constructor(
    private val dao: ProductDao,
) : ViewModel() {

    suspend fun save(product: Product) {
        dao.save(product)
    }

}