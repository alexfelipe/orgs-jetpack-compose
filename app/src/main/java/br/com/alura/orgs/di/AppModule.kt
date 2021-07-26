package br.com.alura.orgs.di

import android.content.Context
import androidx.room.Room
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.database.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDao(db: AppDatabase): ProductDao =
        db.getProductDao()

    @Provides
    @Singleton
    fun prodideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "orgs.db"
        ).build()

}
