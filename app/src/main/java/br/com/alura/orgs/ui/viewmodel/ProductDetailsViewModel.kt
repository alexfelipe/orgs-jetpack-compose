package br.com.alura.orgs.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.orgs.database.dao.ProductDao
import br.com.alura.orgs.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val dao: ProductDao,
) : ViewModel() {

    fun findById(id: String): Flow<Product?> {
        return dao.findById(id)
    }

}
