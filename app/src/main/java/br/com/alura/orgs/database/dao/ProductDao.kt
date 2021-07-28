package br.com.alura.orgs.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.alura.orgs.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    fun findAll(): Flow<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(product: Product)

    @Query("SELECT * FROM Product WHERE id = :id")
    fun findById(id: String): Flow<Product?>

}
