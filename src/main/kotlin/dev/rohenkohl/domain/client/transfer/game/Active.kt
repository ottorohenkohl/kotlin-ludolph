package dev.rohenkohl.domain.client.transfer.game

import com.fasterxml.jackson.annotation.JsonProperty

data class Active(

    @field:JsonProperty("Id")
    val id: Int,

    @field:JsonProperty("Name")
    val name: String,

    @field:JsonProperty("StartTime")
    val startTime: Int,

    @field:JsonProperty("EndTime")
    val endTime: Int,

    @field:JsonProperty("HostUserId")
    val hostUserId: Int,

    @field:JsonProperty("HostScreenName")
    val hostScreenName: String,

    @field:JsonProperty("MyPortfolioId")
    val myPortfolioId: Int,

    @field:JsonProperty("Currency")
    val currency: String,

    @field:JsonProperty("InitialAmount")
    val initialAmount: Int,

    @field:JsonProperty("Portfolios")
    val portfolios: List<Portfolio>

)