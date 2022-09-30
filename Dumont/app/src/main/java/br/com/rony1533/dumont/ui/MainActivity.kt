package br.com.rony1533.dumont.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.orgs.ui.recyclerview.adapter.ListaServicosAdapter
import br.com.rony1533.dumont.dao.PaidServiceDAO
import br.com.rony1533.dumont.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val dao = PaidServiceDAO()
    private val adapter = ListaServicosAdapter(this, dao.buscaTodos())
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecyclerView()
        config()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())

        if (dao.buscaTodos().isNotEmpty())
            gastoTotal()

    }

    private fun gastoTotal() {
        var total: BigDecimal = BigDecimal(0)
        dao.buscaTodos().map {
            total += it.valor
        }

        val formatador = NumberFormat.getInstance(Locale("pt", "br"))
        binding.tvMes1Gasto.text = formatador.format(total)
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.activityListaServicoRecyclerView
        recyclerView.adapter = adapter
    }

    private fun config() {
        binding.ibAddService.setOnClickListener {
            ibAddService()
        }
    }

    private fun ibAddService() {
        val intent = Intent(this, NewProductActivity::class.java)
        startActivity(intent)
    }

}