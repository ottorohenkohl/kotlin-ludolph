package dev.rohenkohl.domain.client.transfer.game

import com.fasterxml.jackson.annotation.JsonProperty

data class Portfolio(

    @field:JsonProperty("Id")
    val id: Int,

    @field:JsonProperty("UserId")
    val userId: Int,

    @field:JsonProperty("Place")
    val place: Int,

    @field:JsonProperty("OwnerScreenName")
    val ownerScreenName: String,

    @field:JsonProperty("Value")
    val tradesCount: Int,

    @field:JsonProperty("IsFollowing")
    val isFollowing: Boolean

)