package dev.rohenkohl.client

import dev.rohenkohl.domain.client.DiscordClient
import discord4j.common.util.Snowflake
import discord4j.core.GatewayDiscordClient
import discord4j.discordjson.json.EmbedData
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class QuarkiverseDiscordClient(val gatewayDiscordClient: GatewayDiscordClient) : DiscordClient {

    override fun sendMessage(content: EmbedData, channel: Long) {
        gatewayDiscordClient.rest().getChannelById(Snowflake.of(channel)).createMessage(content).subscribe()
    }
}