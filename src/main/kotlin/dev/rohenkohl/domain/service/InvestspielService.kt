package dev.rohenkohl.domain.service

import dev.rohenkohl.domain.client.InvestspielClient
import dev.rohenkohl.domain.client.constant.Investspiel
import dev.rohenkohl.domain.client.transfer.game.Game
import dev.rohenkohl.domain.client.transfer.portfolio.Asset
import dev.rohenkohl.domain.client.transfer.portfolio.Portfolio
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.ConfigProvider
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.inject.RestClient

@ApplicationScoped
class InvestspielService(@RestClient val investspielClient: InvestspielClient) {

    private val portfolioId = ConfigProvider.getConfig().getValue("ludolph.id.portfolio", Int::class.java)
    private val gameId = ConfigProvider.getConfig().getValue("ludolph.id.game", Int::class.java)
    private val userEmail = ConfigProvider.getConfig().getValue("ludolph.user.email", String::class.java)
    private val userPassword = ConfigProvider.getConfig().getValue("ludolph.user.password", String::class.java)

    fun fetchSessionCookie(): String = investspielClient.postLoginByUsernamePassword(userEmail, userPassword, Investspiel.SITE.value).cookies["EQSESSID"]!!.value
    fun fetchLudolphsPortfolio(): Portfolio = investspielClient.getOverviewByID(portfolioId).entity
    fun fetchGameStatistics(): Game = investspielClient.getGameStatistics(gameId, fetchSessionCookie()).entity
}