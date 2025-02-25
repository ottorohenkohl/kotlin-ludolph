package dev.rohenkohl.domain.service

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
        val bought = newAssets.minus(storedAssets)
        val sold = storedAssets.minus(newAssets)

        if (bought.isNotEmpty() || sold.isNotEmpty()) discordService.announceChange(bought, sold)

        this.storedAssets = newAssets
    }

    fun updatePosition() {
        if (newPosition != storedPosition) discordService.announcePosition(storedPosition, newPosition)

        this.storedPosition = newPosition
    }
}