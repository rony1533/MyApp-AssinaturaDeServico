package br.com.rony1533.dumont.model

import java.math.BigDecimal
import java.util.*

data class PaidService (
    var nome: String = "",
    var valor: BigDecimal = BigDecimal(0),
    var dtIni: Date? = null,
    var dtFinal: Date? = null,
    var descricao: String? = null
)