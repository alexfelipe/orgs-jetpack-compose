package br.com.alura.orgs.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.orgs.dao.ProductDao
import br.com.alura.orgs.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val dao: ProductDao
) : ViewModel() {

    fun findAll(): List<Product> {
        return dao.all()
    }

}