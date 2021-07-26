package br.com.alura.orgs.database.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

class BigDecimalConverter {

    @TypeConverter
    fun toDouble(value: BigDecimal?): Double {
        return value?.toDouble() ?: 0.0
    }

    @TypeConverter
    fun toBigDecimal(value: Double?): BigDecimal {
        return value?.let {
            BigDecimal(it)
        } ?: BigDecimal.ZERO
    }

}