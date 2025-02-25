package dev.rohenkohl.domain.client

import discord4j.discordjson.json.EmbedData

interface DiscordClient {

    fun sendMessage(content: EmbedData, channel: Long)
}