package dev.rohenkohl.domain.client.transfer.game

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import dev.rohenkohl.domain.client.constant.Investspiel

open class Game() {

    lateinit var active: Active

    @JsonProperty("Sections")
    fun unpack(json: JsonNode) {
        val node = json.first { it.get(Investspiel.TYPE.value).textValue() == Investspiel.ACTIVE_GAME.value }
        val content = node.get(Investspiel.CONTENT.value)

        this.active = Active(
            content.get("Id").intValue(),
            content.get("Name").textValue(),
            content.get("StartTime").intValue(),
            content.get("EndTime").intValue(),
            content.get("HostUserId").intValue(),
            content.get("HostScreenName").textValue(),
            content.get("MyPortfolioId").intValue(),
            content.get("Currency").textValue(),
            content.get("InitialAmount").intValue(),
            content.get("Portfolios").map {
                Portfolio(
                    it.get("Id").intValue(),
                    it.get("UserId").intValue(),
                    it.get("Place").intValue(),
                    it.get("OwnerScreenName").textValue(),
                    it.get("TradesCount").intValue(),
                    it.get("IsFollowing").booleanValue()
                )
            }
        )
    }
}