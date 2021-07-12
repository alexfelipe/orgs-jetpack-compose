package br.com.alura.orgs.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun BigDecimal.formataParaMoeda(
    locale: Locale = Locale("pt", "br")
): String = NumberFormat.getCurrencyInstance(locale).format(this)
