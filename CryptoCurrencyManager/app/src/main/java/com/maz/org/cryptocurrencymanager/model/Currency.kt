package com.maz.org.cryptocurrencymanager.model

class Currency {
    var id:String? = null
    var symbol:String? = null
    var name:String? = null
    var price_usd:String? = null

    constructor(id: String, symbol: String, name: String, price_usd: String) {
        this.id = id
        this.symbol = symbol
        this.name = name
        this.price_usd = price_usd
    }
}