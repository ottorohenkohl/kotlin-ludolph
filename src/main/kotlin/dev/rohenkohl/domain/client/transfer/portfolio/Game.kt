package dev.rohenkohl.domain.client.transfer.portfolio

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Game(

    @field:JsonProperty("Id")
    val id: Int,

    @field:JsonProperty("Name")
    val name: String,

    @field:JsonProperty("StartTime")
    val startTime: Int,

    @field:JsonProperty("EndTime")
    val endTime: Int,

    @field:JsonProperty("Currency")
    val currency: String,

    @field:JsonProperty("InitialAmount")
    val initialAmount: Double,

    @field:JsonProperty("Markets")
    val markets: List<String>,

    @field:JsonProperty("PlayerCount")
    val playerCount: Int,

    @field:JsonProperty("GameGod")
    val gameGod: Boolean,

    @field:JsonProperty("State")
    val state: String,

    @field:JsonProperty("BetaValue")
    val betaValue: Boolean,

)