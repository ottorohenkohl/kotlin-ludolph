package dev.rohenkohl.domain.service

import io.quarkus.logging.Log
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.ConfigProvider

@ApplicationScoped
class LudolphService(val discordService: DiscordService, val investspielService: InvestspielService) {

    private val userId = ConfigProvider.getConfig().getValue("ludolph.id.user", String::class.java)

    private val newAssets get() = investspielService.fetchLudolphsPortfolio().assets.filterNot { it.isGameCurrency }.toSet()
    private val newPosition get() = investspielService.fetchGameStatistics().active.portfolios.first { it.userId == userId.toInt() }.place

    private var storedAssets = newAssets
    private var storedPosition = newPosition

    fun updateChange() {
        val assets = newAssets

        Log.info("Updating portfolio; before ${storedAssets.map { it.name }}, after ${assets.map { it.name }}")

        val bought = storedAssets.union(assets).minus(storedAssets)
        val sold = storedAssets.minus(assets)

        if (bought.isNotEmpty() || sold.isNotEmpty()) discordService.announceChange(bought, sold)

        this.storedAssets = assets
    }

    fun updatePosition() {
        val position = newPosition

        Log.info("Updating position; before $storedPosition, after $position")

        if (position != storedPosition) discordService.announcePosition(storedPosition, position)

        this.storedPosition = position
    }
}