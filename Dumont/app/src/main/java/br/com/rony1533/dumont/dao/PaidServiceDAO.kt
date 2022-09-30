package br.com.rony1533.dumont.dao

import br.com.rony1533.dumont.model.PaidService
import java.security.Provider

class PaidServiceDAO {

    fun adiciona(service: PaidService) {
        servicos.add(service)
    }

    fun buscaTodos(): List<PaidService> {
        return servicos.toList()
    }

    companion object {
        private val servicos = mutableListOf<PaidService>()
    }

}