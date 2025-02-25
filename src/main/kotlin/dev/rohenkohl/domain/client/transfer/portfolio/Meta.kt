package dev.rohenkohl.domain.client.transfer.portfolio

import com.fasterxml.jackson.annotation.JsonProperty

data class Meta(

    @field:JsonProperty("Id")
    val id: Int,

    @field:JsonProperty("Name")
    val name: String,

    @field:JsonProperty("OwnerUserId")
    val ownerUserId: Int,

    @field:JsonProperty("OwnerScreenName")
    val ownerScreenName: String,

    @field:JsonProperty("Game")
    val game: Game,

)