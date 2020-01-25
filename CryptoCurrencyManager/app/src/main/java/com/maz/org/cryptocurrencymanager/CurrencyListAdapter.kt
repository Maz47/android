package com.maz.org.cryptocurrencymanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maz.org.cryptocurrencymanager.model.Currency
import kotlinx.android.synthetic.main.currency_layout.view.*

class CurrencyListAdapter(var currencies: ArrayList<Currency>) :
    RecyclerView.Adapter<CurrencyListAdapter.CurrencyViewHolder>() {

    class CurrencyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val titleView = view.title
        private val descrView = view.description
        private val priceView = view.price

        fun bind (currency: Currency) {
            titleView.text = currency.symbol
            descrView.text = currency.name
            priceView.text = currency.price_usd
        }
    }

    fun updateCurrencies(newCurrencies: List<Currency>) {
        currencies.clear()
        currencies.addAll(newCurrencies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        return CurrencyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.currency_layout, parent, false))
    }

    override fun getItemCount(): Int  = currencies.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(currencies[position])
    }
}