package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rony1533.dumont.databinding.ServiceItemBinding
import br.com.rony1533.dumont.model.PaidService
import java.text.NumberFormat
import java.util.*

class ListaServicosAdapter(
    private val context: Context,
    servicos: List<PaidService>
) : RecyclerView.Adapter<ListaServicosAdapter.ViewHolder>() {

    private val servicos = servicos.toMutableList()

    class ViewHolder(private val binding: ServiceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun vincula(servico: PaidService) {
            val nome = binding.tvAppName
            nome.text = servico.nome

            val valor = binding.tvAppPrice
            val formatador = NumberFormat.getInstance(Locale("pt", "br"))
            valor.text = "R$ ${formatador.format(servico.valor)}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ServiceItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val servico = servicos[position]
        holder.vincula(servico)
    }

    override fun getItemCount(): Int = servicos.size

    fun atualiza(servico: List<PaidService>) {
        this.servicos.clear()
        this.servicos.addAll(servico)
        notifyDataSetChanged()
    }

}
