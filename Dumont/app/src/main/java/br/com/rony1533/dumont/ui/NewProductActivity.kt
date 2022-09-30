package br.com.rony1533.dumont.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.rony1533.dumont.dao.PaidServiceDAO
import br.com.rony1533.dumont.databinding.ActivityNewProductBinding
import br.com.rony1533.dumont.model.PaidService
import java.math.BigDecimal
import java.util.*

class NewProductActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNewProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotaoSalvar()
        config()
    }

    private fun config() {
        binding.ibHomePage.setOnClickListener {
                    irHomePage()
        }
    }

    private fun irHomePage() {
        finish()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.btnSalvar
        val dao = PaidServiceDAO()
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): PaidService {
        val nome = binding.etNome.text.toString()
        val descricao = binding.etDes.text.toString()

        val valorEmTexto = binding.etValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return PaidService(
            nome = nome,
            valor = valor,
            descricao = null,
            dtIni = null,
            dtFinal = null

        )

    }
}