package br.com.alura.orgs.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.orgs.database.dao.ProductDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val dao: ProductDao
) : ViewModel() {

    fun findAll() = dao.findAll()

}