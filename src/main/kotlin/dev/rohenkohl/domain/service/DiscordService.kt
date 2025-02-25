package dev.rohenkohl.domain.service

import dev.rohenkohl.domain.client.DiscordClient
import dev.rohenkohl.domain.client.transfer.portfolio.Asset
import discord4j.core.spec.EmbedCreateSpec
import discord4j.rest.util.Color
import io.quarkus.logging.Log
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.ConfigProvider

@ApplicationScoped
class DiscordService(val discordClient: DiscordClient) {

    private val channel = ConfigProvider.getConfig().getValue("ludolph.id.channel", Long::class.java)

    fun sayHello() {
        val embedData = EmbedCreateSpec.builder()
            .color(Color.ORANGE)
            .title("Hallo zusammen 👋")
            .description("ich bin es, euer Lieblingsdozent Ludolph. Da ich jetzt bereit bin, setz' mich direkt an mein Portfolio. Schau dir meine Trades an und mach es mir gerne nach 📈!")
            .addField("Funktionen", "Ich melde mich, wenn ich neue Trades durchführe oder sich mein Platz in der Rangliste ändert.", true)
            .addField("Ideen", "Für mögliche Erweiterungsvorschläge meldet euch gerne!", true)
            .build()
            .asRequest()


        discordClient.sendMessage(embedData, channel)
    }

    fun announceChange(bought: Set<Asset>, sold: Set<Asset>) {
        val embedData = EmbedCreateSpec.builder()
            .color(Color.ORANGE)
            .title("Neue Änderungen 🆕")
            .description("Ich habe gerade etwas an meinem Portfolio verändert.")
            .addField("Gekaufte Aktien 🛒", bought.joinToString(separator = "\n") { it.name }, false)
            .addField("Verkaufte Aktien 💸", sold.joinToString(separator = "\n") { it.name }, false)
            .build()
            .asRequest()

        discordClient.sendMessage(embedData, channel)
    }

    fun announcePosition(before: Int, position: Int) {
        val embedData = EmbedCreateSpec.builder()
            .title("Platzänderung 🚀")
            .addField("Vorher", before.toString(), true)
            .addField("Nachher", position.toString(), true)
            .build()
            .asRequest()

        discordClient.sendMessage(embedData, channel)
    }
}