package dev.rohenkohl.domain.client.transfer.portfolio

import com.fasterxml.jackson.annotation.JsonProperty

data class Asset(

    @field:JsonProperty("Exchange")
    val exchange: String,

    @field:JsonProperty("Ticker")
    val ticker: String,

    @field:JsonProperty("Name")
    val name: String,

    @field:JsonProperty("StockCurrency")
    val stockCurrency: String,

    @field:JsonProperty("IsGameCurrency")
    val isGameCurrency: Boolean,

)