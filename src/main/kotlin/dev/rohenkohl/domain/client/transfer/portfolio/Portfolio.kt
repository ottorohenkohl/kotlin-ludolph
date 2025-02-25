package dev.rohenkohl.domain.client.transfer.portfolio

import com.fasterxml.jackson.annotation.JsonProperty

data class Portfolio(

    @field:JsonProperty("IsBrief")
    val isBrief: Boolean,

    @field:JsonProperty("IsExplorePortfolio")
    val isExplorePortfolio: Boolean,

    @field:JsonProperty("Portfolio")
    val meta: Meta,

    @field:JsonProperty("Assets")
    val assets: Set<Asset>,

    @field:JsonProperty("Total")
    val total: Double

)