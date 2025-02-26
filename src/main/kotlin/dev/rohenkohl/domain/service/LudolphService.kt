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
        val bought = newAssets.minus(storedAssets)
        val sold = storedAssets.minus(newAssets)

        if (bought.isNotEmpty() || sold.isNotEmpty()) {
            Log.info("Ludolph has made changes; bought $bought, sold $sold")

            discordService.announceChange(bought, sold)
        } else {
            Log.debug("No Changes in the portfolio")
        }

        this.storedAssets = newAssets
    }

    fun updatePosition() {
        if (newPosition != storedPosition) {
            Log.info("Ludolph has switched rank; before $storedPosition, after $newPosition")

            discordService.announcePosition(storedPosition, newPosition)
        } else {
            Log.debug("No Changes in the position")
        }

        this.storedPosition = newPosition
    }
}